/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view;

import aptech.util.AppUtil;
import aptech.util.Constant;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author bo
 * @date Apr 3, 2011
 * @
 */
public abstract class BaseSubContentView {

    protected MainSchool mainSchool;
    protected JPanel subContentPanel;
    protected List<JButton> lstButtons;

    public BaseSubContentView(MainSchool mainSchool) {
        lstButtons = new ArrayList<JButton>();
        this.mainSchool = mainSchool;
    }

    // init left menus
    private void initLeftPanelButton() {
        for (JButton btn : this.lstButtons) {
            btn.setBorder(null);
            btn.setHorizontalAlignment(SwingConstants.LEFT);
            btn.setRolloverEnabled(true);
            btn.setIconTextGap(10);
            btn.setFocusPainted(false);
            btn.setContentAreaFilled(false);
            ImageIcon icon = new ImageIcon(AppUtil.getAppPath() + Constant.RESOURCE_PATH + "setting.png");
            btn.setIcon(icon);
            btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            mainSchool.getLeftPanel().add(btn);
        }

    }

    // send sub view to main schools
    public void initSubView() {
        GridLayout layout = new GridLayout(mainSchool.getHeight() / 30, 1);
        this.mainSchool.getLeftPanel().removeAll();
        this.mainSchool.getLeftPanel().setLayout(layout);
        initLeftPanelButton();
        initSubPanelView();
        mainSchool.validate();
        mainSchool.repaint();
    }

    // send subPanel view to main schools
    private void initSubPanelView() {
        this.subContentPanel = initStartPanel();
        mainSchool.getRightPanel().removeAll();
        if (this.subContentPanel != null) {
            mainSchool.getRightPanel().add(this.subContentPanel,BorderLayout.CENTER);
        }
    }

    protected void createNewSubView(JPanel subViewPanel)
    {
        mainSchool.getRightPanel().removeAll();
        mainSchool.getRightPanel().add(subViewPanel);
        mainSchool.validate();
        mainSchool.repaint();
    }

    protected abstract JPanel initStartPanel();
}
