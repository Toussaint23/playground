package com.altimetrik.playground.trip;

import java.util.Scanner;

public class Test {


    public static void main(String[] args){
       StringBuilder str = new StringBuilder();
       str.append("null");
       System.out.println(str.indexOf("Test"));
        String s = "Test null test 123";
        Scanner sc = new Scanner(s);
        while (sc.hasNext()){
            if(sc.hasNextInt())
                System.out.println(sc.nextInt());
            else    System.out.println(sc.next());
        }


    }

}
