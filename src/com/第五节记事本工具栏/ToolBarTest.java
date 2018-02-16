package com.第五节记事本工具栏;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class ToolBarTest extends JFrame implements ActionListener{
	//创建3个工具按钮，并组成buttonArray数组
	JButton leftButton=new JButton("左对齐",new ImageIcon("G:/图片/对齐方式/左对齐.jpg"));
	JButton middleButton=new JButton("居中",new ImageIcon("G:/图片/对齐方式/居中对齐.jpg"));
	JButton rightButton=new JButton("右对齐",new ImageIcon("G:/图片/对齐方式/右对齐.jpg"));
	private JButton[] buttonArray={leftButton,middleButton,rightButton};
	//创建工具栏对象toolBar，标题为“简易工具栏”，成为浮动工具栏时显示标题
	private JToolBar toolBar=new JToolBar("简易工具栏");
	//创建标签，并设置标签初始显示
	private JLabel label=new JLabel("请单击工具栏，选择对齐方式！");
	
	public ToolBarTest(){
		//添加按钮到工具栏中，设置按钮提示信息并注册动作监听器
		for(int i=0;i<buttonArray.length;i++){
			toolBar.add(buttonArray[i]);//添加按钮到工具栏中
			//为按钮设置工具提示信息，当将鼠标放在其上时显示提示信息
			buttonArray[i].setToolTipText(buttonArray[i].getText());
			buttonArray[i].addActionListener(this);
		}
		toolBar.setFloatable(true);//设置工具栏，true为可以成为浮动工具栏
		this.add(toolBar,BorderLayout.NORTH);//添加工具栏到窗体顶部
		this.add(label);
		
		this.setTitle("工具栏测试窗口");
		this.setBounds(200,200,500,250);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==buttonArray[0]){
			label.setHorizontalAlignment(JLabel.LEFT);
			label.setText("您选择的对齐方式为："+buttonArray[0].getText()+"！！！");
		}else if(e.getSource()==buttonArray[1]){
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setText("您选择的对齐方式为："+buttonArray[1].getText()+"！！！");
		}else if(e.getSource()==buttonArray[2]){
			label.setHorizontalAlignment(JLabel.RIGHT);
			label.setText("您选择的对齐方式为："+buttonArray[2].getText()+"！！！");
		}
	}
	public static void main(String[] args) {
		new ToolBarTest();
	}
}
