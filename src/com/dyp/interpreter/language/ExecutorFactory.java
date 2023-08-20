package com.dyp.interpreter.language;

public interface ExecutorFactory {
    Executor createExecutor(String name);
}
