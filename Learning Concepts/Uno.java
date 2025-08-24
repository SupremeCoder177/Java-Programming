import java.util.*;

public class Uno {

    private final String[] cards = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Reverse", "Skip", "+2"};
    private final String[] colors = {"Red", "Blue", "Green", "Yellow"};
    private final String[] specialCards = {"+4", "Color Change"};
    private final int num_cards = (cards.length * colors.length * 2) + specialCards.length * 2;
    private final int start_cards = 7;
    private String[][] deck;
    private Random random;
    private Scanner scanner;
    private String curr_player;
    private boolean player_drawn = false;
    private boolean comp_drawn = false;
    private int plusFourThrown = 0;

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
            player_drawn = false;
            curr_player = "player";
            this.getPlayerInput();
            curr_player = "comp";
            comp_drawn = false;
            this.getCompCard();
        }
        if(playerInven.isEmpty()){
            System.out.println("You won the game !! ;>)");
            System.out.println("Goodbye !...");
        }else{
            System.out.println("Oh no you lost !");
            System.out.println("Don't worry you will get the computer next time 👍");
        }
        this.scanner.close();
    }

    //generates a random top card
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

    //add a given amount of cards to the inventory given
    private void addCards(List<String[]> inven, int num){
        inven.addAll(this.getCards(num));
    }

    private void showTopCard(){
        System.out.println("The top card is :");
        if(this.top_card[0] != null) {
            System.out.println(this.top_card[0] + " " + this.top_card[1]);
        }else{
            System.out.println(this.top_card[1]);
        }
    }


    //shows the player inventory on the console
    private void showPlayerInven(){
        System.out.println("Your hand:");
        for(int i = 0; i < playerInven.size(); ++i){
            if(this.playerInven.get(i)[0] != null) {System.out.println((i + 1) + " " + this.playerInven.get(i)[0] + " " + this.playerInven.get(i)[1]);}
            else{
                System.out.println((i + 1) + " " + this.playerInven.get(i)[1]);
            }
        }
    }

    //gets player input
    private void getPlayerInput(){
        if(this.playerInven.isEmpty()){
            return;
        }
        int choice;
        while(true){
            System.out.println();
            this.showPlayerInven();
            this.showTopCard();
            System.out.println("Enter the index of the card you want to use.");
            System.out.println("Enter 100 if you want to draw a card and enter 101 if you want to see inventory again.");
            System.out.print(">");
            try{
                choice = this.scanner.nextInt();
                if(0 < choice && choice <= playerInven.size()){
                    break;
                }
                else if(choice == 100){
                    if(!player_drawn){
                        System.out.println("Taking a card from the deck.....");
                        this.addCards(this.playerInven, 1);
                        System.out.println("Added a card..");
                        player_drawn = true;
                    }else{
                        System.out.println("You have already taken a card from the deck !!");
                    }
                }
                else if(choice == 0 && player_drawn){
                    System.out.println("OK skipping turn....");
                    break;
                }
                else if(choice == 101){
                    continue;
                }
                else{
                    System.out.println("Please only enter valid index.");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input !");
                this.scanner.nextLine();
            }
        }
        if(choice == 0) return;
        this.checkChoice(this.playerInven.get(choice - 1));
        boolean temp = this.applyCardEffect(this.playerInven.get(choice - 1));
        this.setTopCard(this.playerInven.get(choice - 1));
        this.playerInven.remove(choice - 1);
        if(temp){this.getPlayerInput();}
    }

    private void getCompCard(){
        if(this.compInven.isEmpty()){
            return;
        }
        if(this.comp_drawn){
            String[] card = this.compInven.getLast();
            boolean use = false;
            if(card[0] == (null)){use = true;}
            if(card[0] != null && card[0].equals(this.top_card[0])){use = true;}
            if(use){
                System.out.println("The computer used the card they drew.");
                this.applyCardEffect(card);
                this.setTopCard(this.compInven.removeLast());
            }
            return;
        }

        boolean hasColor = false;
        boolean hasSpecial = false;
        int choice = 0;
        for(String[] card: this.compInven){
            if(card[0] == null){hasSpecial = true; continue;}
            if(card[0].equals(this.top_card[0])){hasColor = true;}
        }
        if(hasColor){
            for(int i = 0; i < this.compInven.size(); i++){
                if(this.compInven.get(i)[0].equals(this.top_card[0])){
                   choice = i;
                   break;
                }
            }
        }else{
            if(hasSpecial){
                for(int i = 0; i < this.compInven.size(); ++i){
                    if(this.compInven.get(i)[0].equals(null)){
                        choice = i;
                        break;
                    }
                }
            }else{
                choice = 100;
            }
        }
        System.out.println();
        System.out.println("It's the computer's turn.");
        if(choice != 100){
            System.out.println("The computer has chosen " + this.compInven.get(choice)[0] + " " + this.compInven.get(choice)[1]);
            boolean temp = this.applyCardEffect(this.compInven.get(choice));
            this.setTopCard(this.compInven.get(choice));
            this.compInven.remove(choice);
            if(temp){this.getCompCard();}
        }else{
            System.out.println("The computer has taken a card from the stack.");
            this.addCards(this.compInven, 1);
            this.comp_drawn = true;
            this.getCompCard();
        }
    }

    private void checkChoice(String[] choice){
        if(choice[0] == null){
            return;
        }
        if(this.top_card[0] == null || this.top_card[1] == null){
            return;
        }
        if(!choice[0].equals(this.top_card[0]) && !choice[1].equals(this.top_card[1])){
            if(!player_drawn) {
                System.out.println();
                System.out.println("The color of the chosen card should match the color of the top card\nor the number of the top card, if you don't have a matching card then try taking a card from the deck.");
                this.getPlayerInput();
            }else{
                System.out.println();
                System.out.println("This card is invalid, you have already taken a card from the deck, enter 0 to skip your turn, or choose a valid card.");
                this.getPlayerInput();
            }
        }
    }

    private boolean applyCardEffect(String[] card){
        if(card[0] == null){
            if(card[1].equals("+4")){
                this.plusFourThrown++;
                this.plusFour();
            }else{
                this.colorChange();
            }
            return false;
        }else{
           if(card[1].equalsIgnoreCase("reverse") || card[1].equalsIgnoreCase("skip")){
                this.skipChance();
                return true;
           }
           if(card[1].equalsIgnoreCase("+2")){
               this.plusTwo();
               return true;
           }
        }
        return false;
    }

    private void plusFour(){
        if(!this.checkCounter()){
            if(curr_player.equals("player")){
                System.out.println("You have used a plus four card ....");
                System.out.println("The computer got" + this.plusFourThrown * 4 + " cards !");
                this.addCards(this.compInven, this.plusFourThrown * 4);
            }
            else{
                System.out.println("The computer used a +4 !");
                System.out.println("You got " + this.plusFourThrown * 4 + " cards !!");
                this.addCards(this.playerInven, this.plusFourThrown * 4);
            }
            this.plusFourThrown = 0;
        }else{
            if(curr_player.equals("player")){
                System.out.println();
                System.out.println("You have used a plus four card ....");
                System.out.println("Oh no the computer used a +4 too !");
                System.out.println("You have a plus four in your inventory.");
                String choice;
                while(true){
                    System.out.print("Do you want to use it ?(Y/N)");
                    choice = this.scanner.next();
                    if(choice.length() == 1 && (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n"))){break;}
                    else{
                        System.out.println();
                        System.out.println("Please enter a valid choice !");
                        System.out.println();
                    }
                }
                if(choice.equalsIgnoreCase("y")){
                    this.playerInven.remove(new String[]{null, "+4"});
                    this.plusFourThrown++;
                    this.curr_player = "comp";
                }else{
                    System.out.println("Ok you are not using your counter.");
                }
            }else{
                this.plusFourThrown++;
                this.compInven.remove(new String[]{null, "+4"});
                this.curr_player = "player";
            }
            this.applyCardEffect(new String[]{null, "+4"});
        }
    }

    private String chooseColor() {
        int temp;
        if (curr_player.equals("player")) {
            while (true) {
                System.out.println("Choose a color:");
                for (int i = 0; i < colors.length; ++i) {
                    System.out.println((i + 1) + " " + colors[i]);
                }
                try {
                    temp = this.scanner.nextInt();
                    if(0 < temp && temp <= this.colors.length){break;}
                    else{
                        System.out.println();
                        System.out.println("Please enter a valid index !");
                        System.out.println();
                    }
                }catch (InputMismatchException e){
                    this.scanner.nextLine();
                    System.out.println("Invalid input !");
                }
            }
        }else{
            temp = random.nextInt(1, this.colors.length + 1);
        }
        return this.colors[temp - 1];
    }

    private void colorChange(){
        String color = this.chooseColor();
        this.setTopCard(new String[]{color, null});
        System.out.println();
        if(this.curr_player.equals("player")){
            System.out.println("Ok set the top color to what you chose.");
        }
        else{
            System.out.println("The computer used a color change, the top card's color has been changed.");
        }
        System.out.println();
    }

    private void skipChance(){
        if(this.curr_player.equals("player")){
            System.out.println("The computer's chance got skipped.");
        }else{
            System.out.println("Your chance got skipped !");
        }
    }

    private void plusTwo(){
        if(this.curr_player.equals("player")){
            System.out.println("The computer got two cards and their chance got skipped .");
            this.addCards(this.compInven, 2);
        }else{
            System.out.println("You got 2 cards, and your chance got skipped.");
            this.addCards(this.playerInven, 2);
        }
    }

    private boolean checkCounter(){
        if(curr_player.equals("player")){
            for(String[] card: this.compInven){
                if(card[1].equals("+4")){
                    return true;
                }
            }
        }
        if(curr_player.equals("comp")){
            for(String[] card: this.playerInven){
                if(card[1].equals("+4")){
                    return true;
                }
            }
        }
        return false;
    }

    private List<String[]> getCards(int numOfCards){
        List<String[]> output = new ArrayList<>();
        if(this.deck.length < numOfCards) this.genDeck();
        for(int i = 0; i < numOfCards; ++i){
            while(true) {
                int temp = random.nextInt(0, this.deck.length);
                String[] chosen = this.deck[temp];
                if(!chosen[1].isEmpty()) {
                    output.add(new String[]{chosen[0], chosen[1]});
                    this.deck[temp][1] = "";
                    break;
                }
            }
        }
        return output;
    }

    private void setTopCard(String[] card){
        this.top_card[0] = card[0];
        this.top_card[1] = card[1];
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