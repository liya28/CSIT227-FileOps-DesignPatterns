package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementSystem extends JFrame {

    private JPanel pMain;
    private JButton btn_addStudent;
    private JButton btn_viewStudentList;
    private JButton btn_calculateAverage;
    private JButton btn_saveCSV;
    private JTable table_Students;
    private JScrollPane table_StudentsScrollPane;
    private JLabel label_F1;
    private JTextField tf_Name;
    private JTextField tf_221;
    private JLabel label_Name;
    private JLabel label_221;
    private JTextField tf_227;
    private JTextField tf_213;
    private JLabel label_227;
    private JLabel label_213;
    private JPanel panel2;
    String[] cols = new String[]{"Name", "CSIT221", "CSIT227", "CSIT213"};
    Object[][] vals = new Object[][]{{"Aliyah", 5.0, 5.0, 5.0}};


    StudentManagementSystem() {
        table_Students = new JTable(vals, cols);
        table_StudentsScrollPane = new JScrollPane(table_Students);
        pMain = new JPanel(new BorderLayout());
        pMain.add(panel2, BorderLayout.NORTH);
        pMain.add(table_StudentsScrollPane, BorderLayout.CENTER);

        btn_addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        StudentManagementSystem s = new StudentManagementSystem();
        s.setContentPane(s.pMain);
        s.setSize(700, 700);
        s.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        s.setTitle("Student Management System");
        s.setVisible(true);
    }
}
