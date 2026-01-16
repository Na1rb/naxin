package com.example.naxin.mapper;

import com.example.naxin.entity.Student;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface StudentMapper {

    @Insert("INSERT INTO students (student_id, name, class_name) VALUES (#{studentId}, #{name}, #{className})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Student student);

    @Select("SELECT * FROM students ORDER BY id DESC")
    List<Student> selectAll();

    @Select("SELECT * FROM students WHERE id = #{id}")
    Student selectById(Integer id);

    @Select("SELECT * FROM students WHERE student_id = #{studentId}")
    Student selectByStudentId(String studentId);

    @Update("UPDATE students SET student_id = #{studentId}, name = #{name}, class_name = #{className} WHERE id = #{id}")
    int update(Student student);

    @Delete("DELETE FROM students WHERE id = #{id}")
    int delete(Integer id);

    @Select("SELECT COUNT(*) FROM students")
    int count();

    @Select("SELECT COUNT(*) FROM students WHERE student_id = #{studentId}")
    int existsByStudentId(String studentId);
}
