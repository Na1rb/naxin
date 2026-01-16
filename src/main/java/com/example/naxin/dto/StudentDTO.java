package com.example.naxin.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private String studentId;
    private String name;
    private String className;

    // 手动验证方法
    public boolean isValid() {
        return studentId != null && !studentId.trim().isEmpty() &&
                name != null && !name.trim().isEmpty() &&
                className != null && !className.trim().isEmpty();
    }

    public String getValidationMessage() {
        if (studentId == null || studentId.trim().isEmpty()) {
            return "学号不能为空";
        }
        if (name == null || name.trim().isEmpty()) {
            return "姓名不能为空";
        }
        if (className == null || className.trim().isEmpty()) {
            return "班级不能为空";
        }
        return null;
    }
}
