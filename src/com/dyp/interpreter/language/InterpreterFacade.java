package com.dyp.interpreter.language;

import com.dyp.interpreter.language.impl.ProgramNode;

/**
 * @Description: TODO
 */
public class InterpreterFacade implements Executor {
    private ExecutorFactory executorFactory;
    private Context context;
    private Node programNode;

    public InterpreterFacade(ExecutorFactory executorFactory) {
        this.executorFactory = executorFactory;
    }

    public boolean parse(String text) {
        boolean res = true;
        context = new Context(text);
        context.setExecutorFactory(executorFactory);
        programNode = new ProgramNode();
        try {
            programNode.parse(context);
            System.out.println(programNode);
        } catch (ParseException e) {
            e.printStackTrace();
            res = false;
        }
        return res;
    }

    @Override
    public void execute() {
        programNode.execute();
    }
}
