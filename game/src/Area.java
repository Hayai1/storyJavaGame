
/*
 * an area has exits, items and characters
 * when you enter a room it will have an introduction and marked as visted
 * 
 * if you go back to the room then you can it will simply say what exits and items there are
 */

public class Area {
    private String name;
    private String introduction;
    private String optionText;
    private Area[] exits;
    private Item[] items;
    private Character[] characters;
    private Ending[] endings; 

    private boolean hasEndings = false;
    public Area(String name, String introduction, String optionText, Area[] exits){
        this.name = name;
        this.introduction = introduction;
        this.optionText = optionText;
        this.exits = exits;
    }
    public Area(String name, String introduction, String optionText, Area[] exits, Item[] items){
        this.name = name;
        this.introduction = introduction;
        this.optionText = optionText;
        this.exits = exits;
        this.items = items;
    }
    public Area(String name, String introduction, String optionText, Area[] exits, Item[] items, Character[] characters){
        this.name = name;
        this.introduction = introduction;
        this.optionText = optionText;
        this.exits = exits;
        this.items = items;
        this.characters = characters;
    }
    public Area(String name, String introduction, String optionText, Area[] exits, Character[] characters){
        this.name = name;
        this.introduction = introduction;
        this.optionText = optionText;
        this.exits = exits;
        this.characters = characters;
    }
    public Area(String name, String introduction, String optionText, Item[] items, Character[] characters){
        this.name = name;
        this.introduction = introduction;
        this.optionText = optionText;
        this.items = items;
        this.characters = characters;
    }
    public String getName() { return name; }
    public String getIntroduction() { return introduction; }
    public Area[] getExits() { return exits; } 
    public Item[] getItems() { return items; }
    public Character[] getCharacters() { return characters; }
    public String getOptionText() { return optionText; }
    public Ending[] getEndings(Inventory inv) { 
        if (this.endings == null){
            return null;
        }
        Ending[] possibleEndings = new Ending[endings.length];
        int counter = 0;
        for (Ending ending : endings){
            if ((ending.hasItemRequirement())){
                if (inv.Contains(ending.getItemRequirement())){
                    possibleEndings[counter] = ending;
                    counter++;
                }
            }
            else if (ending.hasKnowledgeRequirement()){
                if (inv.getKnowledge()){
                    possibleEndings[counter] = ending;
                    counter++;
                }
            }
            else{
                possibleEndings[counter] = ending;
                counter++;
            }   
        }
        Ending[] possibleEndingsCleaned = new Ending[counter];
            for (int i = 0; i < counter; i++){
                possibleEndingsCleaned[i] = possibleEndings[i];
            }
        return possibleEndingsCleaned; 
    }
    public boolean hasEndings() { return this.hasEndings; }
    public void setItemList(Item[] items) { this.items = items; }
    public void setEndings(Ending[] endings) { 
        this.endings = endings; 
        this.hasEndings = true;
    }
    public void addExit(Area exit){
        for (int i = 0; i < this.exits.length; i++){
            if (exits[i] == null){
                exits[i] = exit;
            }
        }
    }
    public void setCharacters(Character[] characters) {
        this.characters = characters;
    }
}
