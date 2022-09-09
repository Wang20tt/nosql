import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test2 {
    private JLabel reset;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox2;
    private JLabel choose1;
    private JLabel value1;
    private JLabel change;
    private JLabel choose2;
    private JLabel value2;
    private JPanel JP;
    private JButton submitButton;

    public test2(){
        JFrame frame = new JFrame("test2");
        frame.setContentPane(JP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        comboBox1.addItem("--请选择--");
        comboBox1.addItem("sid");
        comboBox1.addItem("name");
        comboBox1.addItem("sex");
        comboBox1.addItem("age");
        comboBox1.addItem("birthday");
        comboBox1.addItem("dname");
        comboBox1.addItem("class");
        comboBox2.addItem("--请选择--");
        comboBox2.addItem("sid");
        comboBox2.addItem("name");

        comboBox2.addItem("sex");
        comboBox2.addItem("age");
        comboBox2.addItem("birthday");
        comboBox2.addItem("dname");
        comboBox2.addItem("class");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MongoClient mongoClient = new MongoClient("localhost", 27017);
                MongoDatabase db = mongoClient.getDatabase("user201800301236");
                System.out.println("connect to database successfully!");
                MongoCollection<Document> stu = db.getCollection("student");
                stu.updateOne(Filters.eq(comboBox1.getSelectedItem().toString(),textField1.getText()),new Document("$set",new Document(comboBox2.getSelectedItem().toString(),textField2.getText())));
                JOptionPane.showMessageDialog(null, "更改成功");
            }
        });
    }

    public static void main(String[] args) {
 new test2();
    }
}
