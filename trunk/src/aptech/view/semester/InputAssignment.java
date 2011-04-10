/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InputAssignment.java
 *
 * Created on Apr 10, 2011, 8:29:45 PM
 */

package aptech.view.semester;

/**
 *
 * @author anhson
 */
import java.util.ArrayList;
import java.util.List;
import api.ClassOfferDAO;
import api.ClassOffer;
import api.Staff;
import api.StaffDAO;
import api.Subject;
import api.SubjectDAO;
import api.SubjectAssignment;
import api.SubjectAssignmentDAO;

import aptech.util.ValidateUtil;
import javax.swing.JOptionPane;
public class InputAssignment extends javax.swing.JPanel {

    /** Creates new form InputAssignment */
    public InputAssignment() {
        initComponents();
        initClassOffCombo();
        initStaffCombo();
        initSubjectCombo();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblClass = new javax.swing.JLabel();
        lblStaff = new javax.swing.JLabel();
        lblNumberOf = new javax.swing.JLabel();
        lblNumberOfAss = new javax.swing.JLabel();
        txtNumberAss = new javax.swing.JTextField();
        cbClassOffer = new javax.swing.JComboBox();
        txtMinutePerLession = new javax.swing.JTextField();
        cbStaff = new javax.swing.JComboBox();
        lblMinutePer = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        lblStaff1 = new javax.swing.JLabel();
        cbSubject = new javax.swing.JComboBox();
        txtNumberOflession = new javax.swing.JTextField();

        lblClass.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClass.setText("Class :");

        lblStaff.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblStaff.setText("Staff :");

        lblNumberOf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumberOf.setText("Number of lession :");

        lblNumberOfAss.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumberOfAss.setText("Number of Assiment :");

        lblMinutePer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblMinutePer.setText("Minute per lession :");

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("Subject Assinmegt  Manager");

        btnAdd.setText("Add new");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblStaff1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblStaff1.setText("Subject :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNumberOf)
                            .addComponent(lblMinutePer)
                            .addComponent(lblNumberOfAss)
                            .addComponent(lblClass)
                            .addComponent(lblStaff)
                            .addComponent(lblStaff1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumberOflession)
                            .addComponent(cbSubject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbClassOffer, 0, 186, Short.MAX_VALUE)
                            .addComponent(cbStaff, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMinutePerLession, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(txtNumberAss, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(lblTitle)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMinutePer)
                    .addComponent(txtMinutePerLession, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumberOf)
                    .addComponent(txtNumberOflession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumberOfAss)
                    .addComponent(txtNumberAss, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClass)
                    .addComponent(cbClassOffer, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStaff)
                    .addComponent(cbStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStaff1)
                    .addComponent(cbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

ClassOfferDAO offDao;
ClassOffer offer;
SubjectDAO subjectDao;
Subject subject;
StaffDAO staffDao;
Staff staff;
SubjectAssignment subjectAss;
SubjectAssignmentDAO subjectAssDao;

List<Integer> listOfferId= new ArrayList<Integer>();
List<Integer> listSubjectId= new ArrayList<Integer>();
List<Integer> listStaffId= new ArrayList<Integer>();
    @SuppressWarnings("static-access")
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int idOffer = listOfferId.get(cbClassOffer.getSelectedIndex());

        int idStaff = listStaffId.get(cbStaff.getSelectedIndex());
        int idSubject = listSubjectId.get(cbSubject.getSelectedIndex());


        String minute = txtMinutePerLession.getText();
        String numberOffLession = txtNumberOflession.getText();
        String numberOfAss = txtNumberAss.getText();


        ValidateUtil validate = new ValidateUtil();

        subjectAss = new SubjectAssignment();
        subjectAssDao = new SubjectAssignmentDAO();


        if(!validate.isEmpty(minute)) {
            txtMinutePerLession.requestFocus();
        }else if (!validate.isEmpty(numberOffLession)) {
            txtNumberOflession.requestFocus();
        }else if(!validate.isEmpty(numberOfAss)) {
            txtNumberAss.requestFocus();
        }else {
            try {
                int minuteLession = Integer.parseInt(minute);
                short numberLession = Short.parseShort(numberOffLession);
                short numberAss = Short.parseShort(numberOfAss);

                subjectAssDao.getSession().beginTransaction();
                
                subjectAss.setClassOfferId(idOffer);
                subjectAss.setSubjectId(idSubject);
                subjectAss.setStaffId(idStaff);
                subjectAss.setMinutesPerLession(minuteLession);
                subjectAss.setNumberOfAssignment(numberAss);
                subjectAss.setNumberOfLession(numberLession);

                subjectAssDao.save(subjectAss);
                subjectAssDao.getSession().getTransaction().commit();

                JOptionPane.showMessageDialog(null,"Add new succefully !");
            }catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Must is a number !","System saying",JOptionPane.WARNING_MESSAGE);
                txtNumberOflession.requestFocus();
            }
        }
        
}//GEN-LAST:event_btnAddActionPerformed

 public void initClassOffCombo()
 {
         offDao = new ClassOfferDAO();
        offer = new ClassOffer();
         List listName= offDao.findAll();
         for (Object object : listName) {
            cbClassOffer.addItem(((ClassOffer)object).getClassCode());
           listOfferId.add(((ClassOffer)object).getId());
        }
}
 public void initStaffCombo()
 {
         staffDao = new StaffDAO();
        staff = new Staff();
         List listName= staffDao.findAll();
         for (Object object : listName) {
            cbStaff.addItem(((Staff)object).getName());
           listStaffId.add(((Staff)object).getStaffId());
        }
}
 public void initSubjectCombo()
 {
        subjectDao = new SubjectDAO();
        subject = new Subject();
         List listName= subjectDao.findAll();
         for (Object object : listName) {
            cbSubject.addItem(((Subject)object).getSubjectName());
           listSubjectId.add(((Subject)object).getSubjectId());
        }
}
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox cbClassOffer;
    private javax.swing.JComboBox cbStaff;
    private javax.swing.JComboBox cbSubject;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblMinutePer;
    private javax.swing.JLabel lblNumberOf;
    private javax.swing.JLabel lblNumberOfAss;
    private javax.swing.JLabel lblStaff;
    private javax.swing.JLabel lblStaff1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtMinutePerLession;
    private javax.swing.JTextField txtNumberAss;
    private javax.swing.JTextField txtNumberOflession;
    // End of variables declaration//GEN-END:variables

}