package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LifeLinkFileManager {
        public static void writeFile(String filePath,String content) {
                try (
                        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))
                ) {
                        writer.write(content);
                        System.out.println("File written successfully: "+ filePath);
                } 
                catch (IOException e) {
                        System.out.println("File writing failed: " + e.getMessage());
                }
        }
        
        public static void appendFile(String filePath,String content) {
                try (   
                        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))
                ) {
                        writer.write(content);
                        writer.newLine();
                } 
                catch (IOException e) {
                        System.out.println("File append failed: " + e.getMessage());
                }
        }

        public static String readFile(String filePath) {
                StringBuilder content = new StringBuilder();
                try (
                        BufferedReader reader = new BufferedReader(new FileReader(filePath))
                ) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                                content.append(line);
                                content.append(System.lineSeparator());
                        }
                } 
                catch (IOException e) {
                        System.out.println("File reading failed: " + e.getMessage());
                }

                return content.toString();
        }
}