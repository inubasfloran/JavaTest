package service;

import util.Input;
import util.Validation;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Scanner;

import static util.ServiceUtil.generateARandomString;

public class FileWrite {
   public void createFile(String file){
        try {

            System.out.println("Enter number of lines");
            String input = Input.getInput();
            if(Validation.checkIfValidInteger(input)){
                FileOutputStream fileOutputStream  = new FileOutputStream(file);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                createInputToFile(input, bufferedOutputStream);
                bufferedOutputStream.close();
            }

        }catch (Exception e){
            if(e instanceof FileNotFoundException) {
                System.out.println("Unable to create file");
            } else if (e instanceof IOException){
                System.out.println("IO exception occured");
            } else {
                System.out.println("Unknow exception" );
                e.printStackTrace();
            }
        }
    }

    private void createInputToFile(String input, BufferedOutputStream bufferedOutputStream) throws IOException {
        int lines = Integer.parseInt(input);
        for(int counter = 1 ; counter <= lines ; counter++){
                bufferedOutputStream.write(generateARandomString().getBytes(StandardCharsets.UTF_8));
                //Do not add new line at the end of the file
                if(counter != lines) {
                    bufferedOutputStream.write(10); //linefeed
                }
        }
    }




}
