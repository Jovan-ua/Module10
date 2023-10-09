package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.*;

import java.io.InputStream;

public class Task1 {
    public static void main(String[] args) {
        String fileName = "Task1/file.txt";
        try (InputStream inputStream = Task1.class.getClassLoader().getResourceAsStream(fileName);
             InputStreamReader reader = new InputStreamReader(inputStream)) {
            if (inputStream != null) {
                BufferedReader bufferedReader = new BufferedReader(reader);

                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    if (isValidPhoneNumber(str)) {
                        System.out.println(str);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidPhoneNumber(String number) {

        String regex = "\\((\\d{3})\\)\\s(\\d{3})-(\\d{4})|(\\d{3})-(\\d{3})-(\\d{4})";
        return number.matches(regex);
    }
}

