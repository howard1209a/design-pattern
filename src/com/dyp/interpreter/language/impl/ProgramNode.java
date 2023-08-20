package com.dyp.interpreter.language.impl;

import com.dyp.interpreter.language.Context;
import com.dyp.interpreter.language.Node;
import com.dyp.interpreter.language.ParseException;

/**
 * @Description: TODO
 */
public class ProgramNode extends Node {
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[program " + commandListNode + "]";
    }

    @Override
    public void execute() {
        commandListNode.execute();
    }
}
