package com.�ڶ��ڼ��±��Ķ����ı���_�ı����͹�����;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class NoteTextArea extends JFrame implements ActionListener{
	private JPanel jp=new JPanel();
	JButton jb1=new JButton("�����Զ�����");
	JButton jb2=new JButton("���Ҳ�����");
	private JTextArea jt=new JTextArea();
	private JScrollPane js=new JScrollPane(jt);//���������ı���
	public NoteTextArea(){
		jp.setLayout(null);
		jb1.setBounds(40,20,120,20);
		jb2.setBounds(240, 20,120,20);
		jp.add(jb1);
		jp.add(jb2);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		js.setBounds(15,60,360,80);//���ù�������λ�úʹ�С
		jp.add(js);//��ӹ������������
		jt.setLineWrap(false);//�����ı���Ϊ���Զ�����
		for(int i=0;i<30;i++){//����ı����ı�����
			jt.append("�Զ����У������У�");
		}
		this.add(jp);
		
		this.setTitle("���±������ı���");
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
