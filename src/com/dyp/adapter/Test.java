package com.dyp.adapter;

import com.dyp.adapter.impl.FileProperties;

import java.io.IOException;

/**
 * @author howard
 * @version 1.0
 */
public class Test {
    public static void main(String[] args){
        FileIO fileIO = new FileProperties();
        try {
            fileIO.readFromFile("F:\\JavaWorkspace\\design-pattern\\src\\com\\dyp\\adapter\\file.txt");
            fileIO.setValue("year","2004");
            fileIO.setValue("month","4");
            fileIO.setValue("day","21");
            fileIO.writeToFile("F:\\JavaWorkspace\\design-pattern\\src\\com\\dyp\\adapter\\newfile.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
