# 实验室报名系统

一个简单的实验室报名系统后端，使用Spring Boot + MyBatis + MySQL实现。

## 技术栈
- Java 17
- Spring Boot 3.1.5
- MyBatis 3.0.2
- MySQL 8.0+
- Maven

## 快速开始

## 权限控制

系统支持两种角色：
- **ADMIN**：管理员，拥有所有CRUD权限
- **USER**：普通用户，只有查询权限

### 使用方式
在请求头中添加用户角色信息：

### 1. 环境要求
- JDK 17+
- MySQL 8.0+
- Maven 3.6+

### 2. 数据库配置
```sql
-- 创建数据库
CREATE DATABASE IF NOT EXISTS lab_registration;
USE lab_registration;

-- 创建学生表（包含手机号字段）
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL,
    class_name VARCHAR(50) NOT NULL,
    phone VARCHAR(20)
);

-- 插入测试数据
INSERT INTO students (student_id, name, class_name, phone) VALUES
('20230001', '张三', '计算机一班', '13800138001'),
('20230002', '李四', '计算机二班', '13800138002');