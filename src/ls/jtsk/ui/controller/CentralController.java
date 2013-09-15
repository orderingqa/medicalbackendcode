/*
 * �������Ϊ����UI�Ŀ�����������������ͼ�����ݣ�Ȼ�����һ�����߼����㣬��䲢������Ӧ���µ���ͼ��
 */
package ls.jtsk.ui.controller;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import ls.jtsk.helper.ApgarHelper;
import ls.jtsk.helper.BabyHelper;
import ls.jtsk.helper.CasesHelper;
import ls.jtsk.helper.CustomerHelper;
import ls.jtsk.model.Apgar;
import ls.jtsk.model.Baby;
import ls.jtsk.model.Cases;
import ls.jtsk.model.Customer;
import ls.jtsk.model.Doctor;
import ls.jtsk.model.Gender;
import ls.jtsk.model.Gravida;
import ls.jtsk.ui.APGARTab;
import ls.jtsk.ui.CaseHistory;
import ls.jtsk.ui.CreateNewBaby;
import ls.jtsk.ui.CreateNewCase;
import ls.jtsk.ui.ModifyExistsCase;
import ls.jtsk.ui.ViewExistingCase;
import ls.jtsk.ui.assistant.ApgarPrintableTable;
import ls.jtsk.ui.model.ApgarTableModel;

/**
 *
 * @author liushuai
 */
public class CentralController {
    private static CasesHelper ch = new CasesHelper();
    
    // �����ʼ���ڴ���һ��caseʱ������Ȼ�������и��²����е��á�
    private static CaseHistory caseHistory = null;
    
    
    public static void saveCaseAndExit(String medicalNo, String doctorName, String gravidaName, String age, String comment) {
        ch.addCase(Integer.parseInt(medicalNo), doctorName, gravidaName, Integer.parseInt(age), comment);
        if (caseHistory != null) caseHistory.updateModelFromExternal();
    }
    
    // -------------------------------------------------------------------------------------------------------------------------------
    /**
     * 
     * ����������ͼcreateNewCase�Ŀ����������������ͼ�ϴ��������û����룬Ȼ��ѡ��һ���µ���ͼ���ء�
     * @param medicalNo
     * @param doctorName
     * @param gravidaName
     * @param age 
     */
    public static void saveCaseAndShowBabyInputWindow(String medicalNo, String doctorName, String gravidaName, String age, String comment) {
        long newCaseId = ch.addCase(Integer.parseInt(medicalNo), doctorName, gravidaName, Integer.parseInt(age), comment); // ģ�͸�����ϣ�������ƴװ�µ���ͼ��
        // TODO ��ô������ʹ��������������������ֵ����ͨ����������ɣ��������޸Ĵ��룿�����ҿ�����ʱ������û��db�Ĵ��롣
//        long newCaseId = 0;
        CreateNewBaby cnb = new CreateNewBaby(newCaseId);
        cnb.setTitle("�������:"+doctorName+" ������:" + medicalNo + "--����������"+gravidaName+" ��������:"+age);
        cnb.setVisible(true);
        if (caseHistory != null) caseHistory.updateModelFromExternal();
    }
    
    public static void showBabyInputFromCaseList(Cases existCase, CaseHistory ch) {
        if (existCase != null) {
            initCaseHistory(ch);
            long caseId = existCase.getId();
            CreateNewBaby cnb = new CreateNewBaby(caseId);
            cnb.setTitle("���������" + existCase.getDoctor().getDoctorName() +" ������:" + existCase.getGravida().getMedicNo() + "--����������"+existCase.getGravida().getName()+" ��������:"+existCase.getGravida().getAge());
            cnb.setVisible(true);
        } else {
            showCommonMessageBox();
        }
    }
    // -------------------------------------------------------------------------------------------------------------------------------    
    
    public static void saveBabyAndShowApgarScoreWindow(long momId, int babyGender, String babyBirthTime, String babyWindowTitle) {
        long babyId = BabyHelper.addBaby(momId, babyGender, babyBirthTime); // update backend model
//        long babyId = 0;
        APGARTab apgarWindow = new APGARTab(momId, babyId);
        apgarWindow.setTitle(babyWindowTitle+"--�Ա�:" + (babyGender == Gender.BOY ? "��" : "Ů" ) + " ����ʱ��:" + babyBirthTime);
        apgarWindow.setVisible(true);
        if (caseHistory != null) {
            caseHistory.updateModelFromExternal();
            caseHistory.updateButtonForCurrentCase();
        }
    }
    

   
    

    // ����ֺ�ر�apgar���ڣ�����ӡ
    public static void saveApgarAndDisposeWindow(long momId, long babyId, Collection collections, JFrame apgarFrame){
        ApgarHelper.addApgar(momId, babyId, collections);
        apgarFrame.dispose();
        if (caseHistory != null) caseHistory.updateModelFromExternal();
    }
    
