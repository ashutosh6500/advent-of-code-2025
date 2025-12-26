package com.java.aoc2025.day07;

import com.java.aoc2025.common.FileUtils;

import java.util.List;

public class Solution {
    static int ans , n, m;
    static List<String> grid ;
    static boolean visited [][];

    public static void recur(int i, int j){
        if(i < 0 || j< 0 || i >= n || j >= m){
            return;
        }

        if(grid.get(i).charAt(j) == '^' && ! visited[i][j]){
            if(! visited[i][j])
            ans++;
            visited[i][j] = true;
            recur(i, j+1);
            recur(i, j-1);
        }
        else if(! visited[i][j])
        {
            visited[i][j] = true;
            recur(i+1, j);
        }
        return;
    }
    public static void main(String[] args) throws Exception {

        grid = FileUtils.readLines("day07.txt");

        int source_index = grid.get(0).trim().indexOf('S');
        ans = 0;
        n = grid.size();
        m = grid.get(0).length();
        visited = new boolean[n][m];
        recur(0, source_index);
        System.out.println(ans);

    }
}
