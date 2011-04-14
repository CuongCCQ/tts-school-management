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
import aptech.util.ValidateUtil;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 *
 * @author anhson
 */
public class inputClassOffer extends javax.swing.JPanel {
SemesterDAO semesDao;
Semester semester;
CourseDAO courceDao;
Course cource;
ClassOfferDAO offDao;
ClassOffer offer;
List<Integer> listId= new ArrayList<Integer>();
List<Integer> listIdCource= new ArrayList<Integer>();
    /** Creates new form inputClassOffer */
    public inputClassOffer() {
        initComponents();
        initSemesterCombo();
        initCourceCombo();
    }
     protected void initComponentV2(){
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
                            .addComponent(cbCource, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(Btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(lblTitle)))
                .addContainerGap(84, Short.MAX_VALUE))
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
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        try {
               if(!IsSure.confirm(confirmSaveMessage))
                {
                       return;
                }
               String errMsg = initOfferFromUI();
               
                if(errMsg.isEmpty()){
                    if(txtClassCode.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null,"Enter class code !","System saying",JOptionPane.WARNING_MESSAGE);
                        txtClassCode.requestFocus();
                    }else if (txtMinstudent.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null,"Enter min student !","System saying",JOptionPane.WARNING_MESSAGE);
                        txtMinstudent.requestFocus();
                    }else if(txtMaxStudent.getText().isEmpty())
                    {
                     JOptionPane.showMessageDialog(null,"Enter max student !","System saying",JOptionPane.WARNING_MESSAGE);                       txtMaxStudent.requestFocus();
                    }
                    else{
                        offDao = new ClassOfferDAO();
                        offer = new ClassOffer();
                       int idSemester = listId.get(cbSemester.getSelectedIndex());
                       int idCource = listIdCource.get(cbCource.getSelectedIndex());
                       String classOffCode = txtClassCode.getText();
                       String minStudent = txtMinstudent.getText();
                       String maxStudent = txtMaxStudent.getText();
                           try
                           {
                               int min = Integer.parseInt(minStudent);
                                int max = Integer.parseInt(maxStudent);
                                if(offDao.findByClassCode(classOffCode).size()>0)
                                {
                                    JOptionPane.showMessageDialog(null,"Code early exits database !","System saying",JOptionPane.WARNING_MESSAGE);
                                    txtClassCode.requestFocus();
                             }else{
                                    offDao.getSession().beginTransaction();
                                    offer.setClassCode(classOffCode);
                                    offer.setId(min);
                                    offer.setMinStudent(min);
                                    offer.setMaxStudent(max);
                                    offer.setId(idCource);
                                    offer.setSemesterId(idSemester);

                                    offDao.save(offer);
                                    offDao.getSession().getTransaction().commit();

                                    JOptionPane.showMessageDialog(null,"Add new succefully !");
                                }


                            }catch(NumberFormatException ex)
                            {
                                JOptionPane.showMessageDialog(null, "Must is a number !","System saying",JOptionPane.WARNING_MESSAGE);
                                 txtMinstudent.requestFocus();
                            }
                        }
                }else
                {
                    AppUtil.showErrMsg(errMsg);
                }
            } catch (ParseException ex) {
             System.out.print(ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void BtndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtndeleteActionPerformed
         if (cOffer != null) {
            if (IsSure.confirm(this.confirmDeleteMessage)) {
                ClassOfferDAO dao = new ClassOfferDAO();
                dao.getSession().beginTransaction();
                dao.delete(cOffer);
                dao.getSession().getTransaction().commit();
                AppUtil.showNoticeMessage(Constant.NOTICE_TO_DELETE_STUDENT);
                this.Btndelete.setEnabled(false);
                this.btnAdd.setVisible(false);
            }
        }
    }//GEN-LAST:event_BtndeleteActionPerformed
    public void initSemesterCombo()
    {
         semesDao = new SemesterDAO();
         semester = new Semester();  
         List list= semesDao.findAll();
         for (Object object : list) {
            cbSemester.addItem(((Semester)object).getName());
            listId.add(((Semester)object).getSemesterId());
        }
    }
    public void initCourceCombo()
    {
         courceDao = new CourseDAO();
         cource = new Course();
         List listName= courceDao.findAll();
         for (Object object : listName) {
            cbCource.addItem(((Course)object).getCourseName());
           listIdCource.add(((Course)object).getId());
        }
    }
    //update , delete
   protected String initOfferFromUI() throws ParseException {
        String errMsg = "";
        if (cOffer == null) {
            this.cOffer = new ClassOffer();
        }
        this.cOffer.setClassCode(this.txtClassCode.getText());
        this.cOffer.setMinStudent(Integer.parseInt(this.txtMinstudent.getText()));
        this.cOffer.setMaxStudent(Integer.parseInt(this.txtMaxStudent.getText()));
        
        return errMsg;
    }
    protected  void initClassOfferModel(ClassOffer cOfferFromModel)
    {
         try {
            this.cOffer = cOfferFromModel;
            this.txtClassCode.setText(cOffer.getClassCode());
            this.txtMinstudent.setText(cOffer.getMinStudent().toString());
            this.txtMaxStudent.setText(cOffer.getMaxStudent().toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, Constant.ERROR_STRING);
        }
    }
    public JButton getBtnDelete()
    {
        return Btndelete;
    }

    //--------------------------------
    String confirmSaveMessage = Constant.SURE_TO_SAVE_STUDENT;
    String confirmDeleteMessage = Constant.SURE_TO_DELETE_STUDENT;
    protected ClassOffer  cOffer;
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
