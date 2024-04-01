package model;

public class Community {

    //Attributes
    private String name;
    private String representantName;
    private String representantPhone;
    private int population;
    private Challenge challenge;
    private CommunityType type;
    
    //Relations
    private Product[] products;

    //Methods

    //To get the info from enumerations
    public static String[] getChallenges(){
        return Challenge.getChallenges();
    }

    public static String[] getCommunityTypes(){
        return CommunityType.getCommunityTypes();
    }

    //Constructor
    public Community(String name, String representantName, String representantPhone, 
    int population, int intChallenge, int intType) {
        this.name = name;
        this.representantName = representantName;
        this.representantPhone = representantPhone;
        this.population = population;
        this.challenge = Challenge.intToChallenge(intChallenge);
        this.type = CommunityType.intToCommunityType(intType);
        this.products = new Product[20];
    }

    //Enumeration selection


    //Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRepresentantName() {
        return representantName;
    }

    public void setRepresentantName(String representantName) {
        this.representantName = representantName;
    }

    public String getRepresentantPhone() {
        return representantPhone;
    }

    public void setRepresentantPhone(String representantPhone) {
        this.representantPhone = representantPhone;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    //To get the challenge from a community
    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public CommunityType getType() {
        return type;
    }

    public void setType(CommunityType type) {
        this.type = type;
    }


    //No need for a setter for products because they will be added by another method
    public Product[] getProducts() {
        return products;
    }
    

}
