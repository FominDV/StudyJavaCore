package ru.test.fomin.testing;

import java.util.Arrays;

public class FastTest {
    public static void main(String[] args){
        String stringCode="x0x1x2";
        StringBuffer stringBuffer = new StringBuffer(stringCode);
        stringBuffer.deleteCharAt(0);
        //stringBuffer.setLength(stringCode.length()-1);
        stringCode= String.valueOf(stringBuffer);
        System.out.println(stringCode);
        System.out.println(stringCode.length());
        System.out.println(stringCode.indexOf("hello"));
        System.out.println(stringCode.indexOf("x"+"1"));
        System.out.println(stringCode.indexOf("hellowwww"));
        }

    }

