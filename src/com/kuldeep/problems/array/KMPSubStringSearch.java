package com.kuldeep.problems.array;

import java.util.Scanner;

/**
 * @Author kuldeep
 * KMP Search
 */
public class KMPSubStringSearch {
    public static void main(String args[]) {
//    String str = "abcxabcdabcdabcy";
//    String subString = "abcdabcy";


        Scanner sc = new Scanner(System.in);

        int test = Integer.parseInt(sc.nextLine());
        System.out.println("Test :"+test);
        KMPSubStringSearch kmpSubStringSearch = new KMPSubStringSearch();

        for(int t=0; t<test; t++) {
            String str = sc.nextLine();
            System.out.println("Entered str : " + str);

            String subString = sc.nextLine();
            System.out.println("Entered subStr :" + subString);

            kmpSubStringSearch.patternExist(str.toCharArray(), subString.toCharArray());
            kmpSubStringSearch.KMPSubstringExist(str.toCharArray(), subString.toCharArray());
        }
    }

    public int [] computeTempPrefixSuffixArray(char [] subString){
        int index=0;
        int [] prefixSuffixArray = new int[subString.length];
        for(int i=1; i<subString.length;){
            if(subString[i]==subString[index]){
                prefixSuffixArray[i]=index+1;
                i++;
                index++;
            } else {
                if(index !=0){
                    index=prefixSuffixArray[index-1];
                } else {
                    prefixSuffixArray[i]=0;
                    i++;
                }
            }
        }
        return prefixSuffixArray;
    }

    public void KMPSubstringExist(char [] str, char [] subStr){
        int i=0,j=0;
        int [] prefixSuffixArr = computeTempPrefixSuffixArray(subStr);
        while(i<str.length && j<subStr.length){
            if(str[i]==subStr[j]){
                i++;
                j++;
            } else {
                if(j!=0){
                    j=prefixSuffixArr[j-1];
                } else {
                    i++;
                }
            }
        }
        if(j==subStr.length){
            System.out.println("KMP method => Pattern exist");
        } else {
            System.out.println("KMP method => Pattern does not exist");
        }
    }

    /**
     * Brute force way
     * @param str
     * @param subString
     */
    public void patternExist(char [] str, char [] subString){
        int i=0,j=0,k=0;
        while(i<str.length && j<subString.length){
            if(str[i]==subString[j]){
                i++;
                j++;
            } else{
                j=0;
                k++;
                i=k;
            }
        }
        if(subString.length == j){
            System.out.println("Brute force method => Pattern exist");
        } else {
            System.out.println("Brute force method => Pattern does not exist");
        }

    }
}
