import java.util.Random;

public class Uno {

    String[] cards = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Reverse", "Skip", "+2"};
    String[] colors = {"Red", "Blue", "Green", "Yellow"};
    String[] specialCards = {"+4", "Color Change"};
    int num_cards = (cards.length * colors.length * 2) + specialCards.length * 2;
    String[] deck;
    Random random;

    String[] playerInven;
    String[] compInven;

    Uno(){
        this.deck = new String[num_cards];
        this.random = new Random();
        this.genDeck();

    }

    String[] getCard(int numOfCards){
        String[] output = new String[numOfCards];
        for(int i = 0; i < numOfCards; ++i){
            while(true) {
                int temp = random.nextInt(0, this.deck.length);
                String chosen = this.deck[temp];
                if(!chosen.equals(" ")) {
                    output[i] = this.deck[temp];
                    this.deck[temp] = "";
                    break;
                }
            }
        }
        return output;
    }

    void genDeck(){
        int count = 0;
        for(String card : cards){
            for(String color : colors){
                this.deck[count] = color + " " + card;
                this.deck[count + 1] = color + " " + card;
                count += 2;
            }
        }
        for(String card : specialCards){
            this.deck[count] = card;
            this.deck[count + 1] = card;
            count += 2;
        }
    }
}
