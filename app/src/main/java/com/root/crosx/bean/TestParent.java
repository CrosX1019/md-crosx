package com.root.crosx.bean;

import java.util.List;

/**
 * Created by CrosX on 2017/6/22.
 */

public class TestParent {

    private String name;

    private List<TestSub> subList;

    public TestParent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TestSub> getSubList() {
        return subList;
    }

    public void setSubList(List<TestSub> subList) {
        this.subList = subList;
    }
}
