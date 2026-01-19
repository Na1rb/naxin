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
        // 验证数据
        String validateResult = student.validate();
        if (validateResult != null) {
            throw new RuntimeException(validateResult);
        }

        // 检查学号是否已存在
        if (studentMapper.existsByStudentId(student.getStudentId()) > 0) {
            throw new RuntimeException("学号已存在");
        }

        return studentMapper.insert(student);
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
        // 验证数据
        String validateResult = student.validate();
        if (validateResult != null) {
            throw new RuntimeException(validateResult);
        }

        // 检查学生是否存在
        Student existing = studentMapper.selectById(student.getId());
        if (existing == null) {
            throw new RuntimeException("学生不存在");
        }

        // 检查学号是否重复（排除当前学生）
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