/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.control;

import api.StudentAttendance;

/**
 *
 * @author bo
 * @date May 12, 2011
 * @
 */
public class AttendanceTableModel extends BaseTableModel<StudentAttendance> {

    @Override
    public String[] initLabel() {
        return new String[]{"Student Name", "Student Code", "Presence", "Description"};
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return lstData.get(rowIndex).getStudentName();
        }
        if (columnIndex == 1) {
            return lstData.get(rowIndex).getStudentCode();
        }
        if (columnIndex == 2) {
            return lstData.get(rowIndex).getAbsenceStatus();
        }
        if (columnIndex == 3) {
            return lstData.get(rowIndex).getDescription();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        if (columnIndex >= 2) {
            return true;
        }
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        {
            if (columnIndex == 2) {
                lstData.get(rowIndex).setAbsenceStatus((Boolean) aValue);
            }
            if (columnIndex == 3) {
                lstData.get(rowIndex).setDescription(aValue.toString());
            }
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
