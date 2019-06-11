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
JLabel jLabelPrompt = new JLabel();// ״̬��ʾ��
JPanel jPanelMain = new JPanel();
BorderLayout borderLayoutMain = new BorderLayout();
JTextField textFieldURL = new JTextField();// URL�����
JEditorPane jEditorPane = new JEditorPane();// ��ʾ��ҳ���ݵ�����
public Test() {
try {
jbInit();//��ʼ������ʾ����
}catch(Exception e) {
e.printStackTrace();
}
}
private void jbInit() throws Exception  {//����������ʼ��
contentPane = (JPanel)getContentPane();
contentPane.setLayout(borderLayoutAll);
jPanelMain.setLayout(borderLayoutMain);
jLabelPrompt.setText("KevinHuang");
textFieldURL.setText(""); //����ı���
textFieldURL.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(ActionEvent e) {
textFieldURL_actionPerformed(e); }
});
jEditorPane.setEditable(false); //���ò��ɱ༭
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
this.setTitle("��Ƶ������Ի��� ");
this.setVisible(true);
}
void textFieldURL_actionPerformed(ActionEvent e) {// �����ַ����Ӧ�س�
try {
jEditorPane.setPage(textFieldURL.getText());// ��ʾURL
}catch(IOException ex) {
JOptionPane msg = new JOptionPane();
JOptionPane.showMessageDialog(this, "URL��ַò�Ʋ���ȷ��"+textFieldURL.getText(), "���벻��ȷ��", 0);
}
}
void jEditorPane_hyperlinkUpdate(HyperlinkEvent e) {//��Ӧ�򿪳�������Ϣ
if(e.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
	try {
		URL url = e.getURL();// ����Ϣ�еõ�URL
		jEditorPane.setPage(url);// ��ʾ��ҳ
		textFieldURL.setText(url.toString());// ��ʾURL
	}catch(IOException io){
		JOptionPane msg = new JOptionPane();
		JOptionPane.showMessageDialog(this, "������ʧ�ܣ�", "���ַ���벻��ȷ��", 0);
	}
}
}
protected void processWindowEvent(WindowEvent e) { //�������¼�
super.processWindowEvent(e);
if (e.getID() == WindowEvent.WINDOW_CLOSING) {
System.exit(0);//�ر�
}
}
public static void main(String[] args) {//Main����
    new Test();
}
}