import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test_2 {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JButton submitButton;
public test_2(){
    JFrame frame = new JFrame("test_2");
    frame.setContentPane(panel1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    comboBox1.addItem("找出年龄小于20岁的所有学生");
    comboBox1.addItem("找出年龄小于20岁且是软件学院的学生");
    comboBox1.addItem("找出学生关系中的所有学生");
    MongoClient mongoClient = new MongoClient("localhost", 27017);
    MongoDatabase db = mongoClient.getDatabase("user201800301236");
    System.out.println("connect to database successfully!");
    MongoCollection<Document> stu = db.getCollection("student");
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
if(comboBox1.getSelectedItem().toString()=="找出年龄小于20岁的所有学生"){
    FindIterable<Document> stu_iter = stu.find(new Document("age", new Document("$lt", "20")));
    stu_iter.forEach(new Block<Document>() {
        @Override
        public void apply(Document document) {
            textArea1.append(document.toString()+"\n");
        }

    });
}else if(comboBox1.getSelectedItem().toString()=="找出年龄小于20岁且是软件学院的学生"){
    FindIterable<Document> stu_iter2=stu.find(new Document("age",new Document("$lt", "20")).append("dname", "软件学院"));
    stu_iter2.forEach(new Block<Document>() {
        @Override
        public void apply(Document document) {
           textArea1.append(document.toString()+"\n");
        }
    });
}else if(comboBox1.getSelectedItem().toString()=="找出学生关系中的所有学生"){
    FindIterable<Document> stu_iter3=stu.find(new Document());
    stu_iter3.forEach(new Block<Document>() {
        @Override
        public void apply(Document document) {
            textArea1.append(document.toString()+"\n");
        }
    });
}
        }
    });
}
    public static void main(String[] args) {
new test_2();
    }
}
