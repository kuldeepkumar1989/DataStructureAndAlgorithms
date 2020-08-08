package com.kuldeep.problems.array;

public class LongestCommanSubsequence {
    public static void main(String args[]){
        String s1 = "bd";
        String s2="abcd";

        int lcs = findLCS( s2.toCharArray(), s1.toCharArray(), s2.length(), s1.length());
        System.out.println(lcs);


    }


    private static int findLCS(char[] s2, char[] s1, int m, int n) {
        int lcs[][] = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n;j++){
                if(i==0 || j==0) // initializing first row and column as zero, we can skip also as in java for primitive
                    lcs[i][j]=0;// byte short int long array will initialize with 0 by default
                else if(s2[i-1]==s1[j-1]) {
                    lcs[i][j]= 1+lcs[i-1][j-1]; //diagonal+1
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]); //max of previous row and previous column
                }
            }
        }
        int index = lcs[m][n];
        int tmp = index;
        char print[] = new char[index];
        int i=m;
        int j=n;

        while(i>0 && j>0){

            if(s2[i-1] == s1[j-1]){
                print[index-1] = s2[i-1];
                i--;
                j--;
                index--;
            } else if(lcs[i-1][j]>lcs[i][j-1]){
                i--;
            } else {
                j--;
            }

        }
        for(int k=0;k<tmp;k++)
            System.out.print(print[k] +" ");
        System.out.println(" ");
        return lcs[m][n];
    }
}
