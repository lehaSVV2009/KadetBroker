package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.view.LoggerPanel;
import com.kadet.kadetBroker.view.View;

import java.util.*;

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

    public static int viewId = 0;

    private Map<Integer, View> viewsMap = new HashMap<Integer, View>();

    private Map<Integer, View> activeViewsMap = new HashMap<Integer, View>();


    //TODO: remove later
    private View activeView;

    //TODO: once again
    private LoggerPanel activeLoggerPanel;

    private Map<PropertyChangingType, List<View>> propertyChangesActions = new HashMap<PropertyChangingType, List<View>>();

    public View newView (String viewClassName) {
        View view = ViewFactory.createView(viewClassName);
        viewsMap.put(viewId ++, view);
        return view;
    }

    public View removeView (Integer viewId) {
        return viewsMap.remove(viewId);
    }

    public void addActiveView (View view) throws KadetException {
        if (!viewsMap.containsValue(view)) {
            throw new KadetException(Strings.THERE_IS_NO_SUCH_VIEW_EXCEPTION);
        } else {
            Set<Map.Entry<Integer, View>> viewIdViewSet = viewsMap.entrySet();
            for (Map.Entry<Integer, View> viewIdView : viewIdViewSet) {
                if (view == viewIdView.getValue()) {
                    activeViewsMap.put(viewIdView.getKey(), view);
                    return;
                }
            }
        }
    }

    public void removeActiveView (View view) throws KadetException {
        if (!viewsMap.containsValue(view)) {
            throw new KadetException(Strings.THERE_IS_NO_SUCH_VIEW_EXCEPTION);
        } else {
            Set<Map.Entry<Integer, View>> viewIdViewSet = viewsMap.entrySet();
            for (Map.Entry<Integer, View> viewIdView : viewIdViewSet) {
                if (view == viewIdView.getValue()) {
                    activeViewsMap.remove(viewIdView.getKey());
                    return;
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

    public List<View> getActiveViews () {
        return (List<View>) activeViewsMap.values();
    }

    public void addPropertyChangeListener (PropertyChangingType propertyChangingType,  View view) {
        if(!propertyChangesActions.containsKey(propertyChangingType)) {
            List<View> views = new ArrayList<View>();
            views.add(view);
            propertyChangesActions.put(propertyChangingType, views);
        } else {
            List<View> views = propertyChangesActions.get(propertyChangingType);
            views.add(view);
        }
    }

    public void notifyPropertyChange (PropertyChangingType propertyChangingType, Object changedObject) {
        List<View> views = propertyChangesActions.get(propertyChangingType);
        if (views != null) {
            for (View view : views) {
                view.refresh(propertyChangingType, changedObject);
            }
        }
    }


    public void refreshAllViews () {
        for (View view : viewsMap.values()) {
            view.refresh();
        }
    }


}
