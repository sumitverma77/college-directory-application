package com.security.collegedirectoryapplication.service;

import com.security.collegedirectoryapplication.entity.*;
import com.security.collegedirectoryapplication.repo.*;
import com.security.collegedirectoryapplication.request.StudentAcadmicDetailsRequest;
import com.security.collegedirectoryapplication.response.ResponseWrapper;
import com.security.collegedirectoryapplication.response.StudentAcadmicDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    DepartmentRepo departmentRepo;
     @Autowired
     StudentProfileRepo studentProfileRepo;
     @Autowired
     CourseRepo courseRepo;
     @Autowired
     EnrollmentRepo enrollmentRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    FacultyProfileRepo facultyProfileRepo;

    public ResponseWrapper<StudentAcadmicDetailsResponse> studentAcadmicInfo(StudentAcadmicDetailsRequest studentAcadmicDetailsRequest)
    {

        StudentProfile student = studentProfileRepo.findByUserId(studentAcadmicDetailsRequest.getUserid());
        User user = userRepo.findByUserId(studentAcadmicDetailsRequest.getUserid());

        List<Enrollment>enrollments = enrollmentRepo.findByStudentId(studentAcadmicDetailsRequest.getUserid());

        List<StudentAcadmicDetailsResponse.CourseDetails> courses = new ArrayList<StudentAcadmicDetailsResponse.CourseDetails>();

        for(Enrollment enrollment:enrollments)
            {
                Long courseId= enrollment.getCourseId();
                String courseTitle= courseRepo.findById(courseId).get().getTitle();
                Long facultyId= courseRepo.findById(courseId).get().getFacultyId();
                FacultyProfile facultyProfile = facultyProfileRepo.findById(facultyId).get();
                StudentAcadmicDetailsResponse.FacultyInfo facultyInfo = new StudentAcadmicDetailsResponse.FacultyInfo(facultyProfile.getUserId(),userRepo.findByUserId(facultyId).getName(),facultyProfile.getOfficeHours());
                courses.add( new StudentAcadmicDetailsResponse.CourseDetails(enrollment.getCourseId(),courseRepo.findById(enrollment.getCourseId()).get().getTitle(), facultyInfo));
            }
        StudentAcadmicDetailsResponse studentAcadmicDetailsResponse = new StudentAcadmicDetailsResponse(user.getName(),student.getDepartmentId(), departmentRepo.findById(student.getDepartmentId()).get().getName(), student.getYear(),courses);
       return new ResponseWrapper<>(studentAcadmicDetailsResponse , "sucessful" , HttpStatus.OK);

    }

}
