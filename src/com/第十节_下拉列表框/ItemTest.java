package com.第十节_下拉列表框;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//创建公开的ItemTest类
public class ItemTest{//声明窗体、下拉列表框、标签、下拉列表框数据模型数组
	private JFrame jf;
	private JComboBox box1,box2;
	private JLabel label1;
	private JLabel label2;
	private Object[] obj1;//省份
	private Object[][] obj2;//城市
	
	public ItemTest(Object[] obj1,Object[][] obj2){//构造方法，传入数据模型数组
		//创建窗体、下拉列表框、标签，将相应的组件添加到容器中
		this.obj1=obj1;
		this.obj2=obj2;
		jf=new JFrame("下拉列表框测试");
		box1=new JComboBox(obj1);
		box2=new JComboBox(obj2[0]);
		label1=new JLabel("省份：");
		label2=new JLabel("城市：");
		jf.setLayout(new FlowLayout());
		jf.add(label1);
		jf.add(box1);
		jf.add(label2);
		jf.add(box2);
		addEventHandler();//调用addEventHandler方法
	}
	//addEventHandler方法，为下拉列表框注册和注销监听器
	public void addEventHandler(){
		box1.addItemListener(new ItemListener(){//注册ItemListener监听器，重写方法
			public void itemStateChanged(ItemEvent arg0){//重写方法
				int index=box1.getSelectedIndex();//获取box1选中选项的索引
				box2.removeAllItems();//移除box2的所有选项
				for(int i=0;i<obj2[index].length;i++){//给box2添加选项
					box2.addItem(obj2[index][i]);
				}
			}
		});
	}
	public void showMe(){//showMe方法，设置窗体的属性
		jf.setSize(400,300);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		Object[] obj1=new Object[]{
				"==请选择==","广东","山东","河北","河南","江苏","辽宁"
		};
		Object[][] obj2=new Object[][]{
			{"==请选择=="},
			{"广州","深圳","汕头","佛山","中山"},
			{"济南","泰安","青岛","烟台","威海","潍坊"},
			{"石家庄","保定","廊坊","邯郸","秦皇岛"},
			{"郑州","安阳","洛阳","南阳","开封","许昌"},
			{"南京","苏州","徐州","扬州","无锡"},
			{"沈阳","丹东","大连","锦州","铁岭","辽阳"}
		};
		new ItemTest(obj1,obj2).showMe();
	}
}
