/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainTimeTable.java
 *
 * Created on Apr 16, 2011, 10:10:28 PM
 */
package aptech.view.timeline;

import api.AssigmentSchedule;
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
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author bo
 */
public class MainTimeTable extends javax.swing.JPanel {

    /** Creates new form MainTimeTable */
    private PanelImage pnImg;
    List<AssigmentSchedule> lstData=new ArrayList<AssigmentSchedule>();

    public List<AssigmentSchedule> getLstData() {
        return lstData;
    }

    public void setLstData(List<AssigmentSchedule> lstData) {
        this.lstData = lstData;
    }



    public MainTimeTable() {
        initComponents();
    }

    private void initData() {
        AssigmentSchedule as = new AssigmentSchedule();
        as.setDate(new Date());
        as.setMinuteToTeach(200);
        lstData.add(as);

        Date d=new Date();
        d.setHours(11);
        d.setMinutes(0);
        AssigmentSchedule as1 = new AssigmentSchedule();
        as1.setDate(d);
        as1.setMinuteToTeach(100);
        lstData.add(as1);
    }

    public void init() {
        try {
            setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            pnImg = new PanelImage();
            add(pnImg);
            for (AssigmentSchedule ass : lstData) {
                SubjectAssignment subjectAss = new SubjectAssignmentDAO().findById(ass.getClassOfferDetailId());

                // staff name
                Staff staff = new StaffDAO().findById(subjectAss.getStaffId());
                String staffName=staff.getName();
                //subject
                Subject subject = new SubjectDAO().findById(subjectAss.getSubjectId());
                String subjectName=subject.getSubjectName();
                // course
                ClassOffer classOffer = new ClassOfferDAO().findById(subjectAss.getClassOfferId());
                String courseName=classOffer.getClassCode();

                PanelClass pnClass=new PanelClass(ass.getDate(), ass.getMinuteToTeach(), staffName, courseName, subjectName);
                add(pnClass);
            }
        } catch (IOException ex) {
            AppUtil.showErrMsg(Constant.ERROR_STRING);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(400, 600));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
        MainTimeTable mtt = new MainTimeTable();
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.add(mtt);
        jf.pack();
        jf.getContentPane().setBackground(Color.red);
        jf.setVisible(true);
    }
}
