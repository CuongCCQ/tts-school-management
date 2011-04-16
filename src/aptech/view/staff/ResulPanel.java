/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ResulPanel.java
 *
 * Created on 10-04-2011, 14:39:29
 */
package aptech.view.staff;

import api.AssigmentSchedule;
import api.AssigmentScheduleDAO;
import api.ClassOffer;
import api.ClassOfferDAO;
import api.Student;
import api.StudentCourseRegistration;
import api.StudentCourseRegistrationDAO;
import api.StudentDAO;
import api.StudentV2;
import api.SubjectAssignment;
import api.SubjectAssignmentDAO;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author thinp
 */
public class ResulPanel extends javax.swing.JPanel {

    /** Creates new form ResulPanel */
    public ResulPanel() {
        initComponents();
        initClass();
        //initStudent();
        //initSchedu();

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
        cbxClassName = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cbxStudent = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Class Name");

        cbxClassName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClassNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Student Code");

        cbxStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxStudentActionPerformed(evt);
            }
        });

        jLabel3.setText("Subject");

        jLabel4.setText("Description");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbxStudent, 0, 166, Short.MAX_VALUE)
                        .addComponent(cbxClassName, 0, 166, Short.MAX_VALUE)
                        .addComponent(jComboBox1, 0, 166, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxClassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxClassNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClassNameActionPerformed
        // TODO add your handling code here:
        try {
            int clsOfferID = lstIDClass.get(cbxClassName.getSelectedIndex());
            List<StudentCourseRegistration> lstReg = new ArrayList<StudentCourseRegistration>();
            lstReg = studentCourseRegistrationDAO.findByClassOfferId(clsOfferID);
            lstStudentID.clear();
            for (StudentCourseRegistration stuIdTemp : lstReg) {
                lstStudentID.add(stuIdTemp.getStudentId());
            }
           //System.out.println(lstStudentID);
           for (Integer integer : lstStudentID) {
                studentV2 = studentDAO.findByIdV2(integer);
                cbxStudent.addItem(studentV2.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbxClassNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //initSchedu();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxStudentActionPerformed

    public void initSchedu() {
        if (lstClassOfferDetail.isEmpty()) {
            for (SubjectAssignment subjectAss : test) {
                lstClassOfferDetail.add(subjectAss.getClassOfferDetailId());
            }
        }

        System.out.println(lstClassOfferDetail);
        int classID = lstIDClass.get(cbxClassName.getSelectedIndex());
        System.out.println(lstStudentID);
    }

    void initClass() {
        HashSet<Integer> hsIDClass = new HashSet<Integer>();
        for (SubjectAssignment subjectTemp : test) {
            hsIDClass.add(subjectTemp.getClassOfferId());
        }
        for (Integer integer : hsIDClass) {
            cbxClassName.addItem(classOfferDAO.findById(integer).getClassCode());
            lstIDClass.add(integer);
        }



    }

    void initStudent() {
        for (Integer integer : lstIDClass) {
            System.out.println(integer);
        }


    }
    private ClassOffer classOffer = new ClassOffer();
    private ClassOfferDAO classOfferDAO = new ClassOfferDAO();
    private SubjectAssignment assignment = new SubjectAssignment();
    private SubjectAssignmentDAO subjectAssignmentDAO = new SubjectAssignmentDAO();
    private StudentV2 studentV2 = new StudentV2();
    private StudentDAO studentDAO = new StudentDAO();
    private StudentCourseRegistration studentCourseRegistration = new StudentCourseRegistration();
    private StudentCourseRegistrationDAO studentCourseRegistrationDAO = new StudentCourseRegistrationDAO();
    int a = 74;
    List<SubjectAssignment> test = subjectAssignmentDAO.findByStaffId(a);
    List<Integer> lstIDClass = new ArrayList<Integer>();
    List<Student> lstStudent = new ArrayList<Student>();
    List<Integer> lstClassOfferDetail = new ArrayList<Integer>();
    List<Integer> lstClassID = new ArrayList<Integer>();
    List<AssigmentSchedule> lstAssigmentSchedules = new ArrayList<AssigmentSchedule>();
    AssigmentScheduleDAO assigmentScheduleDAO = new AssigmentScheduleDAO();
    List<Integer> lstStudentID = new ArrayList<Integer>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxClassName;
    private javax.swing.JComboBox cbxStudent;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
