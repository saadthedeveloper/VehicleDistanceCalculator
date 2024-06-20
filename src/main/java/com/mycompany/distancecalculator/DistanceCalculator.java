package com.mycompany.distancecalculator;

import java.io.*;
import javax.swing.JOptionPane;

public class DistanceCalculator {

    public static void main(String[] args)throws IOException {
        double hoursTaken = 0;
        double speed = 0;
        double distance = 0;
        String fileName = "";
        String input = "";

        JOptionPane.showMessageDialog(null, "This software calculates the distance traveled by a vehicle given its \nspeed and the time traveled, and saves the results to a specified\ntext file.");

        fileName = JOptionPane.showInputDialog("Enter the name of file you want to store data in (with .txt extension): ");
                       
        FileWriter fwriter = new FileWriter(fileName);
        PrintWriter outputfile = new PrintWriter(fwriter);
        
        input = JOptionPane.showInputDialog("Enter speed of the vehicle (Miles-per-hour):  ");
        speed = Double.parseDouble(input);

        input = JOptionPane.showInputDialog("Enter the number of hours travelled:");
        hoursTaken = Double.parseDouble(input);

        while (speed < 0)
        {
        input = JOptionPane.showInputDialog("Enter speed of the vehicle (Miles-per-hour)\nInput can't be negative :");
        speed = Double.parseDouble(input);
        }

        while (hoursTaken < 1) 
        {
        input = JOptionPane.showInputDialog("Enter the number of hours travelled (input can't be below 1): ");
        hoursTaken = Double.parseDouble(input);
        }

        outputfile.println("Hours      Distance Travelled");

        for (int i = 1; i <= hoursTaken; i++) {
            distance = speed * i;
            outputfile.printf("%-12d%.0f Miles\n", i, distance);
        }
        outputfile.close();
        fwriter.close();
    }
}
