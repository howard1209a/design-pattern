package com.dyp.interpreter.language.impl;

import com.dyp.interpreter.language.Context;
import com.dyp.interpreter.language.Node;
import com.dyp.interpreter.language.ParseException;

/**
 * @Description: TODO
 */
public class CommandNode extends Node {
    private Node node;

    @Override
    public void parse(Context context) throws ParseException {
        if (context.currentToken().equals("repeat")) {
            node = new RepeatCommandNode();
        } else {
            node = new PrimitiveCommandNode();
        }
        node.parse(context);
    }

    @Override
    public String toString() {
        return node.toString();
    }

    @Override
    public void execute() {
        node.execute();
    }
}
