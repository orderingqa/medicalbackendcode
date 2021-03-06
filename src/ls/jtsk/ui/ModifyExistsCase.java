/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ls.jtsk.ui;

import java.awt.event.WindowEvent;
import java.awt.print.Printable;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import ls.jtsk.helper.CasesHelper;
import ls.jtsk.model.Apgar;
import ls.jtsk.model.Apgarinterval;
import ls.jtsk.model.Baby;
import ls.jtsk.model.Cases;
import ls.jtsk.model.Gender;
import ls.jtsk.ui.controller.CentralController;
import ls.jtsk.ui.model.ApgarTableModel;
import ls.jtsk.ui.utility.JTablePrinter;
import ls.jtsk.ui.utility.TablePrintable;

/**
 *
 * @author liushuai
 */
public class ModifyExistsCase extends javax.swing.JFrame {
    Cases existCase = null;
    /**
     * Creates new form CaseHistoryViewFrame
     */
    public ModifyExistsCase(Cases existCase) {
        initComponents();
        this.existCase = existCase;
        fillUIWithCaseData(existCase);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        babyGenderLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        babyBirthDateLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        apgarScoreTable = new javax.swing.JTable() {
            @Override
            public Printable getPrintable(PrintMode printMode, MessageFormat headerFormat, MessageFormat footerFormat) {
                return new TablePrintable(this, printMode, headerFormat, footerFormat);
            }
        };
        modifyCaseButton = new javax.swing.JButton();
        medicalNoInput = new javax.swing.JTextField(10);
        gravidaInput = new javax.swing.JTextField(10);
        doctorInput = new javax.swing.JTextField(10);
        ageInput = new javax.swing.JTextField(10);
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        commentsInput = new javax.swing.JTextArea();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("查看病历");
        setResizable(false);

        jButton4.setFont(new java.awt.Font("宋体", 0, 20)); // NOI18N
        jButton4.setText("退出");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel1.setText("住院号");

        jLabel3.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel3.setText("主治医师");

        jLabel5.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel5.setText("产妇姓名");

        jLabel7.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel7.setText("产妇年龄");

        jLabel9.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel9.setText("婴儿性别");

        babyGenderLabel.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        babyGenderLabel.setText("男");

        jLabel11.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel11.setText("出生时间");

        babyBirthDateLabel.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        babyBirthDateLabel.setText("2012-05-18 18:30");

        apgarScoreTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(apgarScoreTable);

        modifyCaseButton.setFont(new java.awt.Font("宋体", 0, 20)); // NOI18N
        modifyCaseButton.setText("确认修改");
        modifyCaseButton.setActionCommand("修改");
        modifyCaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyCaseButtonActionPerformed(evt);
            }
        });

        medicalNoInput.setFont(new java.awt.Font("宋体", 0, 20)); // NOI18N
        medicalNoInput.setMinimumSize(new java.awt.Dimension(100, 24));

        gravidaInput.setFont(new java.awt.Font("宋体", 0, 20)); // NOI18N
        gravidaInput.setMinimumSize(new java.awt.Dimension(100, 24));

        doctorInput.setFont(new java.awt.Font("宋体", 0, 20)); // NOI18N
        doctorInput.setMinimumSize(new java.awt.Dimension(100, 24));

        ageInput.setFont(new java.awt.Font("宋体", 0, 20)); // NOI18N
        ageInput.setMinimumSize(new java.awt.Dimension(100, 24));

        jLabel2.setFont(new java.awt.Font("宋体", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setText("(请输入数字)");

        jLabel4.setFont(new java.awt.Font("宋体", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 0));
        jLabel4.setText("(请输入数字)");

        jLabel6.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel6.setText("备注");

        commentsInput.setColumns(20);
        commentsInput.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        commentsInput.setRows(5);
        jScrollPane2.setViewportView(commentsInput);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(modifyCaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(362, 362, 362)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(475, 475, 475)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(babyBirthDateLabel)
                        .addGap(29, 29, 29))))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(babyGenderLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(medicalNoInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gravidaInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doctorInput, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(ageInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(doctorInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gravidaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(medicalNoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(babyGenderLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(babyBirthDateLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifyCaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit
        this.dispose();
    }//GEN-LAST:event_exit

    private void modifyCaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyCaseButtonActionPerformed
        if (!validInput()) {
            CentralController.showCommonMessageBox();    
            return;
        } else {
            CentralController.modifyCase(existCase.getId(), gravidaInput.getText(), Integer.parseInt(ageInput.getText()), Integer.parseInt(medicalNoInput.getText()), doctorInput.getText(),commentsInput.getText(), this);
        }
    }//GEN-LAST:event_modifyCaseButtonActionPerformed

    private boolean validInput() {
        String medicalNoValue = medicalNoInput.getText();
        String ageValue = ageInput.getText();
        
        if (medicalNoValue != null && medicalNoValue.trim().length() > 0 && ageValue != null && ageValue.trim().length() > 0 
                && doctorInput.getText() != null && doctorInput.getText().trim().length() > 0
                && gravidaInput.getText() != null && gravidaInput.getText().trim().length() > 0 ) {
            try {
                Integer.parseInt(medicalNoValue);
                Integer.parseInt(ageValue);
                return true;
            }
            catch (Exception e) {
                return false;
            }
        
        }
        return false;
    }
    
    private void fillUIWithCaseData(Cases existCase) {
        if (existCase != null) {
//            medicalNoLabel.setText(new Integer(existCase.getGravida().getMedicNo()).toString());
            medicalNoInput.setText(new Integer(existCase.getGravida().getMedicNo()).toString());
//            doctorNameLabel.setText(existCase.getDoctor().getDoctorName());
            doctorInput.setText(existCase.getDoctor().getDoctorName());
//            gravidaNameLabel.setText(existCase.getGravida().getName());
            gravidaInput.setText(existCase.getGravida().getName());
            commentsInput.setText(existCase.getGravida().getComment());
//            gravidaAgeLabel.setText(new Integer(existCase.getGravida().getAge()).toString());
            ageInput.setText(new Integer(existCase.getGravida().getAge()).toString());
            if (existCase.getGravida().getBabys() != null && existCase.getGravida().getBabys().size() > 0) {
                Baby baby = (Baby) existCase.getGravida().getBabys().iterator().next();
                babyBirthDateLabel.setText(baby.getBirthTime());
                babyGenderLabel.setText(baby.getGender() == Gender.BOY ? "男" : "女");
//              if (baby.getApgars() != null && baby.getApgars().size() > 0) { 
// TODO [待总] 只用baby.getApgars()不为空来决定显示，就解决了如果一个打分也没做，那么我们会统一显示成没有打分
// 所有的显示逻辑都由ApgarTableModel来控制。
                if (baby.getApgars() != null) {
                    apgarScoreTable.setModel(new ApgarTableModel(baby.getApgars().toArray()));
                    CentralController.EnableLargerTableFontSize(apgarScoreTable);
//                    modifyCaseButton.setEnabled(true);
                }
            } else {
                babyBirthDateLabel.setText("");
                babyGenderLabel.setText("");
//                modifyCaseButton.setEnabled(false);
            }
            
//            Object[] tableModel = new Object [][] {
//                {"心率(次/分)", null, "", null},
//                {"呼吸", null, "", null},
//                {"肌张力", null, null, null},
//                {"对刺激反应、怪像", null, null, null},
//                {"皮肤颜色", null, null, null},
//                {"总分", null, null, null}
//            };
        }
    }
    
    // 组织窗口被所有的子窗口关闭
    @Override  
    protected void processWindowEvent(WindowEvent e) {  
        if (e.getID() == WindowEvent.WINDOW_CLOSING)  
            this.dispose(); //直接返回，阻止默认动作，阻止窗口关闭  
        else {
            super.processWindowEvent(e); //该语句会执行窗口事件的默认动作(如：隐藏)  
        }
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
            java.util.logging.Logger.getLogger(ModifyExistsCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyExistsCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyExistsCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyExistsCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyExistsCase(CasesHelper.getCasesById(1)).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageInput;
    private javax.swing.JTable apgarScoreTable;
    private javax.swing.JLabel babyBirthDateLabel;
    private javax.swing.JLabel babyGenderLabel;
    private javax.swing.JTextArea commentsInput;
    private javax.swing.JTextField doctorInput;
    private javax.swing.JTextField gravidaInput;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField medicalNoInput;
    private javax.swing.JButton modifyCaseButton;
    // End of variables declaration//GEN-END:variables
}
