package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        String inputFileName = "Task2/file.txt";
        String outputFileName = "user.json";
        List<User> userList = new ArrayList<>();
        try (InputStream inputStream = Task2.class.getClassLoader().getResourceAsStream(inputFileName);
             InputStreamReader reader = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(reader)) {
        String str;
        boolean firsLine = true;
        while ((str = br.readLine()) != null){
            if (firsLine){
                firsLine = false;
                continue;
            }
            String[] arrStr = str.split(" ");
            if(arrStr.length == 2){
                String name = arrStr[0];
                int age = Integer.parseInt(arrStr[1]);
                userList.add(new User(name,age));
            }
        }
        }catch (IOException e){
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(userList);

        try (FileWriter writer = new FileWriter(outputFileName)){
            writer.write(json);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
