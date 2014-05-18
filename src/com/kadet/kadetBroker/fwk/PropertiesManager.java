package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.entity.Entity;
import com.kadet.kadetBroker.exception.KadetException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Date: 16.05.14
 * Time: 4:51
 *
 * @author Кадет
 */
public class PropertiesManager {

    private final static PropertiesManager instance = new PropertiesManager();

    public static PropertiesManager getInstance () {
        return instance;
    }

    private PropertiesManager() {}
    
    private Properties controllersProperties = new Properties();
    private Properties viewsProperties = new Properties();
    private Properties viewControllerMappingProperties = new Properties();

    public void initControllersProperties (String controllersPropertiesPath) throws KadetException {
        try {
            controllersProperties.load(new FileInputStream(controllersPropertiesPath));
        } catch (IOException e) {
            throw new KadetException("Not correct path to controllers.properties");
        }
    }

    public void initViewsProperties (String viewsPropertiesPath) throws KadetException {
        try {
            viewsProperties.load(new FileInputStream(viewsPropertiesPath));
        } catch (IOException e) {
            throw new KadetException("Not correct path to views.properties");
        }
    }

    public void initViewControllerMappingProperties (String viewControllerMappingPropertiesPath) throws KadetException {
        try {
            viewControllerMappingProperties.load(new FileInputStream(viewControllerMappingPropertiesPath));
        } catch (IOException e) {
            throw new KadetException("Not correct path to view_controller_mapping.properties");
        }
    }

    public String getControllerClassNameByViewClassName (String viewClassName) {
        String viewName = getViewNameByViewClassName(viewClassName);
        String controllerName = viewControllerMappingProperties.getProperty(viewName);
        String controllerClassName = controllersProperties.getProperty(controllerName);
        return controllerClassName;
    }

    public String getViewNameByViewClassName (String viewClassName) {
        Set<Map.Entry<Object, Object>> viewsPropertiesSet = viewsProperties.entrySet();
        for (Map.Entry<Object, Object> viewProperty : viewsPropertiesSet) {
            if (viewClassName.equals(viewProperty.getValue())) {
                return (String)viewProperty.getKey();
            }
        }
        return "";
    }


}
