/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.semester;

import api.ClassOfferDAO;
import api.Staff;
import api.StaffDAO;
import api.SubjectAssignment;
import api.SubjectDAO;
import aptech.view.control.BaseTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anhson
 */
public class AssimentTableModel extends BaseTableModel<SubjectAssignment> {

    public AssimentTableModel(List<SubjectAssignment> lstData) {
        this.lstData = new ArrayList<SubjectAssignment>();
        this.lstData.add(new SubjectAssignment());
        this.lstData.addAll(lstData);
    }

    @Override
    public String[] initLabel() {
        return new String[]{"Minute per lesson", "Number of lession", "Number of Assiment", "Class offer", "Subject", "Staff"};
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
            return lstData.get(rowIndex).getMinutesPerLession();
        } else if (columnIndex == 1) {
            return lstData.get(rowIndex).getNumberOfLession();
        } else if (columnIndex == 2) {
            return lstData.get(rowIndex).getNumberOfAssignment();
        } else if (columnIndex == 3) {
             int temp = 0;
            if (lstData.get(rowIndex).getClassOfferId()!= null) {
                temp = lstData.get(rowIndex).getClassOfferId();
                return classOfferDAO.findById(temp).getClassCode().toUpperCase();
            }
            return "";
        } else if (columnIndex == 4) {
            int temp = 0;
            if (lstData.get(rowIndex).getSubjectId() != null) {
                temp = lstData.get(rowIndex).getSubjectId();
                return subjectDAO.findById(temp).getSubjectName();
            }
            return "";
        } else if (columnIndex == 5) {
            int temp = 0;
            lstData.get(rowIndex).getStaffId();
            if (lstData.get(rowIndex).getStaffId() != null) {
                temp = lstData.get(rowIndex).getStaffId();
                return staffDAO.findById(temp).getStaffCode() + "_" + staffDAO.findById(temp).getName();
            }
            return "";

        } else {
            return "";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (rowIndex == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        {
            if (columnIndex == 0) {
                lstData.get(rowIndex).setMinutesPerLession(Integer.parseInt(aValue.toString()));
            } else if (columnIndex == 1) {
                lstData.get(rowIndex).setNumberOfLession(Short.parseShort(aValue.toString()));
            } else if (columnIndex == 2) {
                lstData.get(rowIndex).setNumberOfAssignment(Short.parseShort(aValue.toString()));
            } else if (columnIndex == 3) {
                lstData.get(rowIndex).setClassOfferId(Integer.parseInt(aValue.toString()));
            } else if (columnIndex == 4) {
                lstData.get(rowIndex).setSubjectId(Integer.parseInt(aValue.toString()));
            } else if (columnIndex == 5) {
                lstData.get(rowIndex).setStaffId(Integer.parseInt(aValue.toString()));
            }
        }

    }
    private ClassOfferDAO classOfferDAO= new ClassOfferDAO();
    private StaffDAO staffDAO = new StaffDAO();
    private SubjectDAO subjectDAO = new SubjectDAO();
}
