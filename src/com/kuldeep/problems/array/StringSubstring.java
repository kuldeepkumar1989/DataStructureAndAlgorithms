package com.kuldeep.problems.array;

public class StringSubstring {
    public static  void main(String args[]){
        String str = "abcd";
       // printSubStringUsingSubstringMethod(str);

        printSubStringUsingStringBuilder(str);

    }
    static void printSubStringUsingSubstringMethod(String str){
        for(int i=0; i<str.length();i++){
            for(int j=i+1; j<=str.length(); j++){
                System.out.println(str.substring(i,j));
            }

        }
    }

    static void printSubStringUsingStringBuilder(String str){
        for(int i=0; i<str.length();i++){
            StringBuilder sb = new StringBuilder().append(str.charAt(i));
            System.out.println(sb);
            for(int j=i+1; j<str.length(); j++){
                sb.append(str.charAt(j));
                System.out.println(sb);
            }
        }
    }
}
