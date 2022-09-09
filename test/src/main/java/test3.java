

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;
import java.math.BigInteger;
import java.util.Arrays;

    public class test3 {
        public static void main(String args[]) {
            try {
                //MongoCredential credential = MongoCredential.createCredential("root", "user201800301236", "123456".toCharArray());
                MongoClient mongoClient = new MongoClient("localhost", 27017);

                MongoDatabase db = mongoClient.getDatabase("user201800301236");

                System.out.println("connect to database successfully!");
                MongoCollection<Document> stu = db.getCollection("student");
                MongoCollection<Document> tec = db.getCollection("teacher");
                MongoCollection<Document> cour = db.getCollection("course");
                Document newstu=new  Document();
                long newsid=200900030104L;
                newstu.put("sid",newsid);
                newstu.put("name","LiuYan");
                newstu.put("sex","女");
                newstu.put("age",18);
                newstu.put("birthday","1996-6-6");
                newstu.put("dname","CS");
                newstu.put("class",2010);
                stu.insertOne(newstu);
                Document newtec=new  Document();
                newtec.put("tid",100104);
                newtec.put("name","Wang");
                newtec.put("sex","F");
                newtec.put("age",43);
                newtec.put("dname","CS");
                tec.insertOne(newtec);
                Document newcor=new  Document();
                newcor.put("cid",300004);
                newcor.put("name","HCI");
                newcor.put("fcid",null);
                newcor.put("credit",3);
                cour.insertOne(newcor);
                System.out.println("文档插入成功！");
                System.out.println("1.所有学生信息：");
                FindIterable<Document> stu_iter=stu.find(new Document());
                stu_iter.forEach(new Block<Document>() {
                    @Override
                    public void apply(Document document) {
                        System.out.println(document.toString());
                    }
                });
                System.out.println("2.所有教师信息：");
                FindIterable<Document> tec_iter=tec.find(new Document());
                tec_iter.forEach(new Block<Document>() {
                    @Override
                    public void apply(Document document) {
                        System.out.println(document.toString());
                    }
                });
                System.out.println("3.所有课程信息：");
                FindIterable<Document> cor_iter=cour.find(new Document());
                cor_iter.forEach(new Block<Document>() {
                    @Override
                    public void apply(Document document) {
                        System.out.println(document.toString());
                    }
                });
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


