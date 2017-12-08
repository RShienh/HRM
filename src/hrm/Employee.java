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

    public static void addEmployee(String eID) throws IOException {
        List.listAll();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Database.txt", true));
        Scanner input = new Scanner(System.in);

        String eName, eAge, eAddress, ePosition, eSalary, eEmail;
        System.out.println("");

        if (eID != null) {
        } else {
            System.out.print("            Enter the Employee ID: ");
            eID = input.nextLine();
        }
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
        System.out.print("            Enter the Salary or Hour rate: ");
        eSalary = input.nextLine();

        bufferedWriter.write(eID + "|" + eName + "|" + eAge + "|" + eEmail + "|" + eAddress + "|" + ePosition + "|" + eSalary);
        bufferedWriter.flush();
        bufferedWriter.newLine();
        bufferedWriter.close();
        System.out.println("\n        Data successfully Added to Database !");
        List.listAll();
    }

    public static void deleteEmployee(String eID) throws IOException {
        List.listAll();
        Scanner in = new Scanner(System.in);
        String eData;
        File dB = new File("Database.txt");
        File tempDB = new File("Database_t.txt");
        BufferedReader br = new BufferedReader(new FileReader(dB));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));
        if (eID != null) {
        } else {
            System.out.print("      Enter the ID of the Employee data has to be deleted: ");
            eID = in.nextLine();
        }
        while ((eData = br.readLine()) != null) {
            if (eData.trim().startsWith(eID)) {
              //  System.err.println("\n              Data has successfully been deleted !");
                continue;
            }
            bw.write(eData);
            bw.flush();
            bw.newLine();
        }
        bw.close();
        br.close();

        if (!dB.delete()) {
            System.err.println("Failed to delete the file !");
        };

        if (!tempDB.renameTo(dB)) {
            System.out.println("Failed to rename file !");
        };
        List.listAll();
    }

    public static void updateEmployee() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the ID of the employee to be updated : ");
        String dID = in.nextLine();
        deleteEmployee(dID);
        addEmployee(dID);

    }
}
