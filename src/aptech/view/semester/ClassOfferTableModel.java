
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.view.semester;

import api.ClassOffer;
import api.CourseDAO;
import api.Semester;
import api.SemesterDAO;
import aptech.view.control.BaseTableModel;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author anhson
 */
public class ClassOfferTableModel extends BaseTableModel<ClassOffer>{

   @Override
    public String[] initLabel() {
        return new String[] {"Class code",  "Min students", "Max students","Semester","Course"};
    }


    public ClassOfferTableModel(List<ClassOffer> lstData) {
        super();
        this.lstData = new ArrayList<ClassOffer>();
        this.lstData.add(new ClassOffer());
        this.lstData.addAll(lstData);
        isCellEditable(0,3);
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
            if(lstData.get(rowIndex).getClassCode()!=null){
            return lstData.get(rowIndex).getClassCode().toUpperCase();}
            return "";
            
        } else if (columnIndex == 1) {
            return lstData.get(rowIndex).getMinStudent();
        } else if (columnIndex == 2) {
            return lstData.get(rowIndex).getMaxStudent();
        }else if(columnIndex==3)
        {   int temp=0;
            if(lstData.get(rowIndex).getSemesterId()!=null){
                temp=lstData.get(rowIndex).getSemesterId();
                return (semesterDAO.findById(temp).getName());
            }
            return "";
        }else if(columnIndex==4)
        {
            int temp=0;
            if(lstData.get(rowIndex).getId()!=null){
                temp=lstData.get(rowIndex).getId();
                return (courseDAO.findById(temp).getCourseCode()+""+courseDAO.findById(temp).getCourseName());
            }
            return "";
        }
        else {
            return "";
        }
//        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        {
            if (columnIndex == 0) {
                lstData.get(rowIndex).setClassCode((String)aValue);
            } else if (columnIndex == 1) {
                lstData.get(rowIndex).setMinStudent((Integer)aValue);
            } else if (columnIndex == 2) {
                lstData.get(rowIndex).setMaxStudent((Integer)aValue);
            } else if (columnIndex == 3)
            {
                lstData.get(rowIndex).setSemesterId((Integer)aValue);
            } else if (columnIndex == 4)
            {
                lstData.get(rowIndex).setId((Integer)aValue);
            }
        }
    }
        @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {    
        if(rowIndex!=0 || columnIndex==1 || columnIndex==2||columnIndex==3||columnIndex==4)
            return false;
        return true;
    }
        private SemesterDAO semesterDAO= new SemesterDAO();
        private CourseDAO courseDAO = new CourseDAO();
    
}
