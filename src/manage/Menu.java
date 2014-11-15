package manage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Event;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Menu extends JFrame {
	Delete  delete;
	Input   input;
	Inquiry inquiry;
	Modify  modify;
	
	public Menu() throws HeadlessException {
		// TODO Auto-generated constructor stub
		init();
	}

	public Menu(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
		init();
	}

	public Menu(String title) throws HeadlessException {
		super(title);
		init();
	
	}

	public Menu(String title, GraphicsConfiguration gc) {
		super(title, gc);
		init();
	}

	public boolean handleEvent(Event e) 
    {
        if (e.id == Event.WINDOW_DESTROY) {
        	StudentsInfo.write();
            System.exit(0);
        }
         return super.handleEvent(e);
    }
	
	public void init(){
		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		StudentsInfo.read();
		delete  = new Delete();
		input   = new Input();
		inquiry = new Inquiry();
		modify  = new Modify();
		
		CardLayout card = new CardLayout();
		JPanel pnlCard = new JPanel(card);
		pnlCard.add(input, "input");
		pnlCard.add(delete, "delete");
		pnlCard.add(inquiry, "inquiry");
		pnlCard.add(modify, "modify");
		this.add(pnlCard);

		ActionListener al = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String ac = e.getActionCommand();
				if(ac.equals("录入学生基本信息"))
				{
					card.show(pnlCard, "input");
				}
				else if(ac.equals("查询学生基本信息"))
				{
					card.show(pnlCard, "inquiry");
				}
				else if(ac.equals("修改学生基本信息"))
				{
					card.show(pnlCard, "modify");
				}
				else 
				{
					card.show(pnlCard, "delete");
				}
			}
		};
		
		ActionListener a2 = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String ac = e.getActionCommand();
				if(ac.equals("上传"))
				{
					//上传动作
					try {
						StudentsInfo.up1();
						JOptionPane.showOptionDialog(null, "上传成功","上传学生信息",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
					} catch (IOException e1) {
						JOptionPane.showOptionDialog(null, "上传失败","上传学生信息",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
						e1.printStackTrace();
					}
				}
				else if(ac.equals("下载"))
				{
					//下载动作
					try {
						StudentsInfo.down1();
						JOptionPane.showOptionDialog(null, "下载成功","下载学生信息",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
					} catch (IOException e1) {
						JOptionPane.showOptionDialog(null, "下载失败","下载学生信息",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
						e1.printStackTrace();
					}
				}
			}
		};
		
		
		ActionListener a3 = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				String ac = e.getActionCommand();
				if(ac.equals("退出不保存"))
				{
					setVisible(false);
					System.exit(0);
				}
				else if(ac.equals("保存并退出"))
				{
						StudentsInfo.write();
						setVisible(false);
						System.exit(0);
				}
			}
		};
		
		JMenuBar mainmenubar =  new JMenuBar();
		JMenu titlebar = new JMenu("菜单选项");
		JMenuItem menuinputs=new JMenuItem("录入学生基本信息");
		menuinputs.addActionListener(al);
		JMenuItem menumodify=new JMenuItem("修改学生基本信息");
		menumodify.addActionListener(al);
		JMenuItem menuinquiry=new JMenuItem("查询学生基本信息");
		menuinquiry.addActionListener(al);
		JMenuItem menudelete=new JMenuItem("删除学生基本信息");
		menudelete.addActionListener(al);
		titlebar.add(menuinputs);
		titlebar.add(menumodify);
		titlebar.add(menuinquiry);
		titlebar.add(menudelete);
		
		
		JMenu remoteMenu = new JMenu("云端");
		JMenuItem upload = new JMenuItem("上传");
		upload.addActionListener(a2);
		JMenuItem download= new JMenuItem("下载");
		download.addActionListener(a2);
		remoteMenu.add(upload);
		remoteMenu.add(download);
		
		JMenu otherMenu = new JMenu("其他");
		JMenuItem exit1 = new JMenuItem("退出不保存");
		exit1.addActionListener(a3);
		JMenuItem exit2= new JMenuItem("保存并退出");
		exit2.addActionListener(a3);
		otherMenu.add(exit1);
		otherMenu.add(exit2);
		
		mainmenubar.add(titlebar);
		mainmenubar.add(remoteMenu);
		mainmenubar.add(otherMenu);
		this.setJMenuBar(mainmenubar);
		
		this.setSize(400, 400);
		this.show();
	}
}
