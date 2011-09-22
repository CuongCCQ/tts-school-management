/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.semester;

import api.StudentV2;
import aptech.view.control.BaseTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bo
 * @date Apr 10, 2011
 * @
 */
public class StudentTableModel extends BaseTableModel<StudentV2> {

    //List<StudentV2> lstData;
    //String[] label = {"Student Roll Number", "Name", "Address", "Phone Number", "Email", "Sex"};
    @Override
    public String[] initLabel() {
        return new String[]{"Student Roll Number", "Name", "Address", "Phone Number", "Email", "Sex"};
    }

    public StudentTableModel(List<StudentV2> lstData) {
        super();
        this.lstData = new ArrayList<StudentV2>();
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
            return lstData.get(rowIndex).getStudentCode();
        } else if (columnIndex == 1) {
            return lstData.get(rowIndex).getName();
        } else if (columnIndex == 2) {
            return lstData.get(rowIndex).getAddress();
        } else if (columnIndex == 3) {
            return lstData.get(rowIndex).getPhoneNumber();
        } else if (columnIndex == 4) {
            return lstData.get(rowIndex).getEmail();
        } else if (columnIndex == 5) {
            return lstData.get(rowIndex).getSex();
        } else {
            return "";
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
