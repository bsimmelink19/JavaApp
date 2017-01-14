import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JComponent implements ActionListener{
	JFrame frame; 
	JPanel LeftPanel;
	JLabel label1; 
	ImageIcon circleIcon;
	ImageIcon squareIcon;
	ImageIcon rectangleIcon;
	ImageIcon triangleIcon;
	Window(ArrayList<Shape> shapes)
	{
		frame = new JFrame("Shapes"); 
		frame.setBounds(100, 100, 550, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		LeftPanel = new JPanel();  
		LeftPanel.setLayout(new GridLayout(35, 3));
		label1 = new JLabel();
		
		Toolkit toolkit = Toolkit.getDefaultToolkit(); 
		java.net.URL imgUrl = getClass().getResource("/resources/circle.jpg"); 
		Image img = toolkit.getImage(imgUrl); 
		img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
		circleIcon = new ImageIcon(img); 
		
		java.net.URL imgUrl1 = getClass().getResource("/resources/rectangle.jpg"); 
		Image img1 = toolkit.getImage(imgUrl1); 
		img1 = img1.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
		rectangleIcon = new ImageIcon(img1);
		
		java.net.URL imgUrl2 = getClass().getResource("/resources/square.jpg"); 
		Image img2 = toolkit.getImage(imgUrl2); 
		img2 = img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
		squareIcon = new ImageIcon(img2); 
		
		java.net.URL imgUrl3 = getClass().getResource("/resources/triangle.jpg"); 
		Image img3 = toolkit.getImage(imgUrl3); 
		img3 = img3.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
		triangleIcon = new ImageIcon(img3); 
		
		frame.add(label1, BorderLayout.CENTER); 
		
		myButton btn; 
		for (int i = 0; i < shapes.size(); i++)
		{
			String n = shapes.get(i).getName(); 
			int d = shapes.get(i).getID();
			String s = String.format("%s (%d)", n, d);
			btn = new myButton(s, shapes.get(i)); 
			LeftPanel.add(btn);
			btn.addActionListener(this);
		
		}
		frame.add(LeftPanel, BorderLayout.WEST); 
		 
		repaint(); 
		revalidate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		myButton b = (myButton)e.getSource(); 
		if (b.getShape() instanceof Circle)
		{
			label1.setIcon(circleIcon); 
			Circle sh = (Circle)b.getShape(); 
			String s = String.format("<html>Kind: %s<br> ID: %d<br> Radius: %d<br> Color: %s</html>", sh.getName(), sh.getID(), sh.getRadius(), sh.getColor()); 
			label1.setText(s);
			repaint(); 
		}
		else if (b.getShape() instanceof Square)
		{
			label1.setIcon(squareIcon); 
			Square sh = (Square)b.getShape(); 
			String s = String.format("<html>Kind: %s<br> ID: %d<br> Side: %d<br> Color: %s </html>", sh.getName(), sh.getID(), sh.getSide(), sh.getColor()); 
			label1.setText(s); 
			repaint(); 
		}
		else if (b.getShape() instanceof Rectangle)
		{
			label1.setIcon(rectangleIcon); 
			Rectangle sh = (Rectangle)b.getShape(); 
			String s = String.format("<html>Kind: %s<br> ID: %d<br> length: %d<br> Width: %d<br> Color: %s</html>", sh.getName(), sh.getID(), sh.getLenth(), sh.getWidth(), sh.getColor()); 
			label1.setText(s); 
			repaint(); 
		}
		
		else if (b.getShape() instanceof Triangle)
		{
			label1.setIcon(triangleIcon); 
			Triangle sh = (Triangle)b.getShape(); 
			String s = String.format("<html>Kind: %s<br> ID: %d<br> side1: %d<br> side2: %d<br> side3: %d<br> Color: %s</html>", sh.getName(), sh.getID(), sh.getSide1(), sh.getSide2(), sh.getSide3(), sh.getColor()); 
			label1.setText(s); 
			repaint(); 
		}
		
		
		
		
	}
}
