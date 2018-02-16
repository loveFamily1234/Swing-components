package com.�ڰ˽ڼ�����;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.BigDecimal;
import java.nio.charset.MalformedInputException;
public class Calculator implements ActionListener{
	private String[] names={"Backspace","CE","C","+","7","8","9","-","4","5","6","*","1","2","3","/","0","+/-",".","="};
	private JButton[] buttonArray=new JButton[names.length];
	private boolean append=false;//Ĭ��׷��Ϊfalse
	private String operator="+";//Ĭ�������Ϊ��+��
	private String s1="0";//Ĭ���ַ�Ϊ0
	private String ss="0";//Ĭ���ַ�Ϊ0
	//����������ʾ20���ַ����ı���
	JTextField jtf=new JTextField(20);
	
	public Calculator(){}
	public Calculator(String title){
		JFrame jf=new JFrame(title);
		JPanel jp=new JPanel();
		jp.setLayout(new GridLayout(5,4));//�������Ϊ���񲼾�
		for(int i=0;i<buttonArray.length;i++){
			buttonArray[i]=new JButton(names[i]);
			buttonArray[i].addActionListener(this);
			jp.add(buttonArray[i]);
		}
		jf.add(jtf,BorderLayout.NORTH);
		jf.add(jp);
		jtf.setHorizontalAlignment(JTextField.RIGHT);//�����ı����ˮƽ����Ϊ��
		jtf.setText("0");
		jtf.setEditable(false);//�����ı���Ϊ���ɱ༭״̬
		
		jf.pack();//ϵͳ�Զ����ô�С��λ��
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		String comm=e.getActionCommand();
		if(comm.matches("\\d")){//��������ʽ�ж�������Ƿ���0~9
			/*
			 * �˴�����ʡ��
			 */
		}else if(comm.equals(".")){//����С����ʱ
			/*
			 * �˴�����ʡ��
			 */
		}else if("+ - * /".indexOf(comm)!=-1){//����Ӽ��˳�����ʱ
			//��������Ӧ��ע���������ͣ������Ǵ����ֺ͸�������int���������е�����
			/*
			 * �˴�����ʡ��
			 */
			append=false;//������׷��
		}else if(comm.equals("=")){//����Ⱥ�ʱ������Ӽ��˳��Ľ��
			/*
			 * �˴�����ʡ��
			 */
		}else if(comm.equals("CE")||comm.equals("C")){//����CE��Cʱ
			jtf.setText("0");
			ss="0";
			append=false;
		}else if(comm.equals("+/-")){//�ı���ֵ��������
			String temp=jtf.getText();
			if(!append){
				jtf.setText("-");
				append=true;
			}else if(temp.startsWith("-")){//����ַ����Ը��ſ�ͷ
				jtf.setText(temp.substring(1));
			}else{
				jtf.setText("-"+temp);
			}
		}else if(comm.equals("Backspace")){//����Backspaceʱ���˻�һ���ַ�
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
