package com.root.crosx.bean;

/**
 * Created by CrosX on 2017/6/15.
 */

public enum Tab {
    HOME("首页");

    private final String name;

    Tab(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
