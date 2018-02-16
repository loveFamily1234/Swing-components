package com.第十二节_编辑器面板;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
public class MyBrowser extends JFrame implements ActionListener,HyperlinkListener{
	//创建面板对象、编辑器面板、文本框、按钮以及滚动条窗口
	private JPanel panel=new JPanel();
	private JEditorPane editorPane=new JEditorPane();
	private JTextField textField=new JTextField();
	private JButton button=new JButton("转到");
	//添加编辑器面板到滚动条窗口中
	private JScrollPane scrollPane=new JScrollPane(editorPane);
	public MyBrowser(){
		//设置编辑器、布局、组件位置、大小，并将组件添加到容器中
		editorPane.setEditable(false);//设置编辑器面板为不可编辑
		panel.setLayout(null);
		textField.setBounds(10,10,500,26);
		button.setBounds(520,10,80,26);
		scrollPane.setBounds(5,40,602,430);
		panel.add(textField);
		panel.add(button);
		panel.add(scrollPane);
		button.addActionListener(this);
		textField.addActionListener(this);
		editorPane.addHyperlinkListener(this);//为编辑器面板注册HyperlinkListener监听器
		
		this.add(panel);
		this.setTitle("简易浏览器");
		this.setBounds(100,100,620,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		String url=textField.getText().trim();//首先从文本框获取URL地址的字符串
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
			//判断事件类型是否激活页面类型，若为激活页面类型则加载网页
			if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
				editorPane.setPage(e.getURL());
			}
		}
		catch(IOException ioe){
			this.errorMsg();
			ioe.printStackTrace();
		}
	}
	
	private void errorMsg(){//当指定页面不能访问时报错误信息的方法
		//指定的URL地址非法时错误提示的信息
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
