/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ls.jtsk.ui;

import java.awt.event.WindowEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import ls.jtsk.model.Apgar;
import ls.jtsk.model.Apgarinterval;
import ls.jtsk.model.Baby;
import ls.jtsk.model.Cases;
import ls.jtsk.model.Gender;
import ls.jtsk.ui.model.ApgarTableModel;

/**
 *
 * @author liushuai
 */
public class ViewExistingCase extends javax.swing.JFrame {
    Cases existCase = null;
    /**
     * Creates new form CaseHistoryViewFrame
     */
    public ViewExistingCase(Cases existCase) {
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
        medicalNoLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        doctorNameLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        gravidaNameLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        gravidaAgeLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        babyGenderLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        babyBirthDateLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        apgarScoreTable = new javax.swing.JTable();

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
        setTitle("�޸Ĳ���");
        setResizable(false);

        jButton4.setText("�˳�");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit(evt);
            }
        });

        jLabel1.setText("סԺ��");

        medicalNoLabel.setText("0000001");

        jLabel3.setText("����ҽʦ");

        doctorNameLabel.setText("�����");

        jLabel5.setText("��������");

        gravidaNameLabel.setText("����");

        jLabel7.setText("��������");

        gravidaAgeLabel.setText("30");

        jLabel9.setText("Ӥ���Ա�");

        babyGenderLabel.setText("��");

        jLabel11.setText("����ʱ��");

        babyBirthDateLabel.setText("2012-05-18 18:30");

        apgarScoreTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(apgarScoreTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(medicalNoLabel)
                            .addComponent(gravidaNameLabel))
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(gravidaAgeLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(doctorNameLabel))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(35, 35, 35)
                        .addComponent(babyGenderLabel)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(babyBirthDateLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(medicalNoLabel)
                    .addComponent(jLabel3)
                    .addComponent(doctorNameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(gravidaNameLabel)
                    .addComponent(jLabel7)
                    .addComponent(gravidaAgeLabel))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(babyGenderLabel)
                    .addComponent(jLabel11)
                    .addComponent(babyBirthDateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton4)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit
        this.dispose();
    }//GEN-LAST:event_exit

    private void fillUIWithCaseData(Cases existCase) {
        if (existCase != null) {
            medicalNoLabel.setText(new Integer(existCase.getGravida().getMedicNo()).toString());
            doctorNameLabel.setText(existCase.getDoctor().getDoctorName());
            gravidaNameLabel.setText(existCase.getGravida().getName());
            gravidaAgeLabel.setText(new Integer(existCase.getGravida().getAge()).toString());
            if (existCase.getGravida().getBabys() != null && existCase.getGravida().getBabys().size() > 0) {
                Baby baby = (Baby) existCase.getGravida().getBabys().iterator().next();
                babyBirthDateLabel.setText(baby.getBirthTime());
                babyGenderLabel.setText(baby.getGender() == Gender.BOY ? "��" : "Ů");
//              if (baby.getApgars() != null && baby.getApgars().size() > 0) { 
// TODO [����] ֻ��baby.getApgars()��Ϊ����������ʾ���ͽ�������һ�����Ҳû������ô���ǻ�ͳһ��ʾ��û�д��
// ���е���ʾ�߼�����ApgarTableModel�����ơ�
                if (baby.getApgars() != null) {
                    apgarScoreTable.setModel(new ApgarTableModel(baby.getApgars().toArray()));
                }
            } else {
                babyBirthDateLabel.setText("");
                babyGenderLabel.setText("");
            }
            
//            Object[] tableModel = new Object [][] {
//                {"����(��/��)", null, "", null},
//                {"����", null, "", null},
//                {"������", null, null, null},
//                {"�Դ̼���Ӧ������", null, null, null},
//                {"Ƥ����ɫ", null, null, null},
//                {"�ܷ�", null, null, null}
//            };
        }
    }
    
    // ��֯���ڱ����е��Ӵ��ڹر�
    @Override  
    protected void processWindowEvent(WindowEvent e) {  
        if (e.getID() == WindowEvent.WINDOW_CLOSING)  
            this.dispose(); //ֱ�ӷ��أ���ֹĬ�϶�������ֹ���ڹر�  
        else {
            super.processWindowEvent(e); //������ִ�д����¼���Ĭ�϶���(�磺����)  
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
            java.util.logging.Logger.getLogger(ViewExistingCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewExistingCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewExistingCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewExistingCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewExistingCase(null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable apgarScoreTable;
    private javax.swing.JLabel babyBirthDateLabel;
    private javax.swing.JLabel babyGenderLabel;
    private javax.swing.JLabel doctorNameLabel;
    private javax.swing.JLabel gravidaAgeLabel;
    private javax.swing.JLabel gravidaNameLabel;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel medicalNoLabel;
    // End of variables declaration//GEN-END:variables
}