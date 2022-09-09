import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test_5 {
    private JTextField textField1;
    private JButton search;
    private JLabel sid;
    private JLabel course_in;

    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton submitButton;
    private JPanel jp;
    private JComboBox comboBox3;
    private JTextArea textArea1;

    public test_5(){
        JFrame frame = new JFrame("test_5");
        frame.setContentPane(jp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        comboBox2.addItem("300001");
        comboBox2.addItem("300002");
        comboBox2.addItem("300003");
        comboBox2.addItem("300004");
        comboBox1.addItem("--请选择--");
        comboBox1.addItem("添加");
        comboBox1.addItem("更新");
        comboBox3.addItem("300001");
        comboBox3.addItem("300002");
        comboBox3.addItem("300003");
        comboBox3.addItem("300004");
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("user201800301236");
        System.out.println("connect to database successfully!");
        MongoCollection<Document> stu = db.getCollection("student_course");
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FindIterable<Document> sc_iter=stu.find(new Document("sid",textField1.getText().toString()));
                sc_iter.forEach(new Block<Document>() {
                    @Override
                    public void apply(Document document) {
                      textArea1.append(document.toString()+"\n");
                    }
                });
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem().toString()=="添加"){
                    Document newstu=new  Document();
                    newstu.put("sid",textField1.getText());
                    newstu.put("cid",comboBox2.getSelectedItem().toString());
                    newstu.put("score","60");
                    newstu.put("tid","300001");
                    stu.insertOne(newstu);
                    JOptionPane.showMessageDialog(null, "添加成功");
                }else if(comboBox1.getSelectedItem().toString()=="更新"){
                    stu.updateOne(Filters.eq("sid",textField1.getText()), new Document("$set",new Document("cid",comboBox3.getSelectedItem().toString())));
                    JOptionPane.showMessageDialog(null, "更新成功");
                }
            }
        });

    }

    public static void main(String[] args) {
new test_5();
    }
}
