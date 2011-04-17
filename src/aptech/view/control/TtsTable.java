/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.view.control;

import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import resources.images.PathUtil;

/**
 *
 * @author bo
 * @date Apr 11, 2011
 * @
 */
public class TtsTable extends JTable {

    
    public TtsTable(BaseTableModel dm) {
        super(dm);
         this.setRowHeight(0,25);
    }

    @Override
    public TableCellRenderer getCellRenderer(int row, int column) {
        TableCellRender render = new TableCellRender(true);
        URL resource = PathUtil.class.getResource("tia.png");
        JLabel label = new JLabel(new ImageIcon(resource.getPath()));
        if(row==0){
            render.add(label);
            render.setBackground(new Color(227, 184, 125));
        }else{
            return super.getCellRenderer(row, column);
        }
        return render;
    }

   
    
}
