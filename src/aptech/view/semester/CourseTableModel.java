/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.view.semester;
import aptech.view.control.BaseTableModel;
import java.util.ArrayList;
import java.util.List;
import api.Course;
/**
 *
 * @author anhson
 */
public class CourseTableModel extends BaseTableModel<Course>{

    public CourseTableModel(List<Course> lstData)
    {
        this.lstData = new ArrayList<Course>();
        this.lstData.add(new Course());
        this.lstData.addAll(lstData);
    }
    
    @Override
    public String[] initLabel() {
        return new String[] {"Course Name", "Description", "Code"};
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
            return lstData.get(rowIndex).getCourseName();
        } else if (columnIndex == 1) {
            return lstData.get(rowIndex).getDescription();
        } else if (columnIndex == 2) {
            return lstData.get(rowIndex).getCourseCode();
        } else {
            return "";
        }
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        {
            if (columnIndex == 0) {
                lstData.get(rowIndex).setCourseName(aValue.toString());
            } else if (columnIndex == 1) {
                lstData.get(rowIndex).setDescription(aValue.toString());
            } else if (columnIndex == 2) {
                lstData.get(rowIndex).setCourseCode(aValue.toString());
            } 
        }
    }

}
