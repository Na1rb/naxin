package com.example.naxin.mapper;

import com.example.naxin.entity.Student;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface StudentMapper {

    // 创建学生（新增phone字段）
    @Insert("INSERT INTO students (student_id, name, class_name, phone) " +
            "VALUES (#{studentId}, #{name}, #{className}, #{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Student student);

    // 查询所有学生
    @Select("SELECT * FROM students ORDER BY id DESC")
    List<Student> selectAll();

    // 根据ID查询
    @Select("SELECT * FROM students WHERE id = #{id}")
    Student selectById(Integer id);

    // 根据学号查询
    @Select("SELECT * FROM students WHERE student_id = #{studentId}")
    Student selectByStudentId(String studentId);

    // 更新学生信息（新增phone字段）
    @Update("UPDATE students SET " +
            "student_id = #{studentId}, " +
            "name = #{name}, " +
            "class_name = #{className}, " +
            "phone = #{phone} " +
            "WHERE id = #{id}")
    int update(Student student);

    // 删除学生
    @Delete("DELETE FROM students WHERE id = #{id}")
    int delete(Integer id);

    // 统计总数
    @Select("SELECT COUNT(*) FROM students")
    int count();

    // 检查学号是否存在
    @Select("SELECT COUNT(*) FROM students WHERE student_id = #{studentId}")
    int existsByStudentId(String studentId);

    // 检查学号是否存在（排除指定ID）
    @Select("SELECT COUNT(*) FROM students WHERE student_id = #{studentId} AND id != #{id}")
    int existsByStudentIdExcludingId(@Param("studentId") String studentId, @Param("id") Integer id);
}
