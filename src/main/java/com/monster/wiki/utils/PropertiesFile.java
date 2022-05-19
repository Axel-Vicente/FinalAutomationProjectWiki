package com.monster.wiki.utils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertiesFile {

    private static Properties prop = null;
    private static String separator = File.separator;
    private static final String PATHUSER = System.getProperty("user.dir");

    public static void writeFileProperties(String key, String value){
        try {
            prop = new Properties();
            FileInputStream file;
            file = new FileInputStream(PATHUSER + (separator+"src"+separator+"test"+separator+"resources"+separator+ "environment.properties"));
            prop.load(new InputStreamReader(file, Charset.forName("UTF-8")));
            prop.setProperty(key, value);
            OutputStream out = new FileOutputStream(PATHUSER + (separator+"src"+separator+"test"+separator+"resources"+separator+ "environment.properties"));
            prop.store(out, "Added values " + key + " : " + value);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String readFileProperties(String key){
        String value = null;
        try {
            prop = new Properties();
            FileInputStream file;
            file = new FileInputStream(PATHUSER + (separator+"src"+separator+"test"+separator+"resources"+separator+ "environment.properties"));
            prop.load(new InputStreamReader(file, Charset.forName("UTF-8")));
            value = PropertiesFile.prop.getProperty(key);
            OutputStream out = new FileOutputStream(PATHUSER + (separator+"src"+separator+"test"+separator+"resources"+separator+ "environment.properties"));
            prop.store(out, "Collected the value " + value);

            return value;
        }catch (IOException e){
            e.printStackTrace();
        }
        return value;
    }
}
