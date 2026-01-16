package com.example.naxin.service;

import com.example.naxin.entity.Student;
import java.util.List;

public interface StudentService {
    int createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Integer id);
    Student getStudentByStudentId(String studentId);
    int updateStudent(Student student);
    int deleteStudent(Integer id);
    int getStudentCount();
}

