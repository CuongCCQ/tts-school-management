/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainSchool.java
 *
 * Created on Apr 1, 2011, 10:47:10 PM
 */
package aptech.view;

import api.Account;
import aptech.util.AppUtil;
import aptech.util.Constant;
import aptech.view.semester.semesterView;
import aptech.view.staff.StaffView;
import aptech.view.student.StudentView;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import net.infonode.docking.RootWindow;
import net.infonode.docking.SplitWindow;
import net.infonode.docking.View;
import net.infonode.docking.theme.DockingWindowsTheme;
import net.infonode.docking.theme.ShapedGradientDockingTheme;
import net.infonode.docking.util.DockingUtil;
import net.infonode.docking.util.ViewMap;
import net.infonode.gui.colorprovider.ColorProvider;
import net.infonode.gui.componentpainter.SolidColorComponentPainter;
import net.infonode.util.Direction;

/**
 *
 * @author bo
 */
public class MainSchool extends javax.swing.JFrame {

    View bottomPanel;
    View rightPanel;
    View leftPanel;
    RootWindow rootWindow;
    SplitWindow spl0;
    JPanel toolbarJPanel;
    JPanel contentPanel;
    JPanel contentpanel;
    JMenuBar menuBar;
    JToolBar toolBar;
    JList lstMenu;
    Account userToken;

    public Account getUserToken() {
        return userToken;
    }

    public void setUserToken(Account userToken) {
        this.userToken = userToken;
    }
    


    public View getBottomPanel() {
        return bottomPanel;
    }

    public void setBottomPanel(View bottomPanel) {
        this.bottomPanel = bottomPanel;
    }

    public View getLeftPanel() {
        return leftPanel;
    }

    public void setLeftPanel(View leftPanel) {
        this.leftPanel = leftPanel;
    }

    public View getRightPanel() {
        return rightPanel;
    }

    public void setRightPanel(View rightPanel) {
        this.rightPanel = rightPanel;
    }

