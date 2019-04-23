import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TIMER {
	String[] in;//This array will contain the time at which the employee clock in
	String[] out;//This array will contain the time at which the employee clock in
	
	 JFrame frmIupuiTimeRecorder;//This is the general frame of the GUI
	 JLabel lblDate;//This label will hold the date
	 JLabel lblTime;//This label will hold the time
	 JLabel message;//This will be used to interact with the user
	 JButton keyEnter ;//This is button will take care of validating the user input
	 //The following button are the ones that constitutes the keypad(0---->9)
	 JButton key0;
	 JButton key1;
	 JButton key2;
	 JButton key3;
	 JButton key4;
	 JButton key5;
	 JButton key6;
	 JButton key7;
	 JButton key8;
	 JButton key9;
	double diff1;//This will hold the second done by the user1 at work
	double diff2;//This will hold the second done by the user2 at work
	double diff3;//This will hold the second done by the user3 at work
	double diff4;//This will hold the second done by the user4 at work
	double diff5;//This will hold the second done by the user5 at work
	double diff6;//This will hold the second done by the user6 at work

	//Date t_in;//This will hold the clock in time of the employee
	//Date t_out;//This will hold the clock out time of the employee
	private JTextField IDNumber;//This is the screen that displays what the user has input on the keypad
	Employee e1 =new Employee("000000", "Andy",0  );//Andy's Constructor
	Employee e2 =new Employee("111111", "Kefil",0 );//Kefil's Constructor
	Employee e3 =new Employee("222222", "Paul",0  );//Paul's Constructor
	Employee e4 =new Employee("333333", "Prasad",0);//Prasad's Constructor
	Employee e5 =new Employee("444444", "Jake",0  );//Jake's Constructor
	Employee e6 =new Employee("555555", "Gabe" ,0 );//Gabe's Constructor
	static Employee[] e= new Employee[6];//This is an array that will contain the object of employees
	static ArrayList<String> Employee_working=new ArrayList<String>();//This is an array list to contain the ID of the employee that are already working.
	String filename= "hours.txt";
	public TIMER() throws IOException 
	{	
		this.frmIupuiTimeRecorder=new JFrame();
		frmIupuiTimeRecorder.setTitle("IUPUI TIME RECORDER");
		frmIupuiTimeRecorder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.lblDate=new JLabel("Date");
		this.lblTime=new JLabel("Time");
		this.keyEnter= new JButton("ENTER");
		keyEnter.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.key0=new JButton("0");		
		key0.setForeground(Color.RED);
		this.key1=new JButton("1");
		this.key2=new JButton("2");
		key2.setForeground(Color.RED);
		this.key3=new JButton("3");
		key3.setForeground(Color.RED);
		this.key4=new JButton("4");
		key4.setForeground(Color.RED);
		this.key5=new JButton("5");
		key5.setForeground(Color.RED);
		this.key6=new JButton("6");
		key6.setForeground(Color.RED);
		this.key7=new JButton("7");
		key7.setForeground(Color.RED);
		this.key8=new JButton("8");
		key8.setForeground(Color.RED);
		this.key9=new JButton("9");
		key9.setForeground(Color.RED);
		this.in = new String[6];
		this.out = new String[6];
		this.diff1=0;
		this.diff2=0;
		this.diff3=0;
		this.diff4=0;
		this.diff5=0;
		this.diff6=0;
		makeGUI();
		time();
		
	}
	public static void main(String[] args) 
	{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TIMER window = new TIMER();
					window.frmIupuiTimeRecorder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	public String getTime_in() 
	{
			Calendar cal = new GregorianCalendar();//This create an instance of the Gregorian Calendar 
	       int Hour = cal.get(Calendar.HOUR_OF_DAY);//This gets the Hours 
	       int Minute = cal.get(Calendar.MINUTE);//This gets the minute
	       int Second = cal.get(Calendar.SECOND);//This gets the Second
	       String Time=Hour+":"+Minute+":"+Second;//This makes a string that looks like Time= HH:MM:SS
	       return Time;	
	}
	public  void login(String ID) throws Exception 
	{	
		//This next line are being used to store the employee data into an array
		e[0]=e1;
		e[1]=e2;
		e[2]=e3;
		e[3]=e4;
		e[4]=e5;
		e[5]=e6;
		
		/** Explanation of line (136---->431)
		 * We had created an empty arrayList earlier so everytime someone enter his/her ID number,
		 * The program will go through the list to check for a match. If there is a match,
		 * the user will be logout because that means he was at work. In the other hand when the
		 * Program does not find a match in the list, the employee will be clocked in and at the 
		 * end of the closing in process, the ID of that specific employee will be appended to the 
		 * list of employee that are working so that when that same ID in entered again, the person 
		 * will be clocked out
		 * */
		//CLOCK OUT
		if(Employee_working.contains(ID)) 
		{//if begins
			
			message.setText("Good work today. Have a good rest of your Day");//This message is displayed when the employee clock out
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			
			switch(ID) 
			{//switch begins
			case"000000":
				out[0]=getTime_in();
			Date	 t_in1=format.parse(in[0]);
			Date     t_out1=format.parse(out[0]);
			double	diff1=(double) (t_out1.getTime()-t_in1.getTime())/1000;
				e1.setHours(diff1);
				if((diff1/60)<=1) 
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil(diff1) +" second","Time Information",JOptionPane.INFORMATION_MESSAGE);

				}//if ends
				else
				if((diff1/60)<=60) 
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil(diff1/60) +" minutes","Time Information",JOptionPane.INFORMATION_MESSAGE);

				}//if ends
				else
				if
				((diff1/60)>60)
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil((diff1/60)/60) +"Hours","Time Information",JOptionPane.INFORMATION_MESSAGE);
				}//if ends
				break;
			case"111111":
				out[1]=getTime_in();
			Date 	 t_in2=format.parse(in[1]);
			Date	 t_out2=format.parse(out[1]);
			double diff2=(double) (t_out2.getTime()-t_in2.getTime())/1000;
				e2.setHours(diff2);
				if((diff2/60)<=1) 
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil(diff2) +" second","Time Information",JOptionPane.INFORMATION_MESSAGE);

				}//if ends
				else
				if((diff2/60)<=60) 
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil(diff2/60) +" minutes","Time Information",JOptionPane.INFORMATION_MESSAGE);

				}//if ends
				else
				if
				((diff2/60)>60)
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil((diff2/60)/60) +"Hours","Time Information",JOptionPane.INFORMATION_MESSAGE);
				}//if ends
				break;
			case"222222":
				out[2]=getTime_in();
			Date	 t_in3=format.parse(in[2]);
			Date	 t_out3=format.parse(out[2]);
			double	diff3=(double) (t_out3.getTime()-t_in3.getTime())/1000;
				e3.setHours(diff3);
				if((diff3/60)<=1) 
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil(diff3) +" second","Time Information",JOptionPane.INFORMATION_MESSAGE);

				}//if ends
				else
				if((diff3/60)<=60) 
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil(diff3/60) +" minutes","Time Information",JOptionPane.INFORMATION_MESSAGE);

				}//if ends
				else
				if
				((diff3/60)>60)
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil((diff3/60)/60) +"Hours","Time Information",JOptionPane.INFORMATION_MESSAGE);
				}//if ends
				break;
			case"333333":
				out[3]=getTime_in();
			Date	 t_in4=format.parse(in[3]);
			Date	 t_out4=format.parse(out[3]);
			double diff4=(double) (t_out4.getTime()-t_in4.getTime())/1000;
				e4.setHours(diff4);
				if((diff4/60)<=1) 
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil(diff4) +" second","Time Information",JOptionPane.INFORMATION_MESSAGE);

				}//if ends
				else
				if((diff4/60)<=60) 
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil(diff4/60)+" minutes","Time Information",JOptionPane.INFORMATION_MESSAGE);

				}//if ends
				else
				if
				((diff4/60)>60)
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil((diff4/60)/60) +"Hours","Time Information",JOptionPane.INFORMATION_MESSAGE);
				}//if ends
				break;
			case"444444":
				out[4]=getTime_in();
			Date	 t_in5=format.parse(in[4]);
			Date	 t_out5=format.parse(out[4]);
			double	diff5=(double) (t_out5.getTime()-t_in5.getTime())/1000;
				e5.setHours(diff5);
				if((diff5/60)<=1) 
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil(diff5) +" second","Time Information",JOptionPane.INFORMATION_MESSAGE);

				}//if ends
				else
				if((diff5/60)<=60) 
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil(diff5/60) +" minutes","Time Information",JOptionPane.INFORMATION_MESSAGE);

				}//if ends
				else
				if
				((diff5/60)>60)
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil((diff5/60)/60) +"Hours","Time Information",JOptionPane.INFORMATION_MESSAGE);
				}//if ends
				break;
			case"555555":
				out[5]=getTime_in();
			Date	 t_in6=format.parse(in[5]);
			Date	 t_out6=format.parse(out[5]);
			double	diff6=(double) (t_out6.getTime()-t_in6.getTime())/1000;
				e6.setHours(diff6);
				if((diff6/60)<=1) 
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil(diff6) +" second","Time Information",JOptionPane.INFORMATION_MESSAGE);

				}//if ends
				else
				if((diff6/60)<=60) 
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil(diff6/60) +" minutes","Time Information",JOptionPane.INFORMATION_MESSAGE);

				}//if ends
				else
				if
				((diff6/60)>60)
				{//if begins
					JOptionPane.showMessageDialog(this.keyEnter ,"You did "+Math.ceil((diff6/60)/60) +"Hours","Time Information",JOptionPane.INFORMATION_MESSAGE);
				}//if ends
			}//switch ends
		
			
			Employee_working.remove(ID);//Removing the person who clocked out ID's From the list of working employees
			try 
			{
			PrintWriter hours= new PrintWriter(filename);
			if((diff1/60)<1) 
			{//if begins
				hours.println(e1.getName()+"     --->       "+Math.ceil(e1.getHour())+"seconds");
			}//if ends
			else
			if((diff1/60)>1 && (diff1/60)<60) 
			{//if begins
				hours.println(e1.getName()+"     --->       "+Math.ceil(e1.getHour()/60)+"minutes");
			}//if ends
			else
			if
			((diff1/60)>60)
			{//if begins
				hours.println(e1.getName()+"     --->       "+Math.ceil((e1.getHour()/60)/60)+"hours");
			}//if ends
			/**********************************************************************************/
			if((diff2/60)<1) 
			{//if begins
				hours.println(e2.getName()+"     --->       "+Math.ceil(e2.getHour())+"seconds");
			}//if ends
			else
			if((diff2/60)>1 && (diff2/60)<60) 
			{//if begins
				hours.println(e2.getName()+"     --->       "+Math.ceil(e2.getHour()/60)+"minutes");
			}//if ends
			else
			if
			((diff2/60)>60)
			{//if begins
				hours.println(e2.getName()+"     --->       "+Math.ceil((e2.getHour()/60)/60)+"hours");
			}//if ends
			/**********************************************************************************/
			if((diff3/60)<1) 
			{//if begins
				hours.println(e3.getName()+"     --->       "+Math.ceil(e3.getHour())+"seconds");
			}//if ends
			else
			if((diff3/60)>1 && (diff3/60)<60) 
			{//if begins
				hours.println(e3.getName()+"     --->       "+Math.ceil(e3.getHour()/60)+"minutes");
			}//if ends
			else
			if
			((diff3/60)>60)
			{//if begins
				hours.println(e3.getName()+"     --->       "+Math.ceil((e3.getHour()/60)/60)+"hours");
			}//if ends
			/**********************************************************************************/
			if((diff4/60)<1) 
			{//if begins
				hours.println(e4.getName()+"     --->       "+Math.ceil(e4.getHour())+"seconds");
			}//if ends
			else
			if((diff4/60)>1 && (diff4/60)<60) 
			{//if begins
				hours.println(e4.getName()+"     --->       "+Math.ceil(e4.getHour()/60)+"minutes");
			}//if ends
			else
			if
			((diff4/60)>60)
			{//if begins
				hours.println(e4.getName()+"     --->       "+Math.ceil((e4.getHour()/60)/60)+"hours");
			}//if ends
			/**********************************************************************************/
			if((diff5/60)<1) 
			{//if begins
				hours.println(e5.getName()+"     --->       "+Math.ceil(e5.getHour())+"seconds");
			}//if ends
			else
			if((diff5/60)>1 && (diff5/60)<60) 
			{//if begins
				hours.println(e5.getName()+"     --->       "+Math.ceil(e5.getHour()/60)+"minutes");
			}//if ends
			else
			if
			((diff5/60)>60)
			{//if begins
				hours.println(e5.getName()+"     --->       "+Math.ceil((e5.getHour()/60)/60)+"hours");
			}//if ends
			/**********************************************************************************/
			if((diff6/60)<60) 
			{//if begins
				hours.println(e6.getName()+"     --->       "+Math.ceil(e6.getHour())+"seconds");
			}//if ends
			else
			if((diff6/60)>1 && (diff6/60)<60) 
			{//if begins
				hours.println(e6.getName()+"     --->       "+Math.ceil(e6.getHour()/60)+"minutes");
			}//if ends
			else
			if
			((diff6/60)>60)
			{//if begins
				hours.println(e6.getName()+"     --->       "+Math.ceil((e6.getHour()/60)/60)+"hours");
			}//if ends
			/**********************************************************************************/

			hours.close();
			}
			
			catch(FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}//if ends
		//CLOCK IN
		else
			for(int j=0;j<e.length;j++)//search through the array of employee for a match and return the position
			{//for begins
				if(e[j].getID().equals(ID)) 
				{//if begins
					message.setText("Hello "+e[j].getName()+" Welcome to work");//displays this message when they are clock in
					Employee_working.add(e[j].getID());
					switch(ID) 
					{//switch begins

					case"000000":
						in[0]=getTime_in();
						break;
					case"111111":
						in[1]=getTime_in();
						break;
					case"222222":
						in[2]=getTime_in();
						break;
					case"333333":
						in[3]=getTime_in();		
						break;
					case"444444":
						in[4]=getTime_in();
						break;
					case"555555":
						in[5]=getTime_in();	
						break;
					}//switch ends
				}//if ends
			}//for ends
	};
	public  void time()//This method will be used to display the time as it goes
	{
		Thread time =new Thread()//This is the key element that will help to make the time change
		{
			public void run() 
			{
				try {
					for(;;) 
					{
					   Calendar cal = new GregorianCalendar();
					   int Day = cal.get(Calendar.DAY_OF_MONTH);
				       int Month = cal.get(Calendar.MONTH)+1;
				       int Year = cal.get(Calendar.YEAR);
				       int Hour = cal.get(Calendar.HOUR_OF_DAY);
				       int Minute = cal.get(Calendar.MINUTE);
				       int Second = cal.get(Calendar.SECOND);
				       lblDate.setText("Date:"+Month+"/"+Day+"/"+Year);//Date:month/day/year
				       lblTime.setText("Time:"+Hour+":"+Minute+":"+Second);//Time:Hour:minute:second
				       sleep(1000);//update every second
					}
					} 
				catch (InterruptedException e) 
				{
					
					System.out.println("error");
				}
			};
		};
		time.start();//Star running the thread
	}

	private void makeGUI() {
		
		//The general frame of the GUI
		//frame = new JFrame();
		frmIupuiTimeRecorder.setSize(new Dimension(441, 686));
		frmIupuiTimeRecorder.setLocationRelativeTo(null);
		frmIupuiTimeRecorder.setVisible(true);
		frmIupuiTimeRecorder.getContentPane().setLayout(null);
		frmIupuiTimeRecorder.setResizable(false);
		
		//Date label
		 //lblDate = new JLabel("Date:");
		 lblDate.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDate.setBounds(146, 13, 251, 16);
		frmIupuiTimeRecorder.getContentPane().add(lblDate);
		
		//Time label
		//lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTime.setBounds(146, 42, 251, 16);
		frmIupuiTimeRecorder.getContentPane().add(lblTime);
		
		
		//Keypad Panel
		JPanel KeyPad = new JPanel();
		KeyPad.setBackground(SystemColor.menu);
		KeyPad.setBounds(12, 155, 411, 499);
		frmIupuiTimeRecorder.getContentPane().add(KeyPad);
		KeyPad.setLayout(null);
		
		//key1 
		JButton key1 = new JButton("1");
		key1.setForeground(Color.RED);
		key1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			IDNumber.setText(IDNumber.getText()+"1");
			
			}
		});
		key1.setFont(new Font("Broadway", Font.BOLD, 41));
		key1.setBounds(0, 0, 137, 126);
		KeyPad.add(key1);
		
		//key2
		key2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			
			{	
				IDNumber.setText(IDNumber.getText()+"2");
				
			}
		});
		key2.setFont(new Font("Broadway", Font.BOLD, 41));
		key2.setBounds(137, 0, 137, 126);
		KeyPad.add(key2);
		
		//key3
		key3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			
			{
				IDNumber.setText(IDNumber.getText()+"3");
			}
		});
		key3.setBounds(274, 0, 137, 126);
		key3.setFont(new Font("Broadway", Font.BOLD, 41));
		KeyPad.add(key3);
		
		//key4
		key4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				IDNumber.setText(IDNumber.getText()+"4");
			}
		});
		key4.setBounds(0, 124, 137, 126);
		key4.setFont(new Font("Broadway", Font.BOLD, 41));
		KeyPad.add(key4);
		
		//key5		
		key5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				IDNumber.setText(IDNumber.getText()+"5");
			}
		});
		key5.setBounds(137, 124, 137, 126);
		key5.setFont(new Font("Broadway", Font.BOLD, 41));
		KeyPad.add(key5);
		
		//key6		
		key6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				IDNumber.setText(IDNumber.getText()+"6");
			}
		});
		key6.setBounds(274, 124, 137, 126);
		key6.setFont(new Font("Broadway", Font.BOLD, 41));
		KeyPad.add(key6);
		
		//key7		
		key7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
