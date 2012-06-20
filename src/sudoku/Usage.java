

package sudoku;
import java.net.*;
import java.awt.Cursor;
import guitypes.checkers.quals.*;
public class Usage extends javax.swing.JFrame {

    private URL url;

    /** Creates new form Usage */
    @UIEffect public Usage(URL url) {
        
        this.setLocationRelativeTo(null);
        initComponents();
        
        // set html page for the editor pane
               
        Editor.setContentType("text/html");
        try{
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            Editor.setPage(url);
            status.setText(url.toString());
        }
        catch(Exception e){Editor.setText("Error: "+e.getMessage()+" \n Make sure you are connected to the Internet");}
        finally{setCursor(Cursor.DEFAULT_CURSOR);}
    }

   
    // SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @UIEffect private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ViewerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Editor = new javax.swing.JEditorPane();
        status = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usage of SPS");
        setBounds(new java.awt.Rectangle(350, 150, 0, 0));

        ViewerPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Editor.setContentType("text/html");
        Editor.setEditable(false);
        Editor.setToolTipText("");
        jScrollPane1.setViewportView(Editor);

        status.setEditable(false);
        status.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout ViewerPanelLayout = new javax.swing.GroupLayout(ViewerPanel);
        ViewerPanel.setLayout(ViewerPanelLayout);
        ViewerPanelLayout.setHorizontalGroup(
            ViewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                    .addComponent(status, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
                .addContainerGap())
        );
        ViewerPanelLayout.setVerticalGroup(
            ViewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(545, 545, 545)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ViewerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ViewerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JEditorPane Editor;
    javax.swing.JPanel ViewerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables

}
