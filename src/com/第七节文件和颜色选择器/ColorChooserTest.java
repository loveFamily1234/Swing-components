package com.第七节文件和颜色选择器;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
public class ColorChooserTest extends JFrame implements ActionListener{
	JPanel panel=new JPanel();
	JButton color=new JButton("单击我设置标签颜色");
	JButton open=new JButton("单击我可以打开文件");
	JButton[] buttonArray={color,open};
	JLabel label=new JLabel("单击上面两个按钮，设置这里的文本颜色或打开文件！");
	JFileChooser fileChooser=new JFileChooser("D:\\");//创建文件选择器
	
	public ColorChooserTest(){
		for(int i=0;i<buttonArray.length;i++){
			panel.add(buttonArray[i]);
			buttonArray[i].addActionListener(this);
		}
		this.add(label,BorderLayout.SOUTH);
		this.add(panel);
		//对文件选择器进行初始化并删除原有的文件选择器
		fileChooser.removeChoosableFileFilter(fileChooser.getChoosableFileFilters()[0]);
		//添加可以接收jpg图片文件的选择器
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JPEG图片文件","jpg","jpeg"));
		//添加可以接收gif图片文件的选择器
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("GIF图片文件","gif","GIF"));
		
		this.setTitle("文件和颜色选择");
		this.setBounds(200,200,400,150);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==buttonArray[0]){//选中设置颜色菜单项
			Color c=JColorChooser.showDialog(this, "选择想要的颜色", Color.cyan);
			label.setText("文字的颜色变为您选择的颜色");
			label.setForeground(c);
		}else if(e.getSource()==buttonArray[1]){//选中打开文件菜单项
			fileChooser.showOpenDialog(this);
			label.setText("您选择打开了文件选择器");
		}
	}
	
	public static void main(String[] args) {
		new ColorChooserTest();
	}
}
