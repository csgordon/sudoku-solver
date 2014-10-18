
package sudoku;

import java.awt.Desktop;
//import java.io.*;
import java.net.URI;

import javax.swing.SwingUtilities;
import org.checkerframework.checker.guieffect.qual.*;
public class Aboutbox extends javax.swing.JFrame {

    /** Creates new form Aboutbox */
   
    @UIEffect public Aboutbox() {
       this.setLocationRelativeTo(null);
        initComponents();
        buildlog.setCaretPosition(0);
    }
    
   
    // SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @UIEffect private void initComponents() {

        aboutpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        buildlog = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About SPS");
        setBounds(new java.awt.Rectangle(350, 220, 0, 0));

        buildlog.setColumns(20);
        buildlog.setEditable(false);
        buildlog.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        buildlog.setRows(5);
        buildlog.setText("31/03/10 : Multithreaded GUI Implemented  ,  beta 1 uploaded to sourceforge.net\n01/04/10:  Bug Fixed: Invalid puzzles (a puzzle against the sudoku rules. )\n                  About Box: created\n15/04/10: Input validation improvised.\n17/04/10: Save/Open puzzles options added. settings , usage dialogs added.\n04/05/10: options to choose theme added. \n                 previous settings files are nt compatibe with this version. \n20/05/10: Introduced the file extension for puzzle files. (*.sps)\n24/06/10: Introduced constraint indicators.\n25/06/10: Toolbar added.");
        jScrollPane1.setViewportView(buildlog);

        jLabel4.setText(" hasi_wk ");
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton3.setText("eMail me");
        jButton3.setName("mail"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Build log:");

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24));
        jLabel1.setText("Sudoku Puzzle Solver- 1.6");
        jLabel1.setAlignmentX(100.0F);
        jLabel1.setAlignmentY(100.0F);
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton2.setText("Visit my blog");
        jButton2.setName("blog"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout aboutpanelLayout = new javax.swing.GroupLayout(aboutpanel);
        aboutpanel.setLayout(aboutpanelLayout);
        aboutpanelLayout.setHorizontalGroup(
            aboutpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutpanelLayout.createSequentialGroup()
                .addGroup(aboutpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutpanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(aboutpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, aboutpanelLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(aboutpanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );

        aboutpanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton3});

        aboutpanelLayout.setVerticalGroup(
            aboutpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(aboutpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aboutpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aboutpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @UIEffect private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Sudoku_Puzzle_Solver.newPuzzle.dlg.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
   /// Blog
    @UIEffect private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.performDesktop(0);
    }//GEN-LAST:event_jButton2ActionPerformed
   // mail
    @UIEffect private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.performDesktop(1);
    }//GEN-LAST:event_jButton3ActionPerformed
    // Desktop
    @UIEffect private void performDesktop(final int taski){
    	System.out.println("Curent thread: " + Thread.currentThread().getId());
        final String blog="http://hasi-journal.blogspot.com/";
        final String email="mailto:wkhasintha@gmail.com";

        //Note by Sai Zhang: if the program fails to launch a email client
        //, i.e., an exception is thrown. The thread will access the GUI
        //element directly.
        System.out.println("Execute the code");
        if(Desktop.isDesktopSupported()){
            Thread t = new Thread(new Runnable(){
                public void run(){
                    try{
                        Desktop d=Desktop.getDesktop();
                        switch(taski){
                            case 0: d.browse(new URI(blog));
                            break;
                            case 1:d.mail(new URI(email));
                            break;
                        }
                    }
                    catch(Exception e){
                    	//System.out.println("Current thread: " + Thread.currentThread().getId());
                    	//System.out.println("Before accessing GUI: " + SwingUtilities.isEventDispatchThread());
                    	/* BUG -- Colin Gordon, found by Sai as well */ javax.swing.JOptionPane.showMessageDialog(rootPane, e);
//                    	if(!SwingUtilities.isEventDispatchThread()) {
//                        	throw new RuntimeException("Can not access GUI from a non-UI thread.");
//                        }
                    	}
                }// end of  run
            });
            t.start();
        }
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new @UI Runnable() {
            public void run() {
                new Aboutbox().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JPanel aboutpanel;
    private javax.swing.JTextArea buildlog;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
