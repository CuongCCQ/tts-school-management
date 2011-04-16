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
import datechooser.beans.DateChooserCombo;
import java.io.IOException;
import api.SemesterDAO;
import java.text.DateFormat;
import java.text.ParseException;
import api.Semester;
import aptech.util.AppUtil;
import aptech.util.Constant;
import aptech.util.IsSure;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
public class InputSemester extends javax.swing.JPanel {
    DateChooserCombo chooserCombomStart;
    DateChooserCombo chooserCombomEnd;
    DateFormat df;
    //Method creat calender for java
    public InputSemester() throws Exception {
        initComponents();
        initCalendar();
    }
    protected Semester semester= new Semester();
    
    protected void initComponentV2(){
        initComponents();
    }
    protected void initSemesterFromModel(Semester semesterFromModel){
       
        try {
            this.semester = semesterFromModel;
            this.txtName.setText(semester.getName());
            this.txtDescription.setText(semester.getDescription());
            
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

        jTextField1.setText("jTextField1");

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

        btnAdd.setText("Save");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblName.setText("Name :");

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
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(btnAdd)
                .addContainerGap(99, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    //validate from
    public boolean validateForm()
    {
        if(txtDescription.getText().isEmpty() && txtName.getText().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    //action add new,update semester
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       try {
             if (!IsSure.confirm(confirmSaveMessage)) {
                return;
                }
            String errorMsg = initSemesterFromUI();
            if (errorMsg.isEmpty()) {
                
                if(txtName.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Enter name!","System saying",JOptionPane.WARNING_MESSAGE);
                    txtName.requestFocus();
                }else if (txtDescription.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Enter Description!","System saying",JOptionPane.WARNING_MESSAGE);
                    txtDescription.requestFocus();
                }
                else
                {
                    SemesterDAO semesterDao = new SemesterDAO();
                    df = new SimpleDateFormat("MM/dd/yyyy");

                    String dateStart = chooserCombomStart.getText();
                    String dateEnd = chooserCombomEnd.getText();
                    String name = txtName.getText();
                    Date dStart=null;
                    Date dEnd = null;
                    try {
                        dStart = df.parse(dateStart);
                        dEnd = df.parse(dateEnd);
                    } catch (ParseException ex) {
                        Logger.getLogger(InputSemester.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String description = txtDescription.getText();
                    semesterDao.getSession().beginTransaction();
                    semester.setDescription(description);
                    semester.setStartDate(dStart);
                    semester.setEndDate(dEnd);
                    semester.setName(name);
                    semesterDao.save(semester);
                    semesterDao.getSession().getTransaction().commit();
                    JOptionPane.showMessageDialog(this,"Save Data successfuly");
                }
            } else {
                AppUtil.showErrMsg(errorMsg);
            }
        } catch (ParseException ex)
        {
            System.out.println(ex);
        }
            
       
    }//GEN-LAST:event_btnAddActionPerformed
//Action update semesterDAO//method fill calendar
    public  void initCalendar() throws IOException
    {
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
     
    protected  Semester semesterB;
    String confirmSaveMessage = Constant.SURE_TO_SAVE_STUDENT;
    String confirmDeleteMessage = Constant.SURE_TO_DELETE_STUDENT;
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
