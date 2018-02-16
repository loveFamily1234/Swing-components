package com.��ʮ��_�����б��;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//����������ItemTest��
public class ItemTest{//�������塢�����б�򡢱�ǩ�������б������ģ������
	private JFrame jf;
	private JComboBox box1,box2;
	private JLabel label1;
	private JLabel label2;
	private Object[] obj1;//ʡ��
	private Object[][] obj2;//����
	
	public ItemTest(Object[] obj1,Object[][] obj2){//���췽������������ģ������
		//�������塢�����б�򡢱�ǩ������Ӧ�������ӵ�������
		this.obj1=obj1;
		this.obj2=obj2;
		jf=new JFrame("�����б�����");
		box1=new JComboBox(obj1);
		box2=new JComboBox(obj2[0]);
		label1=new JLabel("ʡ�ݣ�");
		label2=new JLabel("���У�");
		jf.setLayout(new FlowLayout());
		jf.add(label1);
		jf.add(box1);
		jf.add(label2);
		jf.add(box2);
		addEventHandler();//����addEventHandler����
	}
	//addEventHandler������Ϊ�����б��ע���ע��������
	public void addEventHandler(){
		box1.addItemListener(new ItemListener(){//ע��ItemListener����������д����
			public void itemStateChanged(ItemEvent arg0){//��д����
				int index=box1.getSelectedIndex();//��ȡbox1ѡ��ѡ�������
				box2.removeAllItems();//�Ƴ�box2������ѡ��
				for(int i=0;i<obj2[index].length;i++){//��box2���ѡ��
					box2.addItem(obj2[index][i]);
				}
			}
		});
	}
	public void showMe(){//showMe���������ô��������
		jf.setSize(400,300);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		Object[] obj1=new Object[]{
				"==��ѡ��==","�㶫","ɽ��","�ӱ�","����","����","����"
		};
		Object[][] obj2=new Object[][]{
			{"==��ѡ��=="},
			{"����","����","��ͷ","��ɽ","��ɽ"},
			{"����","̩��","�ൺ","��̨","����","Ϋ��"},
			{"ʯ��ׯ","����","�ȷ�","����","�ػʵ�"},
			{"֣��","����","����","����","����","���"},
			{"�Ͼ�","����","����","����","����"},
			{"����","����","����","����","����","����"}
		};
		new ItemTest(obj1,obj2).showMe();
	}
}
