package com.��ʮһ��_΢��������JSpinner��;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
public class SpinnerTest extends JFrame implements ChangeListener{
	//����JPanel��������ǩ�����顢ArrayList����3��΢��ģ�ͺ�΢��������������
	private JPanel panel=new JPanel();
	private JLabel[] labelArray=new JLabel[]{
			new JLabel("ѡ���꣺"),new JLabel("ѡ���£�"),new JLabel("ѡ���գ�")
	};
	JLabel resultLabel=new JLabel("��ѡ����Ԥ����Ʊ�����ڣ�");
	private ArrayList arrayList=new ArrayList();
	private SpinnerNumberModel snm1=new SpinnerNumberModel(2008,2008,2020,1);
	private SpinnerListModel slm=new SpinnerListModel();
	private SpinnerNumberModel snm2=new SpinnerNumberModel(9,1,31,1);
	private JSpinner[] spinnerArray={new JSpinner(snm1),new JSpinner(slm),new JSpinner(snm2)};//����΢���������
	public SpinnerTest(){
		panel.setLayout(null);
		for(int i=1;i<=12;i++){//��ʼ��arrayList�����Ԫ��
			arrayList.add(i+"��");
		}
		slm.setList(arrayList);//����arrayListΪSpinnerListModel��ģ��
		slm.setValue("9��");//���õ�ǰֵ
		//���ñ�ǩ��΢�������λ�á���С��Ϊ΢�����ע���¼�������
		for(int i=0;i<spinnerArray.length;i++){
			labelArray[i].setBounds(20+i*120,30,80,30);
			panel.add(labelArray[i]);
			spinnerArray[i].setBounds(70+i*130,30,60,26);
			panel.add(spinnerArray[i]);
			spinnerArray[i].addChangeListener(this);//΢���ؼ�ע���¼�������
		}
		this.add(panel);
		this.add(resultLabel,BorderLayout.SOUTH);//���resultLabel��������
		//���ô��������
		this.setTitle("ѡ���Ʊ����ʵ��");
		this.setBounds(200,200,450,130);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void stateChanged(ChangeEvent e){
		//�ֱ��ȡѡ��������յ�ֵ��Ȼ���ڱ�ǩ����ʾ�û�ѡ���ʱ��
		int year=((Integer)(spinnerArray[0].getValue())).intValue();
		String month=(String)spinnerArray[1].getValue();//��ȡѡ�����
		int day=((Integer)(spinnerArray[2].getValue())).intValue();//��ȡѡ�����
		//���½����ʾ��ǩ������
		resultLabel.setText("��Ԥ���Ļ�Ʊ�������ǣ�"+year+"��"+month+day+"��");
	}
	
	public static void main(String[] args) {
		new SpinnerTest();
	}
}