    // ����ֺ����̵��ô�ӡ����
    public static void saveApgarAndPrint(long momId, long babyId, Collection collections, JFrame apgarFrame) {
        ApgarHelper.addApgar(momId, babyId, collections);
        apgarFrame.dispose();
        if (caseHistory != null) caseHistory.updateModelFromExternal();
        Cases existCase = CasesHelper.getCasesById(momId);
        new ViewExistingCase(existCase).setVisible(true);
        
//        StringBuffer printableString = new StringBuffer();
//        printableString.append(apgarFrame.getTitle());
//        printableString.append("\r\n-------------------------------------------------------------------------------------------------");
//        printableString.append(getPureApgarPrintableString(collections));
//        String fileName ="temp/" + new Long(System.currentTimeMillis()).toString()+".txt";
//        
//        printToFileAndOpenNotePad(fileName, printableString.toString());
//   
//        // ���±���ӡ������ɺ��һ�����Ҫԭ���Ĵ�ӡ�о��������low priority��
          
    }
    
    
    
    // ��case list�е��ô�ӡ����
    // ��������������ˣ�Ŀǰ���ǲ��ñ�׼�ĶԻ����java�ı�׼��ӡ�ӿں󣬡�
//    public static void printExistCase(Cases existCase) {
////      String strForPrint = getPrintableStringFromCase(existCase);        
//        if (existCase.getGravida().getBabys() != null && existCase.getGravida().getBabys().size() > 0) {
//            String caseTitle = getPrintableCasesTitle(existCase);
//            Baby baby = (Baby) existCase.getGravida().getBabys().iterator().next();
//            if (baby.getApgars() != null) {
//                String strForPrint = caseTitle + ApgarPrintableTable.getPrintableApgarString(new ApgarTableModel(baby.getApgars().toArray()));
//                String fileName ="temp/" + new Long(System.currentTimeMillis()).toString()+".txt";
//                //TODO [����] ���õķ�װ������������ٵ��������������feature�Ĺ�������
//                printToFileAndOpenNotePad(fileName, strForPrint);
//            }
//        }
//    }
    
    public static String getPrintableCasesTitle(Cases existCase) {
        StringBuffer printableString = new StringBuffer();
        Gravida gravida = existCase.getGravida();
        Doctor doctor = existCase.getDoctor();
        Baby firstBaby = (Baby)gravida.getBabys().toArray()[0];
        
        Customer c = CustomerHelper.getFirstCustomer();
        String hospitalString = "";
        if (c != null) hospitalString = "                                          " + 
                c.getHospitalAndDepString() + 
                "����Ӥ���������ֽ��\n\n";
                
        String gravidaString = "��������:" + gravida.getName() + "\n"+
                "��������:" + gravida.getAge() + "\n";
        String hopspitalString = "�������:" + doctor.getDoctorName() + "\n������:" + gravida.getMedicNo() + "\n";
        String babyString = "Ӥ������ʱ��:" + firstBaby.getBirthTime() + "\nӤ���Ա�:" + (firstBaby.getGender() == Gender.BOY ? "��" : "Ů" ) + "\n"; 
        String commentString = "��ע��" + gravida.getComment();
        
        // ��һ��Ӧ������Ҫ���еı��⣬����ڴ�ӡʱ����Ҫ��revise
        printableString.append(hospitalString);
        
        printableString.append(gravidaString);
        printableString.append(hopspitalString);
        printableString.append(babyString);
        printableString.append(commentString);
//        printableString.append("\r\n-------------------------------------------------------------------------------------------------");
//        printableString.append(getPureApgarPrintableString(apgarCollection));
        return printableString.toString();
    }
    
    
//    private static String getPureApgarPrintableString(Collection collections) {
////        StringBuffer apgarPrString = new StringBuffer();
////        apgarPrString.append("����ʱ��   ����   ����    ������    �Դ̼���Ӧ������   ��ɫ\r\n");
////        apgarPrString.append("----------------------------------------------------------------------------\r\n\r\n");
////        Iterator it = collections.iterator();
////        while (it.hasNext()) { // TODO ������Ҫsort������1,5,10���ӵĴ�ֽ����������
////            // TODO ���ﻹ��Ҫ�ϸ�Ŀ��ƴ���ӡ�����ݵ�format��������༸���ո��������ܵõ�һ������format��txt�ļ���
////            Apgar apgar = (Apgar) it.next();
////            apgarPrString.append(apgar.toPrintableString()+"\r\n\r\n\r\n\r\n");
////        }
////        
////        // TODO ������Ҫ��û�д�ֵ�apgarʱ���������ж�����ȫ����ʾδ��֡�
////        return apgarPrString.toString();
//        
//        // TODO [����] �������µĴ�ӡͳһ�ӿ�
//        return ApgarPrintableTable.getPrintableApgarString(new ApgarTableModel(collections.toArray()));
//    }
    
//    // TODO ��Ҫ����ֵ��ȷ���Ƿ�д�ļ��ɹ�����ΪIO����̶Ȼ�ʧ��
//    private static void writeToFile(String fileName, String fileContent) throws IOException{
//        OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8");
//        output.write(fileContent);
//        output.close();
//    }
    
//    private static void callExternalCommand(String commandString) {
//    Runtime rt = Runtime.getRuntime();
//        try {
//            rt.exec(commandString);
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
    
