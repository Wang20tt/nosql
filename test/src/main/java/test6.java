import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.management.Query;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class test6 {
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JPanel jp;
    private JButton submitButton;
    private JScrollPane sp;

    public test6(){
        String a;
    JFrame frame = new JFrame("test6");
    frame.setContentPane(jp);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    comboBox1.addItem("列出student集合中出现过的所有课程名称");
    comboBox1.addItem("找出选课数目排名前10的学生");


        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("user201800301236");
        DB Db = mongoClient.getDB("user201800301236");
        DBCollection Stu = Db.getCollection("student");
        DBCollection SC = Db.getCollection("student_course");
        DBCollection Tea = Db.getCollection("teacher");
        DBCollection TC = Db.getCollection("teacher_course");
        DBCollection Cour = Db.getCollection("course");
        System.out.println("connect to database successfully!");
        //MongoCollection<Document> stu = db.getCollection("student");
        MongoCollection<Document> sc = db.getCollection("student_course");
        //MongoCollection<Document> tea = db.getCollection("teacher");
        //MongoCollection<Document> tc= db.getCollection("teacher_course");
        //MongoCollection<Document> cour = db.getCollection("course");
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (comboBox1.getSelectedItem().toString() == "列出student集合中出现过的所有课程名称") {
                List<String> result = Stu.distinct("dname");
                for (int i = 0; i < result.size(); i++) {
                    textArea1.append(result.get(i) + "\n");
                }

            } else if (comboBox1.getSelectedItem().toString() == "找出选课数目排名前10的学生") {
//                BasicDBObject key = new BasicDBObject("sid", true);
//                BasicDBObject cond = new BasicDBObject("$sum,cid", 1);
//                BasicDBObject initial = new BasicDBObject();
//                String reduce = "function Reduce(prev){prev.num++}";
//                SC.group(key, );

                List<Bson> list = new ArrayList<>();
                BasicDBObject _id = new BasicDBObject("_id", "$sid");
                _id.append("value", new BasicDBObject("$sum", 1));

                BasicDBObject group = new BasicDBObject("$group", _id);

                list.add(group);

                BasicDBObject result = new BasicDBObject();
                result.append("_id", 0);
                result.append("name", "$_id");
                result.append("value", "$value");

                BasicDBObject project = new BasicDBObject("$project", result);
                list.add(project);
                BasicDBObject so=new BasicDBObject("$sort",new BasicDBObject("value",-1));
                list.add(so);
                BasicDBObject limit=new BasicDBObject("$limit",10);
                list.add(limit);
                //System.out.println(list);
                AggregateIterable<Document> iterable = sc.aggregate(list);
                MongoCursor<Document> set = iterable.iterator();
                while (set.hasNext()) {
                    Document map = set.next();
                    textArea1.append(map+"\n");


                }
            }
        }
    });
}
    public static void main(String[] args) {
new test6();
    }
}
