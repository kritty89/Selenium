package com.parabank.utility;

public class TestClass {
    public static void main(String[] args){
        String input = "krishnakumar";
        String output = "";
        String s1 = "krishna";
        String s2 = "kumar";

        s1 = s1 + s2;

        s2 = s1.substring(0, (s1.length() - s2.length()));
        s1 = s1.substring(s2.length());

        for (int i=input.length()-1; i>=0; i--)
        {
            output = output + input.charAt(i);
        }
        System.out.println(output);
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);
    }
}
