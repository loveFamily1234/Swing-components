package com.第四节记事本菜单栏测试;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//定义MenuTest类继承自JFrame，实现了ActionListener接口和ItemListener接口
public class MenuTest extends JFrame implements ActionListener,ItemListener{
	private JMenu[] menu={new JMenu("文件"),new JMenu("设置"),new JMenu("字体")};
	//创建普通菜单项
	JMenuItem open=new JMenuItem("打开");
	JMenuItem save=new JMenuItem("保存");
	JMenuItem saveas=new JMenuItem("另存为");
	JMenuItem exit=new JMenuItem("退出");
	private JMenuItem[] menuItem={open,save,saveas,exit};
	//创建单选按钮菜单项对象数组
	private JRadioButtonMenuItem[] radioButton=new JRadioButtonMenuItem[]{new JRadioButtonMenuItem("自动换行",true),new JRadioButtonMenuItem("不换行")};
    private ButtonGroup buttonGroup=new ButtonGroup();//创建按钮组对象
    private JCheckBoxMenuItem[] checkBox=new JCheckBoxMenuItem[]{new JCheckBoxMenuItem("粗体"),new JCheckBoxMenuItem("斜体"),new JCheckBoxMenuItem("宋体")};
    private JMenuBar menuBar=new JMenuBar();//创建菜单栏对象
    private JTextArea textArea=new JTextArea();//创建文本区对象
    private JScrollPane scrollPane=new JScrollPane(textArea);//创建滚动文本区
    
    public MenuTest(){
    	menuBar.add(menu[0]);//添加文件菜单到菜单栏中
    	menuBar.add(menu[1]);//添加设置菜单到菜单栏中
    	for(int i=0;i<menuItem.length;i++){
    		menu[0].add(menuItem[i]);//添加菜单项对象数组到”文件“菜单中
    		menuItem[i].addActionListener(this);//为菜单项注册监听器
    	}
    	for(int i=0;i<radioButton.length;i++){
    		menu[1].add(radioButton[i]);//添加两个单选按钮菜单项到“设置”菜单中
    		radioButton[i].addItemListener(this);//注册监听器
    		buttonGroup.add(radioButton[i]);//将单选按钮菜单项编组
    	}
    	menu[1].addSeparator();//添加分隔线到“设置”菜单中
    	menu[1].add(menu[2]);//添加字体菜单到设置菜单中，作为其子菜单
    	for(int i=0;i<checkBox.length;i++){
    		menu[2].add(checkBox[i]);//添加两个复选菜单项到“字体”菜单中
    		checkBox[i].addItemListener(this);//注册监听器
    	}
    	this.setJMenuBar(menuBar);//添加菜单栏到窗体中
    	this.add(scrollPane);//添加滚动文本区到窗体中
    	
    	this.setTitle("菜单小测试");
    	this.setBounds(200,200,300,200);
    	this.setVisible(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //实现了actionPerformed方法和itemStateChanged方法
    //使用反射，当选择一个菜单项时，打印菜单项的一些信息
    String newline="\n";
    public void actionPerformed(ActionEvent e){
    	JMenuItem source=(JMenuItem)(e.getSource());
    	String s="监测事件。"+newline+"事件源："+source.getText()+"（选择对象"+getClassName(source)+"）";
    	textArea.append(s+newline);
    }
    
    public void itemStateChanged(ItemEvent e){
    	JMenuItem source=(JMenuItem)(e.getSource());
    	String s="菜单项监听"+newline+"事件源："+source.getText()+"（选择对象"+getClassName(source)+"）"+newline+"新的状态："+((e.getStateChange()==ItemEvent.SELECTED)?"选择":"不选择");
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
