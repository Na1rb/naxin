package com.example.naxin.controller;

import com.example.naxin.entity.Student;
import com.example.naxin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Map<String, Object> createStudent(@RequestBody Student student) {
        Map<String, Object> result = new HashMap<>();
        try {
            int rows = studentService.createStudent(student);
            result.put("success", true);
            result.put("message", "创建成功");
            result.put("data", student);
        } catch (RuntimeException e) {
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    @GetMapping
    public Map<String, Object> getAllStudents() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Student> students = studentService.getAllStudents();
            result.put("success", true);
            result.put("data", students);
        } catch (RuntimeException e) {
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getStudentById(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            Student student = studentService.getStudentById(id);
            result.put("success", true);
            result.put("data", student);
        } catch (RuntimeException e) {
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    @GetMapping("/studentId/{studentId}")
    public Map<String, Object> getStudentByStudentId(@PathVariable String studentId) {
        Map<String, Object> result = new HashMap<>();
        try {
            Student student = studentService.getStudentByStudentId(studentId);
            result.put("success", true);
            result.put("data", student);
        } catch (RuntimeException e) {
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    @PutMapping("/{id}")
    public Map<String, Object> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        Map<String, Object> result = new HashMap<>();
        try {
            student.setId(id);
            int rows = studentService.updateStudent(student);
            result.put("success", true);
            result.put("message", "更新成功");
            result.put("data", student);
        } catch (RuntimeException e) {
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteStudent(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            int rows = studentService.deleteStudent(id);
            result.put("success", true);
            result.put("message", "删除成功");
        } catch (RuntimeException e) {
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    @GetMapping("/count")
    public Map<String, Object> getStudentCount() {
        Map<String, Object> result = new HashMap<>();
        try {
            int count = studentService.getStudentCount();
            result.put("success", true);
            result.put("count", count);
        } catch (RuntimeException e) {
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
