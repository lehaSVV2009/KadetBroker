package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.util.Paths;
import com.kadet.kadetBroker.util.Strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    public void initProperties () throws KadetException {
        initViewsProperties(Paths.VIEWS_PROPERTIES_PATH);
        initControllersProperties(Paths.CONTROLLERS_PROPERTIES_PATH);
        initViewControllerMappingProperties(Paths.VIEW_CONTROLLER_MAPPING_PROPERTIES_PATH);
    }

    private void initControllersProperties (String controllersPropertiesPath) throws KadetException {
        initPropertyFile(controllersProperties, controllersPropertiesPath);
    }

    private void initViewsProperties (String viewsPropertiesPath) throws KadetException {
        initPropertyFile(viewsProperties, viewsPropertiesPath);
    }

    private void initViewControllerMappingProperties (String viewControllerMappingPropertiesPath) throws KadetException {
        initPropertyFile(viewControllerMappingProperties, viewControllerMappingPropertiesPath);
    }


    private void initPropertyFile (Properties properties, String path) throws KadetException {
        try {
            properties.load(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            throw new KadetException(Strings.PROPERTY_FILE_WAS_NOT_FOUND + ": " + path);
        } catch (IOException e) {
            throw new KadetException(Strings.READ_PROPERTY_FILE_ERROR + ": " + path);
        }
    }

    /**
     * @return for example com.kadet.kadetBroker.controller.SomeController
     */
    public String getControllerClassNameByViewClassName (String viewClassName) {
        String viewName = getViewNameByViewClassName(viewClassName);
        String controllerName = viewControllerMappingProperties.getProperty(viewName);
        return controllersProperties.getProperty(controllerName);
    }



    /**
     * @return for example addCustomerView
     */
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
