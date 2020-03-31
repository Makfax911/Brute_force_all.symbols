import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class BruteForce extends Thread {

    Scanner scan = new Scanner(System.in);
    String password;
    private  StringBuilder string = new StringBuilder("");
    private  int min , max ;
    int sum,sum1,sum2;

    long lStartTime = System.nanoTime();

    public void pool(int index) {

        for (int i = min; i < max; i++) {
            sum1+= Integer.parseInt(String.valueOf(i));
            System.out.println(i);
            string.setCharAt(index, (char) i);
            if (index < string.length() - 1)
                pool(index + 1);
            System.out.println(string);
            sum+= Integer.parseInt(String.valueOf(string.length()));
            sum2=sum+sum1;
            if (string.toString().equals(password)) {
                System.err.println("password found: " + string+"\n"+
                                "Elapsed time in nanoseconds: " + output+"\n"
                        +"Number of options selected: "+"\n"
                        +"String: "+ sum +"\n"
                        + "Integer: "+ sum1+"\n"
                        + "All: "+sum2);

                System.exit(0);

            }
        }
    }

    public void run() {


        System.out.println("Please enter a password: ");
        password = scan.nextLine();

        System.out.println("Please enter a Min variable : ");
        min = scan.nextInt();

        System.out.println("Please enter a Max variable : ");
        max = scan.nextInt();
        System.out.println();

        while (true) {
            string.append((char) min);

            for (int i = 0; i < string.length() - 1; i++) {

                for (int j = min; j < max; j++) {

                    string.setCharAt(i, (char) j);
                    pool(i + 1);

                }

            }
        }


    }
    long lEndTime = System.nanoTime();
    long output = lEndTime - lStartTime;

}


