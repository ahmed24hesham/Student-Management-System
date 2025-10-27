/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd;
import BackEnd.Student;
import BackEnd.StudentDataBase;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Asus
 */
public class View extends javax.swing.JPanel {

     private DefaultTableModel model;
    private StudentDataBase b ;
    private javax.swing.JPanel mainPanel;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(main.class.getName());
    
  
    public View(javax.swing.JPanel mainPanel, StudentDataBase db) {
        initComponents();
        this.mainPanel = mainPanel;
        this.b = db;
        initData();
    }

    
    public void initData() {
b.readFromFile();
 model = (DefaultTableModel) jTable1.getModel();
model.setColumnIdentifiers(new String[]{"Student ID", "Full Name", "Age","Gender","Major","GPA"});
model.setRowCount(0);
for (Student s : b.getStudents()) {
    model.addRow(new Object[]{
        s.getStudentID(),
        s.getFullName(),
        s.getAge(),
        s.getGender(),
        s.getDepartment(),
        s.getGPA()});
}
}
    
    
     private void loadTable(ArrayList<Student> students) {
        model.setRowCount(0); // clear previous rows
        for (Student s : students) {
            model.addRow(new Object[]{
                s.getStudentID(),
                s.getFullName(),
                s.getAge(),
                s.getGender(),
                s.getDepartment(),
                s.getGPA()
            });
        }
        model.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Homebtn = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("sort By ID");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sort By Name");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Homebtn.setText("Home");
        Homebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(Homebtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(66, 66, 66)
                .addComponent(Homebtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        b.getStudents().sort(Comparator.comparing(Student::getFullName, String.CASE_INSENSITIVE_ORDER));
        loadTable(b.getStudents());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        b.getStudents().sort(Comparator.comparingInt(Student::getStudentID));
        loadTable(b.getStudents());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void HomebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomebtnActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)(mainPanel.getLayout());
        cl.show(mainPanel, "home");
    }//GEN-LAST:event_HomebtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Homebtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
