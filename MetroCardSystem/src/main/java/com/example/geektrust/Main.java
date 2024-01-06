package com.example.geektrust;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.geektrust.Command.CommandInvoker;
import com.example.geektrust.Configure.ApplicationConfig;

public class Main {
	
	public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.loadCommands();
        CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
        if (args.length != 1) {
            System.out.println("Invalid Argument");
            return;
        }
        // Get the file path from the command line argument
        String filePath = args[0];
        try (BufferedReader reader =
                new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line =null;
            while ((line = reader.readLine()) != null) {

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
