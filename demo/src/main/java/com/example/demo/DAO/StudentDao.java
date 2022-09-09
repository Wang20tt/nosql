package com.example.demo.DAO;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface StudentDao  {
    void saveData(Student stu);

    void removeData(long id);

    void updateData(Student stu);

    Student findDataById(long id);
    List<Student> findDataByAge(int age);
    List<Student> findAllData();

}


