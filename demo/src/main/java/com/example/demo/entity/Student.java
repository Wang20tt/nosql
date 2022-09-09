package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "student")
public class Student {
 @Id
        private long id;
        @Field("username")
        private String name;

        private String sex;
        private int age;
        private String birth;
        private String major;
        private int cla;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getCla() {
        return cla;
    }

    public void setCla(int cla) {
        this.cla = cla;
    }

    public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    public String getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return "学生信息：{" +
                "sid=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthday='" + birth + '\'' +
                ", dname='" + major + '\'' +
                ", class=" + cla +
                '}';
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}




