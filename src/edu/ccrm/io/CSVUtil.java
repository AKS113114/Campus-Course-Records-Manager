package edu.ccrm.io;

import edu.ccrm.domain.Student;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.Course.Builder;

import java.nio.file.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CSVUtil {

    public static List<Student> readStudents(Path p) throws IOException {
        List<Student> out = new ArrayList<>();
        if (!Files.exists(p)) return out;
        for (String line : Files.readAllLines(p)) {
            line = line.trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split(",");
            if (parts.length < 4) continue;
            int id = Integer.parseInt(parts[0].trim());
            String reg = parts[1].trim();
            String name = parts[2].trim();
            String email = parts[3].trim();
            out.add(new Student(id, reg, name, email));
        }
        return out;
    }

    public static void writeStudents(Path p, List<Student> students) throws IOException {
        List<String> lines = students.stream()
            .map(s -> String.format("%d,%s,%s,%s", s.getId(), s.getRegNo(), s.getName(), s.getEmail()))
            .collect(Collectors.toList());
        Files.createDirectories(p.getParent() == null ? Paths.get(".") : p.getParent());
        Files.write(p, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static List<Course> readCourses(Path p) throws IOException {
        List<Course> out = new ArrayList<>();
        if (!Files.exists(p)) return out;
        for (String line : Files.readAllLines(p)) {
            line = line.trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split(",");
            if (parts.length < 4) continue;
            int id = Integer.parseInt(parts[0].trim());
            String code = parts[1].trim();
            String title = parts[2].trim();
            int credits = Integer.parseInt(parts[3].trim());
            Course c = new Course.Builder().id(id).code(code).title(title).credits(credits).build();
            out.add(c);
        }
        return out;
    }

    public static void writeCourses(Path p, List<Course> courses) throws IOException {
        List<String> lines = courses.stream()
            .map(c -> String.format("%d,%s,%s,%d", c.getId(), c.getCode(), c.getTitle(), c.getCredits()))
            .collect(Collectors.toList());
        Files.createDirectories(p.getParent() == null ? Paths.get(".") : p.getParent());
        Files.write(p, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
