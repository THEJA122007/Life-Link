package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LifeLinkByteFileManager {
        public static void copyFile(String source,String destination) {
                try (
                        FileInputStream input = new FileInputStream(source);
                        FileOutputStream output = new FileOutputStream(destination)
                ) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;

                        while ((bytesRead = input.read(buffer)) != -1) {
                                output.write(buffer,0,bytesRead);
                        }

                        System.out.println("File copied successfully.");

                } 
                catch (IOException e) {
                        System.out.println("Byte stream error: "+ e.getMessage());
                }
        }
}