package com.example;
import java.util.Scanner;

public class Game {
    private String gameName;
    private boolean running = true;
    private Inventory playerInventory;
    
    //game areas:
    private Area start;
    private Area outside;
    private Area underground;
    private Area tree;
    private Area monsterRoom;
    private Area cave;
    private Area house;
    private Area crossroad;

    //items
    private Item axe;
    private Item pickaxe;
    private Item key;
    private Item sword;

    //characters
    private Character shadyPerson;
    private Character nicePerson;

    //Endings
    private Ending transformationEnding;
    private Ending normalEnding;
    private Ending chopEnding;
    private Ending playerDeathEnding;
    private Ending monsterTearEnding;
    private Ending monsterDeathEnding;

    
    public Game(String gameName){
        this.gameName = gameName;
        //create items
        this.axe = new Item("Axe", "Pickup axe");
        this.pickaxe = new Item("Pickaxe", "Pickup pickaxe");
        this.key = new Item("Suspicious key", "Steal key", cave);
        this.sword = new Item("Sword", "Take the Sword", pickaxe);
        
        //create player inventory
        this.playerInventory = new Inventory(2);

        //create areas and characters
        this.tree = new Area("underground maple tree", "After a small hike through narrow tunnels, you are met with a juxtaposing huge cavern lit up by a gold-glowing maple tree in the center. \n Is this the tree you're trying to find? You see a path to with huge footprints leading into it. \n In the corner you just about spot a chest in the darkness.","press on following the roots", new Area[]{});      
        this.house = new Area("house", "You wander over to the house and walk through its opened door... you see a key with a tree-like emblem engraved on it,\n suddenly you hear a shout 'Hey! Who are you? do you reason with this person or take the key and run?'","inspect the house", new Item[]{key}, new Character[1]);
        this.monsterRoom = new Area("monster room", "You arrive at a huge cavern lit up by the bioluminesnce from the surrounding foliage.\n In the centre, a beast sits idly; the beast had a lion's head with white hair but sat up as though it were human." ,"cavern with signs to not enter",new Area[]{});
        this.cave = new Area("cave","As you trek through the cave, it's dark and dismal, but sparks of light keep catching your eyes.\n You power on feeling your way through until you find the source of the mysterious light. It's a sword in the stone. \n It glows in an odd way that draws the eyes in. You wonder how it could be released from the stone. you start to see roots coming from deeper within the tunnel, perhaps what your looking for is close" ,"cave with a small glow",new Area[]{tree}, new Item[]{sword});
        this.crossroad = new Area("crossroad", "The odd man takes you down the tight caving; finally you reach a crossroad and he says, 'Go down this way for the tree';\n he points to thick roots reaching from within. To your left, you spot another direction, although it was as dark as every other grotto.\n Each couple of seconds, a spark of light would flash from inside. What about the other way?' the odd man says, I wouldn't try it. I think there's something down there that people seem to get mad for.","crossroad", new Area[]{cave, tree});
        this.nicePerson = new Character("jan", "Reason with the shouting person", "You know it's rude to just stroll into someone's house. Are you looking for something...? the old maple tree... I see... well, I can take you there on the condition you test a theory of mine... A monster lurks down there, and I heard that it has some relation to the tree you're looking for. Put the monster to sleep by singing to it, then take its tears and rub them on the tree.", "Alright lets head out i'm counting on you... the oddly nice person takes you through his basement into the underground.\n You arrive at the tree 'well here we are i'll leave you to it' they wander away before you can say goodbye and thank them", "hey Don't take that!!", tree, cave, true);
        this.shadyPerson = new Character("charlie", "A shady figure with a black waste coat and a mask that covers half their face", "why hello there, that was a long fall you must be in search of the tree? Of course you are, i can show you where it is just follow me,\n hmm... who am I? i was like you once and i desire to cut down the blasted tree", "Very well lets go lets see what you choose", "ha ha smart, I wouldn't go down that way though with all the warning signs ha ha...", crossroad, monsterRoom);
        this.underground = new Area("underground","You wake up in the underground and scan for what little you can see in a cave-like surroundings.\n Theirs someone sitting over there? You also see an old pickaxe in the corner." ,"Open the dark door",new Area[]{monsterRoom}, new Item[]{pickaxe}, new Character[]{shadyPerson});
        this.outside = new Area("outside", "You walk through the left door and find yourself outside in a yellow grass field.\n beside you see an axe, in the slight distance a house and to the left a cave entrance with what seems to be a small shine coming from within", "open the door with light shining through",new Area[]{house, cave}, new Item[]{axe});
        this.start = new Area("starting room", "You wake up in a dark room, cobbled floor and hard brick walls.\n You notice a burning torch illuminating 2 doors, the left had light creeping from its cracks and the right only darkness, \n a message is written in white chalk in the middle of these two doors. The message reads 'reach the tree'. cryptic you think...","", new Area[]{outside, underground});
        
        //some circular depends
        this.house.setCharacters(new Character[]{nicePerson});
        this.key.addExit(cave);
        
        //create endings
        this.transformationEnding = new Ending("You slot the key into the key hole in the chest effortlessly, inside the chest you find a silver small mirror? Inspecting it you find it feels off wood... \n as you stare at your reflection wondering what to do you, see your hair starts growing and your skin turning harder it gets worse and worse. Moments later you look into the mirror again and see you've turned into a monster","Use the key to open the chest", key);
        this.normalEnding = new Ending("Approaching the tree you lightly touch it's trunk, it feels of wood but soft. The tree starts to glow you are reminded of all the memories you forgot when you woke up and you leave to return home", "Touch the tree?");
        this.chopEnding = new Ending("You edge closer to the beautful tree with an The Axe you found and start hacking away at the tree. Each blow to the trunk makes a glass shattering sound but you keep going until it falls down. The cavern suddenly goes pitch black. \n you slowly feel your way out and gaze over the outside and see a waste land", "Use the axe to chop the tree down", axe);
        this.playerDeathEnding = new Ending("You tread closer to the beast to see what it is but the monster spots you... you run as fast as your legs can but the it catches you with nothing to defend yourself it picks you up and swallows you in one gulp.", "walk closer");
        this.monsterTearEnding = new Ending("You try to remember the song you were taught as you head towards the apparent monster cave and see it standing in the middle of a huge opening. You control your breathing and start singing. It does not even turn its head, \n simply lies down, and falls asleep. After hearing its loud snores, you approach its face and collect its tears. You hastily head back to the tree to rub the tears on the tree. After doing so the tree glows immensely and starts to grow rapidly!!!\n your run and hear a crash it's breaking through the cavern ceiling!!! you climb the tree to get to the surface it grows further and further into the clouds.\n The man from earlier who helped you strolls over from the distance and says 'thank you... I believe we have not exchanged names yet my name is Jack'", "Put the monster to sleep for tears and rub them on the tree", true);
        this.monsterDeathEnding = new Ending("You look over to the warning signs and decide to be brave and march through. You reach the beast the warning signs were written for. It turns it's head instantly and starts running on all fours. You charge it with your sword infront of you and pierce it with all your might. It goes down and you leave the sword with the monster. Heading back to the tree it starts to wilt the ground beneath you shakes and you find all living things frozen solid", "Use the sword to kill the monster", sword);

        //set the endings to their specfic endings
        this.tree.setEndings(new Ending[]{this.transformationEnding, this.normalEnding, this.chopEnding, this.monsterTearEnding, this.monsterDeathEnding});
        this.monsterRoom.setEndings(new Ending[]{this.playerDeathEnding});
        }   
    public void Menu(){
        System.out.println("Welcome to "+ this.gameName);
        print("1. Start Game");
        print("2. info");
        print("3. Credits");
        print("4. Exit");
        String userChoice = input();
        switch (userChoice) {
            case "1":
                print("what is your name?");
                String name = input();     
                Start(name);        
                break;
            case "2":
                print("This is a " + this.gameName + " go through the story and choose your path to get to the your end");
                break;
            case "3":
                print("Created by: Dylan Hough");
                break;
            case "4":
                print("Goodbye");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public void Start(String name){
        Area location = this.start;
        int choice;
        Area[] exits;
        Item[] items;
        Character[] characters;
        Ending[] endings;
        boolean nextRoom;
        int counter;
        boolean itemsInRoom = false;
        int amountOfItems;
        int amountOfCharacters;
        int amountOfExits;
        while (running){
            nextRoom = false;
            print(location.getIntroduction());//enter room
            //get items, characters, exits, endings for current room
            exits = location.getExits();
            items = location.getItems();
            characters = location.getCharacters();
            endings = location.getEndings(playerInventory);
            while (!nextRoom){
                //print out options for user
                counter = 0;
                //print out exits
                if (exits != null){
                    for (Area exit : exits){
                        if (exit != null){
                            print((String.valueOf(counter) + ". " + exit.getOptionText()));
                            counter++;
                        }
                    }
                }
                //print out items
                if (items != null){
                    for (Item item : items){
                        if (item != null){
                            itemsInRoom = true;
                            print((String.valueOf(counter) + ". " + item.getOptionText()));
                            counter++;
                        }
                    }
                }
                else{
                    itemsInRoom = false;
                }
                //print out characters
                if (characters != null){
                    for (Character character : characters){
                        if (character != null){
                            print((String.valueOf(counter) + ". " + character.getOutsideDescription()));
                            counter++;
                        }
                    }
                }
                //print out endings
                if (location.hasEndings()){
                    for (Ending ending : endings){ 
                         if ((ending.hasItemRequirement())){
                            if (playerInventory.Contains(ending.getItemRequirement())){
                                print((String.valueOf(counter) + ". " + ending.getDescription()));
                                counter++;
                            }
                        }
                        else if (ending.hasKnowledgeRequirement()){
                            if (playerInventory.getKnowledge()){
                                print((String.valueOf(counter) + ". " + ending.getDescription()));
                                counter++;
                            }
                        }
                        else{
                            print((String.valueOf(counter) + ". " + ending.getDescription()));
                            counter++;
                        }
                        
                    }
                }
                Integer.toString(counter);
                choice = Integer.valueOf(input());//get the input from the user for what to do
                //get amount of items, exits, characters
                amountOfItems = 0;
                amountOfCharacters = 0;
                amountOfExits = 0;
                if (exits != null){ amountOfExits = exits.length; }
                if (items != null && items[0] != null) { amountOfItems = items.length; }
                if (characters != null) { amountOfCharacters = characters.length; }
                // find which option user chooses
                //exits
                if (choice <= amountOfExits-1){
                    location = exits[choice];
                    nextRoom = true;
                }
                //items
                else if (itemsInRoom && choice <= amountOfItems-1 + amountOfExits){
                    //pickup item
                    Item itemToAdd = items[choice - amountOfExits];
                    //if the item has a requirement check if the user has the item
                    if (itemToAdd.getItemRequirement() == null || playerInventory.Contains(itemToAdd.getItemRequirement())){
                        Area newlocation = playerInventory.add(itemToAdd);
                        //check if the item sends the user to a new room
                        if (newlocation != null){
                            nextRoom = true;
                            location = newlocation;
                        }
                        //if all the items are taken then record there are no items
                        if (amountOfItems-1 == 0){
                            items[choice-amountOfExits] = null;
                            amountOfItems = 0;
                            itemsInRoom = false;
                        }
                        //if there are more items avaliable then make a new item list without the item taken
                        else{
                            int itemListCounter = 0;
                            Item[] newItemList = new Item[amountOfItems-1];
                            for (Item item : items){
                                if (item != null){
                                    newItemList[itemListCounter] = item;
                                    itemListCounter++;
                                }
                            }
                            location.setItemList(newItemList);
                        }
                    }
                    //prompt the user that the item needs another item to be obtained
                    else{
                        print("hmm... you might need something to get this");
                    }
                }
                //characters
                else if (characters != null && choice <= amountOfCharacters-1 + amountOfItems + amountOfExits){
                    //get the character
                    Character character = characters[choice-amountOfExits-amountOfItems];
                    
                    //prompt the user to either trust the character or not trust the character
                    print(character.getPreTrustDialogue());
                    print("trust 0:yes 1:no");
                    choice = Integer.valueOf(input());
                    //if you trust the character they might give the user 'knowledge' and will take the user to another room
                    if (choice == 0){
                        if (character.givesKnowledge()){
                            playerInventory.setknowledge(true);
                        }
                        print(character.getPostTrustDialogue());
                        location = character.getTrustLocation();
                        nextRoom = true;                       
                    }
                    //if the user doesn't trust the character then the user is taken to a differnet Area
                    else{
                        print(character.getnonTrustDialogue());
                        location = character.getnonTrustLocation();
                        nextRoom = true;
                    }
                }
                //endings
                else{
                    //the game is finished as the user has selected an ending print the ending description and close the program
                    running = false;
                    print(location.getEndings(playerInventory)[choice-amountOfExits-amountOfItems-amountOfCharacters].getEnding());
                    break;
                }
                    
                
            }
            //if the next room isn't reached then loop through until so
            
        }   
    }
    private String input(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
    private void print(String msg){
        System.out.println(msg);
    }
    
}
