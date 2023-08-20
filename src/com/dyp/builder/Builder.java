package com.dyp.builder;

public abstract class Builder {
    private Boolean isInitialized = false;

    // 多线程安全，防止调用多次buildTitle
    public synchronized void makeTitle(String title) {
        if (!isInitialized) {
            buildTitle(title);
            isInitialized = true;
        }
    }

    // 这里不加synchronized，读取布尔量的值本身是线程安全的，buildString的具体实现中如果存在线程问题，则需要在方法内部解决
    public void makeString(String str) {
        if (isInitialized) {
            buildString(str);
        }
    }

    public void makeItems(String[] items) {
        if (isInitialized) {
            buildItems(items);
        }
    }

    public void close() {
        if (isInitialized) {
            buildClose();
        }
    }

    public String getResult() {
        if (isInitialized) {
            return buildGetResult();
        }
        return null;
    }

    public abstract void buildTitle(String title);

    public abstract void buildString(String str);

    public abstract void buildItems(String[] items);

    public abstract void buildClose();

    public abstract String buildGetResult();
}
