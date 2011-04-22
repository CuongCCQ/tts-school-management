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
import api.Attendance;
import api.AttendanceDAO;
import api.ClassOffer;
import api.ClassOfferDAO;
import api.StudentAttendance;
import api.StudentDAO;
import api.StudentV2;
import api.Subject;
import api.SubjectAssignment;
import api.SubjectAssignmentDAO;
import api.SubjectDAO;
import api.VStudentAtt;
import api.VStudentAttDAO;
import aptech.util.AppUtil;
import aptech.view.control.AttendanceTableModel;
import aptech.view.control.CmbObject;
import aptech.view.control.TtsCmbModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author thinp
 */
public class ResulPanel extends javax.swing.JPanel {

    /** Creates new form ResulPanel */
    public ResulPanel() {
        initComponents();
        initGui();
        initClassCmbBox();
        //initSubject();


    }

    private void initGui() {
        tblAttendance = new JTable();
        scrlPn.setViewportView(tblAttendance);
        tblAttendance.setFillsViewportHeight(true);
        revalidate();
        repaint();
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
        jLabel3 = new javax.swing.JLabel();
        cbxSubject = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        bttSave = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbxDate = new javax.swing.JComboBox();
        scrlPn = new javax.swing.JScrollPane();

        jLabel1.setText("Class Name");

        cbxClassName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxClassNameItemStateChanged(evt);
            }
        });
        cbxClassName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClassNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Subject");

        cbxSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSubjectActionPerformed(evt);
            }
        });

        jLabel4.setText("Class Student");

        bttSave.setText("Save");
        bttSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSaveActionPerformed(evt);
            }
        });

        jLabel6.setText("Date");

        cbxDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SelectDate" }));
        cbxDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                                .addGap(45, 45, 45))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbxSubject, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxClassName, javax.swing.GroupLayout.Alignment.LEADING, 0, 146, Short.MAX_VALUE)
                                .addComponent(cbxDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bttSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(scrlPn, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(155, 155, 155))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxClassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(cbxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(scrlPn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(bttSave))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel4)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxClassNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClassNameActionPerformed
        // TODO add your handling code here:
        initGui();
        CmbObject selectedObj = (CmbObject) cbxClassName.getSelectedItem();
        if (selectedObj.getValue().equals("-1")) {
            cbxSubject.removeAllItems();
        } else {
            int classOfferId = Integer.valueOf(selectedObj.getValue());
            List<CmbObject> lstCmb = new ArrayList<CmbObject>();
            List<Subject> lstSubject = new SubjectDAO().getAllSubjectByClassOfferId(classOfferId);
            if (lstSubject.size() > 0) {
                for (Subject subject : lstSubject) {
                    CmbObject cmbObj = new CmbObject(subject.getSubjectName(), subject.getSubjectId().toString());
                    lstCmb.add(cmbObj);
                }
                TtsCmbModel model = new TtsCmbModel(lstCmb);
                model.setFirstItemLabel("select subject");
                cbxSubject.setModel(model);
                cbxSubject.setSelectedIndex(0);
            }
        }

    }//GEN-LAST:event_cbxClassNameActionPerformed

    private void cbxDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDateActionPerformed
        scheduleChange();
    }

    private void scheduleChange() throws NumberFormatException {
        initGui();
        if (cbxDate.getSelectedIndex() > 0) {
            CmbObject cmbObjDate = (CmbObject) cbxDate.getSelectedItem();
            int assScheduleId = Integer.valueOf(cmbObjDate.getValue());
            CmbObject cmbObjClass = (CmbObject) cbxClassName.getSelectedItem();
            int classOfferId = Integer.valueOf(cmbObjClass.getValue());
            VStudentAttDAO dao = new VStudentAttDAO();
            List<VStudentAtt> lstStudenAtt = new ArrayList<VStudentAtt>();
            lstStudenAtt = dao.findByOfferAndAssScheduleId(classOfferId, assScheduleId);
            if (lstStudenAtt.size() < 1) {
                AttendanceDAO attendanceDAO = new AttendanceDAO();
                attendanceDAO.autoFillAttendaceForClass(classOfferId, assScheduleId);
                lstStudenAtt = dao.findByOfferAndAssScheduleId(classOfferId, assScheduleId);
            }
            List<StudentAttendance> lstAttendances = new ArrayList<StudentAttendance>();
            for (VStudentAtt att : lstStudenAtt) {
                StudentDAO studentDAO = new StudentDAO();
                StudentV2 student = studentDAO.findByIdV2(att.getStudentId());
                StudentAttendance attendance = new StudentAttendance();
                attendance.setStudentId(att.getStudentId());
                attendance.setAssigmentScheduleId(assScheduleId);
                attendance.setStudentCode(student.getStudentCode());
                attendance.setStudentName(student.getName());
                attendance.setAttendanceId(assScheduleId);
                attendance.setAbsenceStatus(att.getAbsenceStatus());
                attendance.setDescription(att.getDescription());
                attendance.setAttendanceId(att.getAttendanceId());
                lstAttendances.add(attendance);
            }
            if (lstAttendances.size() > 0) {
                tblModel = new AttendanceTableModel();
                tblModel.setLstData(lstAttendances);
                this.tblAttendance.setModel(tblModel);
                this.tblAttendance.revalidate();
                this.tblAttendance.repaint();
            }
        }
    }//GEN-LAST:event_cbxDateActionPerformed

    private void cbxSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSubjectActionPerformed
        
        initGui();
        if (cbxSubject.getSelectedIndex() == 0) {
            cbxDate.removeAllItems();
        } else {
            initSchedule();
        }
        // TODO add your handling code here:
}//GEN-LAST:event_cbxSubjectActionPerformed

    private void cbxClassNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxClassNameItemStateChanged
    }//GEN-LAST:event_cbxClassNameItemStateChanged

    private void bttSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSaveActionPerformed
        List<StudentAttendance> lstData = this.tblModel.getLstData();
        AttendanceDAO dao = new AttendanceDAO();
        dao.getSession().beginTransaction();
        for(Attendance att:lstData)
        {
            dao.attachDirty(att);
        }
        dao.getSession().getTransaction().commit();
        AppUtil.showNoticeMessage("Update Successfull");
}//GEN-LAST:event_bttSaveActionPerformed

    void initSchedule() {
        List<CmbObject> lstData = new ArrayList<CmbObject>();
        int classID = Integer.valueOf(((CmbObject) cbxClassName.getSelectedItem()).getValue());
        int subjectID = Integer.valueOf(((CmbObject) cbxSubject.getSelectedItem()).getValue());
        SubjectAssignmentDAO subjectAssignmentDAO=new SubjectAssignmentDAO();
        AssigmentScheduleDAO assigmentScheduleDAO =new AssigmentScheduleDAO();
        List<AssigmentSchedule> lstAssigmentSchedules=new ArrayList<AssigmentSchedule>();
        List<SubjectAssignment> lstList = subjectAssignmentDAO.findByClassStaffAndSubject(classID, AppUtil.UserToken.getStaffId(), subjectID);
        if (lstList.size() > 0) {

            int classOfferID = lstList.get(0).getClassOfferDetailId();
            lstAssigmentSchedules = assigmentScheduleDAO.findByClassOfferDetailId(classOfferID);

            if (lstAssigmentSchedules.size() > 0) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE MM/dd/yyyy");

                for (AssigmentSchedule assSchedule : lstAssigmentSchedules) {
                    String key = dateFormat.format(assSchedule.getDate());
                    CmbObject cmbObject = new CmbObject(key, assSchedule.getAssigmentScheduleId().toString());
                    lstData.add(cmbObject);
                }
            }
        }
        TtsCmbModel cmbModel = new TtsCmbModel(lstData);
        cmbModel.setFirstItemLabel("select class date");
        cbxDate.setModel(cmbModel);
        cbxDate.setSelectedIndex(0);

    }

    private void initClassCmbBox() {
        TtsCmbModel cmbModel = new TtsCmbModel();
        List<CmbObject> lstModel = new ArrayList<CmbObject>();
        List<ClassOffer> classTeachByStaffid = new ClassOfferDAO().getClassTeachByStaffid(AppUtil.UserToken.getStaffId());
        for (ClassOffer offer : classTeachByStaffid) {
            CmbObject cmb = new CmbObject(offer.getClassCode(), offer.getClassOfferId().toString());
            lstModel.add(cmb);
        }
        cmbModel.setLstData(lstModel);
        cmbModel.setFirstItemLabel("select your class");
        this.cbxClassName.setModel(cmbModel);
        cbxClassName.setSelectedIndex(0);

    }
    
    int a = 74;
    
    
    private JTable tblAttendance;
    private AttendanceTableModel tblModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttSave;
    private javax.swing.JComboBox cbxClassName;
    private javax.swing.JComboBox cbxDate;
    private javax.swing.JComboBox cbxSubject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane scrlPn;
    // End of variables declaration//GEN-END:variables
}
