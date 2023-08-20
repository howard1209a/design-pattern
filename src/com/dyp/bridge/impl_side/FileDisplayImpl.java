package com.dyp.bridge.impl_side;

import com.dyp.bridge.impl_side.DisplayImpl;

import java.io.*;

/**
 * @author howard
 * @version 1.0
 */
public class FileDisplayImpl extends DisplayImpl {
    private BufferedReader br;

    @Override
    public void rawOpen() {
        try {
            br = new BufferedReader(new FileReader("src/com/dyp/bridge/content.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rawPrint() {
        String line;
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rawClose() {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
