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
import aptech.util.ValidateUtil;
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

        btnAdd.setText("Add new");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(lblTitle)))
                .addContainerGap(158, Short.MAX_VALUE))
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
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int idSemester = listId.get(cbSemester.getSelectedIndex());
        int idCource = listIdCource.get(cbCource.getSelectedIndex());
        String classOffCode = txtClassCode.getText();
        String minStudent = txtMinstudent.getText();
        String maxStudent = txtMaxStudent.getText();
        ValidateUtil validate = new ValidateUtil();
        offDao = new ClassOfferDAO();
        offer = new ClassOffer();

        
        if(!validate.isEmpty(classOffCode))
        {
            txtClassCode.requestFocus();
        }else if (!validate.isEmpty(minStudent))
        {
            txtMinstudent.requestFocus();
        }else if(!validate.isEmpty(maxStudent))
        {
            txtMaxStudent.requestFocus();
        }else
        {
            try
            {
                int min = Integer.parseInt(minStudent);
                int max = Integer.parseInt(maxStudent);
                if(offDao.findByClassCode(classOffCode).size()>0)
                {
                    JOptionPane.showMessageDialog(null,"Code early exits database !","System saying",JOptionPane.WARNING_MESSAGE);
                    txtClassCode.requestFocus();
                }else
                {
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
        
        
    }//GEN-LAST:event_btnAddActionPerformed
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
