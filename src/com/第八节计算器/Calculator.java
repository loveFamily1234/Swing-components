package com.第八节计算器;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.BigDecimal;
import java.nio.charset.MalformedInputException;
public class Calculator implements ActionListener{
	private String[] names={"Backspace","CE","C","+","7","8","9","-","4","5","6","*","1","2","3","/","0","+/-",".","="};
	private JButton[] buttonArray=new JButton[names.length];
	private boolean append=false;//默认追加为false
	private String operator="+";//默认运算符为“+”
	private String s1="0";//默认字符为0
	private String ss="0";//默认字符为0
	//创建可以显示20个字符的文本框
	JTextField jtf=new JTextField(20);
	
	public Calculator(){}
	public Calculator(String title){
		JFrame jf=new JFrame(title);
		JPanel jp=new JPanel();
		jp.setLayout(new GridLayout(5,4));//设置面板为网格布局
		for(int i=0;i<buttonArray.length;i++){
			buttonArray[i]=new JButton(names[i]);
			buttonArray[i].addActionListener(this);
			jp.add(buttonArray[i]);
		}
		jf.add(jtf,BorderLayout.NORTH);
		jf.add(jp);
		jtf.setHorizontalAlignment(JTextField.RIGHT);//设置文本框的水平方向为右
		jtf.setText("0");
		jtf.setEditable(false);//设置文本框为不可编辑状态
		
		jf.pack();//系统自动设置大小和位置
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		String comm=e.getActionCommand();
		if(comm.matches("\\d")){//用正则表达式判断输出的是否是0~9
			/*
			 * 此处代码省略
			 */
		}else if(comm.equals(".")){//输入小数点时
			/*
			 * 此处代码省略
			 */
		}else if("+ - * /".indexOf(comm)!=-1){//输入加减乘除符号时
			//以下运算应该注意数据类型，尤其是大数字和浮点数及int数在运算中的区别
			/*
			 * 此处代码省略
			 */
			append=false;//不继续追加
		}else if(comm.equals("=")){//输入等号时，计算加减乘除的结果
			/*
			 * 此处代码省略
			 */
		}else if(comm.equals("CE")||comm.equals("C")){//输入CE或C时
			jtf.setText("0");
			ss="0";
			append=false;
		}else if(comm.equals("+/-")){//改变数值的正负号
			String temp=jtf.getText();
			if(!append){
				jtf.setText("-");
				append=true;
			}else if(temp.startsWith("-")){//如果字符串以负号开头
				jtf.setText(temp.substring(1));
			}else{
				jtf.setText("-"+temp);
			}
		}else if(comm.equals("Backspace")){//输入Backspace时，退回一个字符
			String temp=jtf.getText();
			if(temp.length()>0){
				jtf.setText(temp.substring(0, temp.length()-1));
			}
		}
	}
		
	   public static void main(String[] args){
		   new Calculator("Calculator");
	   }
}
