package com.第六节点菜对话框;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class DialogTest extends JFrame implements ActionListener{
	JPanel jp=new JPanel();
	JButton jb1=new JButton("只有OK按钮");
	JButton jb2=new JButton("Yes/No按钮");
	JButton jb3=new JButton("Yes/No按钮（自定义）");
	JButton jb4=new JButton("Yes/No/Cancel3个按钮");
	JButton jb5=new JButton("输入消息对话框");
	JButton jb6=new JButton("选项对话框");
	JButton[] buttonArray={jb1,jb2,jb3,jb4,jb5,jb6};
	JLabel jl=new JLabel("请依次单击按钮，将得到不同的对话框！");
	public DialogTest(){
		jp.setLayout(new GridLayout(2,3));//设置JPanel容器布局为网格布局
		for(int i=0;i<buttonArray.length;i++){
			jp.add(buttonArray[i]);
			buttonArray[i].addActionListener(this);
		}
		this.add(jp);
		this.add(jl,BorderLayout.SOUTH);
		
		this.setTitle("JOptionPane对话框");
		this.setBounds(200,200,500,180);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==buttonArray[0]){//按下“只有OK按钮”的消息对话框
			JOptionPane.showMessageDialog(this,"欢迎光临本店","只有OK按钮的消息对话框",JOptionPane.INFORMATION_MESSAGE);
			jl.setText("欢迎欢迎，热烈欢迎！");//更新标签的内容
		}else if(e.getSource()==buttonArray[1]){//按下有“Yes/No按钮”的确认对话框按钮
			int index=JOptionPane.showConfirmDialog(this, "您好，您是第一次来本店吗？","有Yes/No按钮的确认对话框",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			jl.setText("您是"+((index==0)?"新顾客，欢迎。":"老顾客了，欢迎。"));
		}else if(e.getSource()==buttonArray[2]){//按下有“Yes/No按钮（自定义）”的确认对话框按钮
			Object[] options={"喜欢","不喜欢"};//创建确认对话框
			int index=JOptionPane.showOptionDialog(this,"您好，您喜欢吃酸菜鱼吗？", "有Yes/No按钮（自定义）的确认对话框", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			jl.setText("我记下了，您"+((index==0)?"喜欢":"不喜欢")+"吃酸菜鱼！");
		}else if(e.getSource()==buttonArray[3]){//按下“Yes/No/Cancel3个按钮”的确认对话框按钮
			Object[] options={"好啊，给我来一份","不了，我们菜够多了","给我来份香辣虾"};
			int index=JOptionPane.showOptionDialog(this, "你好，尝尝本店招牌菜酸菜鱼吗？", "有Yes/No/Cancel按钮的确认对话框", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
			String reply=(index==0)?"稍等，您点的酸菜鱼很快就到":(index==1)?"好的，有需要再喊我":(index==2)?"好的，您点的香辣虾很快就到！":"对不起，请您点菜！";
			jl.setText(reply);
		}else if(e.getSource()==buttonArray[4]){//按下“输入消息对话框”按钮
			String dishes=JOptionPane.showInputDialog(this,"请输入您最想吃的菜：","输入信息对话框",JOptionPane.PLAIN_MESSAGE);
			jl.setText("我记下了，您最想吃的菜是："+dishes+"！");
		}else if(e.getSource()==buttonArray[5]){//按下“选项对话框”按钮
			String[] options=new String[]{"香辣虾","酸菜鱼","公安牛肉鱼杂","瓦罐汤"};
			int index=JOptionPane.showOptionDialog(this,"下面是本店免费赠送的菜，请您选一个，默认是瓦罐汤","选项对话框",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[3]);
			String dishes=(index==0)?"香辣虾":(index==1)?"酸菜鱼":(index==2)?"公安牛肉鱼杂":"瓦罐汤";
			jl.setText("你选择了本店赠送的"+dishes+"！");
		}
	}
	
	
	public static void main(String[] args) {
		new DialogTest();
	}
}
	
