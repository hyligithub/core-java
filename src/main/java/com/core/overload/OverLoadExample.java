package com.core.overload;

/**
 * Created by lihuiyan on 2016/12/28.
 */
public class OverLoadExample {



    public int aMethod(char n){
        return 1;
    }

    public int aMethod(int i){
        return 0;
    }

    private  void aMethod(int i,char j){

    }
    private  void aMethod(char i,int j){

    }


}
