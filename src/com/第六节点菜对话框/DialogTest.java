package com.�����ڵ�˶Ի���;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class DialogTest extends JFrame implements ActionListener{
	JPanel jp=new JPanel();
	JButton jb1=new JButton("ֻ��OK��ť");
	JButton jb2=new JButton("Yes/No��ť");
	JButton jb3=new JButton("Yes/No��ť���Զ��壩");
	JButton jb4=new JButton("Yes/No/Cancel3����ť");
	JButton jb5=new JButton("������Ϣ�Ի���");
	JButton jb6=new JButton("ѡ��Ի���");
	JButton[] buttonArray={jb1,jb2,jb3,jb4,jb5,jb6};
	JLabel jl=new JLabel("�����ε�����ť�����õ���ͬ�ĶԻ���");
	public DialogTest(){
		jp.setLayout(new GridLayout(2,3));//����JPanel��������Ϊ���񲼾�
		for(int i=0;i<buttonArray.length;i++){
			jp.add(buttonArray[i]);
			buttonArray[i].addActionListener(this);
		}
		this.add(jp);
		this.add(jl,BorderLayout.SOUTH);
		
		this.setTitle("JOptionPane�Ի���");
		this.setBounds(200,200,500,180);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==buttonArray[0]){//���¡�ֻ��OK��ť������Ϣ�Ի���
			JOptionPane.showMessageDialog(this,"��ӭ���ٱ���","ֻ��OK��ť����Ϣ�Ի���",JOptionPane.INFORMATION_MESSAGE);
			jl.setText("��ӭ��ӭ�����һ�ӭ��");//���±�ǩ������
		}else if(e.getSource()==buttonArray[1]){//�����С�Yes/No��ť����ȷ�϶Ի���ť
			int index=JOptionPane.showConfirmDialog(this, "���ã����ǵ�һ����������","��Yes/No��ť��ȷ�϶Ի���",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			jl.setText("����"+((index==0)?"�¹˿ͣ���ӭ��":"�Ϲ˿��ˣ���ӭ��"));
		}else if(e.getSource()==buttonArray[2]){//�����С�Yes/No��ť���Զ��壩����ȷ�϶Ի���ť
			Object[] options={"ϲ��","��ϲ��"};//����ȷ�϶Ի���
			int index=JOptionPane.showOptionDialog(this,"���ã���ϲ�����������", "��Yes/No��ť���Զ��壩��ȷ�϶Ի���", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			jl.setText("�Ҽ����ˣ���"+((index==0)?"ϲ��":"��ϲ��")+"������㣡");
		}else if(e.getSource()==buttonArray[3]){//���¡�Yes/No/Cancel3����ť����ȷ�϶Ի���ť
			Object[] options={"�ð���������һ��","���ˣ����ǲ˹�����","������������Ϻ"};
			int index=JOptionPane.showOptionDialog(this, "��ã������������Ʋ��������", "��Yes/No/Cancel��ť��ȷ�϶Ի���", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
			String reply=(index==0)?"�Եȣ�����������ܿ�͵�":(index==1)?"�õģ�����Ҫ�ٺ���":(index==2)?"�õģ����������Ϻ�ܿ�͵���":"�Բ���������ˣ�";
			jl.setText(reply);
		}else if(e.getSource()==buttonArray[4]){//���¡�������Ϣ�Ի��򡱰�ť
			String dishes=JOptionPane.showInputDialog(this,"������������ԵĲˣ�","������Ϣ�Ի���",JOptionPane.PLAIN_MESSAGE);
			jl.setText("�Ҽ����ˣ�������ԵĲ��ǣ�"+dishes+"��");
		}else if(e.getSource()==buttonArray[5]){//���¡�ѡ��Ի��򡱰�ť
			String[] options=new String[]{"����Ϻ","�����","����ţ������","�߹���"};
			int index=JOptionPane.showOptionDialog(this,"�����Ǳ���������͵Ĳˣ�����ѡһ����Ĭ�����߹���","ѡ��Ի���",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[3]);
			String dishes=(index==0)?"����Ϻ":(index==1)?"�����":(index==2)?"����ţ������":"�߹���";
			jl.setText("��ѡ���˱������͵�"+dishes+"��");
		}
	}
	
	
	public static void main(String[] args) {
		new DialogTest();
	}
}
	
