package com.kuldeep.problems.array;

public class StringPermutation {
    public static void main(String args[]){
        String str = "ABC";
        int n = str.length();
        permute(str, 0, n-1);
    }

    public static void permute(String str, int l, int r){
        char ch []= new char[2 * 5];
        System.out.println(ch.length);

        if(l==r){
            System.out.println(str);
        } else {
            for(int i=l ; i<=r;i++){
                str = swap(str, l , i);
                permute(str, l+1, r);
                str = swap(str, l, i);
            }
        }


    }

    private static String  swap(String str, int l, int i) {
        char [] ch = str.toCharArray();

        char temp = ch[l];
        ch[l]=ch[i];
        ch[i]=temp;

        return new String(ch);
    }

}
