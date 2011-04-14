/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.view.semester;
import aptech.view.control.BaseTableModel;
import java.util.ArrayList;
import java.util.List;
import api.Subject;

/**
 *
 * @author anhson
 */
public class subjectTableModel extends BaseTableModel<Subject>{
     @Override
    public String[] initLabel() {
        return new String[] {"Subject code", "Subject name", "Description"};
    }

    public subjectTableModel(List<Subject> lstData) {
        super();
        this.lstData = new ArrayList<Subject>();
        this.lstData.add(new Subject());
        this.lstData.addAll(lstData);

    }
    @Override
    public Class getColumnClass(int c) {
        if (lstData.size() > 1) {
            return getValueAt(1, c).getClass();
        }
        return String.class;
    }



    
    public Object getValueAt(int rowIndex, int columnIndex) {
        String value = "";

        if (columnIndex == 0) {
            return lstData.get(rowIndex).getSubjectCode();
        } else if (columnIndex == 1) {
            return lstData.get(rowIndex).getSubjectName();
        } else if (columnIndex == 2) {
            return lstData.get(rowIndex).getDescription();
        } else {
            return "";
        }
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        {
            if (columnIndex == 0) {
                lstData.get(rowIndex).setSubjectCode(aValue.toString());
            } else if (columnIndex == 1) {
                lstData.get(rowIndex).setSubjectName(aValue.toString());
            } else if (columnIndex == 2) {
                lstData.get(rowIndex).setDescription(aValue.toString());
            }
        }
    }
}
