/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package courses;

    import java.sql.*;
    import javax.swing.JOptionPane;
 
/**
 *
 * @author User
 */
public class Courses extends javax.swing.JFrame {
    
        public Connection con;


    /**
     * Creates new form Courses
     */
    public Courses() {
        initComponents();
        this.setTitle("LCU Courses");
        this.setLocationRelativeTo(this);
        tblCourses.getColumnModel().getColumn(0).setMinWidth(0);
        tblCourses.getColumnModel().getColumn(0).setMaxWidth(0);
        getConnection();    
    }
    
    private void getConnection() {
        try {
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost:3306/couses";
            String USERNAME = "root";
            String PASSWORD = "mysql";
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        coursesPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("coursesPU").createEntityManager();
        tblCoursesQuery = java.beans.Beans.isDesignTime() ? null : coursesPUEntityManager.createQuery("SELECT t FROM TblCourses t");
        tblCoursesList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : tblCoursesQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCourses = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblCoursesList, tblCourses);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${courseId}"));
        columnBinding.setColumnName(" Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${courseCode}"));
        columnBinding.setColumnName(" Code");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${courseName}"));
        columnBinding.setColumnName(" Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${courseDescription}"));
        columnBinding.setColumnName(" Description");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${courseNbOfCredits}"));
        columnBinding.setColumnName(" Nb Of Credits");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${courseType}"));
        columnBinding.setColumnName(" Type");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${courseLab}"));
        columnBinding.setColumnName("  Lab");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblCourses);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnModify.setText("Modify");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addGap(44, 44, 44)
                        .addComponent(btnModify)
                        .addGap(30, 30, 30)
                        .addComponent(btnDelete)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnModify)
                    .addComponent(btnDelete))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblCourses.getSelectedRow();
        if (selectedRow > -1) {
            int courseid = Integer.parseInt(tblCourses.getValueAt(selectedRow, 0).toString());
            try {
                Statement stmt = con.createStatement();
                stmt.execute("Delete From tbl_courses Where course_id =" + courseid);
                refreshTable();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a record to delete",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        Course newCourse = new Course(this, true, con, 0);
        newCourse.setVisible(true);
        refreshTable();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCourses.getSelectedRow();
        if (selectedRow > -1) {
            int courseid = Integer.parseInt(tblCourses.getValueAt(selectedRow, 0).toString());
            Course newCourse = new Course(this, true, con, courseid);
            newCourse.setVisible(true);
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Select a record to modify",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModifyActionPerformed

     private void refreshTable() {
        coursesPUEntityManager.getTransaction().begin();
        java.util.Collection data = tblCoursesQuery.getResultList();
        for (Object entity : data) {
            coursesPUEntityManager.refresh(entity);
        }
        tblCoursesList.clear();
        tblCoursesList.addAll(data);
        coursesPUEntityManager.getTransaction().commit();
        bindingGroup.unbind();
        bindingGroup.bind();
        tblCourses.getColumnModel().getColumn(0).setMinWidth(0);
        tblCourses.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Courses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnModify;
    private javax.persistence.EntityManager coursesPUEntityManager;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCourses;
    private java.util.List<courses.TblCourses> tblCoursesList;
    private javax.persistence.Query tblCoursesQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
