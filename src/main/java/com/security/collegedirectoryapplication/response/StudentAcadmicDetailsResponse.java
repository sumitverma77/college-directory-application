package com.security.collegedirectoryapplication.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
    @AllArgsConstructor
public class StudentAcadmicDetailsResponse {

    private String studentName;
    private Long departmentId;
    private String departmentName;
    private String passingYear;
    private List<CourseDetails> courses;

    @Data
    @AllArgsConstructor
    public static class CourseDetails {
        private Long courseId;
        private String courseName;
        private FacultyInfo faculty;
    }

    @Data
    @AllArgsConstructor
    public static class FacultyInfo {
        private Long facultyId;
        private String facultyName;
        private String officeHours;
    }
}
