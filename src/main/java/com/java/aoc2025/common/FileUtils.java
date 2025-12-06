package com.java.aoc2025.common;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

public class FileUtils {

    private static BufferedReader getReader(String fileName) {
        InputStream is = FileUtils.class.getClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            throw new RuntimeException("Input file not found: " + fileName);
        }
        return new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
    }

    /** Read file into List<String> */
    public static List<String> readLines(String fileName) {
        try (Stream<String> lines = getReader(fileName).lines()) {
            return lines.toList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /** Stream the file line-by-line (best for traversal) */
    public static Stream<String> stream(String fileName) {
        return getReader(fileName).lines();
    }
}

