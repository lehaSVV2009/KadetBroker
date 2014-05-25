package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.util.Paths;

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
    private Properties commandProperties = new Properties();

    public void initProperties () throws KadetException {
        initViewsProperties(Paths.VIEWS_PROPERTIES_PATH);
        initControllersProperties(Paths.CONTROLLERS_PROPERTIES_PATH);
        initViewControllerMappingProperties(Paths.VIEW_CONTROLLER_MAPPING_PROPERTIES_PATH);
        initCommandMappingProperties(Paths.COMMANDS_PROPERTIES_PATH);
    }

    private void initControllersProperties (String controllersPropertiesPath) throws KadetException {
        try {
            controllersProperties.load(new FileInputStream(controllersPropertiesPath));
        } catch (IOException e) {
            throw new KadetException("Not correct path to controllers.properties");
        }
    }

    private void initViewsProperties (String viewsPropertiesPath) throws KadetException {
        try {
            viewsProperties.load(new FileInputStream(viewsPropertiesPath));
        } catch (IOException e) {
            throw new KadetException("Not correct path to views.properties");
        }
    }

    private void initViewControllerMappingProperties (String viewControllerMappingPropertiesPath) throws KadetException {
        try {
            viewControllerMappingProperties.load(new FileInputStream(viewControllerMappingPropertiesPath));
        } catch (IOException e) {
            throw new KadetException("Not correct path to view_controller_mapping.properties");
        }
    }


    private void initCommandMappingProperties (String commandPropertiesPath) throws KadetException {
        try {
            commandProperties.load(new FileInputStream(commandPropertiesPath));
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

    public String getCommandClassName (String commandName) {
        return commandProperties.getProperty(commandName);
    }


}
