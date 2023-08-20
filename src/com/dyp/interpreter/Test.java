package com.dyp.interpreter;

import com.dyp.interpreter.language.Context;
import com.dyp.interpreter.language.Node;
import com.dyp.interpreter.language.ParseException;
import com.dyp.interpreter.language.impl.ProgramNode;

import java.io.*;

/**
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new FileReader("src/com/dyp/interpreter/program.txt"));
        String text;
        while ((text = br.readLine()) != null) {
            Node node = new ProgramNode();
            node.parse(new Context(text));
            System.out.println(node);
        }
        br.close();
    }
}
