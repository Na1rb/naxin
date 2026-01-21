package com.example.naxin.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Student {
    private Integer id;
    private String studentId;
    private String name;
    private String className;
    private String phone;
    private String createdBy;    // 新增：创建人
    private LocalDateTime createTime; // 新增：创建时间

    // 验证方法
    public String validate() {
        if (studentId == null || studentId.trim().isEmpty()) {
            return "学号不能为空";
        }
        if (name == null || name.trim().isEmpty()) {
            return "姓名不能为空";
        }
        if (className == null || className.trim().isEmpty()) {
            return "班级不能为空";
        }
        if (phone == null || phone.trim().isEmpty()) {
            return "手机号不能为空";
        }
        if (!phone.matches("^1[3-9]\\d{9}$")) {
            return "手机号格式不正确";
        }
        return null;
    }
}
