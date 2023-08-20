package com.dyp.adapter.impl;

import com.dyp.adapter.FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author howard
 * @version 1.0
 */
public class FileProperties extends Properties implements FileIO {

    @Override
    public void readFromFile(String filename) throws IOException {
        FileInputStream fi = new FileInputStream(filename);
        load(fi);
        fi.close();
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        FileOutputStream fo = new FileOutputStream(filename);
        store(fo, "written by FileProperties");
        fo.close();
    }

    @Override
    public void setValue(String key, String value) {
        put(key, value);
    }

    @Override
    public String getValue(String key) {
        return (String) get(key);
    }
}
