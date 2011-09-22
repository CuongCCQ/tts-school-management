/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InputSubject.java
 *
 * Created on Apr 10, 2011, 6:23:53 PM
 */

package aptech.view.semester;

import api.ClassOffer;
import api.ClassOfferDAO;
import api.SubjectDAO;
import aptech.util.ValidateUtil;
import api.Subject;
import aptech.util.AppUtil;
import aptech.util.Constant;
import aptech.util.IsSure;
import java.text.ParseException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author anhson
 */
public class InputSubject extends javax.swing.JPanel {
    String confirmSaveMessage = Constant.SURE_TO_SAVE_SUBJECT;
    String confirmDeleteMessage = Constant.SURE_TO_DELETE_Subject;
    protected Subject subject;
   

    /** Creates new form InputSubject */
    public InputSubject() {
        initComponents();
        this.btnDelete.setVisible(false);
        this.lblTitle.setText("Add new subject");
    }
     protected void initComponentV2() {
        initComponents();
    }
     public JButton getBtnDelete() {
        return btnDelete;
    }
     public JLabel getLbtltitle()
     {
         return lblTitle;
     }
    protected void initSubjectFromModel(Subject subjectFromModel){
        try {
            this.subject = subjectFromModel;
            this.txtSubCode.setText(subject.getSubjectCode());
            this.txtSubName.setText(subject.getSubjectName());
            this.txtDescription.setText(subject.getDescription());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, Constant.ERROR_STRING);
        }
    }
   protected String initSubjectFromUI() throws ParseException {
        String errMsg = "";
        if (subject == null) {
            this.subject = new Subject();
        }
        this.subject.setSubjectCode(this.txtSubCode.getText().trim());
        this.subject.setSubjectName(this.txtSubName.getText().trim());
        this.subject.setDescription(this.txtDescription.getText().trim());
        return errMsg;
    }
    private boolean isValidate() throws ParseException {
        String msg = null;

        // validate staff code
        String subjectCode = this.txtSubCode.getText().trim();

        if (subjectCode.isEmpty()) {
            AppUtil.showErrMsg(Constant.SUBJECT_CODE_INVALID);
            txtSubCode.requestFocus();
            return false;
        }

        SubjectDAO dao = new SubjectDAO();
        List lstCourse = dao.findBySubjectCode(subjectCode);
        if (lstCourse.size() > 0) {
            AppUtil.showErrMsg(Constant.SUBJECT_CODE_IS_EXISTED);
            txtSubCode.requestFocus();
            return false;
        }

        if (this.txtSubName.getText().trim().isEmpty()) {
            AppUtil.showErrMsg(Constant.NAME_SUBJECT_INVALID);
            txtSubName.requestFocus();
            return false;
        }

        if (this.txtDescription.getText().trim().isEmpty()) {
            AppUtil.showErrMsg(Constant.DESC_SUBJECT_INVALID);
            txtDescription.requestFocus();
            return false;
        }
        return true;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnAdd = new javax.swing.JButton();
        txtSubCode = new javax.swing.JTextField();
        txtSubName = new javax.swing.JTextField();
        lblDesc = new javax.swing.JLabel();
        lblCourceName1 = new javax.swing.JLabel();
        lblCourceName = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/save0002.png"))); // NOI18N
        btnAdd.setText("Save");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblDesc.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblDesc.setText("Description :");

        lblCourceName1.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblCourceName1.setText("Subject code :");

        lblCourceName.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblCourceName.setText("Subject Name :");

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblTitle.setText("Subject Manager");

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/window_close1.png"))); // NOI18N
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCourceName)
                            .addComponent(lblDesc)
                            .addComponent(lblCourceName1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSubCode, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSubName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(lblTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCourceName1)
                            .addComponent(txtSubCode, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSubName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCourceName)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesc)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
           try {

                // validate
                if (!isValidate()) {
                    return;
                }
                // confirm before save
                if (!IsSure.confirm(confirmSaveMessage)) {
                    return;
                }

                String errorMsg = initSubjectFromUI();
                if (errorMsg.isEmpty()) {
                    SubjectDAO dao = new SubjectDAO();
                    dao.getSession().beginTransaction();
                    dao.save(this.subject);
                    //dao.savePhoto(student);
                    dao.getSession().getTransaction().commit();
                    AppUtil.showErrMsg(Constant.NOTICE_TO_UPDATE_Subject);

                } else {
                    AppUtil.showErrMsg(errorMsg);
                }


            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
}//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
         if (subject != null) {
            if (IsSure.confirm(this.confirmDeleteMessage)) {
                SubjectDAO dao = new SubjectDAO();
                dao.getSession().beginTransaction();
                dao.delete(subject);
                dao.getSession().getTransaction().commit();
                AppUtil.showNoticeMessage(Constant.NOTICE_TO_DELETE_Subject);
                this.btnDelete.setEnabled(false);
                this.btnAdd.setEnabled(false);
            }
         }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCourceName;
    private javax.swing.JLabel lblCourceName1;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtSubCode;
    private javax.swing.JTextField txtSubName;
    // End of variables declaration//GEN-END:variables

}