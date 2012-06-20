package sudoku;

import javax.swing.*;
import java.io.*;
import guitypes.checkers.quals.*;

public class ObjectViewer extends javax.swing.JFrame {

    JFileChooser fc;
    File objFile;
    Serialization s;
    FileInputStream fs;
    ObjectInputStream obs;
    
    /** Creates new form ObjectViewer */
    @UIEffect public ObjectViewer() {

        initComponents();
        fc = new JFileChooser();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @UIEffect private void initComponents() {

        browseButton = new javax.swing.JButton();
        filepath = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        objectviewer = new javax.swing.JTextArea();
        status = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sudoku Object Viewer ");
        setResizable(false);

        browseButton.setText("Browse..");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        filepath.setEditable(false);
        filepath.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        objectviewer.setColumns(20);
        objectviewer.setEditable(false);
        objectviewer.setFont(new java.awt.Font("Calibri", 0, 14));
        objectviewer.setLineWrap(true);
        objectviewer.setRows(5);
        jScrollPane1.setViewportView(objectviewer);

        status.setEditable(false);
        status.setFont(new java.awt.Font("Tahoma", 1, 11));
        status.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setText("This tool can only be used to analyse sudoku puzzle solver's object files. (settings. puzzles) . ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filepath, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(browseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browseButton)
                    .addComponent(filepath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @UIEffect private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        // choose a file
        int result = fc.showOpenDialog(this);
        if(result== JFileChooser.APPROVE_OPTION){
            objFile=fc.getSelectedFile();
            filepath.setText(objFile.getPath());
            objectviewer.setText("");
            deserializeMe();
        }

    }//GEN-LAST:event_browseButtonActionPerformed

    @UIEffect private void deserializeMe() {
        if(objFile==null) return;
        status.setText("");
        
        try{
             fs= new FileInputStream(objFile);
             obs = new ObjectInputStream(fs);

            s=(Serialization)obs.readObject();
            displayData();
        }
        catch(Exception e){status.setText(e.getMessage());}
        finally{
            try{
                if(fs!=null) fs.close();
                if(obs!=null) obs.close();
            }
            catch(IOException e){/* no need to handle*/}
        }
    }

    @UIEffect private void displayData(){
        if(s==null) return;
        
        objectviewer.append("SerialversionUID : "+s.serialVersionUID+"\n");
        objectviewer.append("Color indicator :  "+s.CI+"\n");
        objectviewer.append("Color background :  "+s.CB+"\n");
        objectviewer.append("Color foreground :  "+s.CF+"\n");
        objectviewer.append("Panel background :  "+s.CI+"\n");
        //objectviewer.append("Look and feel :  "+Sudoku_Puzzle_Solver.LFclasses[s.lookandfeel]+"\n");
        objectviewer.append("Grid : \n");
        
        int[][] grid = s.getGrid();
        if(grid==null) return;
        
        for(int i=0 ; i<grid.length; i++){
            for(int j=0; j<grid[i].length;j++)
                 objectviewer.append(""+i+j+grid[i][j]+"-");
        }

        objectviewer.setCaretPosition(0);
       
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new @UI Runnable() {
            public void run() {
                ObjectViewer ov = new ObjectViewer();
               
                ov.setLocationRelativeTo(null);
                ov.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JTextField filepath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea objectviewer;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables

}
