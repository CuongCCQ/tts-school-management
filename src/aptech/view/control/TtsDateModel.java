/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.control;

import java.util.Date;

/**
 *
 * @author bo
 * @date Apr 16, 2011
 * @
 */
public class TtsDateModel {

    int dayOfWeek;
    Date date;

    public TtsDateModel(int dayOfWeek, Date date) {
        this.dayOfWeek = dayOfWeek;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }


}
