# CHANGELOG
所有对本项目的显著变更都会记录在此文件中。
格式遵循 [Keep a Changelog](https://keepachangelog.com/zh-CN/1.0.0/)，
本项目版本号遵循 [语义化版本](https://semver.org/lang/zh-CN/)。

## [v1.1.0] - 2026-01-21
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