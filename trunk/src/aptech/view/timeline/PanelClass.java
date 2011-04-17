/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.timeline;

import aptech.util.Constant;
import aptech.view.control.CurvePanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author bo
 * @date Apr 17, 2011
 * @
 */
public class PanelClass extends JPanel {

    private Date startTime;
    private int minutesTolearn;
    private String teacher;
    private String classTitle;
    private String subjectTitle;
    private float unitStart;

    public PanelClass() {
        init();
    }

    public PanelClass(Date startTime, int minutesTolearn, String teacher, String classTitle, String subjectTitle) {
        float f = (538-71.6f) / 160;
        //unitStart = Math.round(f);
        unitStart = 5.2828282828f;
        this.startTime = startTime;
        this.minutesTolearn = minutesTolearn;
        this.teacher = teacher;
        this.classTitle = classTitle;
        this.subjectTitle = subjectTitle;
        init();
    }

    private void init() {
        setLayout(null);
        //setLayout(new FlowLayout(FlowLayout.LEFT));
        //this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(Constant.TIME_LINE_WIDTH, Constant.SCHEDULE_IMAGE_SIZE_HEIGHT));
        int detailStartPost=getStartPosition();
        int detailHeight=getScheduleSize();
        CurvePanel schedultePn=new CurvePanel();
        schedultePn.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        schedultePn.setOpaque(false);
        schedultePn.setPreferredSize(new Dimension(Constant.TIME_LINE_WIDTH-10, detailHeight));
        
        schedultePn.setBounds(0, detailStartPost, Constant.TIME_LINE_WIDTH, detailHeight);
        schedultePn.setBackground(Color.red);
        this.add(schedultePn);

        // init label
        SimpleDateFormat formatTer=new SimpleDateFormat("k:mm");
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.add(Calendar.HOUR, this.minutesTolearn/60);
        calendar.add(Calendar.MINUTE, this.minutesTolearn%60);
        Date endTime = calendar.getTime();
        // class title
        JLabel lbTitle=new JLabel(this.classTitle,SwingConstants.CENTER);
        
        //lbTitle.setPreferredSize(new Dimension(Constant.TIME_LINE_WIDTH-20,20));
        schedultePn.add(lbTitle);
        Font font = new Font("Dialog", 1, 11);
        // class start time
        JLabel lbStart=new JLabel("  Start:"+formatTer.format(startTime));
        lbStart.setFont(font);
        
        lbStart.setPreferredSize(new Dimension(Constant.TIME_LINE_WIDTH-20,11));
        schedultePn.add(lbStart);

        // class end time
        JLabel lbEndTime=new JLabel("  End:"+formatTer.format(endTime));
        lbEndTime.setFont(font);
        lbEndTime.setPreferredSize(new Dimension(Constant.TIME_LINE_WIDTH-20,11));
        schedultePn.add(lbEndTime);

        // class tutor
        JLabel lbTutor=new JLabel("  Tutor:"+this.teacher);
        lbTutor.setFont(font);
        lbTutor.setPreferredSize(new Dimension(Constant.TIME_LINE_WIDTH-20,11));
        schedultePn.add(lbTutor);
        
    }
    // get start pos

    private int getStartPosition() {
        int start = ((this.startTime.getHours() - 7) * 60 + this.startTime.getMinutes()) / 10;
        float startPost = start * unitStart +6f;
        return Math.round(startPost);
    }

    private int getScheduleSize() {
        int k =Math.round( this.minutesTolearn / 10 * unitStart);
        return k;
    }

   
}
