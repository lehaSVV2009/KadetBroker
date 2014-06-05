package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.view.View;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: 18.05.14
 * Time: 0:33
 *
 * @author SarokaA
 */
public class FrameManager {

    private final static FrameManager instance = new FrameManager();

    public static FrameManager getInstance () {
        return instance;
    }

    private FrameManager() {}

    public static int framesNumber = 0;

    private Map<Integer, JFrame> framesMap = new HashMap<Integer, JFrame>();

    private JFrame activeFrame;

    public JFrame newFrame (String frameClassName) {
        JFrame frame = FrameFactory.createFrame(frameClassName);
        framesMap.put(framesNumber ++, frame);
        return frame;
    }

    public void setActiveFrame (JFrame frame) {
        this.activeFrame = frame;
    }



}
