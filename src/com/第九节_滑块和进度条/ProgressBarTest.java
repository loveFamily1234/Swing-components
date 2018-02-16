package com.第九节_滑块和进度条;

import javax.swing.*;
import javax.swing.event.*;
//定义ProgressBarTest类，继承自JFrame，实现了ChangeListener接口
public class ProgressBarTest extends JFrame implements ChangeListener{
	//创建容器、进度条和滑块
	private JPanel panel=new JPanel();
	private JProgressBar progressBar=new JProgressBar(0,100);//指定最小值、最大值
	private JSlider slider=new JSlider(0,100);//指定最小值、最大值
	JLabel label1=new JLabel("进度条：");//创建标签对象
	JLabel label2=new JLabel("拖动滑块可以控制进度条");//创建标签对象
	public ProgressBarTest(){//将标签、进度条、滑块添加到容器中，设置属性
		panel.setLayout(null);
		label1.setBounds(10,10,200,30);
		label2.setBounds(10,70,200,30);
		panel.add(label1);
		panel.add(label2);
		//设置进度条和滑块的位置和大小，将两组件添加到容器中
		progressBar.setBounds(20,40,300,20);
		slider.setBounds(10,110,320,50);
		panel.add(progressBar);
		panel.add(slider);
		progressBar.setValue(50);//设置进度条的初始值
		progressBar.setStringPainted(true);//设置进度条将显示信息字符串
		slider.setPaintTicks(true);//设置滑块绘制刻度标记
		slider.setPaintLabels(true);//设置主刻度标签的状态
		slider.setMajorTickSpacing(10);//设置主刻度标记的间隔
		slider.setMinorTickSpacing(2);//设置副刻度标记的间隔
		slider.addChangeListener(this);//为滑块注册ChangeEvent事件监听器
		this.add(panel);
		//设置窗体的标题、位置、大小、可见性和关闭动作
		this.setTitle("滑块控制进度条");
		this.setResizable(false);
		this.setBounds(200,200,350,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void stateChanged(ChangeEvent e){//当滑块滑动时，滑块值和进度条的值相同
		progressBar.setValue(slider.getValue());
	}
	public static void main(String[] args) {
		new ProgressBarTest();
	}
}
