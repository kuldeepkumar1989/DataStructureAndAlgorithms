package com.kuldeep.problems.array;

public class PrintSubset {
    public static void main(String args[]){
        char [] ch = {'a', 'b'};
        subset(ch);
    }

    static void subset(char []ch){
        int n =ch.length;
        int k = 1<<n;
        for(int i=0; i<(1<<n); i++){
            System.out.print("{ ");
            for(int j=0; j<n;j++){
                if((i&(1<<j))>0){
                    System.out.print(ch[j]);
                }
            }
            System.out.println(" }");
        }
    }
}
