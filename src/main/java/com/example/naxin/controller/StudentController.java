package com.example.naxin.controller;

import com.example.naxin.annotation.RequireRole;
import com.example.naxin.common.Result;
import com.example.naxin.entity.Student;
import com.example.naxin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
@RequireRole({"ADMIN", "USER"}) // 类级别权限：允许管理员和普通用户
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 创建学生
    @PostMapping
    @RequireRole({"ADMIN"})
    public Result<Student> createStudent(@RequestBody Student student) {
        try {
            int rows = studentService.createStudent(student);
            if (rows > 0) {
                return Result.success("创建成功", student);
            } else {
                return Result.error("创建失败");
            }
        } catch (RuntimeException e) {
            return Result.businessError(e.getMessage());
        }
    }

    // 查询所有学生
    @GetMapping
    public Result<List<Student>> getAllStudents() {
        try {
            List<Student> students = studentService.getAllStudents();
            return Result.success(students);
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }

    // 根据ID查询学生
    @GetMapping("/{id}")
    public Result<Student> getStudentById(@PathVariable Integer id) {
        try {
            Student student = studentService.getStudentById(id);
            return Result.success(student);
        } catch (RuntimeException e) {
            return Result.notFound(e.getMessage());
        }
    }

    // 根据学号查询学生
    @GetMapping("/studentId/{studentId}")
    public Result<Student> getStudentByStudentId(@PathVariable String studentId) {
        try {
            Student student = studentService.getStudentByStudentId(studentId);
            return Result.success(student);
        } catch (RuntimeException e) {
            return Result.notFound(e.getMessage());
        }
    }

    // 更新学生信息
    @PutMapping("/{id}")
    @RequireRole({"ADMIN"})
    public Result<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        try {
            student.setId(id);
            int rows = studentService.updateStudent(student);
            if (rows > 0) {
                return Result.success("更新成功", student);
            } else {
                return Result.error("更新失败");
            }
        } catch (RuntimeException e) {
            return Result.businessError(e.getMessage());
        }
    }

    // 删除学生
    @DeleteMapping("/{id}")
    @RequireRole({"ADMIN"})
    public Result<Void> deleteStudent(@PathVariable Integer id) {
        try {
            int rows = studentService.deleteStudent(id);
            if (rows > 0) {
                return Result.success("删除成功", null);
            } else {
                return Result.error("删除失败");
            }
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }

    // 获取学生总数
    @GetMapping("/count")
    public Result<Integer> getStudentCount() {
        try {
            int count = studentService.getStudentCount();
            return Result.success(count);
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }

    // 健康检查
    @GetMapping("/health")
    public Result<String> health() {
        return Result.success("服务运行正常");
    }
}

