package com.���߽��ļ�����ɫѡ����;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
public class ColorChooserTest extends JFrame implements ActionListener{
	JPanel panel=new JPanel();
	JButton color=new JButton("���������ñ�ǩ��ɫ");
	JButton open=new JButton("�����ҿ��Դ��ļ�");
	JButton[] buttonArray={color,open};
	JLabel label=new JLabel("��������������ť������������ı���ɫ����ļ���");
	JFileChooser fileChooser=new JFileChooser("D:\\");//�����ļ�ѡ����
	
	public ColorChooserTest(){
		for(int i=0;i<buttonArray.length;i++){
			panel.add(buttonArray[i]);
			buttonArray[i].addActionListener(this);
		}
		this.add(label,BorderLayout.SOUTH);
		this.add(panel);
		//���ļ�ѡ�������г�ʼ����ɾ��ԭ�е��ļ�ѡ����
		fileChooser.removeChoosableFileFilter(fileChooser.getChoosableFileFilters()[0]);
		//��ӿ��Խ���jpgͼƬ�ļ���ѡ����
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JPEGͼƬ�ļ�","jpg","jpeg"));
		//��ӿ��Խ���gifͼƬ�ļ���ѡ����
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("GIFͼƬ�ļ�","gif","GIF"));
		
		this.setTitle("�ļ�����ɫѡ��");
		this.setBounds(200,200,400,150);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==buttonArray[0]){//ѡ��������ɫ�˵���
			Color c=JColorChooser.showDialog(this, "ѡ����Ҫ����ɫ", Color.cyan);
			label.setText("���ֵ���ɫ��Ϊ��ѡ�����ɫ");
			label.setForeground(c);
		}else if(e.getSource()==buttonArray[1]){//ѡ�д��ļ��˵���
			fileChooser.showOpenDialog(this);
			label.setText("��ѡ������ļ�ѡ����");
		}
	}
	
	public static void main(String[] args) {
		new ColorChooserTest();
	}
}
