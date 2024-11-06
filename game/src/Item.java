
public class Item {
    private String name;
    private String optionText;
    private Item requirement;
    private Area exit;
    public Item(String name, String optionText, Item requirement, Area exit){
        this.name = name;
        this.requirement = requirement;
        this.optionText = optionText;
        this.exit = exit;
        
    }
    public Item(String name, String optionText, Area exit){
        this.name = name;
        this.optionText = optionText;
        this.exit = exit;
        
    }
    public Item(String name, String optionText, Item requirement){
        this.name = name;
        this.optionText = optionText;
        this.requirement = requirement;
        
    }
    public Item(String name, String optionText){
        this.name = name;
        this.optionText = optionText;
    }
    
    public String getName(){
        return name;
    }
    public String getOptionText(){
        return optionText;
    }
    public Item getItemRequirement(){
        return requirement;
    }
    public Area getExit(){
        return exit;
    }
    public void addExit(Area exit){
        this.exit = exit;
    }
}
