/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ClassStartTime.java
 *
 * Created on Apr 14, 2011, 9:15:26 PM
 */
package aptech.view.control;

import aptech.util.AppUtil;
import aptech.util.Constant;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author bo
 */
public class ClassStartTime extends javax.swing.JPanel implements ItemListener, ChangeListener {

    private int minuteConstraint = 0;
    private int dayOfWeek;

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    


    public void stateChanged(ChangeEvent e) {
        if (getDate().getHours() < Constant.TIME_TO_BEGIN_SCHOOL) {
            AppUtil.showNoticeMessage(Constant.NOTICE_INVALID_TIME);
            resetTime();
            return;
        }
        Date date = getDate();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, this.minuteConstraint);
        if (c.getTime().getHours() >= Constant.TIME_TO_END_SCHOOL) {
            AppUtil.showNoticeMessage(Constant.NOTICE_INVALID_TIME);
            resetTime();
            return;
        }
    }

    public void resetTime() {
        Date date = getDate();
        if (date != null) {
            date.setHours(8);
            date.setMinutes(0);
            this.spDateModel.setValue(date);
        }

    }

    public Integer getHourConstraint() {
        return minuteConstraint;
    }

    public void setMinuteConstraint(Integer minutes) {
        this.minuteConstraint = minutes;
    }

    /** Creates new form ClassStartTime */
    public ClassStartTime() {
        initComponents();
        init();
    }

    public ClassStartTime(String cText, Integer hourConstraint) {
        initComponents();
        this.chk.setText(cText);
        init();
        this.minuteConstraint = hourConstraint;
    }

    public void itemStateChanged(ItemEvent e) {
        if (this.chk.isSelected()) {
            this.spDate.setEnabled(true);
        } else {
            this.spDate.setEnabled(false);
        }
    }

    public void init() {
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        time.setHours(8);
        time.setMinutes(0);
        spDateModel = new SpinnerDateModel(time, null, null, Calendar.HOUR);
        spDate.addChangeListener(this);
        spDate.setModel(spDateModel);
        spDate.setEditor(new JSpinner.DateEditor(spDate, "HH:mm a"));
        this.chk.addItemListener(this);
        this.spDate.setEnabled(false);
    }

    public Date getDate() {
        if (this.chk.isSelected()) {
            return spDateModel.getDate();
        }
        return null;
    }
    
    public TtsDateModel getDateModel()
    {
         if (this.chk.isSelected()) {
            return new TtsDateModel(dayOfWeek, spDateModel.getDate());
        }
        return null;
    }


    SpinnerDateModel spDateModel;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chk = new javax.swing.JCheckBox();
        spDate = new javax.swing.JSpinner();

        chk.setText("jCheckBox1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chk, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spDate, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk)
                    .addComponent(spDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chk;
    private javax.swing.JSpinner spDate;
    // End of variables declaration//GEN-END:variables
}