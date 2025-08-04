import java.util.Random;
import java.util.Scanner;

public class Rps {

    int points;
    char[] choices = {'r', 'p', 's'};
    int player_pts, comp_pts;
    String player_choice;
    char comp_choice;
    Random random;
    Scanner scanner;

    Rps(int pts){
        if(pts < 0){
            System.out.println("Points cannot be negative !");
            return;
        }
        if(pts < 3){
            System.out.println("Minimum no. of points is 3");
            return;
        }
        System.out.println(
                "Welcome to rock paper scissors, you will be competing against the computer for " + pts + " points"
        );
        this.points = pts;
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }
    public void run(){
        this.showInputs();
        while(comp_pts < this.points && player_pts < this.points){
            System.out.println("Its your turn");
            this.getUsrInput();
            comp_choice = choices[random.nextInt(0,choices.length - 1)];
            String temp = "";
            if(player_choice.charAt(0) == 'r'){temp = "rock";}
            if(player_choice.charAt(0) == 'p'){temp = "paper";}
            if(player_choice.charAt(0) == 's'){temp = "scissor";}
            if(comp_choice == player_choice.charAt(0)){
                System.out.println("The computer also picked " + temp + " its a draw");
            }else{
                if(temp.equals("rock")){
                    if(comp_choice == 'p'){
                        this.changePlayerPts("paper", -1);
                        this.comp_pts++;
                    }else{
                        this.changePlayerPts("scissor", 1);
                    }
                }
                if(temp.equals("paper")){
                    if(comp_choice == 'r'){
                        this.changePlayerPts("rock", 1);
                    }else{
                        this.changePlayerPts("scissor", -1);
                        this.comp_pts++;
                    }
                }
                if(temp.equals("scissor")){
                    if(comp_choice == 'r'){
                        this.changePlayerPts("rock", - 1);
                        this.comp_pts++;
                    }else{
                        this.changePlayerPts("paper", 1);
                    }
                }
            }
        }
        if(this.comp_pts >= this.points){
            System.out.println("Well looks like you lost, it was fair game though, maybe next time you will win.");
        }else{
            System.out.println("Yay you won, you beat the computer, maybe AI won't take over after all !!");
        }
    }

    // NOTE: num will only be 1 or -1
    private void changePlayerPts(String picked, int num){
        System.out.print("The computer picked " + picked);
        if(num < 0){
            System.out.print(" , you lost a point :(");
        }else{
            System.out.print(" , you won a point :>)");
        }
        System.out.println();
        this.player_pts += num;
    }


    private void getUsrInput(){
        while(true){
            player_choice = this.scanner.nextLine();
            if(!(player_choice.length() == 1)){
                System.out.println("Invalid input");
                continue;
            }
            for(char c : choices){
                if(c == player_choice.charAt(0)){
                    return;
                }
            }
            System.out.println("Please only enter r/p/s for rock, paper, scissor");
        }
    }

    private void showInputs(){
        System.out.println("r/R = rock");
        System.out.println("p/P = paper");
        System.out.println("s/S = scissor");
    }
}
