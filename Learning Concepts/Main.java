import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
//        System.out.println("Hello World !");
//
//        //basic stuff
//        String name = "";
//        int age;
//
//        Scanner scanner = new Scanner(System.in);
//        while(true) {
//            System.out.print("What's you name? :");
//            name = scanner.nextLine();
//            if (name.length() > 0) {
//                break;
//            } else {
//                System.out.println("Please enter something .");
//            }
//        }
//
//        while(true){
//            System.out.println("And how old are you ? :");
//            try {
//                age = scanner.nextInt();
//                break;
//            }catch (InputMismatchException e){
//                System.out.println("Please only enter numeric values .");
//                scanner.nextLine();
//            }
//        }
//
//        System.out.println("Hello there " + name);
//        System.out.println("So you are " + age + " years old huh.");
//        if(age > 18){
//            System.out.println(
//                    "Well you an adult, you don't need my advice ."
//            );
//        }else{
//            System.out.println("Since you are still young, let me give you some advice pal " +
//                    "Life is like something in your pants " +
//                    "sometimes its hard, but it is never hard forever" +
//                    " Sayonara.");
//        }
//
//        Rps n = new Rps(3);
//        n.run();

        /*Uno u = new Uno();
        u.start();*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number from 1 to 7");
        DaysOfTheWeek day = switch (scanner.nextInt()) {
            case 1 -> DaysOfTheWeek.MONDAY;
            case 2 -> DaysOfTheWeek.TUESDAY;
            case 3 -> DaysOfTheWeek.WEDNESDAY;
            case 4 -> DaysOfTheWeek.THRUSDAY;
            case 5 -> DaysOfTheWeek.FRIDAY;
            case 6 -> DaysOfTheWeek.SATURDAY;
            default -> DaysOfTheWeek.SUNDAY;
        };

        if(day == DaysOfTheWeek.MONDAY){
            System.out.println("It is monday.");
        }
        else{
            System.out.println("Today is not monday.");
        }
    }
}
