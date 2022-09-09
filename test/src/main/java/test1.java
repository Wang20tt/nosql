import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test1 {
    private JLabel sid;
    private JTextField textField1;
    private JTextField textField2;
private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JLabel name;
    private JLabel sex;
    private JLabel age;
    private JLabel birthday;
    private JLabel dname;
    private JLabel classnumber;
    private JLabel Student;
    private JPanel JP;
    private JButton submit;
    public test1(){

        JFrame frame = new JFrame("test");
        frame.setContentPane(JP);
        frame.setBounds(300,200,700,300);
        frame.setResizable(false
        );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MongoClient mongoClient = new MongoClient("localhost", 27017);

                MongoDatabase db = mongoClient.getDatabase("user201800301236");

                System.out.println("connect to database successfully!");
                MongoCollection<Document> stu = db.getCollection("student");
                Document newstu=new  Document();
                newstu.put("sid",textField1.getText());
                newstu.put("name",textField2.getText());
                newstu.put("sex",textField3.getText());
                newstu.put("age",textField4.getText());
                newstu.put("birthday",textField5.getText());
                newstu.put("dname",textField6.getText());
                newstu.put("class",textField7.getText());
                stu.insertOne(newstu);
                JOptionPane.showMessageDialog(null, "插入成功");
            }
        });
    }
    public static void main(String[] args) {
       new test1();

    }
}
