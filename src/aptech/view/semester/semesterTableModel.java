/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.semester;

import api.Semester;
import aptech.view.control.BaseTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhson
 */
public class semesterTableModel extends BaseTableModel<Semester> {

    @Override
    public String[] initLabel() {
        return new String[]{"Start Date", "Name", "End Date", "Discription"};
    }

    public semesterTableModel(List<Semester> lstData) {
        super();
        this.lstData = new ArrayList<Semester>();
        this.lstData.add(new Semester());
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

//        if (rowIndex > 0) {
        if (columnIndex == 0) {
            return lstData.get(rowIndex).getStartDate();
        } else if (columnIndex == 1) {
            return lstData.get(rowIndex).getName();
        } else if (columnIndex == 2) {
            return lstData.get(rowIndex).getEndDate();
        } else if (columnIndex == 3) {
            return lstData.get(rowIndex).getDescription();
        } else if (columnIndex == 4) {
            return lstData.get(rowIndex).getName();
        } else {
            return "";
        }
//        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        {
            try {
                if (columnIndex == 3) {
                    lstData.get(rowIndex).setDescription(aValue.toString());
                } else if (columnIndex == 1) {
                    lstData.get(rowIndex).setName(aValue.toString());
                }
            } catch (Exception ex) {
                Logger.getLogger(semesterTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(rowIndex!=0 || columnIndex==0 || columnIndex==1)
            return false;
        return true;
    }
}
