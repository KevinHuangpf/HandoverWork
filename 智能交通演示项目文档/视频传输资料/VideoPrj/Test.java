import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
public class Test extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JPanel contentPane;//
BorderLayout borderLayoutAll = new BorderLayout();
JLabel jLabelPrompt = new JLabel();// 状态提示框
JPanel jPanelMain = new JPanel();
BorderLayout borderLayoutMain = new BorderLayout();
JTextField textFieldURL = new JTextField();// URL输入框
JEditorPane jEditorPane = new JEditorPane();// 显示网页内容的容器
public Test() {
try {
jbInit();//初始化并显示界面
}catch(Exception e) {
e.printStackTrace();
}
}
private void jbInit() throws Exception  {//浏览器界面初始化
contentPane = (JPanel)getContentPane();
contentPane.setLayout(borderLayoutAll);
jPanelMain.setLayout(borderLayoutMain);
jLabelPrompt.setText("KevinHuang");
textFieldURL.setText(""); //清空文本框
textFieldURL.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(ActionEvent e) {
textFieldURL_actionPerformed(e); }
});
jEditorPane.setEditable(false); //设置不可编辑
jEditorPane.addHyperlinkListener(new javax.swing.event.HyperlinkListener(){
public void hyperlinkUpdate(HyperlinkEvent e) {
jEditorPane_hyperlinkUpdate(e);
}
});
JScrollPane scrollPane = new JScrollPane();
scrollPane.getViewport().add(jEditorPane);
jPanelMain.add(textFieldURL, "North");
jPanelMain.add(scrollPane, "Center");
contentPane.add(jLabelPrompt, "North");
contentPane.add(jPanelMain, "Center");
enableEvents(AWTEvent.WINDOW_EVENT_MASK);
this.setSize(new Dimension(600, 500));
this.setTitle("视频传输测试环境 ");
this.setVisible(true);
}
void textFieldURL_actionPerformed(ActionEvent e) {// 输入地址后响应回车
try {
jEditorPane.setPage(textFieldURL.getText());// 显示URL
}catch(IOException ex) {
JOptionPane msg = new JOptionPane();
JOptionPane.showMessageDialog(this, "URL地址貌似不正确："+textFieldURL.getText(), "输入不正确！", 0);
}
}
void jEditorPane_hyperlinkUpdate(HyperlinkEvent e) {//响应打开超链接消息
if(e.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
	try {
		URL url = e.getURL();// 从消息中得到URL
		jEditorPane.setPage(url);// 显示网页
		textFieldURL.setText(url.toString());// 显示URL
	}catch(IOException io){
		JOptionPane msg = new JOptionPane();
		JOptionPane.showMessageDialog(this, "打开链接失败！", "或地址输入不正确！", 0);
	}
}
}
protected void processWindowEvent(WindowEvent e) { //处理窗体事件
super.processWindowEvent(e);
if (e.getID() == WindowEvent.WINDOW_CLOSING) {
System.exit(0);//关闭
}
}
public static void main(String[] args) {//Main函数
    new Test();
}
}