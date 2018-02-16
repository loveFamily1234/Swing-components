package com.第一节登录案例_文本框和密码框;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LoginTest extends JFrame implements ActionListener{
	private JPanel jp=new JPanel();
	JLabel name=new JLabel("请输入用户名");
	JLabel password=new JLabel("请输入密码");
	JLabel show=new JLabel("");
	private JLabel[] jl={name,password,show};
	JButton login=new JButton("登录");
	JButton reset=new JButton("重置");
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
		jPassword.setEchoChar('$');//设置密码框中的回显字符
jPassword.addActionListener(this);
		jl[2].setBounds(10,180,270,20);
		jp.add(jl[2]);
		this.add(jp);
		
		this.setTitle("登录窗口");
		this.setBounds(200,200,270,250);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jName){//如果事件源为文本框
			jPassword.requestFocus();//切换输入焦点到密码框
		}else if(e.getSource()==jb[1]){//如果事件源为重置按钮
			//清空姓名文本框、密码框和show标签中的所有信息
			jl[2].setText("");
			jName.setText("");
			jPassword.setText("");
			jName.requestFocus();//让输入焦点回到文本框
		}else{//如果事件源为登录按钮，则判断登录名和密码是否正确
			//判断用户名和密码是否匹配
			if(jName.getText().equals("sa")&&String.valueOf(jPassword.getPassword()).equals("liuyaodong123456789")){
				jl[2].setText("登录成功，欢迎您的到来！");
			}else{
				jl[2].setText("对不起，您的用户名或密码错误！");
			}
		}
	}
	
	public static void main(String[] args) {
		new LoginTest();
	}
}
