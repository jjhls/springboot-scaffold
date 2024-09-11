package com.thinktech.utils;


import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hls
 * @project springboot-scaffold
 * @date 2024/9/11 10:34:10
 */
public class RandomCity {

    public static void main(String[] args) throws Exception {
        Pattern p = Pattern.compile(".*:\"(.*)\".*");
        String path = System.getProperty("user.dir") + "/files/list.json";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = reader.readLine()) != null) {
            //匹配4个0
            if (line.matches(".*0{4}.*")) {
                Matcher matcher = p.matcher(line);
                if (matcher.find()) {
                    String city = matcher.group(1);
                    System.out.println(city);
                }
            } else if (line.matches(".*00\".*$")) {
                Matcher matcher = p.matcher(line);
                if (matcher.find()) {
                    String city = matcher.group(1);
                    System.out.println(city);
                }
            } else{
                Matcher matcher = p.matcher(line);
                if (matcher.find()) {
                    String city = matcher.group(1);
                    System.out.println(city);
                }
            }

        }
        reader.close();

    }
}
