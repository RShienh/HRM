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
public class Employee {

    public static void addEmployee() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Database.txt", true));
        Scanner input = new Scanner(System.in);
        String eID, eName, eAge, eAddress, ePosition, ePayType, eSalary, eEmail;
        System.out.println("");
        System.out.print("            Enter the Employee ID: ");
        eID = input.nextLine();
        System.out.print("            Enter the Employee Name: ");
        eName = input.nextLine();
        System.out.print("            Enter the email address: ");
        eEmail = input.nextLine();
        System.out.print("            Enter the age of the Employee: ");
        eAge = input.nextLine();
        System.out.print("            Enter the Address of the Employee: ");
        eAddress = input.nextLine();
        System.out.print("            Enter the position of the Employee: ");
        ePosition = input.nextLine();
        System.out.print("            Enter the paytype H for Hourly, S for Salaried: ");
        ePayType = input.nextLine();
        System.out.print("            Enter the Salary or Hour rate: ");
        eSalary = input.nextLine();

        bufferedWriter.write(eID + "|" + eName + "|" +eAge + "|"+eEmail + "|" + eAddress + "|" + ePosition+ "|" + ePayType + "|" + eSalary+"|");
        bufferedWriter.flush();
        bufferedWriter.newLine();
        bufferedWriter.close();
        System.out.println("\n        Data successfully Added to Database !");
    }

    public static void deleteEmployee() throws FileNotFoundException, IOException {
        Scanner in = new Scanner(System.in);
        String eID, eData;
        File dB = new File("Database.txt");
        File tempDB = new File("Database_t.txt");
        BufferedReader br = new BufferedReader(new FileReader(dB));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));
        System.out.print("      Enter the ID of the Employee data to be deleted: ");
        eID = in.nextLine();
        while ((eData = br.readLine()) != null) {
            if (eData.contains(eID)) {
                bw.write(eData);
                bw.flush();
                bw.newLine();
                System.out.println("\nData has successfully been deleted");
            }
        }
        br.close();
        bw.close();
        dB.delete();
        tempDB.renameTo(dB);
    }
}
