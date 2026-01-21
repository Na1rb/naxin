package com.example.naxin.service;

import com.example.naxin.common.PageResult;
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
    // 新增分页查询方法
    PageResult<Student> getStudentsByPage(Integer pageNum, Integer pageSize);
    // 条件分页查询
    PageResult<Student> getStudentsByCondition(String className, Integer pageNum, Integer pageSize);
}
