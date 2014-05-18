package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.view.LoggerView;
import com.kadet.kadetBroker.view.View;

import javax.swing.*;

/**
 * Date: 18.05.14
 * Time: 0:36
 *
 * @author SarokaA
 */
public class FrameFactory {

    private final static FrameFactory instance = new FrameFactory();

    public static FrameFactory getInstance () {
        return instance;
    }

    private FrameFactory() {}


    public static JFrame createFrame (String className) {
        try {
            return (JFrame) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to instantiate" + className);
        }
    }
    
}
