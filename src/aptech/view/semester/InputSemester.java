/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InputSemester.java
 *
 * Created on Apr 7, 2011, 3:03:27 AM
 */
package aptech.view.semester;

import api.ClassOffer;
import api.ClassOfferDAO;
import datechooser.beans.DateChooserCombo;
import java.io.IOException;
import api.SemesterDAO;
import java.text.DateFormat;
import java.text.ParseException;
import api.Semester;
import aptech.util.AppUtil;
import aptech.util.Constant;
import aptech.util.IsSure;
import aptech.util.ValidateUtil;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InputSemester extends javax.swing.JPanel {

    DateChooserCombo chooserCombomStart;
    DateChooserCombo chooserCombomEnd;
    DateFormat df;
    //Method creat calender for java

    public InputSemester() throws Exception {
        initComponents();
        initCalendar();
        this.lblTitle.setText("Add new semester");
        this.bntShow.setVisible(false);
    }
    protected Semester semester = new Semester();

    protected void initComponentV2() {
        initComponents();
    }

    public JButton getBntShow() {
        return this.bntShow;
    }
     public JButton getBntAdd() {
        return this.btnAdd;
    }


    protected void initSemesterFromModel(Semester semesterFromModel) {

        try {
            this.semester = semesterFromModel;
            this.txtName.setText(semester.getName());
            this.txtDescription.setText(semester.getDescription());
            JLabel startDateLabel = new JLabel();
            df = new SimpleDateFormat("dd-MM-yyyy");
            String key = df.format(semester.getStartDate());
            startDateLabel.setText(key);

            JLabel endDateLabel = new JLabel();
            df = new SimpleDateFormat("dd-MM-yyyy");
            key = df.format(semester.getEndDate());
            endDateLabel.setText(key);

            startDateLabel.setPreferredSize(this.panelDateStart.getPreferredSize());
            this.panelDateStart.setLayout(new BorderLayout());
            this.panelDateStart.add(startDateLabel, BorderLayout.CENTER);

            endDateLabel.setPreferredSize(this.panelDateEnd.getPreferredSize());
            this.panelDateEnd.setLayout(new BorderLayout());
            this.panelDateEnd.add(endDateLabel, BorderLayout.CENTER);


            Date dStart = semester.getStartDate();
            Date dEnd = semester.getEndDate();
            this.chooserCombomStart.setText(dStart.toString());
            this.chooserCombomEnd.setText(dEnd.toString());
        } catch (Exception ex) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        lblEndDate = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        panelDateStart = new javax.swing.JPanel();
        panelDateEnd = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        bntShow = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setPreferredSize(new java.awt.Dimension(700, 538));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblTitle.setText("Semester Manager");

        lblStartDate.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblStartDate.setText("Start Date :");

        lblEndDate.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblEndDate.setText("End Date :");

        lblDesc.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblDesc.setText("Description :");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        panelDateStart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelDateStartLayout = new javax.swing.GroupLayout(panelDateStart);
        panelDateStart.setLayout(panelDateStartLayout);
        panelDateStartLayout.setHorizontalGroup(
            panelDateStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );
        panelDateStartLayout.setVerticalGroup(
            panelDateStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        panelDateEnd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelDateEndLayout = new javax.swing.GroupLayout(panelDateEnd);
        panelDateEnd.setLayout(panelDateEndLayout);
        panelDateEndLayout.setHorizontalGroup(
            panelDateEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );
        panelDateEndLayout.setVerticalGroup(
            panelDateEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/save0002.png"))); // NOI18N
        btnAdd.setText("Add New");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblName.setText("Name :");

        bntShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/than.gif"))); // NOI18N
        bntShow.setText("Show All Class");
        bntShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblName)
                            .addComponent(lblStartDate)
                            .addComponent(lblEndDate)
                            .addComponent(lblDesc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelDateStart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelDateEnd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(bntShow))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(lblTitle)))
                .addGap(202, 202, 202))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblStartDate)
                    .addComponent(panelDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEndDate)
                    .addComponent(panelDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesc)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntShow, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    //validate from

    public boolean validateForm() {
        if (txtDescription.getText().isEmpty() && txtName.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    //action add new,update semester
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {

            String errorMsg = initSemesterFromUI();
            if (errorMsg.isEmpty()) {

                if (txtName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter name!", "System saying", JOptionPane.WARNING_MESSAGE);
                    txtName.requestFocus();
                } else if (txtDescription.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter Description!", "System saying", JOptionPane.WARNING_MESSAGE);
                    txtDescription.requestFocus();
                } else {
                    SemesterDAO semesterDao = new SemesterDAO();
                    df = new SimpleDateFormat("MM/dd/yyyy");

                    String dateStart = chooserCombomStart.getText();
                    String dateEnd = chooserCombomEnd.getText();
                    String name = txtName.getText();
                    Date dStart = null;
                    Date dEnd = null;
                    try {
                        dStart = df.parse(dateStart);
                        dEnd = df.parse(dateEnd);
                    } catch (ParseException ex) {
                        Logger.getLogger(InputSemester.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("t");
                    }
                    String description = txtDescription.getText();
                    semester.setDescription(description);
                    semester.setStartDate(dStart);

                    semester.setEndDate(dEnd);
                    semester.setName(name);
                    System.out.println(semester);
                    if (ValidateUtil.checkDate(semester.getStartDate(), semester.getEndDate())) {
                        semesterDao.getSession().beginTransaction();

                        semesterDao.save(semester);
                        semesterDao.getSession().getTransaction().commit();
                        if (!IsSure.confirm(confirmSaveMessage)) {
                            return;
                        } else {
                            JOptionPane.showMessageDialog(this, "Save Data successfuly");
                            this.bntShow.setEnabled(false);
                            this.btnAdd.setEnabled(false);

                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Begin date must be after end date", "Eros", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } else {
                AppUtil.showErrMsg(errorMsg);
            }
        } catch (ParseException ex) {
            System.out.println(ex);
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void bntShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntShowActionPerformed
        // TODO add your handling code here:
        List<ClassOffer> lstClassOffers = new ArrayList<ClassOffer>();
        lstClassOffers.clear();
        lstClassOffers = classOfferDAO.findBySemesterId(semester.getSemesterId());
        LoadAllClass loadAllClass = new LoadAllClass(lstClassOffers);
        loadAllClass.setTitle("All class in " + semester.getName());
        loadAllClass.setSize(600, 200);
        loadAllClass.setLocation(300, 300);
        loadAllClass.setVisible(true);
       
    }//GEN-LAST:event_bntShowActionPerformed
//Action update semesterDAO//method fill calendar

    public void initCalendar() throws IOException {
        chooserCombomStart = new DateChooserCombo();
        chooserCombomStart.setDateFormat(new SimpleDateFormat("MM/dd/yyyy"));
        chooserCombomStart.setSize(196, 27);
        chooserCombomEnd = new DateChooserCombo();
        chooserCombomEnd.setDateFormat(new SimpleDateFormat("MM/dd/yyyy"));
        chooserCombomEnd.setSize(196, 27);

        this.panelDateStart.add(chooserCombomStart);
        this.panelDateEnd.add(chooserCombomEnd);
    }

    protected String initSemesterFromUI() throws ParseException {
        String errMsg = "";
        if (semesterB == null) {
            this.semesterB = new Semester();
        }
        this.semesterB.setDescription(this.txtDescription.getText().trim());
        this.semesterB.setName(this.txtName.getText().trim());
        return errMsg;
    }

    public JLabel getLbltitle() {
        return this.lblTitle;
    }
    protected Semester semesterB;
    String confirmSaveMessage = Constant.SURE_TO_SAVE_STUDENT;
    String confirmDeleteMessage = Constant.SURE_TO_DELETE_STUDENT;
    private ClassOfferDAO classOfferDAO = new ClassOfferDAO();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntShow;
    private javax.swing.JButton btnAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelDateEnd;
    private javax.swing.JPanel panelDateStart;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
