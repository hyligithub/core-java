package com.core.enumexample;

import java.io.IOException;

/**
 * Created by lihuiyan on 2016/9/19.
 */
//可以实现接口
public enum ThreadStateEnum implements Cloneable {

    START(1) {
        //必须实现抽象方法
        public String getDetail() {
            return "START";
        }

        @Override
        public String toString() {
            return "Start Implementation priority:" + getPriority();
        }
    },
    RUNNING(2) {
        public String getDetail() {
            return "RUNNING";
        }

    },
    WAITING(3) {
        public String getDetail() {
            return "WAITING";
        }
    },
    DEAD(4) {
        public String getDetail() {
            return "DEAD";
        }
    };
    //可以有属性
    private int priority;

    //必须是私有构造函数
    private ThreadStateEnum(int i) {
        this.priority = i;
    }

    //可以有抽象方法
    public abstract String getDetail();

    //可以进行方法重写
    @Override
    public String toString() {
        return "priority:" + priority;
    }

    //可以有共有方法
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
