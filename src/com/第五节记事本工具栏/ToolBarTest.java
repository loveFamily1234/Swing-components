package com.����ڼ��±�������;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class ToolBarTest extends JFrame implements ActionListener{
	//����3�����߰�ť�������buttonArray����
	JButton leftButton=new JButton("�����",new ImageIcon("G:/ͼƬ/���뷽ʽ/�����.jpg"));
	JButton middleButton=new JButton("����",new ImageIcon("G:/ͼƬ/���뷽ʽ/���ж���.jpg"));
	JButton rightButton=new JButton("�Ҷ���",new ImageIcon("G:/ͼƬ/���뷽ʽ/�Ҷ���.jpg"));
	private JButton[] buttonArray={leftButton,middleButton,rightButton};
	//��������������toolBar������Ϊ�����׹�����������Ϊ����������ʱ��ʾ����
	private JToolBar toolBar=new JToolBar("���׹�����");
	//������ǩ�������ñ�ǩ��ʼ��ʾ
	private JLabel label=new JLabel("�뵥����������ѡ����뷽ʽ��");
	
	public ToolBarTest(){
		//��Ӱ�ť���������У����ð�ť��ʾ��Ϣ��ע�ᶯ��������
		for(int i=0;i<buttonArray.length;i++){
			toolBar.add(buttonArray[i]);//��Ӱ�ť����������
			//Ϊ��ť���ù�����ʾ��Ϣ����������������ʱ��ʾ��ʾ��Ϣ
			buttonArray[i].setToolTipText(buttonArray[i].getText());
			buttonArray[i].addActionListener(this);
		}
		toolBar.setFloatable(true);//���ù�������trueΪ���Գ�Ϊ����������
		this.add(toolBar,BorderLayout.NORTH);//��ӹ����������嶥��
		this.add(label);
		
		this.setTitle("���������Դ���");
		this.setBounds(200,200,500,250);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==buttonArray[0]){
			label.setHorizontalAlignment(JLabel.LEFT);
			label.setText("��ѡ��Ķ��뷽ʽΪ��"+buttonArray[0].getText()+"������");
		}else if(e.getSource()==buttonArray[1]){
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setText("��ѡ��Ķ��뷽ʽΪ��"+buttonArray[1].getText()+"������");
		}else if(e.getSource()==buttonArray[2]){
			label.setHorizontalAlignment(JLabel.RIGHT);
			label.setText("��ѡ��Ķ��뷽ʽΪ��"+buttonArray[2].getText()+"������");
		}
	}
	public static void main(String[] args) {
		new ToolBarTest();
	}
}
