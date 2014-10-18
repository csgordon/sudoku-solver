package sudoku;

import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.*;
import org.checkerframework.checker.guieffect.qual.*;
@UIType public class Sudoku_Puzzle_Solver extends javax.swing.JFrame  {

    /* Global variables ! Expected to be used in Both classes*/
    private static javax.swing.JTextField[] cells = new javax.swing.JTextField[81];
    static  Implementor puzzle=new Implementor();
    static Sudoku_Puzzle_Solver newPuzzle;
    JDialog dlg ; //options dilg / about dialog
    String whatissudoku="http://hasinthawk.net46.net//what_is_Sudoku.html";
    String usageurl="http://hasinthawk.net46.net//usage.html";

    private static int[][] grid = new int[9][9];
    private int[][] persistentGrid; // Serializable grid 
    private boolean  filled=false;
    private JFileChooser fc;
    private final String setfile="SUDOKU_PUZZLE_SOLVER_SETTINGS";
    
    /*OPTIONS SECTION*/
    Color CI= Color.YELLOW;
    Color CB= Color.white;
    Color CF=Color.black;
    Color PB=new Color(204,255,255);
    int lookandfeel = 0;
   
    /*---------------*/

    /** Creates new form Interface */
    Sudoku_Puzzle_Solver() {
        initComponents();
        /*
         * For any given cellIndex C (cell arrays subscript) it's x and y can be defined as
         *  Cx = C%9 , Cy = C/9
         *  hence the C for given x ,y can be yielded as
         *  C = 9* y + x
         */
          JTextField[] cells2 = {jTextField1 , jTextField2,jTextField3,jTextField4,jTextField5,jTextField6,jTextField7, jTextField8,jTextField9,
                 jTextField10 , jTextField11,jTextField12,jTextField13,jTextField14,jTextField15,jTextField16, jTextField17,jTextField18,
                 jTextField19 , jTextField20,jTextField21,jTextField22,jTextField23,jTextField24,jTextField25, jTextField26,jTextField27,
                 jTextField28 , jTextField29,jTextField30,jTextField31,jTextField32,jTextField33,jTextField34, jTextField35,jTextField36,
                 jTextField37 , jTextField38,jTextField39,jTextField40,jTextField41,jTextField42,jTextField43, jTextField44,jTextField45,
                 jTextField46 , jTextField47,jTextField48,jTextField49,jTextField50,jTextField51,jTextField52, jTextField53,jTextField54,
                jTextField55 , jTextField56,jTextField57,jTextField58,jTextField59,jTextField60,jTextField61, jTextField62,jTextField63,
                jTextField64 , jTextField65,jTextField66,jTextField67,jTextField68,jTextField69,jTextField70, jTextField71,jTextField72,
                jTextField73 , jTextField74,jTextField75,jTextField76,jTextField77,jTextField78,jTextField79, jTextField80,jTextField81};
         cells=cells2; // Global array
         cells2=null; // eligible to GC

         //--- file chooser settings----
         fc=new JFileChooser();
         fc.setAcceptAllFileFilterUsed(false);
         FileNameExtensionFilter filter = new FileNameExtensionFilter("SPS Puzzle files(*.sps)", "sps","SPS");
         fc.setFileFilter(filter);
         
         //-----------------------------

         //------ Document filter--------
          for(JTextField jtf:cells){
              AbstractDocument doc = (AbstractDocument)jtf.getDocument();
              doc.setDocumentFilter(new sudoku.FilteredDocument(1));
          }

           /*-------------LOAD USER SETTINGS SECTION------------*/
            try{
                File set = new File(setfile);
                if(!set.exists()) throw new SettingsFileNotExistException(); // no setting file exists
                
                FileInputStream fi = new FileInputStream(set);
                ObjectInputStream oi=new ObjectInputStream(fi);
                Serialization obj= (Serialization)oi.readObject();
                
                this.CB=obj.CB;
                this.CF=obj.CF;
                this.CI=obj.CI;
                this.PB=obj.PB;
                this.lookandfeel=obj.lookandfeel;

                
                
                // cells colors
                for(JTextField jtf:cells){
                    jtf.setForeground(CF);
                    jtf.setBackground(CB);
                }
                // panel background
                mainpanel.setBackground(PB);

                oi.close();fi.close(); set=null;obj=null;
            }
            catch(IOException ie){JOptionPane.showMessageDialog(null, ie.getMessage() );}
            catch(ClassNotFoundException ne){JOptionPane.showMessageDialog(null, ne.getMessage() );}
            catch(Exception e){JOptionPane.showMessageDialog(null, e.getMessage());}
        /*----------------------------------------------------*/
    }
    

    // SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel0 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        mainpanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jTextField57 = new javax.swing.JTextField();
        jTextField55 = new javax.swing.JTextField();
        jTextField73 = new javax.swing.JTextField();
        jTextField66 = new javax.swing.JTextField();
        jTextField64 = new javax.swing.JTextField();
        jTextField75 = new javax.swing.JTextField();
        jTextField56 = new javax.swing.JTextField();
        jTextField74 = new javax.swing.JTextField();
        jTextField65 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jTextField29 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTextField17 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jTextField69 = new javax.swing.JTextField();
        jTextField68 = new javax.swing.JTextField();
        jTextField59 = new javax.swing.JTextField();
        jTextField77 = new javax.swing.JTextField();
        jTextField67 = new javax.swing.JTextField();
        jTextField58 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jTextField76 = new javax.swing.JTextField();
        jTextField78 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTextField42 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField51 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jTextField36 = new javax.swing.JTextField();
        jTextField54 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jTextField62 = new javax.swing.JTextField();
        jTextField72 = new javax.swing.JTextField();
        jTextField71 = new javax.swing.JTextField();
        jTextField81 = new javax.swing.JTextField();
        jTextField61 = new javax.swing.JTextField();
        jTextField79 = new javax.swing.JTextField();
        jTextField63 = new javax.swing.JTextField();
        jTextField80 = new javax.swing.JTextField();
        jTextField70 = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        tbSavebtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tbSolvebtn = new javax.swing.JButton();
        tbReserbtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        consIndicate = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sudoku_Puzzle_Solver");
        setBounds(new java.awt.Rectangle(300, 120, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(460, 530));
        setName("game"); // NOI18N
        setResizable(false);

        mainpanel0.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        mainpanel.setBackground(PB);
        mainpanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setOpaque(false);

        jTextField57.setBackground(CB);
        jTextField57.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField57.setForeground(CF);
        jTextField57.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField57.setName("62"); // NOI18N
        jTextField57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField57.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField55.setBackground(CB);
        jTextField55.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField55.setForeground(CF);
        jTextField55.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField55.setName("60"); // NOI18N
        jTextField55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField55.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField73.setBackground(CB);
        jTextField73.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField73.setForeground(CF);
        jTextField73.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField73.setName("80"); // NOI18N
        jTextField73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField73.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField66.setBackground(CB);
        jTextField66.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField66.setForeground(CF);
        jTextField66.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField66.setName("72"); // NOI18N
        jTextField66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField66.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField64.setBackground(CB);
        jTextField64.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField64.setForeground(CF);
        jTextField64.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField64.setName("70"); // NOI18N
        jTextField64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField64.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField75.setBackground(CB);
        jTextField75.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField75.setForeground(CF);
        jTextField75.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField75.setName("82"); // NOI18N
        jTextField75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField75.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField56.setBackground(CB);
        jTextField56.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField56.setForeground(CF);
        jTextField56.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField56.setName("61"); // NOI18N
        jTextField56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField56.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField74.setBackground(CB);
        jTextField74.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField74.setForeground(CF);
        jTextField74.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField74.setName("81"); // NOI18N
        jTextField74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField74.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField65.setBackground(CB);
        jTextField65.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField65.setForeground(CF);
        jTextField65.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField65.setName("71"); // NOI18N
        jTextField65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField65.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jTextField73, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField74, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField75, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jTextField64, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField65, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField66, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jTextField55, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField56, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField57, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField55, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField56, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField57, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField64, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField65, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField66, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField73, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField74, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField75, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setOpaque(false);

        jTextField29.setBackground(CB);
        jTextField29.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField29.setForeground(CF);
        jTextField29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField29.setName("31"); // NOI18N
        jTextField29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField29.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField38.setBackground(CB);
        jTextField38.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField38.setForeground(CF);
        jTextField38.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField38.setName("41"); // NOI18N
        jTextField38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField38.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField46.setBackground(CB);
        jTextField46.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField46.setForeground(CF);
        jTextField46.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField46.setName("50"); // NOI18N
        jTextField46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField46.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField28.setBackground(CB);
        jTextField28.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField28.setForeground(CF);
        jTextField28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField28.setName("30"); // NOI18N
        jTextField28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField37.setBackground(CB);
        jTextField37.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField37.setForeground(CF);
        jTextField37.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField37.setName("40"); // NOI18N
        jTextField37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField37.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField39.setBackground(CB);
        jTextField39.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField39.setForeground(CF);
        jTextField39.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField39.setName("42"); // NOI18N
        jTextField39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField39.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField30.setBackground(CB);
        jTextField30.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField30.setForeground(CF);
        jTextField30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField30.setName("32"); // NOI18N
        jTextField30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField30.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField48.setBackground(CB);
        jTextField48.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField48.setForeground(CF);
        jTextField48.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField48.setName("52"); // NOI18N
        jTextField48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField48.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField47.setBackground(CB);
        jTextField47.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField47.setForeground(CF);
        jTextField47.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField47.setName("51"); // NOI18N
        jTextField47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField47.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setOpaque(false);

        jTextField17.setBackground(CB);
        jTextField17.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField17.setForeground(CF);
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setName("17"); // NOI18N
        jTextField17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField27.setBackground(CB);
        jTextField27.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField27.setForeground(CF);
        jTextField27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField27.setName("28"); // NOI18N
        jTextField27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField9.setBackground(CB);
        jTextField9.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField9.setForeground(CF);
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setName("08"); // NOI18N
        jTextField9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField26.setBackground(CB);
        jTextField26.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField26.setForeground(CF);
        jTextField26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField26.setName("27"); // NOI18N
        jTextField26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField18.setBackground(CB);
        jTextField18.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField18.setForeground(CF);
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.setName("18"); // NOI18N
        jTextField18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField8.setBackground(CB);
        jTextField8.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField8.setForeground(CF);
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setName("07"); // NOI18N
        jTextField8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField7.setBackground(CB);
        jTextField7.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField7.setForeground(CF);
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setName("06"); // NOI18N
        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField25.setBackground(CB);
        jTextField25.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField25.setForeground(CF);
        jTextField25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField25.setName("26"); // NOI18N
        jTextField25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField16.setBackground(CB);
        jTextField16.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField16.setForeground(CF);
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setName("16"); // NOI18N
        jTextField16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setOpaque(false);

        jTextField6.setBackground(CB);
        jTextField6.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField6.setForeground(CF);
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setName("05"); // NOI18N
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField14.setBackground(CB);
        jTextField14.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField14.setForeground(CF);
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setName("14"); // NOI18N
        jTextField14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField24.setBackground(CB);
        jTextField24.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField24.setForeground(CF);
        jTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField24.setName("25"); // NOI18N
        jTextField24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField23.setBackground(CB);
        jTextField23.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField23.setForeground(CF);
        jTextField23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField23.setName("24"); // NOI18N
        jTextField23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField4.setBackground(CB);
        jTextField4.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField4.setForeground(CF);
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setName("03"); // NOI18N
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField13.setBackground(CB);
        jTextField13.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField13.setForeground(CF);
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setName("13"); // NOI18N
        jTextField13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField15.setBackground(CB);
        jTextField15.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField15.setForeground(CF);
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setName("15"); // NOI18N
        jTextField15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField5.setBackground(CB);
        jTextField5.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField5.setForeground(CF);
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setName("04"); // NOI18N
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField22.setBackground(CB);
        jTextField22.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField22.setForeground(CF);
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField22.setName("23"); // NOI18N
        jTextField22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);

