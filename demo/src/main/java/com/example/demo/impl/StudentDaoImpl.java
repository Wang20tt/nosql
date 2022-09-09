package com.example.demo.impl;

import com.example.demo.DAO.StudentDao;

import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
        import org.springframework.data.mongodb.core.query.Query;
        import org.springframework.data.mongodb.core.query.Update;
        import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Component
public class StudentDaoImpl  implements StudentDao {

    @Resource
 private  MongoTemplate mongoTemplate;



    /**
     *  新增数据
     * */
    @Override
    public void saveData(Student stu) {
        mongoTemplate.save(stu);
    }


    /**
     *  删除数据
     * */
    @Override
    public void removeData(long id){
        Student stu = new Student();
        stu.setId(id);
        mongoTemplate.remove(stu);
    }

    /**
     *  更新数据
     * */
    @Override
    public void updateData(Student stu) {
        Query query = new Query(Criteria.where("id").is(stu.getId()));

        Update update = new Update();
        update.set("sid", stu.getId());
        update.set("name", stu.getName());
        update.set("sex", stu.getSex());
        update.set("age", stu.getAge());
        update.set("birthday", stu.getBirth());
        update.set("dname", stu.getMajor());
        update.set("class", stu.getCla());
        mongoTemplate.updateFirst(query, update, Student.class);
    }

    /**
     *  查询单条数据
     * */
    @Override
    public Student findDataById(long id) {

        Query query = new Query(Criteria.where("id").is(id));
        Student stu = mongoTemplate.findOne(query, Student.class);
        return stu;
    }
    /**
     *  查询符合条件的数据
     * */
    @Override
   public  List<Student> findDataByAge(int age) {
       Query query = new Query(Criteria.where("age").lt(age));
        //Student stu  = mongoTemplate.findOne(query, Student.class);
        List<Student> stu = mongoTemplate.find(query,Student.class,"student");
      return stu;
   }

    /**
     *  查询全部数据
     * */
    @Override
    public List<Student> findAllData(){
        Query query = new Query();
        List<Student> stu = mongoTemplate.find(query,Student.class,"student");

        return stu;

    }


}


