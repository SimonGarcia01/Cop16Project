package model;

public class Community {
    
    //Enumerations
    public enum Challenge{
        HOSPITALS,
        SCHOOLS,
        WATER,
        FOOD
    }

    public enum CommunityType {
        AFROCOLOMBIAN,
        INDIGENOUS,
        RAIZAL
    }

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


    //Constructor
    public Community(String name, String representantName, String representantPhone, 
    int population, Challenge challenge, CommunityType type) {
        this.name = name;
        this.representantName = representantName;
        this.representantPhone = representantPhone;
        this.population = population;
        this.challenge = challenge;
        this.type = type;
        this.products = new Product[20];
    }

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
