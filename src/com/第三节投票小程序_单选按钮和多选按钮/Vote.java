package com.������ͶƱС����_��ѡ��ť�Ͷ�ѡ��ť;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Vote extends JFrame implements ActionListener{
	private JPanel jp=new JPanel();
	//������ѡ��ť
	JRadioButton jrb1=new JRadioButton("�����վ�ܺã�����ӱ",true);
	JRadioButton jrb2=new JRadioButton("�����վ����ͨ��̫һ��");
	JRadioButton jrb3=new JRadioButton("�����վ�ܲż������");
	JRadioButton jrb4=new JRadioButton("�����վ̫���ˣ�������");
	private JRadioButton[] jrb={jrb1,jrb2,jrb3,jrb4};
	private ButtonGroup bg=new ButtonGroup();//������ť���
	
	//������ѡ��
	JCheckBox jcb1=new JCheckBox("����Ƚ�Ư��");
	JCheckBox jcb2=new JCheckBox("���ݱȽϷḻ");
	JCheckBox jcb3=new JCheckBox("��ֵ����ȽϺ�");
	JCheckBox jcb4=new JCheckBox("��Ա����ȽϺ�");
	private JCheckBox[] jcb={jcb1,jcb2,jcb3,jcb4};//������ѡ������
	
	//������ť����
	JButton jb1=new JButton("��ҪͶƱ");
	JButton jb2=new JButton("��Ҫ��ѡ");
	private JButton[] jb={jb1,jb2};
	
	//������ǩ����
	JLabel jl1=new JLabel("�����վ������ӡ���ǣ�");
	JLabel jl2=new JLabel("����Ϊ��վ�������ıȽϺã�");
	JLabel jl3=new JLabel("��ͶƱ�������ǣ�");
	private JLabel[] jl={jl1,jl2,jl3};
	
	private JTextArea jta=new JTextArea();//�����ı���
	private JScrollPane js=new JScrollPane(jta);//�����ɹ������ı���
	
	public Vote(){
		jp.setLayout(null);
		for(int i=0;i<4;i++){//���ø������
			jrb[i].setBounds(30+170*i,40,170,30);//���õ�ѡ��ť��λ�úʹ�С
			jcb[i].setBounds(30+120*i,100,120,30);//���ø�ѡ���λ�úʹ�С
			jp.add(jrb[i]);//��ӵ�ѡ��ť�������
			jp.add(jcb[i]);//��Ӹ�ѡ�������
			jrb[i].addActionListener(this);//Ϊ��ѡ��ťע�ᶯ���¼�������
			jcb[i].addActionListener(this);//Ϊ��ѡ��ע�ᶯ���¼�������
			
			bg.add(jrb[i]);//��ӵ�ѡ��ť����ť�����
			
			if(i>1) continue;
			
			jl[i].setBounds(20,20+50*i,200,30);//���ñ�ǩ��λ�úʹ�С
			jb[i].setBounds(380+120*i,200,100,20);//������ͨ��ť��λ��
			jp.add(jl[i]);
			jp.add(jb[i]);
			jb[i].addActionListener(this);
		}
		jl[2].setBounds(20,150,120,30);//����jl2λ�úʹ�С�����ı����е����ݽ�����ʾ
		jp.add(jl[2]);
		js.setBounds(120,150,500,50);//����JScrollPane��λ�úʹ�С
		jp.add(js);
		jta.setLineWrap(true);//�����ı���Ϊ�Զ�����
		jta.setEditable(false);//�����ı���Ϊ���ɱ༭״̬
		this.add(jp);
		
		this.setTitle("��վ����ȵ���");
		this.setBounds(150,150,750,280);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jb[1]){//��������Ҫ��ѡ����ťʱִ�еĶ���
			bg.clearSelection();
			for(int i=0;i<jcb.length;i++)
				jcb[i].setSelected(false);
			jta.setText("");
		}else{
				StringBuffer temp1=new StringBuffer("����Ϊ");
				StringBuffer temp2=new StringBuffer();
				for(int i=0;i<4;i++){
					if(jrb[i].isSelected()){//��ȡ��ѡ��ťѡ��ֵ
						temp1.append(jrb[i].getText()+"��");
					}
					if(jcb[i].isSelected()){//��ȡ��ѡ��ѡ��ֵ
						temp2.append(jcb[i].getText()+"��");
					}
				}
				if(temp2.length()==0){//���ı��������ѡ��Ľ��
					jta.setText("�뽫������鶼ѡ��");
				}else{
					temp1.append("����Ϊ�����վ");
					temp1.append(temp2.substring(0,temp2.length()-1));
					jta.setText(temp1.append("��").toString());
				}
			}
		}
		public static void main(String[] args){
			new Vote();
		}
}
