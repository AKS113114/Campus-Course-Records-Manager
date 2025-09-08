package edu.ccrm;

import edu.ccrm.service.*;
import edu.ccrm.domain.*;
import edu.ccrm.domain.enums.Semester;
import edu.ccrm.io.CSVUtil;
import edu.ccrm.io.BackupUtil;
import edu.ccrm.config.AppConfig;

import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentService ss = new StudentService();
        CourseService cs = new CourseService();
        EnrollmentService es = new EnrollmentService();

        System.out.println("Welcome to Campus Course & Records Manager!");
        boolean running = true;
        while(running){
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Add Course");
            System.out.println("4. List Courses");
            System.out.println("5. Enroll Student in Course");
            System.out.println("6. Backup Project");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = Integer.parseInt(sc.nextLine().trim());
            switch(choice){
                case 1:
                    System.out.print("Enter regNo: "); String reg=sc.nextLine();
                    System.out.print("Enter name: "); String name=sc.nextLine();
                    System.out.print("Enter email: "); String email=sc.nextLine();
                    ss.create(reg,name,email);
                    System.out.println("Student added.");
                    break;
                case 2:
                    ss.list().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Code: "); String code=sc.nextLine();
                    System.out.print("Title: "); String title=sc.nextLine();
                    System.out.print("Credits: "); int cr=Integer.parseInt(sc.nextLine());
                    cs.create(code,title,cr);
                    System.out.println("Course added.");
                    break;
                case 4:
                    cs.list().forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Student id: "); int sid=Integer.parseInt(sc.nextLine());
                    System.out.print("Course id: "); int cid=Integer.parseInt(sc.nextLine());
                    System.out.print("Semester (SPRING/SUMMER/FALL/WINTER): "); Semester sem=Semester.valueOf(sc.nextLine().trim().toUpperCase());
                    try {
                        es.enroll(sid,cid,sem);
                        System.out.println("Enrolled successfully.");
                    } catch(Exception ex){
                        System.out.println("Enroll error: " + ex.getMessage());
                    }
                    break;
                case 6:
                    var cfg = AppConfig.getInstance();
                    var dest = Paths.get(cfg.getBackupDir());
                    var src = Paths.get("."); // project root
                    var newPath = BackupUtil.backupFolder(src, dest);
                    System.out.println("Backup created at: " + newPath.toString());
                    break;

		case 7: // Import testdata
    try {
        var studentsFromFile = CSVUtil.readStudents(Paths.get("testdata/students.csv"));
        System.out.println("Imported students: " + studentsFromFile.size());
        studentsFromFile.forEach(System.out::println);

        var coursesFromFile = CSVUtil.readCourses(Paths.get("testdata/courses.csv"));
        System.out.println("Imported courses: " + coursesFromFile.size());
        coursesFromFile.forEach(System.out::println);
    } catch (Exception ex) {
        System.out.println("Error importing CSV: " + ex.getMessage());
    }
    break;

case 8: // Streams demo: search students
    System.out.print("Search name substring: ");
    String q = sc.nextLine();
    var found = ss.searchByNameStream(q);
    System.out.println("Found " + found.size() + " students:");
    found.forEach(System.out::println);
    break;

case 9: // filter courses by credits
    System.out.print("Min credits: ");
    int min = Integer.parseInt(sc.nextLine());
    var heavy = cs.filterByMinCredits(min);
    System.out.println("Courses with >= " + min + " credits:");
    heavy.forEach(System.out::println);
    break;

case 10: // group courses by credits
    var grouped = cs.groupByCreditsCount();
    System.out.println("Course counts by credits:");
    grouped.forEach((credits, cnt) -> System.out.println(credits + " credits -> " + cnt + " courses"));
    break;

case 11: // sort students by name
    ss.sortedByName().forEach(System.out::println);
    break;


                case 0:
                    running=false; break;
                default:
                    System.out.println("Invalid");
            }
        }
        sc.close();
        System.out.println("Goodbye!");
    }
}