        jTextField2.setBackground(CB);
        jTextField2.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField2.setForeground(CF);
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setName("01"); // NOI18N
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField12.setBackground(CB);
        jTextField12.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField12.setForeground(CF);
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setName("12"); // NOI18N
        jTextField12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField19.setBackground(CB);
        jTextField19.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField19.setForeground(CF);
        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.setName("20"); // NOI18N
        jTextField19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField20.setBackground(CB);
        jTextField20.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField20.setForeground(CF);
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setName("21"); // NOI18N
        jTextField20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField10.setBackground(CB);
        jTextField10.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField10.setForeground(CF);
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setName("10"); // NOI18N
        jTextField10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField11.setBackground(CB);
        jTextField11.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField11.setForeground(CF);
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setName("11"); // NOI18N
        jTextField11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField21.setBackground(CB);
        jTextField21.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField21.setForeground(CF);
        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField21.setName("22"); // NOI18N
        jTextField21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField1.setBackground(CB);
        jTextField1.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField1.setForeground(CF);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setName("00"); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField3.setBackground(CB);
        jTextField3.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField3.setForeground(CF);
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setName("02"); // NOI18N
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setOpaque(false);

        jTextField69.setBackground(CB);
        jTextField69.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField69.setForeground(CF);
        jTextField69.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField69.setName("75"); // NOI18N
        jTextField69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField69.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField68.setBackground(CB);
        jTextField68.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField68.setForeground(CF);
        jTextField68.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField68.setName("74"); // NOI18N
        jTextField68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField68.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField59.setBackground(CB);
        jTextField59.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField59.setForeground(CF);
        jTextField59.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField59.setName("64"); // NOI18N
        jTextField59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField59.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField77.setBackground(CB);
        jTextField77.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField77.setForeground(CF);
        jTextField77.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField77.setName("84"); // NOI18N
        jTextField77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField77.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField67.setBackground(CB);
        jTextField67.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField67.setForeground(CF);
        jTextField67.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField67.setName("73"); // NOI18N
        jTextField67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField67.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField58.setBackground(CB);
        jTextField58.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField58.setForeground(CF);
        jTextField58.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField58.setName("63"); // NOI18N
        jTextField58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField58.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField60.setBackground(CB);
        jTextField60.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField60.setForeground(CF);
        jTextField60.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField60.setName("65"); // NOI18N
        jTextField60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField60.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField76.setBackground(CB);
        jTextField76.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField76.setForeground(CF);
        jTextField76.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField76.setName("83"); // NOI18N
        jTextField76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField76.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField78.setBackground(CB);
        jTextField78.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField78.setForeground(CF);
        jTextField78.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField78.setName("85"); // NOI18N
        jTextField78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField78.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jTextField76, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField77, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField78, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jTextField58, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField59, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField60, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jTextField67, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField68, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField69, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField58, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField60, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField67, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField68, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField69, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField76, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField77, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField78, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setOpaque(false);

