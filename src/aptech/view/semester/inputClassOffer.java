/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * inputClassOffer.java
 *
 * Created on Apr 10, 2011, 9:23:19 AM
 */
package aptech.view.semester;

import api.ClassOffer;
import api.ClassOfferDAO;
import api.SemesterDAO;
import api.Semester;
import java.util.ArrayList;
import java.util.List;
import api.CourseDAO;
import api.Course;
import aptech.util.AppUtil;
import aptech.util.Constant;
import aptech.util.IsSure;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author anhson
 */
public class inputClassOffer extends javax.swing.JPanel {

  

    /** Creates new form inputClassOffer */
    public inputClassOffer() {
        initComponents();
       loadAll();
       this.Btndelete.setVisible(false);
       this.lblTitle.setText("Add new class offer");
    }
    public JButton getBtndelete()
    {
        return this.Btndelete;
    }
    public JLabel getLbltitle()
    {
        return this.lblTitle;
    }
    protected void initComponentV2() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        lblMinStudent = new javax.swing.JLabel();
        lblMaxStudent = new javax.swing.JLabel();
        lblSemester = new javax.swing.JLabel();
        lblCource = new javax.swing.JLabel();
        txtClassCode = new javax.swing.JTextField();
        txtMinstudent = new javax.swing.JTextField();
        txtMaxStudent = new javax.swing.JTextField();
        cbSemester = new javax.swing.JComboBox();
        cbCource = new javax.swing.JComboBox();
        btnAdd = new javax.swing.JButton();
        Btndelete = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblTitle.setText("Class Offer  Manager");

        lblCode.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblCode.setText("Class code :");

        lblMinStudent.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMinStudent.setText("Min Student :");

        lblMaxStudent.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMaxStudent.setText("Max student :");

        lblSemester.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSemester.setText("Semester :");

        lblCource.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblCource.setText("Cource :");

