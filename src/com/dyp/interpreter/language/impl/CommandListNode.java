package com.dyp.interpreter.language.impl;

import com.dyp.interpreter.language.Context;
import com.dyp.interpreter.language.Node;
import com.dyp.interpreter.language.ParseException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 */
public class CommandListNode extends Node {
    private List<CommandNode> commandNodeList = new ArrayList<>();

    @Override
    public void parse(Context context) throws ParseException {
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException();
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                CommandNode commandNode = new CommandNode();
                commandNodeList.add(commandNode);
                commandNode.parse(context);
            }
        }
    }

    @Override
    public String toString() {
        return commandNodeList.toString();
    }

    @Override
    public void execute() {
        for (CommandNode commandNode : commandNodeList) {
            commandNode.execute();
        }
    }
}
