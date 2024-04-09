package model;

public class Community {

    //Attributes
    private String name;
    private String representantName;
    private String representantPhone;
    private int population;
    private Challenge[] challenges;
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
                products[space] = newProduct;
                message = "The product has been added successfully to the community's inventory.";
            }

        }

        return message;
    }

    //CHANGE AN INT TO A COMMUNITY
    /**
    * <p><b>deleteProduct</b></p>
    * <b>Description:</b> Deletes a product from the community based on the specified product index.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code intProduct} must be an int representing a valid index of a product within the community.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The product at the specified index is removed from the community, and a success message is returned.</li>
    * </ul>
    * 
    * @param intProduct The index of the product to be deleted from the community.
    * @return A message indicating that the product was successfully deleted.
    */   
    public String deleteProduct(int intProduct){
        String message = "";

        products[intProduct-1]=null;
        message = "Product deleted Successfully from the community.";

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
    * <p><b>getProductTypes</b></p>
    * <b>Description:</b> Retrieves an array containing descriptions of all product types available.
    * The String[] is retrieved from {@link Product#getProductTypes()}.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code getProductTypes} method in the {@link Product} class must be implemented.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A String array holding all the descriptions representing the product types is returned.</li>
    * </ul>
    * 
    * @return A string[] holding all the descriptions representing the product types.
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
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                return i;
            }
        }
        //If there is no more space, a -1 will be returned
        return -1;
    }   

    //SEARCH IF THERE IS ATLEAST ONE PRODUCT
    /**
    * <p><b>oneMinProduct</b></p>
    * <b>Description:</b> Checks if at least one product was registered already.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Array} of products must already exist.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A boolean value indicating if the first position in the products array is occupied or not is returned.</li>
    * </ul>
    * 
    * @return {@code true} if the first position of the products array is filled, {@code false} otherwise.
    */      
    public boolean oneMinProduct() {
        boolean oneProduct = false;

        if(products[0] != null){
            oneProduct = true;
        }

        return oneProduct;
    }

    //DISPLAY ALL CURRENTLY SAVED PRODUCTS
    /**
    * <p><b>displayProducts</b></p>
    * <b>Description:</b> Concatenates and returns a string that holds all the descriptions of the products within the community.
    * It iterates through the products array, assigns a number to each product, and extracts the product names.
    * It makes sure that no null product is passed on to prevent a Null Exception.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li> {@code products} must be in place and initialized.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A String holding all the numbered product names in order will be returned.</li>
    * </ul>
    * 
    * @return A String containing all the numbered product names within the community.
    */
    public String displayProducts(){
        String message = "Products within the Community:\n\t";

        for(int i = 0; i < products.length; i++){

            if(products[i]!=null){
                message += (i + 1) + ". " + products[i].getName() + "\n\t";
            }
        }

        return message;
    }

    //CONSTRUCTOR
    /**
    * <p><b>Community</b></p>
    * <b>Description:</b> Initializes and creates an instance of Community. 
    * The name, representantName, representantPhone, and population are used exactly as they are entered.
    * For intType, it is first converted to a CommunityType literal.
    * For the intChallenge array it is converted into a Challenges array.
    *	
    * <p><b>Preconditions:</b></p>
    * <ul>
    *     <li>{@code name} must be a String.</li>
    *     <li>{@code representantName} must be a String.</li> 
    *     <li>{@code representantPhone} must be a String.</li>   
    *     <li>{@code population} must be an int.</li>
    *     <li>{@code chosenChallenges} must be an array of integers representing the selected challenges for the community (1 for selected, 0 for not selected).</li>
    *     <li>{@code intType} must be an int between 1 and 3 representing the chosen option from the list of CommunityType descriptions.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *     <li>An instance of Community is created with all the necessary parameters.</li>
    * </ul>
    *
    * @param name The name of the Community.
    * @param representantName The name of the person that represents the community.
    * @param representantPhone The phone number of the community's representant.
    * @param population The number of people that live in the community.
    * @param chosenChallenges An array representing the selected challenges for the community (1 for selected, 0 for not selected).
    * @param intType The chosen option from the list of CommunityType descriptions.
    */
    public Community(String name, String representantName, String representantPhone, 
    int population, int[] chosenChallenges, int intType) {
        this.name = name;
        this.representantName = representantName;
        this.representantPhone = representantPhone;
        this.population = population;

        Challenge[] selectedChallenges = new Challenge[4];

        for(int i = 0; i < chosenChallenges.length;i++){
            selectedChallenges[i] = Challenge.intToChallenge(chosenChallenges[i]);
        }

        this.challenges = selectedChallenges;
        this.type = CommunityType.intToCommunityType(intType);
        this.products = new Product[20];
    }


    //SETTERS AND GETTERS
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

    /**
    * <p><b>setName</b></p>
    * <b>Description:</b> Sets the name of the community to the provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code name} must be a non-null String.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The name of the community is updated to the provided value.</li>
    * </ul>
    *
    * @param name The new name for the community.
    */  
    public void setName(String name) {
        this.name = name;
    }

    /**
    * <p><b>getRepresentantName</b></p>
    * <b>Description:</b> Retrieves the name of the representative associated with the community.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The name of the representative associated with the community is returned.</li>
    * </ul>
    * 
    * @return The name of the representative associated with the community.
    */
    public String getRepresentantName() {
        return representantName;
    }

    /**
    * <p><b>setRepresentantName</b></p>
    * <b>Description:</b> Sets the name of the representative associated with the community.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code representantName} must be a non-null String.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The name of the representative associated with the community is updated to the provided value.</li>
    * </ul>
    *
    * @param representantName The new name of the representative associated with the community.
    */  
    public void setRepresentantName(String representantName) {
        this.representantName = representantName;
    }

    /**
    * <p><b>getRepresentantPhone</b></p>
    * <b>Description:</b> Retrieves the phone number of the representative associated with the community.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The phone number of the representative associated with the community is returned.</li>
    * </ul>
    * 
    * @return The phone number of the representative associated with the community.
    */   
    public String getRepresentantPhone() {
        return representantPhone;
    }

    /**
    * <p><b>setRepresentantPhone</b></p>
    * <b>Description:</b> Sets the phone number of the representative associated with the community.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code representantPhone} must be a non-null String.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The phone number of the representative associated with the community is updated to the provided value.</li>
    * </ul>
    *
    * @param representantPhone The new phone number of the representative associated with the community.
    */ 
    public void setRepresentantPhone(String representantPhone) {
        this.representantPhone = representantPhone;
    }

    /**
    * <p><b>getPopulation</b></p>
    * <b>Description:</b> Retrieves the population of the community.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The population of the community is returned.</li>
    * </ul>
    * 
    * @return The population of the community.
    */
    public int getPopulation() {
        return population;
    }

    /**
    * <p><b>setPopulation</b></p>
    * <b>Description:</b> Sets the population of the community.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code population} must be an integer.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The population of the community is updated to the provided value.</li>
    * </ul>
    *
    * @param population The new population of the community.
    */  
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
    * <p><b>getType</b></p>
    * <b>Description:</b> Retrieves the type of the community.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The type of the community is returned.</li>
    * </ul>
    * 
    * @return The type of the community.
    */    
    public CommunityType getType() {
        return type;
    }

    /**
    * <p><b>setType</b></p>
    * <b>Description:</b> Sets the type of the community.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code type} must be a non-null instance of CommunityType.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The type of the community is updated to the provided value.</li>
    * </ul>
    *
    * @param type The new type of the community.
    */      
    public void setType(CommunityType type) {
        this.type = type;
    }


    //No need for a setter for products because they will be added by another method
    /**
    * <p><b>getProducts</b></p>
    * <b>Description:</b> Retrieves the array of Products associated with the community.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>An array containing the Products associated with the community is returned.</li>
    * </ul>
    * 
    * @return An array of Products associated with the community.
    */   
    public Product[] getProducts() {
        return products;
    }
    
    //No neeed for setter because the way to enter the challenges is done by another method
    /**
    * <p><b>getChallenge</b></p>
    * <b>Description:</b> Retrieves the array of challenges associated with the community.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>An array containing the challenges associated with the community is returned.</li>
    * </ul>
    * 
    * @return An array of challenges associated with the community.
    */    
    public Challenge[] getChallenge() {
        return challenges;
    }

}
