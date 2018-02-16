package com.第二节记事本的多行文本区_文本区和滚动条;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class NoteTextArea extends JFrame implements ActionListener{
	private JPanel jp=new JPanel();
	JButton jb1=new JButton("点我自动换行");
	JButton jb2=new JButton("点我不换行");
	private JTextArea jt=new JTextArea();
	private JScrollPane js=new JScrollPane(jt);//创建滚动文本区
	public NoteTextArea(){
		jp.setLayout(null);
		jb1.setBounds(40,20,120,20);
		jb2.setBounds(240, 20,120,20);
		jp.add(jb1);
		jp.add(jb2);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		js.setBounds(15,60,360,80);//设置滚动条的位置和大小
		jp.add(js);//添加滚动条到面板中
		jt.setLineWrap(false);//设置文本区为不自动换行
		for(int i=0;i<30;i++){//添加文本到文本区中
			jt.append("自动换行，不换行，");
		}
		this.add(jp);
		
		this.setTitle("记事本多行文本区");
		this.setBounds(200,200,400,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jb1){
			jt.setLineWrap(true);
		}else if(e.getSource()==jb2){
			jt.setLineWrap(false);
		}
	}
	
	public static void main(String[] args) {
		new NoteTextArea();
	}
}
