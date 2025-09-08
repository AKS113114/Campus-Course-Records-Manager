package edu.ccrm.service;

import edu.ccrm.domain.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CourseService {
    private List<Course> courses = new ArrayList<>();
    private int idGen = 1;

    public Course create(String code, String title, int credits) {
        Course c = new Course.Builder()
                             .id(idGen++)
                             .code(code)
                             .title(title)
                             .credits(credits)
                             .build();
        courses.add(c);
        return c;
    }

    public List<Course> list() {
        return courses;
    }

    public Course findByCode(String code) {
        return courses.stream()
                      .filter(c -> c.getCode().equalsIgnoreCase(code))
                      .findFirst()
                      .orElse(null);
    }

    // Stream examples
    public List<Course> filterByMinCredits(int minCredits) {
        return courses.stream()
                      .filter(c -> c.getCredits() >= minCredits)
                      .collect(Collectors.toList());
    }

    public Map<Integer, Long> groupByCreditsCount() {
        return courses.stream()
                      .collect(Collectors.groupingBy(Course::getCredits, Collectors.counting()));
    }
}

