/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.control;

import aptech.util.Constant;
import datechooser.beans.DateChooserCombo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bo
 * @date Apr 10, 2011
 * @
 */
public class TtsDateChooser extends DateChooserCombo {

    SimpleDateFormat dateFormat;

    public TtsDateChooser() {
        super();
        dateFormat = new SimpleDateFormat(Constant.DATE_FORMAT);
        this.setDateFormat(dateFormat);
    }

    public Date getDate() throws ParseException {
        Date d = new Date();
        return dateFormat.parse(this.getText());
    }
}
