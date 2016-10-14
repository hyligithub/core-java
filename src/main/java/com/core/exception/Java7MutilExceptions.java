package com.core.exception;

/**
 * Created by lihuiyan on 2016/10/13.
 */
public class Java7MutilExceptions {

    public static void main(String[] args) {
        try {
            rethrow("123");
        } catch (FirstException | SecondException | ThirdException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void rethrow(String args) throws FirstException, SecondException, ThirdException {
        try {
            if (args.equals("First")) {
                throw new FirstException("First");
            } else if (args.equals("Second")) {
                throw new SecondException("Second");
            } else
                throw new ThirdException("Third");
        } catch (Exception e) {
            //这里捕获的异常并不包含在throws从句中，编译器会分析try代码块来检查什么类型的异常被抛出和捕获
            throw e;
        }
    }

    static class FirstException extends Exception {
        public FirstException(String msg) {
            super(msg);
        }
    }

    static class SecondException extends Exception {
        public SecondException(String msg) {
            super(msg);
        }
    }

    static class ThirdException extends Exception {
        public ThirdException(String msg) {
            super(msg);
        }
    }

}
