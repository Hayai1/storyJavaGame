
public class Ending {
    private String dialogue;
    private Item itemRequirement;
    private String description;

    private boolean hasItemRequirement = false;
    private boolean hasKnowledgeRequirement = false;

    public Ending(String dialogue, String description){
        this.dialogue = dialogue;
        this.description = description;
    }
    public Ending(String dialogue, String description, Item itemRequirement){
        this.dialogue = dialogue;
        this.description =description;
        this.itemRequirement = itemRequirement;
        this.hasItemRequirement = true;
    }
    public Ending(String dialogue, String description, boolean knowledgeRequirement){
        this.dialogue = dialogue;
        this.description = description;
        this.hasKnowledgeRequirement = knowledgeRequirement;
    }
    public Ending(String dialogue, String description, Item itemRequirement, boolean knowledgeRequirement){
        this.dialogue = dialogue;
        this.description = description;
        this.itemRequirement = itemRequirement;
        this.hasItemRequirement = true;
        this.hasKnowledgeRequirement = knowledgeRequirement;
    }
    public String getDescription(){
        return description;
    }
    public boolean hasItemRequirement(){
        return hasItemRequirement;
    }
    public boolean hasKnowledgeRequirement(){
        return hasKnowledgeRequirement;
    }
    public Item getItemRequirement(){
        return itemRequirement;
    }
    public String getEnding(){
        return dialogue;
    }
}
