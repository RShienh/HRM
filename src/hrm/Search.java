/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author rajbi
 */
public class Search {

    public static void searchList() throws FileNotFoundException, IOException {
        Scanner in = new Scanner(System.in);
        String eID, eData;
        File dB = new File("Database.txt");
        BufferedReader br = new BufferedReader(new FileReader(dB));
        System.out.print("      Enter the ID of the Employee data to searched ");
        eID = in.nextLine();
        while ((eData = br.readLine()) != null) {
            if (eData.contains(eID)) {

                System.out.println("\nData has found");
            }
        }
        br.close();
    }
}
