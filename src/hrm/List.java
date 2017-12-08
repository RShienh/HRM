/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author rajbi
 */
public class List {

    public static void listAll() throws FileNotFoundException, IOException {
        String eData;
        BufferedReader br = new BufferedReader(new FileReader("Database.txt"));
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.format("%-5S%-15S%-10S%-20S%-20S%-20S%-15S",
                "ID", "Name", "Age", "Email", "Address", "Position", "Salary");//Used formatters to format output data
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        while ((eData = br.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(eData, "|");
            System.out.format("%-5s%-15s%-10s%-20s%-20s%-20s%-15s",
                    tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(),
                    tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
            System.out.println("");
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        br.close();
    }

}
