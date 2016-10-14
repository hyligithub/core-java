package com.core.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lihuiyan on 2016/10/14.
 */
public class MyExceptionExample {
    public static void main(String[] args) throws MyException {
        try {
            processFile("a.txt");
        } catch (MyException e) {
            processErrorCode(e);
        }
    }

    private static void processErrorCode(MyException e) throws MyException {
        switch (e.getErrorCode()) {
            case "FILE_NOT_FOUND_EXCEPTION":
                System.out.println("file not found exception");
                throw e;
            case "FILE_CLOSED_EXCEPTION":
                System.out.println("file closed exception");
                break;
            default:
                System.out.println("Unknown Exception" + e.getMessage());
                e.printStackTrace();
        }
    }

    private static void processFile(String fileName) throws MyException {
        InputStream ins = null;
        try {
            ins = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new MyException(e.getMessage(), "FILE_NOT_FOUND_EXCEPTION");
        } finally {
            try {
                if (ins != null)
                    ins.close();
            } catch (IOException e) {
                throw new MyException(e.getMessage(), "FILE_CLOSED_EXCEPTION");
            }
        }
    }
}
