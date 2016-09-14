package com.core.innerclass;

/**
 * Created by lihuiyan on 2016/9/13.
 */
public class OutClass {
    private static String name = "OutClass";
    private int i;
    protected int j;
    int k;
    public int m;

    public OutClass(int i, int j, int k, int m) {
        this.i = i;
        this.j = j;
        this.k = k;
        this.m = m;
    }

    public int getI() {
        return i;
    }

    //静态内部类，可以访问外部类的静态成员和方法
    static class StaticNestedClass {
        private int a;
        protected int b;
        int c;
        public int d;

        public int getA() {
            return a;
        }

        public String getName() {
            return name;
        }
    }

    class InnerClass {
        private int ia;
        protected int ib;
        int ic;
        public int id;

        public int getIa() {
            return ia;
        }

        //非静态内部类可以访问外部类的所有成员变量和方法
        public void setValues() {
            this.ia = i;
            this.ib = j;
            this.ic = k;
            this.id = m;
        }

        public String toString() {
            return "ia:" + ia + ",ib:" + ib + ",ic:" + ic + ",id:" + id;
        }

        public String getName() {
            return name;
        }
    }

    //局部内部类
    public void print(String initial) {
        class Logger {
            String name;

            public Logger(String name) {
                this.name = name;
            }

            public void log(String s) {
                System.out.println(this.name + ":" + s);
            }
        }
        Logger logger = new Logger(initial);
        logger.log("" + this.i);
        logger.log("" + this.j);
        logger.log("" + this.k);
        logger.log("" + this.m);
    }

    public void anonymousClassTest(){
        Car car = new Car(){

            public void travel() {
                System.out.println("this is a BMW");
            }
        };
        car.travel();
    }
}
