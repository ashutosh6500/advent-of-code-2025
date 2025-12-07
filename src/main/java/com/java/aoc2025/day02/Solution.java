package com.java.aoc2025.day02;

import com.java.aoc2025.common.FileUtils;

import java.util.Arrays;
import java.util.List;
public class Solution {

    public static boolean checkInvalidStr(String s){
        if ( (s.length() & 1) == 1 ) {
            return false;
        }
        return s.substring(0,s.length()/2).equals(s.substring(s.length()/2));
    }

    public static boolean checkInvalidStrPart2(String s){

        for(int i = 1 ; i <= s.length()/2 ; i++){

            if(((s.length() & 1) == 1)){
                String check_str = "" , curr_str = "";
                // check only odd values.
                int part_size = 0, skip = -1;
                if((i & 1) == 1){
                    if(i > 1){
                        if(s.length() % i != 0)
                            continue;
                        part_size = s.length() / i;
                    }
                    else
                        part_size = 1;

                    //System.out.println("Considering part size" + part_size);
                    for(int j = 0 ; j<=s.length()-part_size ; j+=part_size){
                        if(j == 0)
                            check_str = s.substring(j , j+part_size) ;
                        else
                        {
                            curr_str = s.substring(j , j+part_size);

                            if(! curr_str.equals(check_str)) {
                                skip = 1;
                                break;
                            }

                        }
                    }
                    if(skip == -1 && check_str.equals(curr_str)) {

                        return true;
                    }
                }
                else
                    continue;
            }
            else
            {
                String check_str = "", curr_str = "";
                int part_size =0, skip = -1;
                if(i > 1){
                    if(s.length() % i != 0)
                        continue;
                    part_size = s.length() / i;
                }
                else
                    part_size = 1;
                for(int j = 0 ; j<=s.length()-part_size ; j+=part_size){
                    if(j == 0)
                        check_str = s.substring(j , j+part_size);
                    else
                    {
                        curr_str = s.substring(j , j+part_size);

                        if(! curr_str.equals(check_str)) {
                            skip = 1;
                            break;
                        }

                    }
                }
                if(skip == -1 && check_str.equals(curr_str)) {

                    return true;
                }

            }
        }

        return false;
    }
    public static void main(String [] args) throws java.lang.Exception {
        List<String> input = FileUtils.readLines("day02.txt");
        System.out.println(input);
        long ans = 0;
        for(String s: input){

            String [] lis = s.split(",");
            for(String range : lis){

                String left_index = range.split("-")[0].trim() ;
                String right_index = range.split("-")[1].trim();
                long left_itr = Long.parseLong(left_index), right_itr = Long.parseLong(right_index);
                for(long i = left_itr ; i <= right_itr ; i++){
                    if(checkInvalidStrPart2(Long.toString(i)))
                    {
                        ans = ans + i;
                        System.out.println("Considered" + i);
                    }

                }
            }
        System.out.println(ans);
        }
    }
}


