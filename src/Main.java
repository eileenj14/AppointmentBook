import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        boolean[][] schedule = new boolean[8][60];
        AppointmentBook a = new AppointmentBook(schedule);
        for(int i = 10; i < 15; i++) schedule[1][i] = true;
        for(int i = 30; i < 45; i++) schedule[1][i] = true;
        for(int i = 50; i < 60; i++) schedule[1][i] = true;
        a.printPeriod(2);
        System.out.println();
        System.out.println(a.findFreeBlock(2,15));
        System.out.println(a.findFreeBlock(2,9));
        System.out.println(a.findFreeBlock(2,20));
        System.out.println();

        schedule = new boolean[8][60];
        for(int i = 25; i < 30; i++) schedule [1][i] = true;
        for(int i = 0; i < 15; i++) schedule [2][i] = true;
        for(int i = 41; i < 60; i++) schedule [2][i] = true;
        for(int i = 5; i < 30; i++) schedule [3][i] = true;
        for(int i = 44; i < 60; i++) schedule [3][i] = true;
        AppointmentBook b = new AppointmentBook(schedule);
        int period = 2;
        while(period < 5)
        {
            System.out.println("Period: " + period);
            b.printPeriod(period);
            System.out.println();
            period++;
        }
        System.out.println(b.makeAppointment(2,4,22));
        System.out.println(b.makeAppointment(3,4,3));
        System.out.println(b.makeAppointment(2,4,30));
        System.out.println();
        period = 2;
        while(period < 5)
        {
            System.out.println("Period: " + period);
            b.printPeriod(period);
            System.out.println();
            period++;
        }
    }

    public static int read() throws FileNotFoundException
    {
        int fulfilledAppointments = 0;

        AppointmentBook[] appointmentBooks = new AppointmentBook[1000];
        File f = new File("Schedules.txt");
        Scanner s = new Scanner(f);
        int index = 0;
        while(s.hasNextLine())
        {
            boolean[][] schedule = new boolean[8][60];
            AppointmentBook a = new AppointmentBook(schedule);
            for(int p = 0; p < 8; p++)
            {
                for(int m = 0; m < 60; m++)
                {
                    schedule[p][m] = s.nextBoolean();
                }
            }
            boolean appointmentStatus = a.makeAppointment(s.nextInt(),s.nextInt(),s.nextInt());
        }
    }
}
