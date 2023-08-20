package com.dyp.flyweight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Description: TODO
 */
public class BigChar {
    private char charname;
    private String fontData = "";

    public BigChar(char charname) {
        this.charname = charname;
        String path = "src/com/dyp/flyweight/bigchar/big" + charname + ".txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                fontData += line + "\n";
            }
        } catch (IOException e) {
            fontData = charname + "?";
        }
    }

    public void print() {
        System.out.print(fontData);
    }
}
