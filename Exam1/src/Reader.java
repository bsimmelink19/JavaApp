import java.util.ArrayList;
import java.io.*;
import java.math.BigInteger;

public class Reader{
	ArrayList<Shape> shapes = new ArrayList<Shape>(); 
	String[] parts;
	public static void main(String[] args) {
		Reader r = new Reader(); 
		File f = new File("C:/Users/bsimmelink19/workspace/Exam1/src/resources/shapes.txt"); 
		System.out.printf(f.getAbsolutePath()); 
		int x = 0; 
		int y =0; 
		int z = 0; 
		int zz = 0; 
		try(FileInputStream is = new FileInputStream(f)) {
			InputStreamReader ir = new InputStreamReader(is); 
			BufferedReader rdr = new BufferedReader(ir); 
			String line = rdr.readLine(); 
			
			while (line != null)
			{
			r.parts = line.split(" "); 
                line = rdr.readLine();
                if(r.parts[0].equals("circle:"))
                {
                x = Integer.parseInt(r.parts[1]); 
                y = Integer.parseInt(r.parts[2]);
               r.shapes.add(new Circle(x, y, r.parts[3])); 
                }
                if(r.parts[0].equals("rectangle:"))
                {
                	  x = Integer.parseInt(r.parts[1]); 
                      y = Integer.parseInt(r.parts[2]);
                      z = Integer.parseInt(r.parts[3]); 
                      r.shapes.add(new Rectangle(x, y, z, r.parts[4])); 
                      
                }
                if (r.parts[0].equals("square:"))
                {
                	x = Integer.parseInt(r.parts[1]);
                	y = Integer.parseInt(r.parts[2]); 
                	r.shapes.add(new Square(x, y, r.parts[3]));
                }
                if (r.parts[0].equals("triangle:"))
                {
                	x = Integer.parseInt(r.parts[1]); 
                	y = Integer.parseInt(r.parts[2]);
                	z = Integer.parseInt(r.parts[3]);
                	zz = Integer.parseInt(r.parts[4]);
                	r.shapes.add(new Triangle(x, y, z, zz, r.parts[5])); 
                }
			//System.out.printf("%s: %s\n", f.getName(), line);
		}
		}catch (Exception ex) { System.out.printf(ex.getMessage());}
		Window w = new Window(r.shapes); 
		//System.out.printf("%d\n", r.shapes.size()); 
    }
}
