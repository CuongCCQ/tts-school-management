/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RegCourse.java
 *
 * Created on 11-04-2011, 00:21:20
 */
package aptech.view.student;

import api.ClassOffer;
import api.ClassOfferDAO;
import api.Student;
import api.StudentCourseRegistration;
import api.StudentCourseRegistrationDAO;
import api.StudentDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thinp
 */
public class RegCourse extends javax.swing.JPanel {

    /** Creates new form RegCourse */
    public RegCourse() {
        initComponents();
        loadAll();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbxStudent = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cbxClass = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Student ID");

        jLabel2.setText("Class Offer");

        jLabel3.setText("Note");

        txtNote.setColumns(20);
        txtNote.setRows(5);
        jScrollPane1.setViewportView(txtNote);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(65, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        registration= new StudentCourseRegistration();
        registrationDAO= new StudentCourseRegistrationDAO();
        registration.setStudentId(listStudentID.get(cbxStudent.getSelectedIndex()));
        registration.setClassOfferId(listClassID.get(cbxClass.getSelectedIndex()));
        registration.setNote(txtNote.getText());
        registrationDAO.getSession().beginTransaction();
        registrationDAO.save(registration);
        registrationDAO.getSession().getTransaction().commit();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void loadAll() {
        studentDAO = new StudentDAO();
        student = new Student();
        List<Student> list = studentDAO.findAll();
        listStudentID = new ArrayList<Integer>();


        classOffer = new ClassOffer();
        classOfferDAO = new ClassOfferDAO();
        List<ClassOffer> listClassName = classOfferDAO.findAll();
        listClassID= new ArrayList<Integer>();

        for ( Student stud : list) {
            cbxStudent.addItem(stud.getName());
            listStudentID.add(stud.getStudentId());
        }
        for (ClassOffer clOffer : listClassName) {
            cbxClass.addItem(clOffer.getClassCode());
            listClassID.add(clOffer.getId());
        }
    }
    private Student student;
    private StudentDAO studentDAO;
    private ClassOffer classOffer;
    private ClassOfferDAO classOfferDAO;
    private  StudentCourseRegistration registration;
    private  StudentCourseRegistrationDAO  registrationDAO;
    private  List <Integer> listClassID;
    private   List<Integer> listStudentID;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxClass;
    private javax.swing.JComboBox cbxStudent;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtNote;
    // End of variables declaration//GEN-END:variables
}
