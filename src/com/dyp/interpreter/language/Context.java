package com.dyp.interpreter.language;

import java.util.StringTokenizer;

/**
 * @Description: TODO
 */
public class Context implements ExecutorFactory {
    public ExecutorFactory executorFactory;
    private StringTokenizer tokenizer;
    private String currentToken;

    public Context(String text) {
        tokenizer = new StringTokenizer(text);
        nextToken();
    }

    public String nextToken() {
        if (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
        return currentToken;
    }

    public String currentToken() {
        return currentToken;
    }

    public void skipToken(String token) throws ParseException {
        if (currentToken == null || !currentToken.equals(token)) {
            throw new ParseException();
        }
        nextToken();
    }

    public int currentNumber() throws ParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            throw new ParseException();
        }
        return number;
    }

    public void setExecutorFactory(ExecutorFactory executorFactory) {
        this.executorFactory = executorFactory;
    }

    @Override
    public Executor createExecutor(String name) {
        return executorFactory.createExecutor(name);
    }
}
