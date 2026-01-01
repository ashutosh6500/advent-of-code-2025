package com.java.aoc2025.day09;

import com.java.aoc2025.common.FileUtils;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {

        List<String> input = FileUtils.readLines("day09.txt");
        System.out.println(input);

        List<List<Long>> num_list = new ArrayList<>();

        long max_col = -1, max_row = -1;
        long min_row = Long.MAX_VALUE, min_col = Long.MAX_VALUE;

        for (String s : input) {

            String[] nums = s.trim().split(",");

            // swap
            String tmp = nums[0];
            nums[0] = nums[1];
            nums[1] = tmp;

            long r = Long.parseLong(nums[0]);
            long c = Long.parseLong(nums[1]);

            if (r > max_row) max_row = r;
            if (c > max_col) max_col = c;
            if (r < min_row) min_row = r;
            if (c < min_col) min_col = c;

            List<Long> pair = new ArrayList<>();
            pair.add(r);
            pair.add(c);
            num_list.add(pair);
        }

        System.out.println("max row is " + max_row + " max col is " + max_col);

        long ans = -1;

        long breadth = max_row - min_row + 1;

        long col_min_one = Long.MAX_VALUE, col_max_one = -1;
        long col_min_two = Long.MAX_VALUE, col_max_two = -1;

        for (List<Long> lis : num_list) {
            if (lis.get(0) == max_row) {
                if (lis.get(1) > col_max_one) col_max_one = lis.get(1);
                if (lis.get(1) < col_min_one) col_min_one = lis.get(1);
            }
            if (lis.get(0) == min_row) {
                if (lis.get(1) > col_max_two) col_max_two = lis.get(1);
                if (lis.get(1) < col_min_two) col_min_two = lis.get(1);
            }
        }

        long length = Math.max(col_max_one - col_min_two + 1, col_max_two - col_min_one + 1);
        ans = Math.max(ans, (breadth ) * (length ));

        // part 2

        breadth = max_col - min_col + 1;

        long row_min_one = Long.MAX_VALUE, row_max_one = -1;
        long row_min_two = Long.MAX_VALUE, row_max_two = -1;

        for (List<Long> lis : num_list) {
            if (lis.get(1) == min_col) {
                if (lis.get(0) > row_max_one) row_max_one = lis.get(0);
                if (lis.get(0) < row_min_one) row_min_one = lis.get(0);
            }
            if (lis.get(1) == max_col) {
                if (lis.get(0) > row_max_two) row_max_two = lis.get(0);
                if (lis.get(0) < row_min_two) row_min_two = lis.get(0);
            }
        }

        length = Math.max(row_max_one - row_min_two + 1, row_max_two - row_min_one + 1);
        ans = Math.max(ans, (breadth ) * (length ));

        System.out.println("answer is " + ans + " breadth is " + breadth + " length is " + length);
    }
}
