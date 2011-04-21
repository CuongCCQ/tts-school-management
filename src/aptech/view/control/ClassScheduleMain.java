/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ClassScheduleMain.java
 *
 * Created on Apr 14, 2011, 11:45:41 PM
 */
package aptech.view.control;

import api.AssigmentSchedule;
import api.AssigmentScheduleDAO;
import api.ClassOffer;
import api.ClassOfferDAO;
import api.CommonDAO;
import api.Subject;
import api.SubjectAssignment;
import api.SubjectAssignmentDAO;
import api.SubjectDAO;
import aptech.util.AppUtil;
import aptech.util.Constant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bo
 */
public class ClassScheduleMain extends javax.swing.JPanel {

    /** Creates new form ClassScheduleMain */
    SchedulePanel schedulePanel;
    SubjectAssignment subjectAssignment;

    public SchedulePanel getSchedulePanel() {
        return schedulePanel;
    }

    public void setSchedulePanel(SchedulePanel schedulePanel) {
        this.schedulePanel = schedulePanel;
    }

    public ClassScheduleMain(int staffId) {
        initComponents();
        initData(staffId);
    }

    private int getTimeNeedSchedule() {
        List<AssigmentSchedule> lstSchedule = new AssigmentScheduleDAO().findByClassOfferDetailIdTimeUnTeach(this.subjectAssignment.getClassOfferDetailId());
        int allTimeToTeach = this.subjectAssignment.getMinutesPerLession() * this.subjectAssignment.getNumberOfLession();
        int timeTeached = 0;
        for (AssigmentSchedule ass : lstSchedule) {
            timeTeached += ass.getMinuteToTeach();
        }
        return allTimeToTeach - timeTeached;
    }

    private void initData(int staffId) {
        List<CmbObject> lstObj = new ArrayList<CmbObject>();
        List<SubjectAssignment> lstSubjectAssigment = new SubjectAssignmentDAO().findByStaffId(staffId);

        for (SubjectAssignment assignment : lstSubjectAssigment) {
            ClassOffer classOffer = new ClassOfferDAO().findById(assignment.getClassOfferId());
            Subject subject = new SubjectDAO().findById(assignment.getSubjectId());
            String key = classOffer.getClassCode() + "_" + subject.getSubjectName();
            CmbObject cmbObj = new CmbObject(key, assignment.getClassOfferDetailId().toString());
            lstObj.add(cmbObj);
        }
//        lstObj.add(new CmbObject("tu", "1"));
//        lstObj.add(new CmbObject("dung", "2"));
        TtsCmbModel model = new TtsCmbModel(lstObj);
        model.setFirstItemLabel("select your class");
        this.jComboBox1.setModel(model);
        this.jComboBox1.setSelectedIndex(0);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumb = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(300, 250));

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel1.setText("Select Class");

        jLabel2.setText("Minutes per lesson");

        txtMin.setFocusable(false);

        jLabel3.setText("Number of lession");

        txtNumb.setFocusable(false);

        btnSave.setText("Save ");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumb, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        saveSchedule();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void saveSchedule() {
        List<TtsDateModel> lstDate = this.schedulePanel.getDateModel();
        if (!validateInput()) {
            return;
        }

        // save schedule
        saveOrUpdateSchedule(lstDate);

    }

    // save schedule
    private void saveOrUpdateSchedule(List<TtsDateModel> lstDate) {
        List<AssigmentSchedule> lstAss = new ArrayList<AssigmentSchedule>();
        // delete all schedule after this day
        new AssigmentScheduleDAO().deleteAllByClassOfferId(this.subjectAssignment.getClassOfferDetailId());
        // calculate number of lession need to schedule

        int numberOfLessionNeedToSchedule = getTimeNeedSchedule() / this.subjectAssignment.getMinutesPerLession();
        Calendar calendar = Calendar.getInstance();
        Date d = new CommonDAO().getServerTime();
        calendar.setTime(d);
        for (int i = 0; i < numberOfLessionNeedToSchedule; i++) {
            boolean flag = false;
            while (!flag) {
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                int get = calendar.get(Calendar.DAY_OF_WEEK);
                for (TtsDateModel tDateModel : lstDate) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(tDateModel.getDate());
                    if (tDateModel.getDayOfWeek() == get) {
                        calendar.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
                        calendar.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
                        AssigmentSchedule assigmentSchedule = new AssigmentSchedule();
                        assigmentSchedule.setClassOfferDetailId(this.subjectAssignment.getClassOfferDetailId());
                        assigmentSchedule.setMinuteToTeach(subjectAssignment.getMinutesPerLession());
                        assigmentSchedule.setDate(calendar.getTime());
                        lstAss.add(assigmentSchedule);
                        flag = true;
                        break;
                    }
                }

            }
        }
        AssigmentScheduleDAO dao = new AssigmentScheduleDAO();
        for (AssigmentSchedule schedule : lstAss) {
            dao.getSession().beginTransaction();
            dao.save(schedule);
            dao.getSession().getTransaction().commit();
        }
        AppUtil.showNoticeMessage(Constant.NOTICE_UPDATE_SCHEDULE_COMPLETED);
    }
    // validate input

    private boolean validateInput() {
        if (this.subjectAssignment == null) {
            AppUtil.showErrMsg(Constant.NOTICE_NOT_SELECT_CLASS);
            return false;
        }
        if (this.schedulePanel.getDateModel().size() < 1) {
            AppUtil.showErrMsg(Constant.NOTICE_NOT_SCHEDULE);
            return false;
        }

        int timeNeedSchedule = getTimeNeedSchedule();
        if (timeNeedSchedule <= 0) {
            AppUtil.showErrMsg(Constant.NOTICE_CLASS_FINISHED);
            return false;
        }


        return true;
    }

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        CmbObject obj = (CmbObject) jComboBox1.getSelectedItem();
        this.txtMin.setText("");
        this.txtNumb.setText("");
        this.subjectAssignment = null;
        SubjectAssignment ass = new SubjectAssignmentDAO().findById(Integer.valueOf(obj.getValue()));
        if (ass != null) {
            this.txtMin.setText(ass.getMinutesPerLession().toString());
            this.txtNumb.setText(ass.getNumberOfLession().toString());
            this.schedulePanel.setMinutePerLession(Integer.valueOf(this.txtMin.getText()));
            this.subjectAssignment = ass;
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtMin;
    private javax.swing.JTextField txtNumb;
    // End of variables declaration//GEN-END:variables
}