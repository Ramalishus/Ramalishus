// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;

class HelloWorld {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       
       while(true) {
           
       System.out.println("enter day (press 0 to quit): ");
       
      int day = scan.nextInt();
       System.out.println(week(day));
       if (day == 0){
             break;
         }
       }
    }
    public static String week(int day) {
        
        if (day == 1) {
            
            return ("The day is monday");
            
        }
       else if (day == 2) {
            
            return ("The day is tuesday");
            
        }
       else if (day == 3) {
            
            return ("The day is wednesday(my B-DAY)");
            
        }
       else if (day == 4) {
            
            return ("The day is thursday");
            
        }
       else if (day == 5) {
            
            return ("The day is friday");
            
        }
        if (day == 6) {
            
            return ("The day is saturday");
            
        }
        if (day == 7) {
            
            return ("The day is sunday");
            
        }
        else {
            return ("invalid number");
        }
      }
    }
