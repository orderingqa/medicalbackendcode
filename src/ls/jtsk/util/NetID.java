/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// TODO 这个是为了获得活动网卡的地址的程序，但可惜的是以下就获得了所有的网卡。
package ls.jtsk.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;
import static java.lang.System.out;

/**
 *
 * @author LS
 */
public class NetID {

    public static void main(String args[]) throws SocketException {
//        String address = "";
//        String host = "localhost";
//
//        NetID test = new NetID();
//              通过期望调用一个JDK1.6的http://yoyo08.iteye.com/blog/470582 网络硬件接口来获得网卡地址不work。
//              address = test.getMacAddress(host);
//		System.out.println("Physical Address is : " + address);
//            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
//            for (NetworkInterface netint : Collections.list(nets))
//                displayInterfaceInformation(netint);
//      address = NetID.getMacAddressFromSystemCall();
        
    	System.out.println("请在下面输入授权申请号：    \r\n" );
    	BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
    	try {
			long l = Long.parseLong(b.readLine());
			String activateNumberString = NetID.finalActivateNumberGenerate(l);
			System.out.println("请将本激活码：    "+activateNumberString+ "    授权给申请号：    "+l);
		} catch (NumberFormatException e) {
//			e.printStackTrace();
			System.out.print("序列码输入错误，请重新运行程序输入正确的序列码");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }


    public static boolean isValidActivateNumber(long applySN) {
    	// correctActivateSN为刘大夫生成的最终序列号
    	String correctActivateSN = finalActivateNumberGenerate(generateSnFromMacAddressToNumber(getMacAddressFromSystemCall()));
    	return correctActivateSN.equals((new Long(applySN)).toString()) ? true : false;
    }
    
    public static long generateApplyNumber() {
    	return generateSnFromMacAddressToNumber(getMacAddressFromSystemCall());
    }
    
    
    // TODO 这个返回String实在是迫不得已，因为无法确保返回来long的长度。
    public static String finalActivateNumberGenerate(long sn) {
    	long finalNumber = (sn + 10016959) * 17 ;
    	return new Long(finalNumber).toString().substring(0, 9);
    }
    
    public static long generateSnFromMacAddressToNumber(String macAddress) {
        if (macAddress == null || macAddress.length() == 0 || macAddress.equals("00-00-00-00-00-00")) return 10016957L; 
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<macAddress.length(); i++) {
            char c = macAddress.charAt(i);
            if ( c != '-') {
                sb.append((c-48)%10); // 将所有的字符都减去0所在的ASCII数字48，然后全部规约到0-9
            }
        }
        String numbers = sb.toString();
        return Long.parseLong(numbers);
    } 
    
    public static String getMacAddressFromSystemCall() {
        String mac = "";
        String line = "";

        String os = System.getProperty("os.name");

        if (os != null && os.startsWith("Windows")) {
            try {
                String command = "cmd.exe /c ipconfig /all";
                Process p = Runtime.getRuntime().exec(command);

                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

                while ((line = br.readLine()) != null) {
                    if (line.indexOf("Physical Address") > 0 || line.indexOf("物理地址") > 0) {
                        int index = line.indexOf(":") + 2;

                        mac = line.substring(index);

                        break;
                    }
                }

                br.close();

            } catch (IOException e) {
            }
        }

        return mac;
    }

    // not used TODO may be some day debug on this.
//    public String getMacAddress(String host) {
//        String mac = "";
//        StringBuffer sb = new StringBuffer();
//
//        try {
//            NetworkInterface ni = NetworkInterface.getByInetAddress(InetAddress.getByName(host));
//
//            byte[] macs = ni.getHardwareAddress();
//
//            for (int i = 0; i < macs.length; i++) {
//                mac = Integer.toHexString(macs[i] & 0xFF);
//
//                if (mac.length() == 1) {
//                    mac = '0' + mac;
//                }
//
//                sb.append(mac + "-");
//            }
//
//        } catch (SocketException e) {
//            e.printStackTrace();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//
//        mac = sb.toString();
//        mac = mac.substring(0, mac.length() - 1);
//
//        return mac;
//    }
    
    
        // TODO not used
//    static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
//        out.printf("Display name: %s\n", netint.getDisplayName());
//        out.printf("Name: %s\n", netint.getName());
//        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
//        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
//            out.printf("InetAddress: %s\n", inetAddress);
//
//        }
//        out.printf("\n");
//    }
}
