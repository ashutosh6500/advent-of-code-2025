package com.java.aoc2025.day01;
import com.java.aoc2025.common.FileUtils;
import java.util.List;
public class Solution {


    public static void main(String [] args) throws java.lang.Exception{
        List<String> input = FileUtils.readLines("day01.txt");

        //System.out.println(input) ;
        long ans = 0, ans_part_2 = 0, val= 50, previous_value = -1;
        for(String s: input){
            char dir = s.charAt(0);
            long cnt = val;
            if(Integer.parseInt(s.substring(1))  > 100) {
                ans_part_2 = ans_part_2 + (Integer.parseInt(s.substring(1)) / 100);
                System.out.println(Integer.parseInt(s.substring(1)) / 100);
            }
            if(dir == 'L'){
                val = val - (Integer.parseInt(s.substring(1)) % 100);

            }
            else {
                val = val + (Integer.parseInt(s.substring(1)) % 100);

            }

            if(val < 0) {

                val = val + 100;
                if(val != 0 && previous_value != 0) {

                    ans_part_2++;
                    System.out.println("part two here is" + ans_part_2 + "and val is " + val);
                }
            }
            else if(val > 99) {
                long prev_r_value = val;
                val = val - 100;
                if(val != 0 && previous_value != 0) {
                    ans_part_2++;
                    System.out.println("part twi here is" + ans_part_2);
                }

            }
            if(val == 0)
                ans++;
            //System.out.println(val);
            previous_value = val ;
        }
        System.out.println(ans + ans_part_2);
    }
}


