package com.java.aoc2025.day04;

import com.java.aoc2025.common.FileUtils;

import java.util.List;

public class Solution {
    public static int n,m;
    public static boolean isValid(int i, int j){
        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;

        return true;
    }

    public static void main(String [] args) throws java.lang.Exception {
        List<String> input = FileUtils.readLines("day04.txt");
        n = input.size();
        m = input.get(0).length();
        int ans =0;
        for(int i=0 ; i<n;i++){
            for(int j=0; j<m; j++){
                if(input.get(i).charAt(j) == '.')
                    continue;
                int tot = 0;
                // conditions
                int p = i-1, q = j-1;
                if(isValid(p, q) && input.get(p).charAt(q) == '@') {
                    tot++;
                    if(tot >= 4)
                        continue;
                }

                p = i+1;
                q = j+1;
                if(isValid(p, q) && input.get(p).charAt(q) == '@') {
                    tot++;
                    if(tot >= 4)
                        continue;
                }
                p = i-1;
                q = j+1;
                if(isValid(p, q) && input.get(p).charAt(q) == '@') {
                    tot++;
                    if(tot >= 4)
                        continue;
                }
                p = i+1;
                q = j-1;
                if(isValid(p, q) && input.get(p).charAt(q) == '@') {
                    tot++;
                    if(tot >= 4)
                        continue;
                }
                p = i;
                q = j-1;
                if(isValid(p, q) && input.get(p).charAt(q) == '@') {
                    tot++;
                    if(tot >= 4)
                        continue;
                }
                p = i;
                q = j+1;
                if(isValid(p, q) && input.get(p).charAt(q) == '@') {
                    tot++;
                    if(tot >= 4)
                        continue;
                }
                p = i-1;
                q = j;
                if(isValid(p, q) && input.get(p).charAt(q) == '@') {
                    tot++;
                    if(tot >= 4)
                        continue;
                }
                p = i+1;
                q = j;
                if(isValid(p, q) && input.get(p).charAt(q) == '@') {
                    tot++;
                    if(tot >= 4)
                        continue;
                }
                if(tot < 4)
                    ans++;
            }
        }
    System.out.println(ans);
    }
}
