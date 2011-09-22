/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InputStaff.java
 *
 * Created on Apr 3, 2011, 4:44:19 PM
 */
package aptech.view.staff;

import api.AssigmentSchedule;
import api.AssigmentScheduleDAO;
import api.AttendanceDAO;
import api.Staff;
import api.StaffDAO;
import api.Student;
import api.SubjectAssignment;
import api.SubjectAssignmentDAO;
import aptech.util.AppUtil;
import aptech.util.Constant;
import aptech.util.IsSure;
import aptech.util.ValidatePerson;
import aptech.view.control.ImageControl;
import aptech.view.control.TtsDateChooser;
import aptech.view.control.image.ImageFileChooser;
import aptech.view.student.InputStudent;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import resources.images.PathUtil;

/**
 *
 * @author bo
 */
public class InputStaff extends javax.swing.JPanel {

    /** Creates new form InputStaff */
    public InputStaff() throws IOException {
        initComponents();
        initImage();
        initStaffToEdit();
        initDateChooser();
    }

    protected void initComponentV2() {
        initComponents();
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnImg = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        lblStaffCode = new javax.swing.JLabel();
        txtStaffCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtStaffName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStaffAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtStaffPhone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtStaffEmail = new javax.swing.JTextField();
        cbStaffSex = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 300));

        pnImg.setPreferredSize(new java.awt.Dimension(200, 202));

        javax.swing.GroupLayout pnImgLayout = new javax.swing.GroupLayout(pnImg);
        pnImg.setLayout(pnImgLayout);
        pnImgLayout.setHorizontalGroup(
            pnImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        pnImgLayout.setVerticalGroup(
            pnImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/gifIcon.gif"))); // NOI18N
        jButton2.setText("Select Photo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblStaffCode.setText("Staff Code");

        jLabel2.setText(" Name");

        jLabel3.setText("Address");

        jLabel6.setText("Phone Number");

        jLabel7.setText("Email");

        cbStaffSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fermale", "Male", " " }));

        jLabel8.setText("Sex");

        jLabel4.setText("Date Of Birth");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/save0002.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setForeground(new java.awt.Color(255, 51, 102));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/Delete2.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStaffCode, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStaffCode, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStaffAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtStaffPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbStaffSex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtStaffEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(175, 175, 175)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)))
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblStaffCode)
                                .addComponent(txtStaffCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(txtStaffPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)
                            .addComponent(txtStaffEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbStaffSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(txtStaffAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("static-access")
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ImageFileChooser fileChooser = new ImageFileChooser();
        int result = fileChooser.showDialog(this, "Select image");
        if (result == fileChooser.APPROVE_OPTION) {
            try {
                imageControl = new ImageControl(fileChooser.getSelectedFile().getAbsolutePath());

            } catch (IOException ex) {
                Logger.getLogger(InputStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.pnImg.removeAll();
        this.pnImg.add(imageControl);
        this.validate();
        this.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {

            String bodMesseage = ValidatePerson.chekDOB(dateChooserCombo.getDate());
            String emailMesseage = ValidatePerson.isEmail(txtStaffEmail.getText());
            String phoneMesseage = ValidatePerson.isPhoneNumber(txtStaffPhone.getText());
            StaffDAO staffDAO = new StaffDAO();
            if (!isValidate()) {
                return;

            }
            if (checkValidate(bodMesseage) && checkValidate(emailMesseage) && checkValidate(phoneMesseage)) {
                staffDAO.getSession().beginTransaction();
                initStaff();
                staffDAO.save(staff);
                staffDAO.getSession().getTransaction().commit();
                JOptionPane.showMessageDialog(this, "OK!Add success!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private boolean isValidate() throws ParseException {
        String msg = null;
        // validate staff code
        String staffCode = this.txtStaffCode.getText().trim();
        if (staffCode.isEmpty()) {
            AppUtil.showErrMsg(Constant.STAFF_CODE_INVALID);
            return false;
        }
        StaffDAO dao = new StaffDAO();
        List lstStaff = dao.findByStaffCode(staffCode);
        if (lstStaff.size() > 0) {
            if (staff == null) {
                AppUtil.showErrMsg(Constant.STAFF_CODE_IS_EXISTED);
                return false;
            }
        }

        if (this.txtStaffName.getText().trim().isEmpty()) {
            AppUtil.showErrMsg(Constant.NAME_INVALID);
            return false;
        }

        if (this.txtStaffAddress.getText().trim().isEmpty()) {
            AppUtil.showErrMsg(Constant.ADDRESS_INVALID);
            return false;
        }

        msg = ValidatePerson.chekDOB(dateChooserCombo.getDate());
        if (msg != null) {
            AppUtil.showErrMsg(msg);
            return false;
        }

        msg = ValidatePerson.isPhoneNumber(txtStaffPhone.getText());
        if (msg != null) {
            AppUtil.showErrMsg(msg);
            return false;
        }
        msg = ValidatePerson.isEmail(this.txtStaffEmail.getText().trim());
        if (msg != null) {
            AppUtil.showErrMsg(msg);

            return false;
        }
        return true;
    }

    @SuppressWarnings("static-access")
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        StaffDAO staffDAO = new StaffDAO();
        if (IsSure.confirm()) {
            staffDAO.getSession().beginTransaction();
            staffDAO.delete(staff);
            List<SubjectAssignment> lstSubjectAssignments = subjectAssignmentDAO.findByStaffId(staff.getStaffId());
            for (SubjectAssignment subjectAssignment : lstSubjectAssignments) {
                attendanceDAO.deleteByStaffID(assigmentScheduleDAO.findByClassOfferDetailId(subjectAssignment.getClassOfferDetailId()));
            }

            assigmentScheduleDAO.deleteByStaffID(subjectAssignmentDAO.findByStaffId(staff.getStaffId()));
            subjectAssignmentDAO.deleteByStaffID(staff.getStaffId());
            staffDAO.getSession().getTransaction().commit();
        }

    }//GEN-LAST:event_btnDeleteActionPerformed
    private boolean checkValidate(String input) {
        boolean check = true;
        if (input != null) {
            check = false;
            JOptionPane.showMessageDialog(this, input, "Eros", JOptionPane.ERROR_MESSAGE);
        }
        return check;
    }

    private void initStaff() throws ParseException {
        if (staff == null) {
            staff = new Staff();
        }
        staff.setName(txtStaffName.getText());
        staff.setStaffCode(txtStaffCode.getText());
        staff.setAddress(txtStaffAddress.getText());
        boolean checkSex = true;
        if (cbStaffSex.getSelectedIndex() == 0) {
            checkSex = false;
        }
        staff.setSex(checkSex);
        staff.setEmail(txtStaffEmail.getText());
        staff.setPhoneNumber(txtStaffPhone.getText());
        staff.setDateOfBirth(dateChooserCombo.getDate());
        staff.setPhoto(imageControl.getImgData());

    }

    private void initImage() throws IOException {
        InputStream resourceAsStream = PathUtil.class.getResourceAsStream(Constant.DEFAULT_IMG_NAME);
        imageControl = new ImageControl(resourceAsStream);
        this.pnImg.add(imageControl);
        dateChooserCombo = new TtsDateChooser();
    }

    private void initDateChooser() {
        dateChooserCombo = new TtsDateChooser();
        dateChooserCombo.setSize(168, 18);
        this.jPanel1.add(dateChooserCombo);
    }

    protected void initDateChooser(Date startDate) {
        initDateChooser();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        this.dateChooserCombo.setSelectedDate(calendar);
    }

    protected void initStaffFromModel(Staff studentFromModel) {
        try {
            this.staff = studentFromModel;
            this.txtStaffAddress.setText(staff.getAddress());
            this.txtStaffEmail.setText(staff.getEmail());
            this.txtStaffName.setText(staff.getName());
            this.txtStaffPhone.setText(staff.getPhoneNumber());
            this.txtStaffCode.setText(staff.getStaffCode());
            this.txtStaffCode.setEditable(false);
            initDateChooser(staff.getDateOfBirth());
            this.imageControl = new ImageControl(staff.getPhoto());
            this.pnImg.add(imageControl);
            if (staff.getSex()) {
                this.cbStaffSex.setSelectedIndex(1);
            }
        } catch (IOException ex) {
            //JOptionPane.showMessageDialog(this, Constant.ERORR_STRING);
        }
    }

    protected void initStaffToEdit() {
        this.btnDelete.setVisible(false);
        return;
    }
    private ImageControl imageControl;
    TtsDateChooser dateChooserCombo;
    private Staff staff;
    private SubjectAssignmentDAO subjectAssignmentDAO = new SubjectAssignmentDAO();
    private AssigmentScheduleDAO assigmentScheduleDAO = new AssigmentScheduleDAO();
    private AttendanceDAO attendanceDAO = new AttendanceDAO();
    //private  JButton btnDelete;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbStaffSex;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblStaffCode;
    private javax.swing.JPanel pnImg;
    private javax.swing.JTextField txtStaffAddress;
    private javax.swing.JTextField txtStaffCode;
    private javax.swing.JTextField txtStaffEmail;
    private javax.swing.JTextField txtStaffName;
    private javax.swing.JTextField txtStaffPhone;
    // End of variables declaration//GEN-END:variables
}