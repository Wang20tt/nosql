package com.example.demo.Serviceimpl;

import com.example.demo.DAO.StudentDao;
import com.example.demo.Service.stuService;
import com.example.demo.entity.Student;

import java.util.List;

public class stuSerimpl implements stuService {
private StudentDao studao;
public void setStuDao(StudentDao sd){
    this.studao=sd;
}
    @Override
    public void saveData(Student stu) {
         studao.saveData(stu);
    }

    @Override
    public void removeData(long id) {
       studao.removeData(id);
    }

    @Override
    public void updateData(Student stu) {
  studao.updateData(stu);
    }

    @Override
    public Student findDataById(long id) {
        return studao.findDataById(id);
    }

    @Override
    public List<Student> findDataByAge(int age) {
        return studao.findDataByAge(age);
    }

    @Override
    public List<Student> findAllData() {
        return studao.findAllData();
    }
}