        jTextField42.setBackground(CB);
        jTextField42.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField42.setForeground(CF);
        jTextField42.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField42.setName("45"); // NOI18N
        jTextField42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField42.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField40.setBackground(CB);
        jTextField40.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField40.setForeground(CF);
        jTextField40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField40.setName("43"); // NOI18N
        jTextField40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField40.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField51.setBackground(CB);
        jTextField51.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField51.setForeground(CF);
        jTextField51.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField51.setName("55"); // NOI18N
        jTextField51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField51.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField31.setBackground(CB);
        jTextField31.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField31.setForeground(CF);
        jTextField31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField31.setName("33"); // NOI18N
        jTextField31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField31.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField49.setBackground(CB);
        jTextField49.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField49.setForeground(CF);
        jTextField49.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField49.setName("53"); // NOI18N
        jTextField49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField49.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField50.setBackground(CB);
        jTextField50.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField50.setForeground(CF);
        jTextField50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField50.setName("54"); // NOI18N
        jTextField50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField50.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField41.setBackground(CB);
        jTextField41.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField41.setForeground(CF);
        jTextField41.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField41.setName("44"); // NOI18N
        jTextField41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField41.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField33.setBackground(CB);
        jTextField33.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField33.setForeground(CF);
        jTextField33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField33.setName("35"); // NOI18N
        jTextField33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField33.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField32.setBackground(CB);
        jTextField32.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField32.setForeground(CF);
        jTextField32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField32.setName("34"); // NOI18N
        jTextField32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField32.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setOpaque(false);

        jTextField36.setBackground(CB);
        jTextField36.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField36.setForeground(CF);
        jTextField36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField36.setName("38"); // NOI18N
        jTextField36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField36.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField54.setBackground(CB);
        jTextField54.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField54.setForeground(CF);
        jTextField54.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField54.setName("58"); // NOI18N
        jTextField54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField54.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField43.setBackground(CB);
        jTextField43.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField43.setForeground(CF);
        jTextField43.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField43.setName("46"); // NOI18N
        jTextField43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField43.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField44.setBackground(CB);
        jTextField44.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField44.setForeground(CF);
        jTextField44.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField44.setName("47"); // NOI18N
        jTextField44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField44.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField45.setBackground(CB);
        jTextField45.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField45.setForeground(CF);
        jTextField45.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField45.setName("48"); // NOI18N
        jTextField45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField45.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField52.setBackground(CB);
        jTextField52.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField52.setForeground(CF);
        jTextField52.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField52.setName("56"); // NOI18N
        jTextField52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField52.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField35.setBackground(CB);
        jTextField35.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField35.setForeground(CF);
        jTextField35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField35.setName("37"); // NOI18N
        jTextField35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField35.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField34.setBackground(CB);
        jTextField34.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField34.setForeground(CF);
        jTextField34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField34.setName("36"); // NOI18N
        jTextField34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField34.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField53.setBackground(CB);
        jTextField53.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField53.setForeground(CF);
        jTextField53.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField53.setName("57"); // NOI18N
        jTextField53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField53.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setOpaque(false);

