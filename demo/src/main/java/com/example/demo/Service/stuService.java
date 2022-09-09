package com.example.demo.Service;

import com.example.demo.entity.Student;

import java.util.List;

public interface stuService {
    void saveData(Student stu);

    void removeData(long id);

    void updateData(Student stu);

    Student findDataById(long id);
    List<Student> findDataByAge(int age);
    List<Student> findAllData();


}
