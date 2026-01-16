# 实验室报名系统

一个简单的实验室报名系统后端，使用Spring Boot + MyBatis + MySQL实现。

## 技术栈
- Java 17
- Spring Boot 3.1.5
- MyBatis 3.0.2
- MySQL 8.0+
- Maven

## 快速开始

### 1. 环境要求
- JDK 17+
- MySQL 8.0+
- Maven 3.6+

### 2. 数据库配置
```sql
-- 创建数据库
CREATE DATABASE IF NOT EXISTS lab_registration;
USE lab_registration;

-- 创建学生表
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL,
    class_name VARCHAR(50) NOT NULL
);

-- 插入测试数据
INSERT INTO students (student_id, name, class_name) VALUES
('20230001', '张三', '计算机一班'),
('20230002', '李四', '计算机二班');
