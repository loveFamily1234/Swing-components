package com.第十一节_微调控制器JSpinner类;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
public class SpinnerTest extends JFrame implements ChangeListener{
	//创建JPanel容器、标签及数组、ArrayList对象、3个微调模型和微调控制器及数组
	private JPanel panel=new JPanel();
	private JLabel[] labelArray=new JLabel[]{
			new JLabel("选择年："),new JLabel("选择月："),new JLabel("选择日：")
	};
	JLabel resultLabel=new JLabel("请选择您预订机票的日期！");
	private ArrayList arrayList=new ArrayList();
	private SpinnerNumberModel snm1=new SpinnerNumberModel(2008,2008,2020,1);
	private SpinnerListModel slm=new SpinnerListModel();
	private SpinnerNumberModel snm2=new SpinnerNumberModel(9,1,31,1);
	private JSpinner[] spinnerArray={new JSpinner(snm1),new JSpinner(slm),new JSpinner(snm2)};//创建微调组件数组
	public SpinnerTest(){
		panel.setLayout(null);
		for(int i=1;i<=12;i++){//初始化arrayList，添加元素
			arrayList.add(i+"月");
		}
		slm.setList(arrayList);//设置arrayList为SpinnerListModel的模型
		slm.setValue("9月");//设置当前值
		//设置标签和微调组件的位置、大小并为微调组件注册事件监听器
		for(int i=0;i<spinnerArray.length;i++){
			labelArray[i].setBounds(20+i*120,30,80,30);
			panel.add(labelArray[i]);
			spinnerArray[i].setBounds(70+i*130,30,60,26);
			panel.add(spinnerArray[i]);
			spinnerArray[i].addChangeListener(this);//微调控件注册事件监听器
		}
		this.add(panel);
		this.add(resultLabel,BorderLayout.SOUTH);//添加resultLabel到窗体中
		//设置窗体的属性
		this.setTitle("选择机票日期实例");
		this.setBounds(200,200,450,130);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void stateChanged(ChangeEvent e){
		//分别获取选择的年月日的值，然后在标签中显示用户选择的时间
		int year=((Integer)(spinnerArray[0].getValue())).intValue();
		String month=(String)spinnerArray[1].getValue();//获取选择的月
		int day=((Integer)(spinnerArray[2].getValue())).intValue();//获取选择的日
		//更新结果显示标签的内容
		resultLabel.setText("您预订的机票的日期是："+year+"年"+month+day+"日");
	}
	
	public static void main(String[] args) {
		new SpinnerTest();
	}
}
