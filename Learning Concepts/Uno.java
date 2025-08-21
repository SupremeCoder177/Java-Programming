import java.util.*;

public class Uno {

    private String[] cards = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Reverse", "Skip", "+2"};
    private String[] colors = {"Red", "Blue", "Green", "Yellow"};
    private String[] specialCards = {"+4", "Color Change"};
    private final int num_cards = (cards.length * colors.length * 2) + specialCards.length * 2;
    private final int start_cards = 7;
    private String[][] deck;
    private  Random random;
    private Scanner scanner;

    List<String[]> playerInven;
    List<String[]> compInven;
    String[] top_card;

    Uno(){
        this.deck = new String[num_cards][2];
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        this.top_card = new String[2];
        this.playerInven = new ArrayList<>();
        this.compInven = new ArrayList<>();
        this.genDeck();
        this.getTopCard();
    }

    public void start(){
        System.out.println("Starting game...");
        System.out.println("Distributing Cards...");
        this.addCards(playerInven, start_cards);
        this.addCards(compInven, start_cards);
        while(!playerInven.isEmpty() && !compInven.isEmpty()){
            this.getPlayerInput();
        }
    }

    private void getTopCard(){
        int temp;
        while(true) {
            temp = this.random.nextInt(0, this.deck.length);
            if(this.deck[temp][0] != null) {
                this.top_card[0] = this.deck[temp][0];
                this.top_card[1] = this.deck[temp][1];
                break;
            }
        }
    }

    private void addCards(List<String[]> inven, int num){
        inven.addAll(this.getCards(num));
    }

    private void showPlayerInven(){
        for(int i = 0; i < playerInven.size(); ++i){
            System.out.println((i + 1) + " " + this.playerInven.get(i)[0] + " " + this.playerInven.get(i)[1]);
        }
    }

    private void getPlayerInput(){
        while(true){
            this.showPlayerInven();
            System.out.println("Enter the index of the card you want to use.");
            System.out.println("Enter 100 if you want to draw a card.");
            try{
                int choice = this.scanner.nextInt();
                if(0 < choice && choice <= playerInven.size()){
                    break;
                }else{
                    System.out.println("Please only enter valid index.");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input !");
            }
        }
    }

    private List<String[]> getCards(int numOfCards){
        List<String[]> output = new ArrayList<>();
        for(int i = 0; i < numOfCards; ++i){
            while(true) {
                int temp = random.nextInt(0, this.deck.length);
                String[] chosen = this.deck[temp];
                if(!chosen[1].isEmpty()) {
                    output.add(this.deck[temp]);
                    this.deck[temp][1] = "";
                    break;
                }
            }
        }
        for(String[] card: output){
            System.out.println(card[0] + card[1]);
        }
        return output;
    }

    private void genDeck(){
        int count = 0;
        for(String card : cards){
            for(String color : colors){
                this.deck[count][0] = color;
                this.deck[count][1] = card;
                this.deck[count + 1][0] = color;
                this.deck[count + 1][1] = card;
                count += 2;
            }
        }
        for(String card : specialCards){
            this.deck[count][1] = card;
            this.deck[count + 1][1] = card;
            count += 2;
        }
    }
}
