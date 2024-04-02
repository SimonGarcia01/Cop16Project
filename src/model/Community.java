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

    //TO GET THE INFO FROM ENUMERATIONS

    /**
	* <p><b>getChallenges</b></p>
	* <b>Description:</b> Extracts the array from Challenge holding every description associated to a Challenge literal and returns it.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code getChallenges} method in Challenge must be in place.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>An String array is returned holding the descriptions of every Literal. </li>
	* </ul>
    *
	* @return A string[] holding all the descriptions representing the Challenge literals.
	*/   
    public static String[] getChallenges(){
        return Challenge.getChallenges();
    }

    /**
	* <p><b>getCommunityTypes</b></p>
	* <b>Description:</b> Extracts the array from CommunityType holding every description associated to a Challenge literal and returns it.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code getCommunityTypes} method in CommunityType must be in place.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>An String array is returned holding the descriptions of every Literal. </li>
	* </ul>
	*
	* @return A string[] holding all the descriptions representing the CommunityType literals.
	*/    
    public static String[] getCommunityTypes(){
        return CommunityType.getCommunityTypes();
    }

    //CONSTRUCTOR
    /**
	* <p><b>Communty</b></p>
	* <b>Description:</b> Initializes and creates an instance of Community. 
    * The name, representantName,representantPhone, and population are used exactly as they are entered.
    * For intChallenge and intType, they are first converted to a Challenge and CommunityType literal first.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code name} must be a String.</li>
	* 	<li> {@code representantName} must be a String.</li> 
	* 	<li> {@code representantPhone} must be a String.</li>   
	* 	<li> {@code population} must be an int.</li>
	* 	<li> {@code intChallenge} must be an int between 1 and 4.</li>
	* 	<li> {@code population} must be an int between 1 and 3.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>An instance of Community is created with all the necessary parameters.</li>
	* </ul>
	*
	* @param name The name of the Community.
    * @param representantName The name of the person that represents the community.
    * @param representantPhone The phone number of the community's representant.
    * @param population The number of people that live in the community.
    * @param intChallenge The chosen option from the list of Challenge descriptions.
    * @param intType The chosen option from the list of CommunityType descriptions.
	*/
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


    //SETTER AND GETTERS
    
    /**
	* <p><b>getName</b></p>
	* <b>Description:</b> Allows the extraction of the name from a Community instance as a String.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code Null} search can't be done on a null object. Null Pointer Exception. </li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A String containing the name of a Community instance is returned. </li>
	* </ul>
	*
	* @return A String with the name of a Community instance.
	*/
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
