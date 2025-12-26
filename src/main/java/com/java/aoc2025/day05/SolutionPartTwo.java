package com.java.aoc2025.day05;

import java.util.*;
import com.java.aoc2025.common.FileUtils;

public class SolutionPartTwo {

    public static void main(String[] args) throws Exception {

        List<String> input = FileUtils.readLines("day05.txt");

        Vector<Long> numbers = new Vector<>();


        TreeMap<Long, List<Long>> mp = new TreeMap<>();

        boolean flag = false;

        for (String s : input) {
            s = s.trim();

            if (s.isEmpty()) {
                flag = true;
                break;
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

        long ans = 0, last_captured_value = -1;
        System.out.println("ranges  = " + mp);
        for (Map.Entry<Long, List<Long>> entry : mp.entrySet()) {
            long key = entry.getKey();
            long max_value = Collections.max(entry.getValue());
            if(last_captured_value == -1){
                last_captured_value = max_value;
                ans+= (last_captured_value - key + 1);
                continue;
            }
            if(key > last_captured_value ){
                last_captured_value = max_value;
                ans+= (last_captured_value - key + 1);
            }
            else if(key <= last_captured_value){
                if(max_value <= last_captured_value){
                    continue;
                }
                ans+= (max_value - (Long.max(last_captured_value, key)));
                last_captured_value = max_value;
            }
        }
        System.out.println(ans);
    }
}
