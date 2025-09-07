package edu.ccrm;

import java.util.ArrayList;
import java.util.Scanner;
import edu.ccrm.domain.Student;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Welcome to Campus Course & Records Manager!");
        boolean running = true;

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter registration number: ");
                    String regNo = sc.nextLine();

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    Student s = new Student(id, regNo, name, email);
                    students.add(s);
                    System.out.println("✅ Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("📋 Student List:");
                        for (Student stu : students) {
                            System.out.println(stu);
                        }
                    }
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }

        sc.close();
        System.out.println("Goodbye!");
    }
}
