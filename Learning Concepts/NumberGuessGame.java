import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {

    Random random;
    Scanner scanner;
    int curr_num;
    int usr_input;
    int upper_lim;

    NumberGuessGame(int difficulty){
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        this.upper_lim = 10 * (difficulty / 2);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Guess the number:");
            this.getInput();
        }
    }

    private void changeNum(){
        curr_num = random.nextInt(0, this.upper_lim);
    }

    private void getInput() {
        while(true){
            try{
                usr_input = scanner.nextInt();
                return;
            }catch (InputMismatchException e){
                System.out.println("Please only enter numeric values");
            }
        }
    }

}
