// ���ƣ�VideoStream
// ���ܣ�����ݮ�ɵ�������������Դ����Ƶ������ն�
// ���ߣ�KevinHuang

import java.lang.reflect.Method;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class VideoStream {
	public static void main(String[] args) {
//		ImageIcon icon =new ImageIcon("E:\\1.jpg");
		ImageIcon icon =new ImageIcon("/home/pi/VideoPrj/icon.jpg");
		int answer = JOptionPane.showConfirmDialog(null, "�Ƿ�����������Ƶ��", "�����Ƚ���ͨ����", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,icon);
	    if (answer == 0){
	    	String url = "http://192.168.1.1:8080/?action=stream";         
	    	VideoStream.openURL(url);  
	    }
	    else
	    	System.exit(0);
	    		    	
	}
      public static void openURL(String url) {  
           try {  
               browse(url);  
           } catch (Exception e) {  
           }  
       }  
   
       private static void browse(String url) throws Exception {  
         
           String osName = System.getProperty("os.name", "");  
           if (osName.startsWith("Mac OS")) {  
 
               Class<?> fileMgr = Class.forName("com.apple.eio.FileManager");  
               Method openURL = fileMgr.getDeclaredMethod("openURL", new Class[] { String.class });  
               openURL.invoke(null, new Object[] { url });  
           } else if (osName.startsWith("Windows")) {  
              //windows  
               Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);  
           } else {  
               // Unix or Linux����ݮ�ɣ�
               String[] browsers = { "firefox", "opera", "konqueror", "chromium", "mozilla", "netscape" };  
               String browser = null;  
               for (int count = 0; count < browsers.length && browser == null; count++)  

                   if (Runtime.getRuntime().exec(new String[] { "which", browsers[count] }).waitFor() == 0)  
                       browser = browsers[count];  
               if (browser == null)  
                   throw new Exception("Could not find web browser");  
               else  
                   //�õ�����
                   Runtime.getRuntime().exec(new String[] { browser, url });  
           }  
       }  

}
 

