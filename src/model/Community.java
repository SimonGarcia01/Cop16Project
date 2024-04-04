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

    //ADD A PRODUCT TO A COMMUNITY
    /**
    * <p><b>addProduct</b></p>
    * <b>Description:</b> Uses the entered product to then save in the producs array and returns a success message. 
    * First, it checks if there is a duplicate product with the same name already existing within the community. If so, a duplicate message is returned.
    * Second, it checks if there is space to register a new product within the community. If not, a no space message will be returned.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code newProduct} must be a valid instance of Product. Non-null.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>If a product with the same name already exists within the community, a duplicate message is returned.</li>
    *   <li>If there is no more space to register a new product within the community, a no space message is returned.</li>
    *   <li>Otherwise, the new product is added to the products array, and a success message is returned.</li>
    * </ul>
    * 
    * @param newProduct The product instance to be added to the community.
    * @return A message stating if the product was added successfully or not (stating the reason if it wasn't successful).
    */
    public String addProduct(Product newProduct){
        String message = "";

        boolean duplicate = searchProduct(newProduct.getName());

        if(duplicate){
            message = "A product with that name already exist within the community.";
        } else {

            int space = availableProduct();

            if (space == -1){
                message = "There is no more space to register a new product within the community.";
            } else {
                this.products[space] = newProduct;
                message = "The place has been registered successfully.";
            }

        }

        return message;
    }

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
    public static String[] getProductTypes(){
        return Product.getProductTypes();
    }



    //SEARCH METHODS

    /**
    * <p><b>searchProduct</b></p>
    * <b>Description:</b> Verifies if the entered product name already exists in the array of products. 
    * It will loop through all the existing products and check if the name matches the entered product name.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Array} holding the products must already exist.</li>
    *   <li>{@code productName} has to be a String.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A boolean indicating if a duplicate was found or not.</li>
    * </ul>
    * 
    * @param productName The name of the product to be searched for in the products array.
    * @return A boolean indicating if there is a duplicate or not.
    */

    public boolean searchProduct(String productName){

        boolean duplicate = false;

        for (Product product : products) {
            if (product != null && product.getName().equals(productName)) {
                duplicate = true;
            }
        }

        return duplicate;
    }

    //AVAILABLE SPACE METHODS

/**
* <p><b>availableProduct</b></p>
* <b>Description:</b> Verifies if there is an empty space in the array of products in order to save another product afterwards. 
* It will loop through the products array and check if each element is equal to null. If an element is null, it returns the index of that element.
* If there are no null elements, it will return -1.
* 
* <p><b>Preconditions:</b></p>
* <ul>
*   <li>{@code Array} holding the products must already exist.</li>
* </ul>
* 
* <p><b>Postconditions:</b></p>
* <ul>
*   <li>An int holding the index of the last null element in the products array will be returned. If there is no more space, -1 will be returned instead.</li>
* </ul>
* 
* @return An int holding the index of the last null element in the products array (if there is no more space, -1 will be returned).
*/
    public int availableProduct(){
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] == null) {
                return i;
            }
        }
        //If there is no more space, a -1 will be returned
        return -1;
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
