package com.��ʮ����_�༭�����;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
public class MyBrowser extends JFrame implements ActionListener,HyperlinkListener{
	//���������󡢱༭����塢�ı��򡢰�ť�Լ�����������
	private JPanel panel=new JPanel();
	private JEditorPane editorPane=new JEditorPane();
	private JTextField textField=new JTextField();
	private JButton button=new JButton("ת��");
	//��ӱ༭����嵽������������
	private JScrollPane scrollPane=new JScrollPane(editorPane);
	public MyBrowser(){
		//���ñ༭�������֡����λ�á���С�����������ӵ�������
		editorPane.setEditable(false);//���ñ༭�����Ϊ���ɱ༭
		panel.setLayout(null);
		textField.setBounds(10,10,500,26);
		button.setBounds(520,10,80,26);
		scrollPane.setBounds(5,40,602,430);
		panel.add(textField);
		panel.add(button);
		panel.add(scrollPane);
		button.addActionListener(this);
		textField.addActionListener(this);
		editorPane.addHyperlinkListener(this);//Ϊ�༭�����ע��HyperlinkListener������
		
		this.add(panel);
		this.setTitle("���������");
		this.setBounds(100,100,620,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		String url=textField.getText().trim();//���ȴ��ı����ȡURL��ַ���ַ���
		try{
			editorPane.setPage(url);
		}
		catch(IOException ioe){
			this.errorMsg();
			ioe.printStackTrace();
		}
	}
	public void hyperlinkUpdate(HyperlinkEvent e){
		try{
			//�ж��¼������Ƿ񼤻�ҳ�����ͣ���Ϊ����ҳ�������������ҳ
			if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
				editorPane.setPage(e.getURL());
			}
		}
		catch(IOException ioe){
			this.errorMsg();
			ioe.printStackTrace();
		}
	}
	
	private void errorMsg(){//��ָ��ҳ�治�ܷ���ʱ��������Ϣ�ķ���
		//ָ����URL��ַ�Ƿ�ʱ������ʾ����Ϣ
		try{
			File file=new File("D:\\lixiangguo\\MyEclipse6.5\\Java\\src\\ch10\\error.htm");
			editorPane.setPage(file.toURI().toURL());
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MyBrowser();
	}
}
