package com.���Ľڼ��±��˵�������;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//����MenuTest��̳���JFrame��ʵ����ActionListener�ӿں�ItemListener�ӿ�
public class MenuTest extends JFrame implements ActionListener,ItemListener{
	private JMenu[] menu={new JMenu("�ļ�"),new JMenu("����"),new JMenu("����")};
	//������ͨ�˵���
	JMenuItem open=new JMenuItem("��");
	JMenuItem save=new JMenuItem("����");
	JMenuItem saveas=new JMenuItem("���Ϊ");
	JMenuItem exit=new JMenuItem("�˳�");
	private JMenuItem[] menuItem={open,save,saveas,exit};
	//������ѡ��ť�˵����������
	private JRadioButtonMenuItem[] radioButton=new JRadioButtonMenuItem[]{new JRadioButtonMenuItem("�Զ�����",true),new JRadioButtonMenuItem("������")};
    private ButtonGroup buttonGroup=new ButtonGroup();//������ť�����
    private JCheckBoxMenuItem[] checkBox=new JCheckBoxMenuItem[]{new JCheckBoxMenuItem("����"),new JCheckBoxMenuItem("б��"),new JCheckBoxMenuItem("����")};
    private JMenuBar menuBar=new JMenuBar();//�����˵�������
    private JTextArea textArea=new JTextArea();//�����ı�������
    private JScrollPane scrollPane=new JScrollPane(textArea);//���������ı���
    
    public MenuTest(){
    	menuBar.add(menu[0]);//����ļ��˵����˵�����
    	menuBar.add(menu[1]);//������ò˵����˵�����
    	for(int i=0;i<menuItem.length;i++){
    		menu[0].add(menuItem[i]);//��Ӳ˵���������鵽���ļ����˵���
    		menuItem[i].addActionListener(this);//Ϊ�˵���ע�������
    	}
    	for(int i=0;i<radioButton.length;i++){
    		menu[1].add(radioButton[i]);//���������ѡ��ť�˵�������á��˵���
    		radioButton[i].addItemListener(this);//ע�������
    		buttonGroup.add(radioButton[i]);//����ѡ��ť�˵������
    	}
    	menu[1].addSeparator();//��ӷָ��ߵ������á��˵���
    	menu[1].add(menu[2]);//�������˵������ò˵��У���Ϊ���Ӳ˵�
    	for(int i=0;i<checkBox.length;i++){
    		menu[2].add(checkBox[i]);//���������ѡ�˵�������塱�˵���
    		checkBox[i].addItemListener(this);//ע�������
    	}
    	this.setJMenuBar(menuBar);//��Ӳ˵�����������
    	this.add(scrollPane);//��ӹ����ı�����������
    	
    	this.setTitle("�˵�С����");
    	this.setBounds(200,200,300,200);
    	this.setVisible(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //ʵ����actionPerformed������itemStateChanged����
    //ʹ�÷��䣬��ѡ��һ���˵���ʱ����ӡ�˵����һЩ��Ϣ
    String newline="\n";
    public void actionPerformed(ActionEvent e){
    	JMenuItem source=(JMenuItem)(e.getSource());
    	String s="����¼���"+newline+"�¼�Դ��"+source.getText()+"��ѡ�����"+getClassName(source)+"��";
    	textArea.append(s+newline);
    }
    
    public void itemStateChanged(ItemEvent e){
    	JMenuItem source=(JMenuItem)(e.getSource());
    	String s="�˵������"+newline+"�¼�Դ��"+source.getText()+"��ѡ�����"+getClassName(source)+"��"+newline+"�µ�״̬��"+((e.getStateChange()==ItemEvent.SELECTED)?"ѡ��":"��ѡ��");
    	textArea.append(s+newline);
    }
    
    protected String getClassName(Object o){
    	String classString=o.getClass().getName();
    	int dotIndex=classString.lastIndexOf(".");
    	return classString.substring(dotIndex+1);
    }
    
    public static void main(String[] args) {
		new MenuTest();
	}
}	
