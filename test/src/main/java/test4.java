import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class test4 {
    public static void main(String[]args){
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase("user201800301236");
            System.out.println("connect to database successfully!");
            MongoCollection<Document> stu = db.getCollection("student");
            MongoCollection<Document> tec = db.getCollection("teacher");
            MongoCollection<Document> cour = db.getCollection("course");
            System.out.println("1.将WangXin的年龄改为22");
            stu.updateOne(Filters.eq("name","WangXin"), new Document("$set",new Document("age",22)));
            System.out.println("文档修改成功！");
            System.out.println("所有学生信息：");
            FindIterable<Document> stu_iter=stu.find(new Document());
            stu_iter.forEach(new Block<Document>() {
                @Override
                public void apply(Document document) {
                    System.out.println(document.toString());
                }
            });
            System.out.println("2.将Mrs.Ma的性别改为男");
            tec.updateOne(Filters.eq("name","Ma"),new Document("$set",new Document("sex","F")));
            System.out.println("文档修改成功！");
            System.out.println("所有教师信息：");
            FindIterable<Document> tec_iter=tec.find(new Document());
            tec_iter.forEach(new Block<Document>() {
                @Override
                public void apply(Document document) {
                    System.out.println(document.toString());
                }
            });
            System.out.println("3.将OS的先行课程号改为300002");
            cour.updateOne(Filters.eq("name","OS"),new Document("$set",new Document("fcid",300002)));
            System.out.println("文档修改成功！");
            System.out.println("所有课程信息：");
            FindIterable<Document> cor_iter=cour.find(new Document());
            cor_iter.forEach(new Block<Document>() {
                @Override
                public void apply(Document document) {
                    System.out.println(document.toString());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