    private static void initCaseHistory(CaseHistory ch) {
        if (caseHistory == null) {
            caseHistory = ch;
        }
    }
    
    public static void displayCreateCaseWindow(CaseHistory ch) {
        CreateNewCase cnc = new CreateNewCase();
        cnc.setChForUpdate(ch);
        cnc.setTitle("�����µĲ���");
        cnc.setVisible(true);
        // ��case�������д������޸ģ�ɾ�����Լ�apgar���ʱ�����Ƕ���Ҫ�����ⲿ�Ĳ����б�
        initCaseHistory(ch);
    }
    
    public static void viewExistingCase(Cases existCase) {
        new ViewExistingCase(existCase).setVisible(true);
    }

    // �����б��ϵ��ã������޸Ĳ������档
    public static void modifyExistingCase (Cases existCases, CaseHistory ch) {
        if (existCases == null) return ;
        new ModifyExistsCase(existCases).setVisible(true);
        initCaseHistory(ch);
    }
    
    // ���޸Ĳ����Ĵ����ϵ��"ȷ���޸�"����á�
    public static void modifyCase(long caseId, String gravidaName, int age, int medicalNo, String doctorName, String comment, JFrame modifyWindow) {
        
        CasesHelper.modifyCase(caseId, gravidaName, age, medicalNo, doctorName, comment);
        modifyWindow.dispose();
        if (caseHistory != null) {
            caseHistory.updateModelFromExternal();
            caseHistory.updateButtonForCurrentCase();
        }
    }
    
    // TODO ����Ȼ���κεĵ��õķ���ֵ���Լ�exception��û�д��������ݻ���������ķֲ�ʽ�����ִ��������ƺ�ʲô��û������
    public static void deleteExistCase(Cases existCases, CaseHistory ch) {
        if (existCases == null) return ;
        if (CentralController.shouldContinueMessageBox("ȷ��ɾ����ǰ����", "ȷ�Ϻ�������Ե�ɾ���������Ƿ�ȷ�ϣ�")) {
            CasesHelper.deleteCase(existCases.getId());
            initCaseHistory(ch);
            if (caseHistory != null) {
                caseHistory.updateModelFromExternal();
                caseHistory.updateButtonForCurrentCase();
            }
        }
    }
    
//    private static void printToFileAndOpenNotePad(String fileName, String printableString) {
//        try{
//            writeToFile(fileName, printableString);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        callExternalCommand("notepad.exe "+fileName);
//    }
    
    public static void showCommonMessageBox() {
        JOptionPane.showMessageDialog(null, "�밴����ʾ������ȷ�ĸ�ʽ");
    }
    
    public static void showCommonMessageBox(String customerizedMessageDisplay) {
        JOptionPane.showMessageDialog(null, customerizedMessageDisplay);
    }
    
    public static boolean shouldContinueMessageBox(String promptTitle, String promptMessageBody) {
        Object[] options = {"ȷ��","ȡ��"}; 
        int response = JOptionPane.showOptionDialog(null, promptMessageBody, promptTitle,JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
        if(response == 0) {  
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
//        try {
//            writeToFile("a.txt", "bcde");
//            callExternalCommand("notepad.exe " + "a.txt");
//        } catch (IOException ex) {
//            Logger.getLogger(CentralController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    
    public static void EnableLargerTableFontSize(javax.swing.JTable jtable) {
        Font tableFont = new Font("SansSerif", Font.PLAIN, 20);
        Font headerFont = new Font("SansSerif", Font.BOLD, 22);
        jtable.setFont(tableFont);
        jtable.getTableHeader().setFont(headerFont);
        jtable.setRowHeight(jtable.getRowHeight()+tableFont.getSize());
        
//      getFont�õ��Ľ��
//      jtable.getFont();  "javax.swing.plaf.FontUIResource[family=SansSerif,name=sansserif,style=plain,size=12]"
    }
}