        btnAdd.setText("Save");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        Btndelete.setText("Delete");
        Btndelete.setPreferredSize(new java.awt.Dimension(57, 23));
        Btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMinStudent)
                                    .addComponent(lblCode)
                                    .addComponent(lblMaxStudent)
                                    .addComponent(lblSemester)
                                    .addComponent(lblCource))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMinstudent, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbSemester, 0, 186, Short.MAX_VALUE)
                                    .addComponent(txtClassCode)
                                    .addComponent(cbCource, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(26, 26, 26)
                        .addComponent(Btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCode)
                    .addComponent(txtClassCode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMinStudent)
                    .addComponent(txtMinstudent, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaxStudent)
                    .addComponent(txtMaxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSemester)
                    .addComponent(cbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCource)
                    .addComponent(cbCource, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
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

            String errorMsg = initClassOfferUI();
            if (errorMsg.isEmpty()) {
                ClassOfferDAO dao  = new ClassOfferDAO();
                dao.getSession().beginTransaction();
                dao.save(this.classOffer);
                //dao.savePhoto(student);
                dao.getSession().getTransaction().commit();

                 JOptionPane.showMessageDialog(this,"Save Data successfuly");
            } else {
                AppUtil.showErrMsg(errorMsg);
            }


        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void BtndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtndeleteActionPerformed
          if (classOffer != null) {
            if (IsSure.confirm(this.confirmDeleteMessage)) {
                ClassOfferDAO dao  = new ClassOfferDAO();
                dao.getSession().beginTransaction();
                dao.delete(classOffer);

                dao.getSession().getTransaction().commit();
                AppUtil.showNoticeMessage(Constant.NOTICE_TO_DELETE_ASS);
                this.Btndelete.setEnabled(false);
                this.btnAdd.setEnabled(false);
            }
        }
        
    }//GEN-LAST:event_BtndeleteActionPerformed
   protected String initClassOfferUI() throws ParseException {
        String errMsg = "";
        if (classOffer == null) {
            this.classOffer = new ClassOffer();
        }
        this.classOffer.setClassCode(this.txtClassCode.getText().trim());
        this.classOffer.setMinStudent(Integer.parseInt(this.txtMinstudent.getText().trim()));
        this.classOffer.setMaxStudent(Integer.parseInt(this.txtMaxStudent.getText().trim()));
        this.classOffer.setSemesterId(listSemesterID.get(cbSemester.getSelectedIndex()));
        this.classOffer.setId(listCourseID.get( cbCource.getSelectedIndex()));
        return errMsg;
    }
    private boolean isValidate() throws ParseException {
        String msg = null;
        // validate staff code
        
        if (this.txtClassCode.getText().isEmpty()) {
            AppUtil.showErrMsg(Constant.CLASS_CODE_INVALID);
            txtClassCode.requestFocus();
            return false;
        }

        if (this.txtMinstudent.getText().trim().isEmpty()) {
            AppUtil.showErrMsg(Constant.MIN_STUDENT_CLASS);
            txtMinstudent.requestFocus();
            return false;
        }

        if (this.txtMaxStudent.getText().trim().isEmpty()) {
            AppUtil.showErrMsg(Constant.MAX_STUDENT_CLASS);
            txtMaxStudent.requestFocus();
            return false;
        }
        
        return true;
    }
    protected void initClassOffFromModel(ClassOffer classOffFromModel){

        try {
            this.classOffer = classOffFromModel;
            this.txtMinstudent.setText(classOffer.getMinStudent().toString());
            this.txtMaxStudent.setText( classOffer.getMaxStudent().toString());
            this.txtClassCode.setText(classOffer.getClassCode().toString());

            semester = new Semester();
            semesterDao = new SemesterDAO();
            semester = semesterDao.findById(classOffer.getSemesterId());
            semesterDao.getSession().beginTransaction();
            String semesterName = semester.getName();
            semesterDao.save(semester);
            this.cbSemester.setSelectedItem(semesterName);
            semesterDao.getSession().getTransaction().commit();

            course = new Course();
            courseDao = new CourseDAO();
            course = courseDao.findById(classOffer.getId());
            courseDao.save(course);
            courseDao.getSession().beginTransaction();
            String courseCode = course.getCourseCode();
            this.cbCource.setSelectedItem(courseCode);
            courseDao.getSession().getTransaction().commit();
        } catch (Exception ex) {

        }
    }
    protected void loadAll()
    {
        semester = new Semester();
        semesterDao = new SemesterDAO();
        List<Semester> listSmesterName = semesterDao.findAll();
        listSemesterID = new ArrayList<Integer>();

        for(Semester clSemester : listSmesterName)
        {
            cbSemester.addItem(clSemester.getName());
            listSemesterID.add(clSemester.getSemesterId());
        }


        course = new Course();
        courseDao = new CourseDAO();
        List<Course> listCourseCourse = courseDao.findAll();
        listCourseID = new ArrayList<Integer>();
        for(Course lCourse : listCourseCourse)
        {
            cbCource.addItem(lCourse.getCourseCode());
            listCourseID.add(lCourse.getId());
        }
    }
 private  ClassOffer classOffer = new ClassOffer();
    private Semester semester;
    private SemesterDAO semesterDao;
    private ClassOfferDAO classOfferDao;
    private Course course;
    private CourseDAO courseDao;
    String confirmSaveMessage = Constant.SURE_TO_UPDATE_ASS;
    String confirmDeleteMessage = Constant.SURE_TO_DELETE_ASS;
    private List<Integer> listSemesterID;
    private List<Integer> listCourseID;
   
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btndelete;
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox cbCource;
    private javax.swing.JComboBox cbSemester;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblCource;
    private javax.swing.JLabel lblMaxStudent;
    private javax.swing.JLabel lblMinStudent;
    private javax.swing.JLabel lblSemester;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtClassCode;
    private javax.swing.JTextField txtMaxStudent;
    private javax.swing.JTextField txtMinstudent;
    // End of variables declaration//GEN-END:variables
}
