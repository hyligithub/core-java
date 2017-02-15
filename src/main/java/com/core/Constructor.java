package com.core;

/**
 * Created by lihuiyan on 2017/1/6.
 */
public class Constructor
{
    Constructor c = new Constructor();
    public Constructor(){
        c = new Constructor();
    }

    public static void main(String[] args){
        Constructor c = new Constructor();
    }
}
