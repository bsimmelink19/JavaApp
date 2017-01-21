import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

/**
*this class begins at a given URL, 
*Stores any URLs on that page
*then moves on to one of the stored URLs
*/ 
public class WebSpider {
	private static Map<String, Boolean> urls = new HashMap<String, Boolean>(); 
    public static void main(String[] args) {
        	
       
            urls.put("http://www.whitworth.edu/cms/", false); 
            String u = getNext(); 
            int i = 0; 
            while (u != null && i < 100)
            {
            	try {
            URL url = new URL(u); 
            BufferedReader rdr = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            
            while ((line = rdr.readLine()) != null) {
               Pattern Url = Pattern.compile("<a\\s*?href=\"(http:.*?)\""); 
               Matcher matcher = Url.matcher(line); 
               if (matcher.find())
               {
            	   urls.put(matcher.group(1), false);
            	   System.out.printf("URL: %s\n", matcher.group(1)); 
               }
            }
            	}
             
            catch (Exception ex) {
            System.out.printf("Oops: %s", ex.getMessage());  
        }
            	u = getNext(); 
            	i++; 
            }
        }
    
            

/**
*gets the next URL in the map
*
*/
public static String getNext()
{
	for (Map.Entry<String, Boolean> e: urls.entrySet())
	{
		if (e.getValue() == false)
		{
			e.setValue(true); 
			return e.getKey(); 
		}
	}
	return null; 
}
}


