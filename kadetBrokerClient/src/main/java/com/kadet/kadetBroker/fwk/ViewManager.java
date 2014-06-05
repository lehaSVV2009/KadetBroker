package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.Entity;
import com.kadet.kadetBroker.to.TO;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.view.CurrentCustomerContainer;
import com.kadet.kadetBroker.view.LoggerPanel;
import com.kadet.kadetBroker.view.View;
import com.kadet.kadetBroker.viewModel.AllCustomersViewModel;
import com.kadet.kadetBroker.viewModel.CustomerInfoViewModel;
import com.kadet.kadetBroker.viewModel.StocksViewModel;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 16.05.14
 * Time: 5:11
 *
 * @author Кадет
 */
public class ViewManager {

    private static Logger logger = Logger.getLogger(ViewManager.class.getName());

    private final static ViewManager instance = new ViewManager();

    public static ViewManager getInstance () {
        return instance;
    }

    private ViewManager() {}

    public static int viewId = 0;

    private Map<Integer, View> viewsMap = new HashMap<Integer, View>();

    private View activeView;
    private LoggerPanel activeLoggerPanel;


    public View newView (String viewClassName) {
        View view = ViewFactory.createView(viewClassName);
        viewsMap.put(viewId ++, view);
        logger.log(Level.INFO, Strings.NEW_VIEW_WAS_CREATED + ":" + view.getClass().getName());
        return view;
    }

    public void removeView (View view) {
        if (viewsMap.containsValue(view)) {
            Set<Map.Entry<Integer, View>> viewIdViewSet = viewsMap.entrySet();
            for (Map.Entry<Integer, View> viewIdView : viewIdViewSet) {
                if (view == viewIdView.getValue()) {
                    viewsMap.remove(viewIdView.getKey());
                    logger.log(Level.INFO, Strings.VIEW_WAS_REMOVED + ":" + view.getClass().getName());
                }
            }
        }
    }

    public void setActiveView (View activeView) {
        this.activeView = activeView;
    }

    public View getActiveView () {
        return activeView;
    }

    public void setActiveLoggerPanel (LoggerPanel activeLoggerPanel) {
        this.activeLoggerPanel = activeLoggerPanel;
    }

    public LoggerPanel getActiveLoggerPanel () {
        return activeLoggerPanel;
    }


    private Map<TO, List<View>> subscribers = new HashMap<TO, List<View>>();
    private List<View> subscribersOnNobodyWasNotified = new ArrayList<View>();

    /**
     *  Подписываются на изменения модели, на которые не произошло ни одного изменения вьюх
     */
    public void subscribeOnNobodyElse (View view) {
        subscribersOnNobodyWasNotified.add(view);
    }

    public void subscribe (View view, TO to) {

        if (subscribers.containsKey(to)) {
            List<View> views = subscribers.get(to);
            views.add(view);
        } else {
            List<View> views = new ArrayList<View>();
            subscribers.put(to, views);
        }
    }

    public void subscribe (View view, List<TO> tos) {
        for (TO to : tos) {
            subscribe(view, to);
        }
    }

    public void subscribe (View view, AllCustomersViewModel viewModel) {
        for (CustomerTO customerTO : viewModel.getCustomersListTO()) {
            subscribe(view, customerTO);
        }
        subscribe(view, viewModel.getCurrentCustomerTO());
    }

    public void unSubscribe (View view, AllCustomersViewModel viewModel) {
        for (CustomerTO customerTO : viewModel.getCustomersListTO()) {
            unSubscribe(view, customerTO);
        }
        unSubscribe(view, viewModel.getCurrentCustomerTO());
    }

    public void subscribe (View view, CustomerInfoViewModel viewModel) {
        subscribe(view, viewModel.getCurrentCustomerTO());
    }

    public void unSubscribe (View view, CustomerInfoViewModel viewModel) {
        unSubscribe(view, viewModel.getCurrentCustomerTO());
    }


    public void subscribe (View view, StocksViewModel stocksViewModel) {
        subscribe(view, stocksViewModel.getPortfolioTO().getCustomerTO());
        //TODO: subscribe to the your shares
    }

    public void unSubscribe (View view, StocksViewModel stocksViewModel) {
        unSubscribe(view, stocksViewModel.getPortfolioTO().getCustomerTO());
        //TODO: unSubscribe to the your shares
    }


    public void unSubscribe (View view, TO to) {
        if (subscribers.containsKey(to)) {
            List<View> views = subscribers.get(to);
            for (int viewIndex = 0; viewIndex < views.size(); ++viewIndex) {
                View viewFromList = views.get(viewIndex);
                if (view == viewFromList) {
                    views.remove(view);
                    --viewIndex;
                }
            }
        }
    }

    /**
     *  If TO changes it will notify all subscribers on this object to refresh
     *  If there is no any subscriber, it will notify subscribers from the list "subscribersOnNobodyWasNotified"
     *
     * @param to
     */
    public void notifyByObjectChanged (TO to) {

        boolean anythingWasNotified = false;
        TO [] subscribersKeys = new TO[] {};
        subscribers.keySet().toArray(subscribersKeys);
        for (int keyIndex = 0; keyIndex < subscribersKeys.length; ++keyIndex) {
            TO toFromMap = subscribersKeys[keyIndex];
            if (to.getClass().equals(toFromMap.getClass())) {
                if (to instanceof Entity) {
                    if(((Entity)to).getId().equals(((Entity)toFromMap).getId())) {
                        List<View> views = subscribers.get(toFromMap);
                        for (int viewIndex = 0; viewIndex < views.size(); ++viewIndex) {
                            anythingWasNotified = true;
                            View view = views.get(viewIndex);
                            view.refresh();
                        }
                    }
                }
            }
        }
        if (!anythingWasNotified) {
            for (View view : subscribersOnNobodyWasNotified) {
                view.refresh();
            }
        }

    }

    /**
     *  Notify all views that contains current customer info by current customer
     */
    public void notifyByCurrentCustomer (CustomerTO customerTO) {
        for (View view : viewsMap.values()) {
            if (view instanceof CurrentCustomerContainer) {
                ((CurrentCustomerContainer)view).refreshByCurrentCustomer(customerTO);
            }
        }
    }

    public void setMessageToLogger(String message) {
        getActiveLoggerPanel().setText(message);
    }

}
