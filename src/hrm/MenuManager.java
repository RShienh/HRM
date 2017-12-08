/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrm;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author rajbir
 */
public class MenuManager {

    public static void Menus() throws IOException {
        Scanner input = new Scanner(System.in);
        String eID = null;
        System.out.println("Welcome to HRM system");
        System.out.println("..Select from list of menus..");
        boolean exit = false;
        do {
            System.out.println("1. Manage an employee");
            System.out.println("2. List of Employees");
            System.out.println("3. Find an employee");
            System.out.println("4. Check Attendence");
            System.out.println("5. Employee Performance data");
            System.out.println("6. Manage Employee Salary");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            switch (input.nextInt()) {
                case 1:
                    //call class variable of employee management
                    do {
                        System.out.println("");
                        System.out.println("    You have selected to Add/Remove/Edit Employee data");
                        System.out.println("    What would you like to do from the following ?");
                        System.out.println("        1. Add an employee");
                        System.out.println("        2. Remove an employee data");
                        System.out.println("        3. Edit employee's data");
                        System.out.println("        4. List of Employees");
                        System.out.println("        5. Exit");
                        System.out.print("          Select your option : - ");
                        switch (input.nextInt()) {
                            case 1:
                                Employee.addEmployee(eID);
                                break;
                            case 2:
                                Employee.deleteEmployee(eID);
                                break;
                            case 3:
                                Employee.updateEmployee();
                                break;
                            case 4:
                                List.listAll();
                                break;
                            case 5:
                                System.out.println("");
                                System.out.println("        You chose to exit !");
                                exit = true;
                                break;
                            default:
                                System.err.println("Invalid Choice, please select from the following menus");
                                break;
                        }
                    } while (!exit);

                    break;
                case 2:
                    //display list of employees
                    List.listAll();
                    break;
                case 3:
                    System.out.println("Searching for an employee : ");
                    Search.searchList();
                    break;
                case 4:
                    System.out.println("4. Check Attendence");
                    break;
                case 5:
                    System.out.println("5. Employee Performance data");
                    break;
                case 6:
                    System.out.println("6. Manage Employee Salary");
                    break;
                case 7:
                    System.out.println("");
                    System.out.println(" You chose to exit !");
                    exit = true;
                    break;
                default:
                    System.err.println("Invalid Choice, please select from the following menus");
            }

        } while (!exit);
    }
}
