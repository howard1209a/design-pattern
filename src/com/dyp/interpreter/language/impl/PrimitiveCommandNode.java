package com.dyp.interpreter.language.impl;

import com.dyp.interpreter.language.Context;
import com.dyp.interpreter.language.Executor;
import com.dyp.interpreter.language.Node;
import com.dyp.interpreter.language.ParseException;

/**
 * @Description: TODO
 */
public class PrimitiveCommandNode extends Node {
    private Executor executor;
    private String name;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.nextToken();
        if (!name.equals("go") && !name.equals("left") && !name.equals("right")) {
            throw new ParseException();
        }
        if (context.executorFactory != null) {
            executor = context.executorFactory.createExecutor(name);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void execute() {
        executor.execute();
    }
}
