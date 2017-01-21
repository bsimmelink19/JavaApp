import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * this class is a window that display 5 rolling dice
 * @see JFrame
 * @author Brady Simmelink 
 */
public class ThreadTest extends JFrame{
	JLabel label; 
	 public ThreadTest() {
	        setSize(300, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new FlowLayout());
	        
	        Roll[] cs = new Roll[5];
	        for (int i=0; i<5; i++) {
	            JLabel l = new JLabel();
	            cs[i] = new Roll(l);
	            this.add(l);
	        }

	        this.setVisible(true);
	        Thread[] threads = new Thread[5]; 
	        for (int i=0; i<5; i++) {
	           threads[i] = new Thread(cs[i]);
	            threads[i].start();
	            try {
	                Thread.sleep(100);
	            }
	            catch (InterruptedException ex) {;}
	        }
	  
	            for (int i=0; i<5; i++) {
	                try {
	                    threads[i].join();
	                }
	                catch (InterruptedException ex) {};    
	    }  
	            
	        int sum = 0; 
	        for (int i = 0; i < 5; i++)
	        {
	        	sum += cs[i].value; 
	        }    
	        label = new JLabel(); 
	        this.add(label);
	        String s = String.format("Sum: %d\n", sum); 
	        label.setText(s); 
	        System.out.printf("Sum: %d\n", sum); 
	 }
	 /**
	  * creates a new threadTest
	  * @param args
	  */
	 public static void main(String[] args)
	 {
		  ThreadTest t = new ThreadTest(); 
	 }
}

/**
 * this class models a six sided dice, rolling a
 * random number of times.
 * stores its value as an integer 
 * @author Brady Simmelink
 */
class Roll implements Runnable {
	int value; 
    private JLabel _label;
    private ImageIcon[] images = new ImageIcon[6]; 
    public Roll(JLabel label) {
    	
    	Toolkit toolkit = Toolkit.getDefaultToolkit(); 
		java.net.URL imgUrl = getClass().getResource("/resources/img1.png"); 
		Image img = toolkit.getImage(imgUrl); 
		img = img.getScaledInstance(35, 35, Image.SCALE_SMOOTH); 
		ImageIcon image1 = new ImageIcon(img); 
		 
		java.net.URL imgUrl1 = getClass().getResource("/resources/img2.png"); 
		Image img1 = toolkit.getImage(imgUrl1); 
		img1 = img1.getScaledInstance(35, 35, Image.SCALE_SMOOTH); 
		ImageIcon image2 = new ImageIcon(img1); 
		
		java.net.URL imgUrl2 = getClass().getResource("/resources/img3.jpg"); 
		Image img2 = toolkit.getImage(imgUrl2); 
		img2 = img2.getScaledInstance(35, 35, Image.SCALE_SMOOTH); 
		ImageIcon image3 = new ImageIcon(img2);
		
		java.net.URL imgUrl3 = getClass().getResource("/resources/img4.png"); 
		Image img3 = toolkit.getImage(imgUrl3); 
		img3 = img3.getScaledInstance(35, 35, Image.SCALE_SMOOTH); 
		ImageIcon image4 = new ImageIcon(img3); 
		
		java.net.URL imgUrl4 = getClass().getResource("/resources/img5.png"); 
		Image img4 = toolkit.getImage(imgUrl4); 
		img4 = img4.getScaledInstance(35, 35, Image.SCALE_SMOOTH); 
		ImageIcon image5 = new ImageIcon(img4); 
		
		java.net.URL imgUrl5 = getClass().getResource("/resources/img6.png"); 
		Image img5 = toolkit.getImage(imgUrl5); 
		img5 = img5.getScaledInstance(35, 35, Image.SCALE_SMOOTH); 
		ImageIcon image6 = new ImageIcon(img5); 
		
		images[0] = image1; 
		images[1] = image2; 
		images[2] = image3;
		images[3] = image4; 
		images[4] = image5; 
		images[5] = image6; 
		
        _label = label;
    }
    /**
     * changes the image on the label to a random face of a dice
     * runs a random number of times 
     */
    public void run() {
    	Random r = new Random(); 
    	Random r1 = new Random();
    	int x = r1.nextInt(30); 
        for(int i = 0; i < x; i++) {
        	int ran = r.nextInt(6); 
           _label.setIcon(images[ran]);
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex) {;}
            this.value = ran + 1; 
        }
     
       
    }
}
