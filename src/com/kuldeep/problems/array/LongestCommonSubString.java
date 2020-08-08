package com.kuldeep.problems.array;

public class LongestCommonSubString {
    public static void main(String args[]){
        String str1 = "abcdaf";
        String str2 = "zbcdf";
        int lcs= getLongestCommonSubString(str1, str2);
        System.out.println(lcs);
    }

    private static int getLongestCommonSubString(String str1, String str2) {
        int T[][] = new int[str1.length()+1][str2.length()+1];
        int max=0;
        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    T[i][j] = T[i-1][j-1]+1;
                } else {
                    T[i][j]=0;
                }

                if(T[i][j]>max){
                    max=T[i][j];
                }
            }
        }

        int m = max;
        int n = max;
        char print[] = new char[max];
        int index=max;

        while(max>0){
            print[index-1] = str2.charAt(m);
            index--;
            m--;
            max--;
        }

        for(int i=0; i<print.length; i++){
            System.out.println(print[i]);
        }

        return max;
    }
}
