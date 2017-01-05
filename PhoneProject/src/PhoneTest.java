import java.util.Random; 
public class PhoneTest {
	public static void main(String[] args) {
        Phone[] phones = {new Landline(), new Landline(), 
                new Landline(), new Mobile(), new Mobile(), new Smart(), 
                new Smart(), new Smart() };


        for (Phone p: phones)
            System.out.printf("Phone: %s\n", p.toString());

        Random rnd = new Random();
        for (int i=0; i<10; i++) {
            int c = rnd.nextInt(phones.length);
            int d = rnd.nextInt(phones.length);
            while (d == c) d = rnd.nextInt(phones.length);

            if (phones[c] instanceof Textable && phones[d] instanceof Textable) {
                ((Textable)phones[c]).sendText((Textable)phones[d]);
                System.out.printf("Phone %s texted %s successfully\n", 
                                             phones[c], phones[d]);
            }
            else if (phones[c].call(phones[d]))
                System.out.printf("Phone %s called %s successfully\n", 
                                            phones[c], phones[d]);
            else
                System.out.printf("Phone %s was ignored by %s\n", 
                                             phones[c], phones[d]);
        }

        }
    }