    /** Creates new form MainSchool */
    public MainSchool() {
        //initComponents();
        initView();
        initMenu();
        initToolBar();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // init main window at the first load
    private void initView() {
        // init views
        bottomPanel = new View("bottomPanel", null, null);
        rightPanel = new View("rightPanel", null, null);
        leftPanel = new View("Action                                                ", null, null);

        // create root window

        ViewMap viewMap = new ViewMap();
        rootWindow = DockingUtil.createRootWindow(viewMap, true);
        SplitWindow spl1 = new SplitWindow(true, 0.2f, leftPanel, rightPanel);

        // init theme
        DockingWindowsTheme xxTheme = new ShapedGradientDockingTheme();
        xxTheme.getRootWindowProperties().getComponentProperties().setBackgroundColor(Color.yellow);

        rootWindow.getRootWindowProperties().addSuperObject(xxTheme.getRootWindowProperties());
        rootWindow.setPopupMenuFactory(null);
        // init title control buttons
        rootWindow.getRootWindowProperties().getDockingWindowProperties().setCloseEnabled(false);
        rootWindow.getRootWindowProperties().getDockingWindowProperties().setUndockEnabled(false);
        rootWindow.getRootWindowProperties().getDockingWindowProperties().setMinimizeEnabled(false);
        leftPanel.getWindowProperties().setUndockEnabled(false);
        leftPanel.getWindowProperties().setMaximizeEnabled(false);
        leftPanel.getWindowProperties().setDockEnabled(false);

        rightPanel.setLayout(new CardLayout());


        this.getContentPane().setBackground(new Color(171, 171, 171));
        bottomPanel.getWindowProperties().setMinimizeEnabled(true);
        rootWindow.getWindowBar(Direction.DOWN).setEnabled(true);
        spl1.setEnabled(false);
        spl1.getWindowProperties().setMaximizeEnabled(false);
        spl1.getWindowProperties().setMinimizeEnabled(false);
        spl1.getWindowProperties().setDockEnabled(false);
        spl0 = new SplitWindow(false, 0.8f, spl1, bottomPanel);

        rootWindow.getRootWindowProperties().getWindowAreaShapedPanelProperties().setComponentPainter(
                new SolidColorComponentPainter(new ColorProvider() {

            public Color getColor() {
                return Color.WHITE;
            }

            public Color getColor(Component component) {
                return Color.WHITE;
            }
        }));

        // init maximize
        this.setExtendedState(this.getExtendedState() | MAXIMIZED_BOTH);
        rootWindow.setWindow(spl0);
        // init layout panel
        toolbarJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toolbarJPanel.setSize(rootWindow.getWidth(), 40);
        toolbarJPanel.setBackground(new Color(240, 240, 240));

        this.getContentPane().setLayout(new BorderLayout(0, 5));
        this.getContentPane().add(toolbarJPanel, BorderLayout.NORTH);
        this.getContentPane().add(rootWindow, BorderLayout.CENTER);
        rootWindow.setVisible(false);
        setTitle("School Management");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.setResizable(false);

    }

    // init menu
    private void initMenu() {

        // menu bar
        menuBar = new JMenuBar();
        initFileMenu();
        initEditMenu();
        initHelpMenu();
        setJMenuBar(menuBar);
    }

    // init tool bar
    private void initToolBar() {
        toolBar = new JToolBar(JToolBar.HORIZONTAL);
        initStudentButton();
        initTeacherButton();
        initCourceButton();
        this.toolbarJPanel.add(toolBar);
    }

    // <editor-fold defaultstate="collapsed" desc="init toolbar buttons">
    private void initStudentButton() {
        JButton btnStudent = new JButton();
        ImageIcon studentIcon = new ImageIcon(AppUtil.getAppPath() + Constant.RESOURCE_PATH + "student.png");
        btnStudent.setIcon(studentIcon);
        btnStudent.setText("Student");
        btnStudent.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                loadStudentView(e);
            }
        });
        toolBar.add(btnStudent);
    }

    private void initTeacherButton() {
        JButton btnTeacher = new JButton();
        ImageIcon studentIcon = new ImageIcon(AppUtil.getAppPath() + Constant.RESOURCE_PATH + "teacher.png");
        btnTeacher.setIcon(studentIcon);
        btnTeacher.setText("Staff");
        btnTeacher.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                loadStaffView(e);
            }
        });
        clearAllListView();
        toolBar.add(btnTeacher);
    }

    private void initCourceButton() {
        JButton btnCource = new JButton();
        ImageIcon studentIcon = new ImageIcon(AppUtil.getAppPath() + Constant.RESOURCE_PATH + "course.png");
        btnCource.setIcon(studentIcon);
        btnCource.setText("Cource");
        btnCource.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                loadCourceView(e);
            }
        });
        clearAllListView();
        toolBar.add(btnCource);
    }

    private void clearAllListView() {
        this.leftPanel.removeAll();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="init menus">
    // init file menu
    private void initFileMenu() {
        // init file menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                exitProgram(e);
            }
        });
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
    }

    // init Edit menu
    private void initEditMenu() {
        JMenu editMenu = new JMenu("Edit");
        JMenuItem studentMenuItem = new JMenuItem("Student");
        studentMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                exitProgram(e);
            }
        });
        editMenu.add(studentMenuItem);
        menuBar.add(editMenu);
    }

    // init Help menu
    private void initHelpMenu() {
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
//                new About().setVisible(true);
            }
        });
        helpMenu.add(aboutMenuItem);
        menuBar.add(helpMenu);
    }

// </editor-fold>
    private void loadStudentView(ActionEvent eventData) {
        //this.getContentPane().setBackground(new Color(240,240,240));
        StudentView studentView = new StudentView(this);
        studentView.initSubView();
        this.rootWindow.setVisible(true);
    }

    private void loadStaffView(ActionEvent eventData) {
        //this.getContentPane().setBackground(new Color(240,240,240));
        StaffView staffView = new StaffView(this);
        staffView.initSubView();
        this.rootWindow.setVisible(true);
    }

    private void loadCourceView(ActionEvent evenData) {
        semesterView smView = new semesterView(this);
        smView.initSubView();
        this.rootWindow.setVisible(true);
    }
    // terminate program

    private void exitProgram(ActionEvent event) {
        System.exit(1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                MainSchool mainSchool = new MainSchool();
                Account acc=new Account(1, "tuyuri", "123",72,new Date(),(short)2);
                mainSchool.setUserToken(acc);
            }
        });


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
