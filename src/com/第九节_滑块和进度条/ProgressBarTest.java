package com.�ھŽ�_����ͽ�����;

import javax.swing.*;
import javax.swing.event.*;
//����ProgressBarTest�࣬�̳���JFrame��ʵ����ChangeListener�ӿ�
public class ProgressBarTest extends JFrame implements ChangeListener{
	//�����������������ͻ���
	private JPanel panel=new JPanel();
	private JProgressBar progressBar=new JProgressBar(0,100);//ָ����Сֵ�����ֵ
	private JSlider slider=new JSlider(0,100);//ָ����Сֵ�����ֵ
	JLabel label1=new JLabel("��������");//������ǩ����
	JLabel label2=new JLabel("�϶�������Կ��ƽ�����");//������ǩ����
	public ProgressBarTest(){//����ǩ����������������ӵ������У���������
		panel.setLayout(null);
		label1.setBounds(10,10,200,30);
		label2.setBounds(10,70,200,30);
		panel.add(label1);
		panel.add(label2);
		//���ý������ͻ����λ�úʹ�С�����������ӵ�������
		progressBar.setBounds(20,40,300,20);
		slider.setBounds(10,110,320,50);
		panel.add(progressBar);
		panel.add(slider);
		progressBar.setValue(50);//���ý������ĳ�ʼֵ
		progressBar.setStringPainted(true);//���ý���������ʾ��Ϣ�ַ���
		slider.setPaintTicks(true);//���û�����ƿ̶ȱ��
		slider.setPaintLabels(true);//�������̶ȱ�ǩ��״̬
		slider.setMajorTickSpacing(10);//�������̶ȱ�ǵļ��
		slider.setMinorTickSpacing(2);//���ø��̶ȱ�ǵļ��
		slider.addChangeListener(this);//Ϊ����ע��ChangeEvent�¼�������
		this.add(panel);
		//���ô���ı��⡢λ�á���С���ɼ��Ժ͹رն���
		this.setTitle("������ƽ�����");
		this.setResizable(false);
		this.setBounds(200,200,350,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void stateChanged(ChangeEvent e){//�����黬��ʱ������ֵ�ͽ�������ֵ��ͬ
		progressBar.setValue(slider.getValue());
	}
	public static void main(String[] args) {
		new ProgressBarTest();
	}
}
