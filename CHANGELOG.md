# CHANGELOG
所有对本项目的显著变更都会记录在此文件中。
格式遵循 [Keep a Changelog](https://keepachangelog.com/zh-CN/1.0.0/)，
本项目版本号遵循 [语义化版本](https://semver.org/lang/zh-CN/)。

## [v1.0.1] - 2026-01-21
### 新增 (Features)
- 学生表新增 `phone` 字段，支持手机号存储
- 新增统一返回结果类 `Result`，标准化接口返回格式
- 实体类添加手机号字段及格式验证逻辑

### 变更 (Changed)
- Mapper接口新增手机号相关的CRUD操作方法
- Service层新增手机号合法性校验逻辑
- Controller层统一使用 `Result` 封装返回数据
- 数据库初始化脚本同步更新表结构与测试数据
- API测试文档补充手机号字段的说明与示例

### 兼容说明
- 旧版数据库需执行 `ALTER TABLE students ADD COLUMN phone VARCHAR(20);` 完成字段新增


## [1.2.0] - 2026-01-22
### 新增
- 用户角色管理（ADMIN管理员/USER普通用户）
- 权限控制注解（@RequireRole）
- 权限拦截器（AuthInterceptor）
- PageHelper分页功能
- 分页返回结果（PageResult类）

### 数据库变更
- 新增users表存储用户信息
- students表新增created_by和create_time字段

### 配置变更
- 添加PageHelper依赖
- 添加WebConfig配置跨域和拦截器

### 修复
- 修复缺少RequireRole注解的问题
- 优化权限验证逻辑
- 修复分页查询参数默认值

## API变更
- GET /students/page - 新增分页查询
- GET /students/search - 新增条件分页查询
- POST /students, PUT /students/{id}, DELETE /students/{id} - 现在需要ADMIN权限
