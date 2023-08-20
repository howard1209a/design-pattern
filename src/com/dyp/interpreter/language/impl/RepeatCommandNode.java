package com.dyp.interpreter.language.impl;

import com.dyp.interpreter.language.Context;
import com.dyp.interpreter.language.Node;
import com.dyp.interpreter.language.ParseException;

/**
 * @Description: TODO
 */
public class RepeatCommandNode extends Node {
    private int number;
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[repeat " + number + " " + commandListNode + "]";
    }

    @Override
    public void execute() {
        for (int i = 0; i < number; i++) {
            commandListNode.execute();
        }
    }
}
