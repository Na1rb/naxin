package com.example.naxin.service.impl;

import com.example.naxin.entity.Student;
import com.example.naxin.mapper.StudentMapper;
import com.example.naxin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int createStudent(Student student) {
        check(student);

        if (studentMapper.existsByStudentId(student.getStudentId()) > 0) {
            throw new RuntimeException("学号已存在");
        }

        return studentMapper.insert(student);
    }

    private void check(Student student) {
        if (student.getStudentId() == null || student.getStudentId().trim().isEmpty()) {
            throw new RuntimeException("学号不能为空");
        }
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            throw new RuntimeException("姓名不能为空");
        }
        if (student.getClassName() == null || student.getClassName().trim().isEmpty()) {
            throw new RuntimeException("班级不能为空");
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        Student student = studentMapper.selectById(id);
        if (student == null) {
            throw new RuntimeException("学生不存在");
        }
        return student;
    }

    @Override
    public Student getStudentByStudentId(String studentId) {
        Student student = studentMapper.selectByStudentId(studentId);
        if (student == null) {
            throw new RuntimeException("学生不存在");
        }
        return student;
    }

    @Override
    public int updateStudent(Student student) {
        if (student.getId() == null) {
            throw new RuntimeException("ID不能为空");
        }
        check(student);

        Student existing = studentMapper.selectById(student.getId());
        if (existing == null) {
            throw new RuntimeException("学生不存在");
        }

        if (!existing.getStudentId().equals(student.getStudentId())) {
            if (studentMapper.existsByStudentId(student.getStudentId()) > 0) {
                throw new RuntimeException("学号已存在");
            }
        }

        return studentMapper.update(student);
    }

    @Override
    public int deleteStudent(Integer id) {
        Student student = studentMapper.selectById(id);
        if (student == null) {
            throw new RuntimeException("学生不存在");
        }
        return studentMapper.delete(id);
    }

    @Override
    public int getStudentCount() {
        return studentMapper.count();
    }
}