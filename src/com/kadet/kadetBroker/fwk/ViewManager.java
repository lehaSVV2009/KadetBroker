package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.view.AbstractView;
import com.kadet.kadetBroker.view.ViewType;
import sun.management.resources.agent_pt_BR;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 16.05.14
 * Time: 5:11
 *
 * @author Кадет
 */
public class ViewManager {

    private final static ViewManager instance = new ViewManager();

    public static ViewManager getInstance () {
        return instance;
    }

    private ViewManager() {}

    private Map<Integer, AbstractView> viewsMap = new HashMap<Integer, AbstractView>();

    private Map<Integer, AbstractView> activeViewsMap = new HashMap<Integer, AbstractView>();

    public AbstractView newView (ViewType viewType, Object param) {
        AbstractView view = ViewFactory.createView(viewType, param);
        viewsMap.put(view.getViewId(), view);
        return view;
    }

    public AbstractView removeView (Integer viewId) {
        return viewsMap.remove(viewId);
    }

    public void addActiveView (Integer viewId) {
        activeViewsMap.put(viewId, viewsMap.get(viewId));
    }

    public void removeActiveView (Integer viewId) {
        activeViewsMap.remove(viewId);
    }

    public void notifyViews (Object changedObject) {
        for (AbstractView view : activeViewsMap.values()) {
            view.refresh();
        }
    }


}
