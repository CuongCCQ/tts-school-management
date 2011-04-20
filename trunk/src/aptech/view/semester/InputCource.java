/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InputCource.java
 *
 * Created on Apr 10, 2011, 10:37:08 AM
 */
package aptech.view.semester;

/**
 *
 * @author anhson
 */
import api.ClassOffer;
import api.ClassOfferDAO;
import javax.swing.JOptionPane;
import api.CourseDAO;
import api.Course;
import aptech.util.AppUtil;
import aptech.util.Constant;
import aptech.util.IsSure;
import java.text.ParseException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;

public class InputCource extends javax.swing.JPanel {

    String confirmSaveMessage = Constant.SURE_TO_SAVE_STUDENT;
    String confirmDeleteMessage = Constant.SURE_TO_DELETE_STUDENT;
     private ClassOffer classOffer= new ClassOffer();
    private  ClassOfferDAO classOfferDAO= new ClassOfferDAO();
    protected Course course;

    /** Creates new form InputCource */
    public InputCource() {
        initComponents();
        this.btnDelete.setVisible(false);
        this.lblTitle.setText("Add new cource");
    }

    protected void initComponentV2() {
        initComponents();
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }
public JLabel getLbltitle()
{
    return lblTitle;
}
    protected void initCourseFromModel(Course courseFromModel) {
        try {
            this.course = courseFromModel;
            this.txtCourceName.setText(course.getCourseName());
            this.txtDescription.setText(course.getDescription());
            this.txtCourceCode.setText(course.getCourseCode());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, Constant.ERROR_STRING);
        }
    }

    protected String initCourseFromUI() throws ParseException {
        String errMsg = "";
        if (course == null) {
            this.course = new Course();
        }
        this.course.setCourseCode(this.txtCourceCode.getText().trim());
        this.course.setCourseName(this.txtCourceName.getText().trim());
        this.course.setDescription(this.txtDescription.getText().trim());
        return errMsg;
    }

    private boolean isValidate() throws ParseException {
        String msg = null;

        // validate staff code
        String courseCode = this.txtCourceCode.getText().trim();

        if (courseCode.isEmpty()) {
            AppUtil.showErrMsg(Constant.COURSE_CODE_INVALID);
            txtCourceCode.requestFocus();
            return false;
        }

        CourseDAO dao = new CourseDAO();
        List lstCourse = dao.findByCourseCode(courseCode);
        if (lstCourse.size() > 0) {
            if (course == null) {
                AppUtil.showErrMsg(Constant.Course_CODE_IS_EXISTED);
                txtCourceCode.requestFocus();
                return false;
            }

        }

        if (this.txtCourceName.getText().trim().isEmpty()) {
            AppUtil.showErrMsg(Constant.NAME_INVALID);
            txtCourceName.requestFocus();
            return false;
        }

        if (this.txtDescription.getText().trim().isEmpty()) {
            AppUtil.showErrMsg(Constant.DESC_COURSE_INVALID);
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

        lblTitle = new javax.swing.JLabel();
        lblCourceName = new javax.swing.JLabel();
        lblCourceName1 = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        txtCourceName = new javax.swing.JTextField();
        txtCourceCode = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnDelete = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblTitle.setText("Cource Manager");

        lblCourceName.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblCourceName.setText("Cource Name :");

        lblCourceName1.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblCourceName1.setText("Cource code :");

        lblDesc.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblDesc.setText("Description :");

        btnAdd.setText("Save");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

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
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCourceName)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDesc)
                                    .addComponent(lblCourceName1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtCourceName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                                        .addComponent(txtCourceCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(86, 86, 86)
                                            .addComponent(lblTitle)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)))
                .addContainerGap(148, Short.MAX_VALUE))
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
                            .addComponent(txtCourceCode, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCourceName)
                        .addComponent(txtCourceName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesc)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

            String errorMsg = initCourseFromUI();
            if (errorMsg.isEmpty()) {
                CourseDAO dao = new CourseDAO();
                dao.getSession().beginTransaction();
                dao.save(this.course);
                //dao.savePhoto(student);
                dao.getSession().getTransaction().commit();
                AppUtil.showErrMsg(Constant.NOTICE_TO_UPDATE_Course);

            } else {
                AppUtil.showErrMsg(errorMsg);
            }


        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (course != null) {
            if (IsSure.confirm(this.confirmDeleteMessage)) {
                CourseDAO dao = new CourseDAO();
                dao.getSession().beginTransaction();
                
                classOfferDAO.deleteByCourseID(course.getId());
                dao.delete(course);
                
                
                classOfferDAO.getSession().getTransaction().commit();
                AppUtil.showNoticeMessage(Constant.NOTICE_TO_DELETE_STUDENT);
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
    private javax.swing.JTextField txtCourceCode;
    private javax.swing.JTextField txtCourceName;
    private javax.swing.JTextArea txtDescription;
    // End of variables declaration//GEN-END:variables
}
