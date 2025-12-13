package com.java.aoc2025.day05;

import java.util.*;
import com.java.aoc2025.common.FileUtils;

public class Solution {

    public static void main(String[] args) throws Exception {

        List<String> input = FileUtils.readLines("day05.txt");

        Vector<Long> numbers = new Vector<>();


        TreeMap<Long, List<Long>> mp = new TreeMap<>();

        boolean flag = false;

        for (String s : input) {
            s = s.trim();

            if (s.isEmpty()) {
                flag = true;
                continue;
            }

            if (flag) {
                numbers.add(Long.parseLong(s));
            } else {
                String[] arr = s.split("-");
                long start = Long.parseLong(arr[0]);
                long end = Long.parseLong(arr[1]);

                // multimap insert
                mp.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
            }
        }

        long ans = 0;

        System.out.println("numbers = " + numbers);
        System.out.println("ranges  = " + mp);


        for (long num : numbers) {
            boolean found = false;

            for (Map.Entry<Long, List<Long>> entry : mp.entrySet()) {
                long key = entry.getKey();

                if (key > num) {
                    break;
                }

                for (long value : entry.getValue()) {
                    if (num >= key && num <= value) {
                        ans++;
                        found = true;
                        break;
                    }
                }
                if(found)
                    break;
            }
        }

        System.out.println(ans);
    }
}
