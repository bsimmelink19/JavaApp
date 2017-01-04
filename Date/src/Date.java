
public class Date {
		int month; 
		int day; 
		int year; 
		
		Date(int m, int d, int y)
		{
			this.month = m;
			this.day = d;
			this.year = y; 
		}
		
		void setMonth(int m)
		{
			this.month = m;
		}
		void setDay(int d)
		{
			this.day = d; 
		}
		void setYear(int y)
		{
			this.year = y; 
		}
		
		int getMonth()
		{
			return this.month;
		}
		
		int getDay()
		{
			return this.day; 
		}
		int getYear()
		{
			return this.year; 
		}
		
		void displayDate()
		{
			System.out.printf("Date: %d/%d/%d", this.month, this.day, this.year); 
		}
}
