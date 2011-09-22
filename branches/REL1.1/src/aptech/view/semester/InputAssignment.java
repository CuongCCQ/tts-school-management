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
import api.ClassOffer;
import api.ClassOfferDAO;
import api.Staff;
import api.StaffDAO;
import api.Subject;
import api.SubjectAssignment;
import api.SubjectAssignmentDAO;
import api.SubjectDAO;
import aptech.util.AppUtil;
import aptech.util.Constant;
import aptech.util.IsSure;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author anhson
 */

public class InputAssignment extends javax.swing.JPanel {

    String confirmSaveMessage = Constant.SURE_TO_UPDATE_ASS;
    String confirmDeleteMessage = Constant.SURE_TO_DELETE_ASS;
    /** Creates new form InputAssignment */
    public InputAssignment() {
        initComponents();
        loadAll();
        this.btnDelete.setVisible(false);
        this.lblTitle.setText("Add new assignment");
    }
    public JButton getBtnDelete() {
        return btnDelete;
    }
    public JLabel getlbltitle()
    {
        return lblTitle;
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
        btnDelete = new javax.swing.JButton();
        txtNumberOflession = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblClass.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblClass.setText("Class :");

        lblStaff.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblStaff.setText("Staff :");

        lblNumberOf.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblNumberOf.setText("Number of lession :");

        lblNumberOfAss.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblNumberOfAss.setText("Number of Assiment :");

        lblMinutePer.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMinutePer.setText("Minute per lession :");

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblTitle.setText("Subject Assinmegt  Manager");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/save0002.png"))); // NOI18N
        btnAdd.setText("Add new");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblStaff1.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblStaff1.setText("Subject :");

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
                            .addComponent(txtNumberAss, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(lblTitle)))
                .addContainerGap(118, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
  
    @SuppressWarnings("static-access")
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

            String errorMsg = initAssimentFromUI();
            if (errorMsg.isEmpty()) {
                SubjectAssignmentDAO dao  = new SubjectAssignmentDAO();
                dao.getSession().beginTransaction();
                dao.save(this.subjectAssiment);
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

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       if (subjectAssiment != null) {
            if (IsSure.confirm(this.confirmDeleteMessage)) {
                SubjectAssignmentDAO dao  = new SubjectAssignmentDAO();
                dao.getSession().beginTransaction();
                dao.delete(subjectAssiment);
               
                dao.getSession().getTransaction().commit();
                AppUtil.showNoticeMessage(Constant.NOTICE_TO_DELETE_ASS);
                this.btnDelete.setEnabled(false);
                this.btnAdd.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    protected String initAssimentFromUI() throws ParseException {
        String errMsg = "";
        if (subjectAssiment == null) {
            this.subjectAssiment = new SubjectAssignment();
        }
        this.subjectAssiment.setMinutesPerLession(Integer.parseInt(this.txtMinutePerLession.getText().trim()));
        this.subjectAssiment.setNumberOfLession(Short.parseShort(this.txtNumberOflession.getText().trim()));
        this.subjectAssiment.setNumberOfAssignment(Short.parseShort( this.txtNumberAss.getText().trim()));
        this.subjectAssiment.setClassOfferId(listClassOffID.get(cbClassOffer.getSelectedIndex()));
        this.subjectAssiment.setSubjectId(listSubjectID.get( cbSubject.getSelectedIndex()));
        this.subjectAssiment.setStaffId(ListStaffID.get( cbStaff.getSelectedIndex()));
        return errMsg;
    }



    private boolean isValidate() throws ParseException {
        String msg = null;
        // validate staff code
        String minutePerLession = this.txtMinutePerLession.getText().trim();
        if (minutePerLession.isEmpty()) {
            AppUtil.showErrMsg(Constant.MINUTE_PER_LESSON);
            txtMinutePerLession.requestFocus();
            return false;
        }

        if (this.txtNumberAss.getText().trim().isEmpty()) {
            AppUtil.showErrMsg(Constant.NUMBER_OF_LESSON);
            txtNumberAss.requestFocus();
            return false;
        }

        if (this.txtNumberOflession.getText().trim().isEmpty()) {
            txtNumberOflession.requestFocus();
            AppUtil.showErrMsg(Constant.NUMBER_OF_LESSON);
            return false;
        }
        
        return true;
    }
     protected void initAssFromModel(SubjectAssignment assimentFromModel){

        try {
            this.subjectAssiment = assimentFromModel;
            this.txtMinutePerLession.setText(subjectAssiment.getMinutesPerLession().toString());
            this.txtNumberOflession.setText( subjectAssiment.getNumberOfLession().toString());
            this.txtNumberAss.setText(subjectAssiment.getNumberOfAssignment().toString());

            //load data classCode to JCOMBOBOX 
            classOffer = new ClassOffer();
            classOfferDAO = new ClassOfferDAO();
            classOffer =  classOfferDAO.findById(subjectAssiment.getClassOfferId());
            classOfferDAO.getSession().beginTransaction();
            String className =classOffer.getClassCode();
            classOfferDAO.save(classOffer);
            cbClassOffer.setSelectedItem(className);
            classOfferDAO.getSession().getTransaction().commit();

            //load data SubjectName to JCOMBOBOX
            subject = new Subject();
            subjectDao = new SubjectDAO();
            subject = subjectDao.findById(subjectAssiment.getSubjectId());
            subjectDao.getSession().beginTransaction();
            String subjectName = subject.getSubjectName();
            cbSubject.setSelectedItem(subjectName);
            subjectDao.getSession().getTransaction().commit();

            //load data StaffCode to JCOMBOBOX
            Staff = new Staff();
            StaffDao = new StaffDAO();
            Staff = StaffDao.findById(subjectAssiment.getStaffId());
            StaffDao.getSession().beginTransaction();
            String staffCode = Staff.getStaffCode();
            cbStaff.setSelectedItem(staffCode);
            StaffDao.getSession().getTransaction().commit();
        } catch (Exception ex) {

        }
    }

    protected void loadAll()
    {
        classOffer = new ClassOffer();
        classOfferDAO = new ClassOfferDAO();
        List<ClassOffer> listClassOfferName = classOfferDAO.findAll();
        listClassOffID = new ArrayList<Integer>();

        for(ClassOffer clOffer : listClassOfferName)
        {
            cbClassOffer.addItem(clOffer.getClassCode());
            listClassOffID.add(clOffer.getClassOfferId());
        }


        subject = new Subject();
        subjectDao = new SubjectDAO();
        List<Subject> listSubjectName = subjectDao.findAll();
        listSubjectID = new ArrayList<Integer>();
        for(Subject lSubject : listSubjectName)
        {
            cbSubject.addItem(lSubject.getSubjectName());
            listSubjectID.add(lSubject.getSubjectId());
        }

        Staff = new Staff();
        StaffDao = new StaffDAO();
        List<Staff> listStaffName = StaffDao.findAll();
        ListStaffID = new ArrayList<Integer>();
        for(Staff lStaff : listStaffName)
        {
            cbStaff.addItem(lStaff.getStaffCode()+"_"+lStaff.getName());
            ListStaffID.add(lStaff.getStaffId());
        }
    }
    private  SubjectAssignment subjectAssiment = new SubjectAssignment();
    private ClassOffer classOffer;
    private ClassOfferDAO classOfferDAO;
    private Subject subject;
    private SubjectDAO subjectDao;
    private Staff Staff;
    private StaffDAO StaffDao;
    private List<Integer> listClassOffID;
    private List<Integer> listSubjectID;
    private List<Integer> ListStaffID;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
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