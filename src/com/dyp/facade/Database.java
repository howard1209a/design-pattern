package com.dyp.facade;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author howard
 * @version 1.0
 */
public class Database {
    private Database() {
    }

    public static Properties getProperties(String dbname) {
        String filename = "src/com/dyp/facade/" + dbname + ".txt";
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