        jTextField62.setBackground(CB);
        jTextField62.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField62.setForeground(CF);
        jTextField62.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField62.setName("67"); // NOI18N
        jTextField62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField62.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField72.setBackground(CB);
        jTextField72.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField72.setForeground(CF);
        jTextField72.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField72.setName("78"); // NOI18N
        jTextField72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField72.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField71.setBackground(CB);
        jTextField71.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField71.setForeground(CF);
        jTextField71.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField71.setName("77"); // NOI18N
        jTextField71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField71.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField81.setBackground(CB);
        jTextField81.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField81.setForeground(CF);
        jTextField81.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField81.setName("88"); // NOI18N
        jTextField81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField81.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField61.setBackground(CB);
        jTextField61.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField61.setForeground(CF);
        jTextField61.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField61.setName("66"); // NOI18N
        jTextField61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField61.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField79.setBackground(CB);
        jTextField79.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField79.setForeground(CF);
        jTextField79.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField79.setName("86"); // NOI18N
        jTextField79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField79.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField63.setBackground(CB);
        jTextField63.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField63.setForeground(CF);
        jTextField63.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField63.setName("68"); // NOI18N
        jTextField63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField63.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField80.setBackground(CB);
        jTextField80.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField80.setForeground(CF);
        jTextField80.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField80.setName("87"); // NOI18N
        jTextField80.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField80.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        jTextField70.setBackground(CB);
        jTextField70.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField70.setForeground(CF);
        jTextField70.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField70.setName("76"); // NOI18N
        jTextField70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredCell(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedCell(evt);
            }
        });
        jTextField70.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parse00(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jTextField79, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField80, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField81, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jTextField61, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField62, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField63, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jTextField70, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField71, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField72, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField61, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField62, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField63, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField72, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField70, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField71, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField79, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField80, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField81, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout mainpanel0Layout = new javax.swing.GroupLayout(mainpanel0);
        mainpanel0.setLayout(mainpanel0Layout);
        mainpanel0Layout.setHorizontalGroup(
            mainpanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanel0Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainpanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainpanel0Layout.setVerticalGroup(
            mainpanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanel0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setRollover(true);

        tbSavebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sudoku/resources/save.png"))); // NOI18N
        tbSavebtn.setToolTipText("save as a puzzle file");
        tbSavebtn.setFocusable(false);
        tbSavebtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbSavebtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbSavebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbSavebtnActionPerformed(evt);
            }
        });
        jToolBar1.add(tbSavebtn);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sudoku/resources/open.png"))); // NOI18N
        jButton3.setToolTipText("Open a puzzle file");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        tbSolvebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sudoku/resources/gamesize.png"))); // NOI18N
        tbSolvebtn.setToolTipText("solve the puzzle");
        tbSolvebtn.setFocusable(false);
        tbSolvebtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbSolvebtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbSolvebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//Note by Sai Zhang: tbSolvebtnActionPerformed will have an invalid thread violation
                tbSolvebtnActionPerformed(evt);
            }
        });
        jToolBar1.add(tbSolvebtn);

        tbReserbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sudoku/resources/reset.png"))); // NOI18N
        tbReserbtn.setToolTipText("reset puzzle grid");
        tbReserbtn.setFocusable(false);
        tbReserbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbReserbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbReserbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbReserbtnActionPerformed(evt);
            }
        });
        jToolBar1.add(tbReserbtn);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sudoku/resources/customize.png"))); // NOI18N
        jButton4.setToolTipText("Options");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jMenu3.setText("File");
        jMenu3.setToolTipText("View sudoku puzzle solver object files");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sudoku/resources/open.png"))); // NOI18N
        jMenuItem4.setText("Open puzzle..");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sudoku/resources/save.png"))); // NOI18N
        jMenuItem5.setText("Save puzzle..");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sudoku/resources/news.png"))); // NOI18N
        jMenuItem8.setText("Object Viewer");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sudoku/resources/close.png"))); // NOI18N
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Settings");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sudoku/resources/customize.png"))); // NOI18N
        jMenuItem7.setText("Options...");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        consIndicate.setSelected(true);
        consIndicate.setText("Indicate constraints");
        consIndicate.setToolTipText("If checked , program will indicate constraints.\n(if you hover mouse pointer over a cell , program will indicate rows, columns and box affected by it)\n and also the possible values for the cell.");
        jMenu2.add(consIndicate);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Help");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sudoku/resources/help.png"))); // NOI18N
        jMenuItem3.setText("About Sudoku");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sudoku/resources/news.png"))); // NOI18N
        jMenuItem6.setText("Usage..");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sudoku/resources/solve.png"))); // NOI18N
        jMenuItem2.setText("About SPS");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Aboutbox(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(mainpanel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainpanel0, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Addedcode: Character verification
    private void parseData(final JTextField tf , char c , java.awt.event.KeyEvent evt){

        if(!Character.isDigit(c)){
            evt.setKeyChar('\u0000');
            java.awt.Toolkit.getDefaultToolkit().beep();
            return;
        }
        // c is a digit , get i and j
         int i = Integer.parseInt(tf.getName().substring(0,1));
         int j = Integer.parseInt(tf.getName().substring(1,2));
         int val=Integer.parseInt(c+"");
         
         //---- major change of flow due to a bug------

        // check whether the puzzle would be legal with this char c
         if( legalPuzzle( i,j,val, refreshGrid(false) ) ){
            //legal data
             grid[i][j]=val;
             
         }
         else{
            // illegal data
             java.awt.Toolkit.getDefaultToolkit().beep();
             evt.setKeyChar('\u0000');
             return;
         }


    }
    // update the grid
    // XXX: Colin Gordon: implicitly inherits @UI effect from class annotation
    private int[][] refreshGrid(boolean colorgrid){
        grid= new int[9][9];
        int i=0 , jj=0 , val=0;
        for(JTextField j:cells){
            if( !j.getText().trim().equals("") ){
                i = Integer.parseInt(j.getName().substring(0,1));
                jj = Integer.parseInt(j.getName().substring(1,2));
                val=Integer.parseInt(j.getText());
                grid[i][jj]=val;

                 // color grids if requested
                if(colorgrid)
                    j.setBackground(CI);
                // grid had at least one val
                if(val!=0)  filled=true;

            }// end if
           
        }// end for
        return grid;
    }

    // legalpuzzle
     private boolean legalPuzzle(int i, int j, int val, int[][] cells) {
        for (int k = 0; k < 9 ; ++k) { // row
            if(i==k) continue;
            if (val == cells[k][j])
                return false;
        }

        for (int k = 0; k < 9  ; ++k){ // col
            if(k==j) continue;
            if (val == cells[i][k])
                return false;
        }

        int boxRowOffset = (i / 3)*3;
        int boxColOffset = (j / 3)*3;
        for (int k = 0; k < 3; ++k){ // box
            for (int m = 0; m < 3 ; ++m){
                if(boxRowOffset+k == i && boxColOffset+m == j) continue;
                if (val == cells[boxRowOffset+k][boxColOffset+m])
                    return false;
            }
        }

        return true; // no violations, so it's legal
        
    }

    // SOLVE THE PUZZLE button action performed  // unused
    // RESET Button actionperformed   // unused
    private void Aboutbox(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Aboutbox
         // new sudoku.Aboutbox().setVisible(true);
    }//GEN-LAST:event_Aboutbox
   // ABOUt BOX
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
          dlg = new JDialog(this,"About SPS",true);
          sudoku.Aboutbox ab= new sudoku.Aboutbox();
          dlg.setContentPane(ab.aboutpanel);
          dlg.setResizable(false);
          dlg.pack();
          dlg.setLocationRelativeTo(this);
          dlg.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
   // EXIT
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    // INPUT VALIDATIONS//-------------------------------kryevents handlers---------------------------------//    // WHAT IS SUDOKU MENU ITEM
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
             
         try{
             java.net.URL url = new java.net.URL(whatissudoku);
       
            final JDialog newd  = new JDialog(this,"Usage",true);
            Usage u = new Usage(url);
            newd.setTitle("About Sudoku");
            newd.setContentPane(u.ViewerPanel);
            newd.setResizable(false);
            newd.pack();
            newd.setLocationRelativeTo(this);
            
            java.awt.EventQueue.invokeLater(new @UI Runnable() {
                public void run() {
                    newd.setVisible(true);
                }
            });
        }
        catch(Exception e){}
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    // SAVE PUZZLES PERSISTENT STATE
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // COLLECT THE CURRENT PUZZLE GRID
        persistentGrid=this.refreshGrid(false);
        // PUZZLE MUST BE NOT EMPTY TO SAVE
        if(!filled) {
            JOptionPane.showMessageDialog(null," EMPTY GRID!", "ERROR" , JOptionPane.ERROR_MESSAGE );
            return;
        }
        // save safely
        saveSafetly();
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    // SAVE PUZZLES PERSISTENT STATE STAGE 2
    private void saveSafetly(){
         // fireup the filechooser
        int returnVal = fc.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try{
                    Serialization obj = new Serialization(persistentGrid);
                    String filename = fc.getSelectedFile().getName();

                   
                    if(fc.getSelectedFile().exists() || 
                       new File(fc.getSelectedFile().getPath()+".sps").exists() ||
                       new File(fc.getSelectedFile().getPath()+".SPS").exists() ){
                        
                        // file already exists. perform basic file saving procedures
                        int response=JOptionPane.showConfirmDialog(null, filename+" already exists, Overwrite? ", "File Exists", JOptionPane.YES_NO_OPTION);
                        if(response==JOptionPane.NO_OPTION) // user asks not to overwrite
                            saveSafetly(); 
                    }
                    else if( !Utils.isSPS(filename.toLowerCase()) )// adds sps extension
                        fc.setSelectedFile(new File(fc.getSelectedFile().getPath()+".sps"));

                    File file = fc.getSelectedFile();
                    
                    FileOutputStream fo=new FileOutputStream(file);
                    ObjectOutputStream os=new ObjectOutputStream(fo);
                    os.writeObject(obj);
                    
                }
                catch(FileNotFoundException e){JOptionPane.showMessageDialog(null, e.getMessage() );}
                catch(IOException ee){JOptionPane.showMessageDialog(null,ee.getMessage()); }
            }
    }
    //OPEN A PUZZLE GRID FORM A FILE
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // FIRE UP THE SAVEDIALOG AND GET THE FILE
        int returnVal = fc.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try{
                    File file = fc.getSelectedFile();
                    FileInputStream fi=new FileInputStream(file);
                    ObjectInputStream oi= new ObjectInputStream(fi);
                    Sudoku_Puzzle_Solver.solution( ((Serialization)oi.readObject()).getGrid()) ;
                }
                catch(ClassNotFoundException e){JOptionPane.showMessageDialog(null, e.getMessage(),e.getClass().getSimpleName(),JOptionPane.ERROR_MESSAGE);}
                catch(StreamCorruptedException se){JOptionPane.showMessageDialog(null, se.getMessage(),se.getClass().getSimpleName(),JOptionPane.ERROR_MESSAGE);}
                catch(InvalidClassException ee){JOptionPane.showMessageDialog(null, "invalid puzzle file. note that puzzle files aren't backword compatible",ee.getClass().getSimpleName(),JOptionPane.ERROR_MESSAGE);}
                catch(IOException ioe){JOptionPane.showMessageDialog(null, ioe.getMessage(),ioe.getClass().getSimpleName(),JOptionPane.ERROR_MESSAGE);}

            }
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed
   //  USAGE INSTRUCTIONS
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        
        try{
             java.net.URL url = new java.net.URL(usageurl);
       
            final JDialog newd  = new JDialog(this,"Usage",true);
            Usage u = new Usage(url);
            newd.setContentPane(u.ViewerPanel);
            newd.pack();
            newd.setLocationRelativeTo(this);
            
            java.awt.EventQueue.invokeLater(new @UI Runnable() {
                public void run() {
                    newd.setVisible(true);
                }
            });
        }
        catch(Exception e){}

    }//GEN-LAST:event_jMenuItem6ActionPerformed
    // OPTIONS DIALOG POPS UP
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
         java.awt.EventQueue.invokeLater(new @UI Runnable() {
            public void run() {
                Options p=new Options();
                dlg=  new JDialog(newPuzzle , "Options" , true);

                dlg.setContentPane(p.OptionsPanel);
                dlg.setResizable(false);
                dlg.pack();
                dlg.setLocationRelativeTo(newPuzzle);

                dlg.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void parse00(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_parse00
        // limit teh text length to 1
        JTextField jtf = (JTextField)evt.getComponent();
        parseData(jtf,evt.getKeyChar(),evt);
}//GEN-LAST:event_parse00
    
    //  developer addition
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        java.awt.EventQueue.invokeLater(new @UI Runnable() {
            public void run() {
                ObjectViewer ov = new ObjectViewer();

                ov.setLocationRelativeTo(null);
                ov.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    // mouse enetered a cell event
    private void MouseEnteredCell(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseEnteredCell
        if(!consIndicate.isSelected())return;
        // get the componenet
        JTextField cell= (JTextField)evt.getComponent();

        // colorize the column ,  row and box
        int i = Integer.parseInt(cell.getName().substring(0,1));
        int j = Integer.parseInt(cell.getName().substring(1,2));
//        int d=0;
//        try{
//            d = Integer.parseInt(cell.getText()); // current value of the cell
//        }
//        catch(Exception e){d=0;}
        
        colorCells_MouseEvent(i,j,CI);
     
        java.util.List<Integer> vals=possibleDigits(i,j);
        cell.setToolTipText(vals.toString());
        
    }//GEN-LAST:event_MouseEnteredCell

    // possible vals
    private java.util.List<Integer> possibleDigits(int i, int j){
       
        java.util.List<Integer> vals= new ArrayList<Integer>();
        int[][] _grid=refreshGrid(false);

        for(int x=1;x<10;x++ ){

            if(legalPuzzle(i,j,x,_grid))
                vals.add(x);
   
        }
        return vals;
    }

    private void MouseExitedCell(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseExitedCell
       if(!consIndicate.isSelected())return;
        // get the componenet
        JTextField cell= (JTextField)evt.getComponent();
        // colorize it
        int i = Integer.parseInt(cell.getName().substring(0,1));
        int j = Integer.parseInt(cell.getName().substring(1,2));
        
        colorCells_MouseEvent(i,j,CB);
        cell.setToolTipText("");
    }//GEN-LAST:event_MouseExitedCell

    private void tbSavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbSavebtnActionPerformed
        // COLLECT THE CURRENT PUZZLE GRID
        persistentGrid=this.refreshGrid(false);
        // PUZZLE MUST BE NOT EMPTY TO SAVE
        if(!filled) {
            JOptionPane.showMessageDialog(null," EMPTY GRID!", "ERROR" , JOptionPane.ERROR_MESSAGE );
            return;
        }
        // save safely
        saveSafetly();
    }//GEN-LAST:event_tbSavebtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // FIRE UP THE SAVEDIALOG AND GET THE FILE
        int returnVal = fc.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try{
                    File file = fc.getSelectedFile();
                    FileInputStream fi=new FileInputStream(file);
                    ObjectInputStream oi= new ObjectInputStream(fi);
                    Sudoku_Puzzle_Solver.solution( ((Serialization)oi.readObject()).getGrid()) ;
                }
                catch(ClassNotFoundException e){JOptionPane.showMessageDialog(null, e.getMessage(),e.getClass().getSimpleName(),JOptionPane.ERROR_MESSAGE);}
                catch(StreamCorruptedException se){JOptionPane.showMessageDialog(null, se.getMessage(),se.getClass().getSimpleName(),JOptionPane.ERROR_MESSAGE);}
                catch(InvalidClassException ee){JOptionPane.showMessageDialog(null, "invalid puzzle file. note that puzzle files aren't backword compatible",ee.getClass().getSimpleName(),JOptionPane.ERROR_MESSAGE);}
                catch(IOException ioe){JOptionPane.showMessageDialog(null, ioe.getMessage(),ioe.getClass().getSimpleName(),JOptionPane.ERROR_MESSAGE);}

            }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbSolvebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbSolvebtnActionPerformed
        // control should pass to the Implemetor thread  from here
        int[][] temp=refreshGrid(true);
        if(filled) {
        	System.out.println("Filled...");
            puzzle.execute(temp);
            tbSolvebtn.setEnabled(false);
        }
        
    }//GEN-LAST:event_tbSolvebtnActionPerformed

    private void tbReserbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbReserbtnActionPerformed
        this.resetBack();
    }//GEN-LAST:event_tbReserbtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         java.awt.EventQueue.invokeLater(new @UI Runnable() {
            public void run() {
                Options p=new Options();
                dlg=  new JDialog(newPuzzle , "Options" , true);

                dlg.setContentPane(p.OptionsPanel);
                dlg.setResizable(false);
                dlg.pack();
                dlg.setLocationRelativeTo(newPuzzle);

                dlg.setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton4ActionPerformed

    // color rows columns and box on mouse hover event
    private void colorCells_MouseEvent(int i, int j ,Color c){
        //color rows
        for(int x = 0 ; x < 9 ; x++){
            cells[9*i+x].setBackground(c);
        }
        //color columns
        for(int x = 0 ; x < 9 ; x++){
            cells[9*x+j].setBackground(c);
        }
        // color boxes
        int boxi= (i/3)*3; // i of the first cell
        int boxj= (j/3)*3; // j of the first cell
        for (int k = boxi; k < (boxi+3); ++k){ // box
            for (int m= boxj ; m < (boxj+3) ; ++m){
                cells[9*k+m].setBackground(c);
            }
        }
    }


    // APPLY THE CHANGES MADE BY USER
    public void applyChanges(){
        // change cell backgrounds/foregrounds
        

        for(JTextField jtf:cells){
            jtf.setForeground(CF);
            jtf.setBackground(CB);
        }
        // panel background
        mainpanel.setBackground(PB);
        //------------------write changes-------------------------------//
        Serialization settings = new Serialization();
        settings.CB=this.CB;
        settings.CF=this.CF;
        settings.CI=this.CI;
        settings.PB=this.PB;
        settings.lookandfeel=this.lookandfeel;
      

        //
        try{
            File settingsfile=new File(setfile);
            if(settingsfile.exists()){ // delete any existing settings file
                settingsfile.delete();
            }
            settingsfile.createNewFile(); // creates new file in the current dir
                      
            FileOutputStream fs= new FileOutputStream(settingsfile);
            ObjectOutputStream os=new ObjectOutputStream(fs);
            os.writeObject(settings);

            // some housekeeping
            os.flush(); fs.close();os.close();
            settings=null; settingsfile=null;
        }
        catch(IOException ie){JOptionPane.showMessageDialog(null, "Program doesn't have write access in current lication\nRun the program from your Documents folder" );}
        
    }

    //  set look and feel
    
   
    // resets the text boxes !
    protected  void  resetBack(){
       for(JTextField cell:cells){
           cell.setText("");
           cell.setBackground(CB);
           grid=new int[9][9];
          
           filled=false;
       }
       this.tbSolvebtn.setEnabled(true);
    }

    // Output the solution
    @SafeEffect public static synchronized void solution(int[][] solution){
        int cellCounter=0;
        for(int i=0 ; i< 9 ; i++){
            for(int j=0 ; j<9 ; j++){
                try{
                    if(solution[i][j]==0) {cellCounter++;continue;}
                    cells[cellCounter++].setText(solution[i][j]+"");
                    
                }
                catch(ArrayIndexOutOfBoundsException e){   System.err.println("Crtical error");}
            }
        }

        // get rid of existing grid
        grid= new int[9][9];

    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new @UI Runnable() {
            public void run() {
               
                newPuzzle= new Sudoku_Puzzle_Solver();
                
                newPuzzle.setLocationRelativeTo(null);
                newPuzzle.setIconImage(new ImageIcon(getClass().getResource("/sudoku/resources/ico_alpha_Categories_24x24.png") ).getImage() );
                newPuzzle.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem consIndicate;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField61;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField63;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextField jTextField65;
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField jTextField67;
    private javax.swing.JTextField jTextField68;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField70;
    private javax.swing.JTextField jTextField71;
    private javax.swing.JTextField jTextField72;
    private javax.swing.JTextField jTextField73;
    private javax.swing.JTextField jTextField74;
    private javax.swing.JTextField jTextField75;
    private javax.swing.JTextField jTextField76;
    private javax.swing.JTextField jTextField77;
    private javax.swing.JTextField jTextField78;
    private javax.swing.JTextField jTextField79;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField80;
    private javax.swing.JTextField jTextField81;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JPanel mainpanel0;
    private javax.swing.JButton tbReserbtn;
    private javax.swing.JButton tbSavebtn;
    private javax.swing.JButton tbSolvebtn;
    // End of variables declaration//GEN-END:variables


}

///*-------------FILTER CLASS FOR THE jFILECHOOSER-------------------*/
//class SPSFilter extends javax.swing.filechooser.FileFilter {
//
//    public boolean accept(File f){
//        if(f.isDirectory())
//            return true;
//        // get the extension
//        String ext = Utils.getExtension(f);
//        if(ext!=null && ext.equalsIgnoreCase(Utils.sps))
//            return true;
//        else
//            return false;
//    }
//
//    public String getDescription(){
//        return "Puzzle Files (*.sps)";
//    }
//}
//
///*--------------CLASS TO GET EXTENSIONS----------------*/
class Utils {

    public final static String sps ="sps";


    /*
     * Get the extension of a file.
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

    public static boolean isSPS(String filename){
        String ext=null;
        int i = filename.lastIndexOf('.');

        if (i > 0 &&  i < filename.length() - 1) {
            ext = filename.substring(i+1).toLowerCase();
        }
        return sps.equals(ext);
    }
}

// custom exception class
class SettingsFileNotExistException extends Exception {
    
}
