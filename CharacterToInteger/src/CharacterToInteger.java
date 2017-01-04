
public class CharacterToInteger {
	public static void main(String[] args)
	{
		char[] myChars = {'A', 'B', 'C', 'a', 'b', 'c', '0', '1', '2', '$', '*', '/', ' '}; 
	for (char c : myChars)
	{
		System.out.printf("The Integer Value for %c has the integer value %d\n", c, (int)c); 
	}
	}
}

