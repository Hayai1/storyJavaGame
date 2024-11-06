package com.example;

public class Character{
    private String name;
    private String outsideDescription;
    private String preTrustDiaLogue;
    private String postTrustDialogue;
    private String nonTrustDialogue;
    private Area trustLocation;
    private Area nonTrustLocation;
    private boolean givesKnowledge;
    public Character(String name, String outsideDescription, String preTrustDiaLogue, String postTrustDialogue, String nonTrustDialogue, Area trustLocation, Area nonTrustLocation){
        this.name = name;
        this.outsideDescription = outsideDescription;
        this.preTrustDiaLogue = preTrustDiaLogue;
        this.postTrustDialogue = postTrustDialogue;
        this.trustLocation = trustLocation;
        this.nonTrustDialogue = nonTrustDialogue;
        this.givesKnowledge = false;
    }
    public Character(String name, String outsideDescription, String preTrustDiaLogue, String postTrustDialogue, String nonTrustDialogue, Area trustLocation, Area nonTrustLocation, boolean givesKnowledge){
        this.name = name;
        this.outsideDescription = outsideDescription;
        this.preTrustDiaLogue = preTrustDiaLogue;
        this.postTrustDialogue = postTrustDialogue;
        this.trustLocation = trustLocation;
        this.nonTrustDialogue = nonTrustDialogue;
        this.givesKnowledge = givesKnowledge;
    }
    public String getName(){
        return name;
    }
    public String getPreTrustDialogue(){
        return preTrustDiaLogue;
    }

    public String getPostTrustDialogue(){
        return postTrustDialogue;
    }
    public String getOutsideDescription(){
        return outsideDescription;
    }
    public String meetCharacter(){
        return preTrustDiaLogue;
    }
    public Area getTrustLocation(){
        return trustLocation;
    }
    public Area getnonTrustLocation(){
        return nonTrustLocation;
    }
    public String getnonTrustDialogue(){
        return nonTrustDialogue;
    }
    public boolean givesKnowledge(){
        return givesKnowledge;
    }
}
