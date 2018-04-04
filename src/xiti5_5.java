	import java.io.*; 
	import javax.swing.*;
	import javax.swing.event.*; 
	import java.awt.event.*;
	import java.awt.*; 
	import java.util.*; 
	public class xiti5_5 extends JFrame implements ActionListener,ItemListener{ 
	String str[]=new String[7],s;  
	FileReader file;     BufferedReader in;    
	JButton restart=new JButton("重新练习");    
	JButton next=new JButton("下一题目"); 
	JButton finish=new JButton("交卷");   
	JCheckBox option[]=new JCheckBox[4];  
	JLabel score=new JLabel("20   剩余时间： 120s");  
	JTextField question=new JTextField(10); 
	int account=0;  
	int n= 0;
	xiti5_5(){     
	for(int i=0;i<4;i++){    
	option[i]=new JCheckBox();             
	option[i].addItemListener(this);  
	       }          
	restart.addActionListener(this);
	     next.addActionListener(this); 
	     finish.addActionListener(this);  
	     try{        
	     file=new FileReader("D:\\result.txt");          
	     in=new BufferedReader(file);        
	 }catch(IOException e){}          
	Box boxV=Box.createVerticalBox();         
	JPanel p1=new JPanel();             
	JPanel p2=new JPanel();             
	JPanel p3=new JPanel();          
	JPanel p4=new JPanel();              
	p1.setLayout(new FlowLayout(FlowLayout.CENTER));        
	p1.add(new JLabel("题目   :8+55+9="));p1.add(question);        
	p2.setLayout(new FlowLayout(FlowLayout.CENTER));         
	p2.add(new JButton("确定"));         
        
	p3.setLayout(new FlowLayout(FlowLayout.CENTER));         
	p3.add(new JLabel("您的得分："));p3.add(score);         
	p4.setLayout(new FlowLayout(FlowLayout.CENTER)); 
	p4.add(restart);p4.add(next);p4.add(finish);  
	boxV.add(p1);boxV.add(p2);boxV.add(p3);boxV.add(p4);  
	    Container con=getContentPane();  
	       con.add(boxV);   
	      this.setSize(800,300);  
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        this.setVisible(true);   
	      this.validate();    
	     reading();  
	           }    
	  public void reading(){   
	      int i=0;        
	 try{              
	s=in.readLine().trim();  
	           if(!(s.startsWith("end"))){                  
	StringTokenizer tokenizer=new StringTokenizer(s,"#");           
	      while(tokenizer.hasMoreTokens()){         
	            str[i]=tokenizer.nextToken();                
	     i++;         
	        }                
	  question.setText(str[0]);              
	   for(int j=1;j<=4;j++){                
	      option[j-1].setLabel(str[j]);        
	         }                            
	 }              
	else if(s.startsWith("end")){             
	     question.setText("考试结束，点击交卷按钮查看得分。");               
	  next.setEnabled(false);                 
	in.close();file.close();            
	 }                     
	 }catch(Exception exp){question.setText("无试题文件");}   
	  }      
	public void actionPerformed(ActionEvent e){         
	if(e.getSource()==restart){            
	 account=0;              
	next.setEnabled(true);            
	 score.setText(account+"分");             
	try{                  
	file=new FileReader("D:\\java.txt");                 
	in=new BufferedReader(file);             
	}catch(IOException ee){}             
	reading();       
	  }          
	if(e.getSource()==next){
	reading();
	              for(int j=0;j<4;j++){  
	                option[j].setEnabled(true); 
	                option[j].setSelected(false);      
	       }            
	             }         
	 if(e.getSource()==finish){ 
      int n=JOptionPane.showConfirmDialog(null,"交卷以后将不能再修改，确实要交卷吗？", "确认对话框",JOptionPane.YES_NO_OPTION);        
	     if(n==JOptionPane.YES_OPTION){             
	    for(int i=0;i<4;i++){         
	             option[i].setEnabled(false);   
	              }                
	  score.setText(account*10+"分");  
	               restart.setEnabled(false); 
	                next.setEnabled(false);  
	               finish.setEnabled(false);   
	          }       
	          }            
	         }     
	 public void itemStateChanged1(ItemEvent e)    
	 {          
	for(int j=0;j<4;j++){             
	 if(option[j].getLabel().equals(str[5])&&option[j].isSelected()){     
	            account++;         
	     }                             
	    }               
         
	if(n==JOptionPane.YES_OPTION){  
		for(int i=0;i<4;i++){                  
			option[i].setEnabled(false);           
			}                 
		score.setText(account*10+"分");     
		restart.setEnabled(false);          
		next.setEnabled(false);     
		finish.setEnabled(false);            
		}                                  }  
		public void itemStateChanged(ItemEvent e)     { 
			for(int j=0;j<4;j++){      
				if(option[j].getLabel().equals(str[5])&&option[j].isSelected()){   
					account++;              }                                 }             }   
		public static void main(String args[]){      
			xiti5_5 ET=new xiti5_5();       
			}     }
		