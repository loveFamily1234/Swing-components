package com.��һ�ڵ�¼����_�ı���������;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LoginTest extends JFrame implements ActionListener{
	private JPanel jp=new JPanel();
	JLabel name=new JLabel("�������û���");
	JLabel password=new JLabel("����������");
	JLabel show=new JLabel("");
	private JLabel[] jl={name,password,show};
	JButton login=new JButton("��¼");
	JButton reset=new JButton("����");
	private JButton[] jb={login,reset};
	private JTextField jName=new JTextField();
	private JPasswordField jPassword=new JPasswordField();
	public LoginTest(){
		jp.setLayout(null);
		for(int i=0;i<2;i++){
			jl[i].setBounds(30,20+40*i,180,20);
			jb[i].setBounds(30+110*i,100,80,20);
			jp.add(jl[i]);
			jp.add(jb[i]);
			jb[i].addActionListener(this);
		}
		jName.setBounds(130,15,100,20);
		jp.add(jName);
		jName.addActionListener(this);
		jPassword.setBounds(130,60,100,20);
		jp.add(jPassword);
		jPassword.setEchoChar('$');//����������еĻ����ַ�
jPassword.addActionListener(this);
		jl[2].setBounds(10,180,270,20);
		jp.add(jl[2]);
		this.add(jp);
		
		this.setTitle("��¼����");
		this.setBounds(200,200,270,250);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jName){//����¼�ԴΪ�ı���
			jPassword.requestFocus();//�л����뽹�㵽�����
		}else if(e.getSource()==jb[1]){//����¼�ԴΪ���ð�ť
			//��������ı���������show��ǩ�е�������Ϣ
			jl[2].setText("");
			jName.setText("");
			jPassword.setText("");
			jName.requestFocus();//�����뽹��ص��ı���
		}else{//����¼�ԴΪ��¼��ť�����жϵ�¼���������Ƿ���ȷ
			//�ж��û����������Ƿ�ƥ��
			if(jName.getText().equals("sa")&&String.valueOf(jPassword.getPassword()).equals("liuyaodong123456789")){
				jl[2].setText("��¼�ɹ�����ӭ���ĵ�����");
			}else{
				jl[2].setText("�Բ��������û������������");
			}
		}
	}
	
	public static void main(String[] args) {
		new LoginTest();
	}
}
