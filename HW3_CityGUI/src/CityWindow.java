import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.print.DocFlavor.URL;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class creates a window with buttons capable of adding people to 
 * different buildings, removing from buildings, displaying people's attributes,
 * and emptying buildings
 * @see JComponent, ActionListener, MouseMotionListener
 * @author Brady Simmelink
 */
public class CityWindow extends JComponent implements ActionListener, MouseMotionListener {
	JFrame frame; 
	JLabel label1; 
	JPanel panel;
	JButton EmptyCityHall;
	JButton EmptySchool; 
	JButton removeFromSchool; 
	JButton removeFromCityHall; 
	myButton schoolButton; 
	myButton cityHallButton; 
	
	int X, Y; 

	/**
	 * constructor
	 * @param array of people in the city
	 * @param array of buildings in the city
	 */
	CityWindow(ArrayList<Person> pop, ArrayList<Building> build)
	{
		//set up the frame
		frame = new JFrame("City");
		frame.setBounds(100, 100, 550, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Toolkit toolkit = Toolkit.getDefaultToolkit(); 
		java.net.URL imgUrl = getClass().getResource("/resources/Kid.jpg"); 
		Image img = toolkit.getImage(imgUrl); 
		img = img.getScaledInstance(35, 35, Image.SCALE_SMOOTH); 
		ImageIcon kidIcon = new ImageIcon(img); 
	 
		//store the images to be used on the buttons for people
		java.net.URL imgUrl1 = getClass().getResource("/resources/Teacher.jpg"); 
		Image img1 = toolkit.getImage(imgUrl1); 
		img1 = img1.getScaledInstance(35, 35, Image.SCALE_SMOOTH); 
		ImageIcon teacherIcon = new ImageIcon(img1); 
		
		java.net.URL imgUrl2 = getClass().getResource("/resources/Police.jpg"); 
		Image img2 = toolkit.getImage(imgUrl2); 
		img2 = img2.getScaledInstance(35, 35, Image.SCALE_SMOOTH); 
		ImageIcon policeIcon = new ImageIcon(img2); 
		
		java.net.URL imgUrl4 = getClass().getResource("/resources/School.jpg"); 
		Image img4 = toolkit.getImage(imgUrl4); 
		img4 = img4.getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
		ImageIcon schoolIcon = new ImageIcon(img4); 
		
		java.net.URL imgUrl5 = getClass().getResource("/resources/CityHall.jpg"); 
		Image img5 = toolkit.getImage(imgUrl5); 
		img5 = img5.getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
		ImageIcon cityHallIcon = new ImageIcon(img5);
		
		//set up the school button
		schoolButton = new myButton(build.get(1),schoolIcon, 200,200,50,50); 
		schoolButton.addActionListener(this); 
		cityHallButton = new myButton(build.get(0),cityHallIcon, 100, 100, 50,50); 
		cityHallButton.addActionListener(this); 
		
		//Panel to hold the empty school, empty city hall, remove from school, remove from city hall buttons
		JPanel panel = new JPanel(); 
		
		//set up buttons to empty city hall and school
		EmptySchool = new JButton("Empty school");
		EmptyCityHall = new JButton("Empty City Hall"); 
		//clears the contents of the currentOccupents array in the school 
		EmptySchool.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				((School)schoolButton.getBuilding()).getOccupents().clear(); 
				
			}
		});
		//clears the contents of the currentOccupents array in the city hall
		EmptyCityHall.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				((CityHall)cityHallButton.getBuilding()).getOccupents().clear(); 
				
			}
		});
		
		//set up button to remove individuals from school
		String s = String.format("<html>Remove from<br> &emsp School</html>"); 
		removeFromSchool = new JButton(s); 
		//calls the remove(String) function in the school class, using the entered name as the parameter
		removeFromSchool.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String s = "Enter the name of the person to remove"; 
				String n = JOptionPane.showInputDialog(null, s); 
				((School)schoolButton.getBuilding()).remove(n);
			}
		});	
		
		//set up button to remove individuals from city hall
		String s1 = String.format("<html>Remove from<br> &emsp City Hall</html>");
		removeFromCityHall = new JButton(s1); 
		//calls the remove(String) function in the city hall class, using the entered name as the parameter 
		removeFromCityHall.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String s = "Enter the name of the person to remove"; 
				String n = JOptionPane.showInputDialog(null, s); 
				((CityHall)cityHallButton.getBuilding()).remove(n);
			}
		});	
		
		//add the remove and empty buttons to the panel in the north
		panel.add(removeFromSchool);
		panel.add(EmptySchool);
		panel.add(EmptyCityHall);
		panel.add(removeFromCityHall); 
		frame.add(panel,BorderLayout.NORTH); 
		JPanel panel1 = new JPanel(); 
		//add the cityhall and school buttons to the panel in the south
		panel1.add(schoolButton);
		panel1.add(cityHallButton); 
		frame.add(panel1, BorderLayout.SOUTH); 
		
		panel = new JPanel(); 
		panel.setLayout(new FlowLayout());
		
		
		//create buttons for the people in the city
		myButton btn; 
		for (int i = 0; i < pop.size(); i++){
			//creates a myButton with the kidIcon, and the name of the Kid
			if (pop.get(i) instanceof Kid)
			{
				btn = new myButton(pop.get(i), kidIcon); 
				panel.add(btn); 
				btn.addActionListener(this); 
				//if the button is dragged over the school icon, the kid is added to the currentOccupents in the school
				btn.addMouseMotionListener(new MouseAdapter(){
					public void mouseDragged(MouseEvent E) {
						// TODO Auto-generated method stub
						myButton b = (myButton)E.getSource(); 
						  X=E.getX()+b.getX();
			              Y=E.getY()+b.getY();
			              b.setBounds(X,Y,90,45);
			             
			              if(b.getX() > 150 && b.getY() > 150)
			              {
			            	if(!((myButton)schoolButton).getBuilding().currentOccupents.contains(b.getPerson()))
			            	  ((School)((myButton) schoolButton).getBuilding()).addOccupent(b.getPerson());
			       
			              }
					}
				});
				
			
			}
			//creates a myButton with the TeacherIcon, and the name of the Teacher
			else if(pop.get(i) instanceof Teacher)
			{
				btn = new myButton(pop.get(i), teacherIcon); 
				panel.add(btn); 
				btn.addActionListener(this);
				//if the button is dragged over the school icon, the Teacher is added to the currentOccupents in the school
				btn.addMouseMotionListener(new MouseAdapter(){
					public void mouseDragged(MouseEvent E) {
						// TODO Auto-generated method stub
						myButton b = (myButton)E.getSource(); 
							
						  X=E.getX()+b.getX();
			              Y=E.getY()+b.getY();
			              b.setBounds(X,Y,90,45);	
			             
			              if(b.getX() > 150 && b.getY() > 150)
			              {
			            	  if(!((myButton)schoolButton).getBuilding().currentOccupents.contains(b.getPerson()))
			            	  ((School)((myButton) schoolButton).getBuilding()).addOccupent(b.getPerson());
			       
			              }
					}
				});
				
			}
			//creates a myButton with the PoliceIcon, and the name of the Police
			else 
			{
				btn = new myButton(pop.get(i), policeIcon); 
				panel.add(btn);  
				btn.addActionListener(this);
				//if the button is dragged over the school icon, the Police is added to the currentOccupents in the cityHall
				btn.addMouseMotionListener(new MouseAdapter(){
					public void mouseDragged(MouseEvent E) {
						// TODO Auto-generated method stub
						myButton b = (myButton)E.getSource(); 
							
						  X=E.getX()+b.getX();
			              Y=E.getY()+b.getY();
			              b.setBounds(X,Y,90,45);
			              
			              if(b.getX() > 275 && b.getY() > 200)
			              {
			            	  if(!((myButton)cityHallButton).getBuilding().currentOccupents.contains(b.getPerson()))
			            	  ((CityHall)((myButton) cityHallButton).getBuilding()).addOccupent(b.getPerson());
			       
			              }
					}
				});
			
			}
		}
		frame.add(panel, BorderLayout.CENTER); 
		
		label1 = new JLabel(""); 
		panel.add(label1);
		frame.setVisible(true);
	}
	

		/**
		 * performs different tasks depending on which button in the frame is clicked
		 * displays a persons attributes, the people in the school or city hall
		 * @param the button clicked
		 */
		public void actionPerformed(ActionEvent e) {
			myButton b = (myButton)e.getSource(); 
			String s = "People in the school:\n";  
			String s1 = "People in the City Hall:\n"; 
			if(b.getPerson() instanceof Kid)
			{
				 
				String l = String.format
						("<html>Name: %s<br>Phone Number: %s <br>Age: %d <br>Favorite Candy: %s</html>",
								b.getPerson().name,b.getPerson().phoneNumber, b.getPerson().age, ((Kid)b.getPerson()).getFavCandy()); 
				label1.setText(l);
			}
			
			
			else if(b.getPerson() instanceof Teacher)
			{
				String l = String.format("<html>Name %s<br>Age: %d<br>Pay: $%.2f<br> Grade Level %d<br>Certification: %s</html>", 
						b.getPerson().name, b.getPerson().age, ((Teacher)b.getPerson()).getPay(), ((Teacher)b.getPerson()).getGradeLevel(),((Teacher)b.getPerson()).getCert() ); 
				label1.setText(l);
				
				
			}
			else if(b.getPerson() instanceof Police)
			{
			
				String l = String.format("<html>Name %s<br>Phone Number: %s<br>Age: %d<br>Pay: $%.2f<br>Role: %s</html>", 
						b.getPerson().name, b.getPerson().phoneNumber, b.getPerson().age, ((Police)b.getPerson()).getPay(), ((Police)b.getPerson()).getRole()); 
				label1.setText(l);
			
				
			}
			
			else if(e.getSource() == schoolButton)
			{
				if (((School)b.getBuilding()).getOccupents().size() == 0)
				{
					label1.setText("There are no people in the school!"); 
					repaint(); 
				}
				else 
				{
					
					label1.setText("");
					for (int i = 0; i < ((School)b.getBuilding()).getOccupents().size(); i++)
					{
						
						s += ((School)b.getBuilding()).getOccupents().get(i).name + "\n"; 
					}
					JOptionPane.showMessageDialog(frame, s); 
					
				}
				
			}
			
			else if(e.getSource() == cityHallButton)
			{
				if (((CityHall)b.getBuilding()).getOccupents().size() == 0)
				{
					label1.setText("There are no police in City Hall!"); 
					repaint(); 
				}
				else 
				{
					label1.setText("");
					
					for (int i = 0; i < ((CityHall)b.getBuilding()).getOccupents().size(); i++)
					{
						
						s1 += ((CityHall)b.getBuilding()).getOccupents().get(i).name + "\n"; 
					}
					JOptionPane.showMessageDialog(frame, s1); 
				}
			
			
			}
		
			repaint(); 
			revalidate(); 
			}


		/**
		 * standard mouseDraggedfunction
		 * @param arg0
		 */
		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		/**
		 * standard mouseMoved function
		 * @param arg0
		 */
		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}



	

		
	



	




	


}
