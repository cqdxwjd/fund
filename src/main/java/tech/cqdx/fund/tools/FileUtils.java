package tech.cqdx.fund.tools;

import java.io.*;
import java.util.*;

public class FileUtils {
    //以行为单位读取文件，常用于读面向行的格式化文件
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }


    //统计文件中重复单词的个数
    public static Map<String, Integer> countLines(String in_filepath, String out_filepath) throws IOException {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        FileReader fileReader = new FileReader(in_filepath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String str = null;

        while ((str = bufferedReader.readLine()) != null) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        bufferedReader.close();
        fileReader.close();

        FileWriter fileWriter = new FileWriter(out_filepath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            bufferedWriter.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        bufferedWriter.close();
        fileWriter.close();
        return map;
    }

    //对map按值排序
    public static List<Map.Entry<String, Integer>> sort(Map<String, Integer> map) {
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list;
    }
}
