package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.view.AbstractView;

import java.util.ArrayList;
import java.util.List;

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

    private List<AbstractView> views = new ArrayList<AbstractView>();

    public void newView () {

    }


}
