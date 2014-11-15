package manage;

import java.awt.Event;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Input extends JPanel {

	JTextField txtnumber,txtname,txtorigo,txthobby;
	JComboBox txtspecial,txtgrade,txtborn,txtage;
	JRadioButton radioboy,radiogirl;
	JLabel imagelabel;
	ButtonGroup group=null;
	ImageIcon image; 
	JButton truein,resetin,imageupload;
	String agestr[] = {"10","11","12","13","14",
						"15","16","17","18","19",
						"20","21","22","23","24",
						"25","26","27","28","29",
						"30","31","32","33","34",
						"35","36","37","38","39","40"};
	
	public Input() {
		init();
	}

	public Input(LayoutManager layout) {
		super(layout);
	}

	public Input(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public Input(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}
	private void init()
	{
		txtnumber = new JTextField(10);
		txtname   = new JTextField(10);
		txtorigo  = new JTextField(10);
		txthobby  = new JTextField(10);
		radioboy  = new JRadioButton("男");
		radiogirl = new JRadioButton("女");
		group     = new ButtonGroup();
		group.add(radioboy);
		group.add(radiogirl);
		 
		txtage=new JComboBox(agestr);
		truein=new JButton("录入");
		 
		image       = new ImageIcon();
		imageupload = new JButton("上传");
		truein      =  new JButton("录入");
		resetin     = new JButton("重置");
		imagelabel = new JLabel();
		
		
		truein.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 String number=txtnumber.getText();
				 String name=txtname.getText();
				 String sex = null;
				 if(radioboy.isSelected())
					 sex=radioboy.getText();
				 else if(radiogirl.isSelected())
					 sex=radiogirl.getText();
				 String age = (String) txtage.getSelectedItem();
				 String origo = txtorigo.getText();
				 String hobby = txthobby.getText();
				 if(number!=null && name !=null && sex!=null && age!=null && origo!=null && hobby!=null){
					 Student stu = new Student(number,name,sex,Integer.parseInt(age),origo,hobby,"暂时为空");
					 if(StudentsInfo.put(stu)){
						 JOptionPane.showOptionDialog(null, "保存成功！","保存学生信息",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
					 }
					 else{
						 JOptionPane.showOptionDialog(null, "保存失败，该学号已经存在","保存学生信息",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
					 }
				 }
				 else{
					 JOptionPane.showOptionDialog(null, "学生信息填写不完整","保存学生信息",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
				 }
			 }
			
		 });
		
		 resetin.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 txtnumber.setText("");
				 txtname.setText("");
				 radioboy.setSelected(false);
				 radiogirl.setSelected(false);
				 txtorigo.setText("");
				 txthobby.setText("");
			 }
		 });
		 
		 
		 imageupload.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
		        chooser.showOpenDialog(null);
		        //String fname=chooser.getName(chooser.getSelectedFile());
		        String finname = chooser.getSelectedFile().getAbsolutePath();
				//Icon ic1 = new ImageIcon("c://"+fname);
		        Icon ic1 = new ImageIcon(finname);
				imagelabel.setIcon(ic1);
				String fileout;
				if((fileout = txtnumber.getText()) != null && !fileout.equals("")){
					StudentsInfo.imagewrite(finname, fileout+".jpg");
				}
			}
		});;

		 	Box box1=Box.createHorizontalBox();
			box1.add(new JLabel("学号:",JLabel.CENTER));
			box1.add(txtnumber);
			Box box2=Box.createHorizontalBox();
			box2.add(new JLabel("姓名:",JLabel.CENTER));
			box2.add(txtname);
			Box box3=Box.createHorizontalBox();
			box3.add(new JLabel("性别:",JLabel.CENTER));
			box3.add(radioboy);
			box3.add(radiogirl);
			Box box4=Box.createHorizontalBox();
			box4.add(new JLabel("年龄:"));
			box4.add(txtage);
			Box box5=Box.createHorizontalBox();
			box5.add(new JLabel("籍贯:"));
			box5.add(txtorigo);
			Box box6=Box.createHorizontalBox();
			box6.add(new JLabel("爱好:"));
			box6.add(txthobby);
			
			
			Box box7=Box.createHorizontalBox();
			box7.add(truein);
			box7.add(resetin);
			Box box8=Box.createHorizontalBox();
			box8.add(imagelabel);
			box8.add(imageupload);
			
			Box boxH=Box.createVerticalBox();
			boxH.add(box1);
			boxH.add(box2);
			boxH.add(box3);
			boxH.add(box4);
			boxH.add(box5);
			boxH.add(box6);
			
			boxH.add(box7);
			boxH.add(box8);
			boxH.setSize(300,300);
			this.add(boxH); 

	}
	public boolean handleEvent(Event e) 
    {
        if (e.id == Event.WINDOW_DESTROY) {
        	StudentsInfo.write();
            System.exit(0);
        }
         return super.handleEvent(e);
    }

}
