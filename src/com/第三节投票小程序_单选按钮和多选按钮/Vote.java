package com.第三节投票小程序_单选按钮和多选按钮;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Vote extends JFrame implements ActionListener{
	private JPanel jp=new JPanel();
	//创建单选按钮
	JRadioButton jrb1=new JRadioButton("这个网站很好，很新颖",true);
	JRadioButton jrb2=new JRadioButton("这个网站很普通，太一般");
	JRadioButton jrb3=new JRadioButton("这个网站很差，偶尔看下");
	JRadioButton jrb4=new JRadioButton("这个网站太差了，不来了");
	private JRadioButton[] jrb={jrb1,jrb2,jrb3,jrb4};
	private ButtonGroup bg=new ButtonGroup();//创建按钮组合
	
	//创建复选框
	JCheckBox jcb1=new JCheckBox("界面比较漂亮");
	JCheckBox jcb2=new JCheckBox("内容比较丰富");
	JCheckBox jcb3=new JCheckBox("增值服务比较好");
	JCheckBox jcb4=new JCheckBox("会员服务比较好");
	private JCheckBox[] jcb={jcb1,jcb2,jcb3,jcb4};//创建复选框数组
	
	//创建按钮数组
	JButton jb1=new JButton("我要投票");
	JButton jb2=new JButton("我要重选");
	private JButton[] jb={jb1,jb2};
	
	//创建标签数组
	JLabel jl1=new JLabel("这个网站给您的印象是：");
	JLabel jl2=new JLabel("您认为本站哪里做的比较好：");
	JLabel jl3=new JLabel("您投票的内容是：");
	private JLabel[] jl={jl1,jl2,jl3};
	
	private JTextArea jta=new JTextArea();//创建文本区
	private JScrollPane js=new JScrollPane(jta);//创建可滚动的文本区
	
	public Vote(){
		jp.setLayout(null);
		for(int i=0;i<4;i++){//设置各个组件
			jrb[i].setBounds(30+170*i,40,170,30);//设置单选按钮的位置和大小
			jcb[i].setBounds(30+120*i,100,120,30);//设置复选框的位置和大小
			jp.add(jrb[i]);//添加单选按钮到面板中
			jp.add(jcb[i]);//添加复选框到面板中
			jrb[i].addActionListener(this);//为单选按钮注册动作事件监听器
			jcb[i].addActionListener(this);//为复选框注册动作事件监听器
			
			bg.add(jrb[i]);//添加单选按钮到按钮组合中
			
			if(i>1) continue;
			
			jl[i].setBounds(20,20+50*i,200,30);//设置标签的位置和大小
			jb[i].setBounds(380+120*i,200,100,20);//设置普通按钮的位置
			jp.add(jl[i]);
			jp.add(jb[i]);
			jb[i].addActionListener(this);
		}
		jl[2].setBounds(20,150,120,30);//设置jl2位置和大小，对文本区中的内容进行提示
		jp.add(jl[2]);
		js.setBounds(120,150,500,50);//设置JScrollPane的位置和大小
		jp.add(js);
		jta.setLineWrap(true);//设置文本区为自动换行
		jta.setEditable(false);//设置文本区为不可编辑状态
		this.add(jp);
		
		this.setTitle("网站满意度调查");
		this.setBounds(150,150,750,280);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jb[1]){//单击“我要重选”按钮时执行的动作
			bg.clearSelection();
			for(int i=0;i<jcb.length;i++)
				jcb[i].setSelected(false);
			jta.setText("");
		}else{
				StringBuffer temp1=new StringBuffer("您认为");
				StringBuffer temp2=new StringBuffer();
				for(int i=0;i<4;i++){
					if(jrb[i].isSelected()){//获取单选按钮选中值
						temp1.append(jrb[i].getText()+"。");
					}
					if(jcb[i].isSelected()){//获取复选框选中值
						temp2.append(jcb[i].getText()+"，");
					}
				}
				if(temp2.length()==0){//在文本区中输出选择的结果
					jta.setText("请将两项调查都选择");
				}else{
					temp1.append("您认为这个网站");
					temp1.append(temp2.substring(0,temp2.length()-1));
					jta.setText(temp1.append("。").toString());
				}
			}
		}
		public static void main(String[] args){
			new Vote();
		}
}
