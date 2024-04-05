package model;

import java.util.Calendar;

public class Controller {
    
    //Attributes

    //Relations
    Community[] communities;
    Place[] places;


    //Methods

    //MAIN METHODS
    //ADMINISTRATIVE MENU
    
    //EDITTT
/**
    * <p><b>registerCommunity</b></p>
    * <b>Description:</b> Initializes and creates an instance of Community, saves it in the communities array, and returns a success message. 
    * First, it is checked if there is a community with the same name already stored. If there is a duplicate, it returns a duplicate message.
    * Second, it checks if there is space to store a new Community in the array. If there is no space, a no space message will be returned.
    * Additionally, it constructs a String array to represent the challenges the community faces based on the provided yes/no inputs.
    *
    * <p><b>Preconditions:</b></p>
    * <ul>
    *     <li>{@code name} must be a String.</li>
    *     <li>{@code representantName} must be a String.</li> 
    *     <li>{@code representantPhone} must be a String.</li>   
    *     <li>{@code population} must be an int.</li>
    *     <li>{@code hospitals} must be a String ("yes" or "no").</li>
    *     <li>{@code schools} must be a String ("yes" or "no").</li>
    *     <li>{@code water} must be a String ("yes" or "no").</li>
    *     <li>{@code food} must be a String ("yes" or "no").</li>
    *     <li>{@code intType} must be an int between 1 and 3.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *     <li>An instance of Community is created with all the necessary parameters, stored in the communities array, and a success message is returned.</li>
    *     <li>If there is a community with the same name already stored, a duplicate message is returned instead.</li>
    *     <li>If there is no space to store a new community in the array, a no space message will be returned.</li>
    *     <li>A String array is constructed representing the challenges faced by the community based on the provided yes/no inputs.</li>
    * </ul>
    *
    * @param name The name of the Community.
    * @param representantName The name of the person that represents the community.
    * @param representantPhone The phone number of the community's representant.
    * @param population The number of people that live in the community.
    * @param hospitals Whether the community has an absence of hospitals ("yes" or "no").
    * @param schools Whether the community has a lack of schools ("yes" or "no").
    * @param water Whether the community has inadequate access to clean water ("yes" or "no").
    * @param food Whether the community has insufficient access to food ("yes" or "no").
    * @param intType The chosen option from the list of CommunityType descriptions.
    * @return A message stating if the community was registered successfully or not (stating the reason if it wasn't successful).
    */
    public String registerCommunity(String name, String representantName, String representantPhone, 
    int population, String hospitals, String schools, String water, String food, int intType){
        String message = "";

        int chosenChallenges[] = new int[4];
            
        if(hospitals.equalsIgnoreCase("yes")) {
            chosenChallenges[0] = 1; 
        }
        if(schools.equalsIgnoreCase("yes")) {
            chosenChallenges[1] = 2; 
        }
        if(water.equalsIgnoreCase("yes")) {
            chosenChallenges[2] = 3; 
        }
        if(food.equalsIgnoreCase("yes")) {
            chosenChallenges[3] = 4; 
        }


        boolean duplicate = searchCommunity(name);

        if(duplicate){
            message = "A community with that name already exists.";
        } else {

            int space = availableCommunity();

            if (space == -1){
                message = "There is no more space to register a new community.";
            } else {
                communities[space] = new Community(name, representantName, representantPhone, 
                population, chosenChallenges, intType);
                message = "The community has been registered successfully.";
            }

        }

        return message;
    }

    /**
	* <p><b>registerPlace</b></p>
	* <b>Description:</b> Initializes and creates an instance of Place, saves it in the places array and returns a success message. 
    * First, it checks if there is atleast one community registered. If not, a no prexistent community message is returned.
    * Second, it changes the int option entered for community and then extracts the entire community.
    * Third, it is checked if there is a place with the same name already stored. If there is a duplicate it returns a duplicate message.
	* Finally, It checks if there is space to store a new placein the array. If there is no space a no space message will be returend.
    *
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code intCommunity} must be a int.</li>
	* 	<li> {@code placeName} must be a String.</li> 
	* 	<li> {@code area} must be a double.</li>   
	* 	<li> {@code inaugurationDate} must be a Calendar Type.</li>
	* 	<li> {@code photo} must be a String.</li>
	* 	<li> {@code resources} must be a double.</li>
	* 	<li> {@code intDepartment} must be an int between 1 and 4.</li>
	* 	<li> {@code intType} must be an int between 1 and 3.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>An instance of place is created with all the necessary parameters, stored in the palces array and a success message is returned.</li>
    * 	<li>If there are no prexistent communities registered, a message will be returned.</li>
    * 	<li>If there is a palce with the same name already stored, a duplicate message is returned instead.</li>
	* 	<li>If there is no space to store a new place in the array, a no space message will be returned.</li>
	* </ul>
	*
	* @param intCommunity int the represents one of the options of the existing communities.
    * @param placeName The name of the place.
    * @param area The area that the place covers in km2.
    * @param inaugurationDate Date the the place is going to be inaugurated.
    * @param photo URL of a photo of the place. 
    * @param resources The amount of money that is invested in a places.
    * @param intDepartment int that represents one of the possible departments to be chosen from.
    * @param intType int that represents one of the possible place types to be chosen from.
    *
    * @return A message stating if the community was registered successfully or not (stating the reason if it wasn't successfull).
	*/    
    public String registerPlace(int intCommunity, String placeName, double area, Calendar inaugurationDate,
    String photo, double resources, int intDepartment, int intType){
        String message = "";

        boolean oneCommunity = oneMinCommunity();

        if(oneCommunity){

            Community caregivingCommunity = intToCommunity(intCommunity);

            boolean duplicate = searchPlace(placeName);

            if(duplicate){
                message = "A place with that name already exists.";
            } else {

                int space = availablePlace();

                if (space == -1){
                    message = "There is no more space to register a new place.";
                } else {
                    places[space] = new Place(placeName, area, inaugurationDate, photo, resources, 
                    intType, intDepartment, caregivingCommunity);
                    message = "The place has been registered successfully.";
                }

            }

        } else {
            message = "There is no community to select from. Register one, please.";
        }

        return message;
    }

    /**
    * <p><b>addProduct</b></p>
    * <b>Description:</b> Associates a new product with the specified community and returns a success message. 
    * First, it retrieves the community based on the provided index.
    * Then, it creates a new Product instance using the provided parameters.
    * Finally, it associates the new product with the specified community.
    *
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code intCommunity} must be an int representing an existing community.</li>
    *   <li>{@code productName} must be a non-null String.</li> 
    *   <li>{@code naturePercent} must be a double.</li>   
    *   <li>{@code handcraft} must be "yes" or "no" String.</li>
    *   <li>{@code intProductType} must be an int representing the type of the product.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A Product instance is created with all the necessary parameters, associated with the specified community, and a success message is returned.</li>
    * </ul>
    * 
    * @param intCommunity The index of the community where the product will be associated.
    * @param productName The name of the product.
    * @param naturePercent The percentage of natural products used to make the product.
    * @param handcraft Stating if the product was handcrafted or not
    * @param intProductType The type of the product.
    * @return A message stating if the product was added successfully or not. The appropiate message is returned after other checks in the {@link Community#addProduct(Product)} 
    */
    public String addProduct(int intCommunity, String productName, double naturePercent, 
    String handcraft, int intProductType){
        String message = "";

            Community productCommunity = intToCommunity(intCommunity);
            Product newProduct = new Product(productName, naturePercent, handcraft, intProductType);
            message = productCommunity.addProduct(newProduct);

        return message;
    }


    /**
    * <p><b>deleteProduct</b></p>
    * <b>Description:</b> Helps in the process of deleting a product from the specified community and returns a message indicating success or failure. 
    * The method retrieves the community based on the provided index and passes is on to {@link Community#deleteProduct(int)} to actually delete it.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code intCommunity} must be an int representing an existing community.</li>
    *   <li>{@code intProduct} must be an int representing an existing product within the community.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>If the product is successfully deleted, a success message is returned.</li>
    *   <li>If the specified community or product does not exist, an appropriate error message is returned.</li>
    * </ul>
    * 
    * @param intCommunity The index of the community from which the product will be deleted.
    * @param intProduct The index of the product to be deleted within the community.
    * @return A message indicating if the product was successfully deleted or not.
    */
    public String deleteProduct(int intCommunity, int intProduct){
        String message = "";

            Community productCommunity = intToCommunity(intCommunity);
            message = productCommunity.deleteProduct(intProduct);

        return message;
    }


    //SEARCH METHODS

    /**
	* <p><b>searchCommunity</b></p>
	* <b>Description:</b> Verifies if the entered community name already exists in the array of communities. It will loop along all the existing communities.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
    *   <li> {@code Array} holding the Communities must already exist.</li>
	* 	<li> {@code name} has to be a String.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A boolean stating if a duplicate was found or not.</li>
	* </ul>
	*
	* @param name the String entered for the community that wants to be registered. 
	* @return A boolean showing if there is a duplicate or not.
	*/

    public boolean searchCommunity(String name){

        boolean duplicate = false;

        for (Community community : communities) {
            if (community != null && community.getName().equals(name)) {
                duplicate = true;
            }
        }

        return duplicate;
    }

    /**
	* <p><b>searchPlace</b></p>
	* <b>Description:</b> Verifies if the entered place name already exists in the array of places. 
    * It will loop along all the existing places.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
    *   <li> {@code Array} holding the Communities must already exist.</li>
	* 	<li> {@code name} has to be a String.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A boolean stating if a duplicate was found or not.</li>
	* </ul>
	*
	* @param name the String entered for the place that wants to be registered. 
	* @return A boolean showing if there is a duplicate or not.
	*/

    public boolean searchPlace(String name){

        boolean duplicate = false;

        for (Place place : places) {
            if (place != null && place.getName().equals(name)) {
                duplicate = true;
            }
        }

        return duplicate;
    }


    //AVAILABLE SPACE METHODS

    /**
	* <p><b>availableCommunity</b></p>
	* <b>Description:</b> Verifies if there is an empty space in the array of communities in order to save another community afterwards. 
    * It will loop an check that every element is equals to Null and then return the index of the last Null element.
    * If there are no null elements, it will return a -1.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
    *   <li> {@code Array} holding the Communities must already exist.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li> An int holding the last null element position in the communities array will be returned. If there is no null element left -1 will be returned instead.</li>
	* </ul>
	*
	* @return An int holding the index of the last null element in the communities array (if there is no more space a -1 will be returned).
	*/    
    public int availableCommunity(){
        for (int i = 0; i < communities.length; i++) {
            if (communities[i] == null) {
                return i;
            }
        }
        //If there is no more space, a -1 will be returned
        return -1;
    }

    /**
	* <p><b>availablePlace</b></p>
	* <b>Description:</b> Verifies if there is an empty space in the array of places in order to save another place afterwards. 
    * It will loop and check that every element is equals to Null and then return the index of the last Null element.
    * If there are no null elements, it will return a -1.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
    *   <li> {@code Array} holding the places must already exist.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li> An int holding the last null element position in the places array will be returned. If there is no null element left -1 will be returned instead.</li>
	* </ul>
	*
	* @return An int holding the index of the last null element in the places array (if there is no more space a -1 will be returned).
	*/    
    public int availablePlace(){
        for (int i = 0; i < places.length; i++) {
            if (places[i] == null) {
                return i;
            }
        }
        //If there is no more space, a -1 will be returned
        return -1;
    }   

    //DISPLAYING ENUMERATIONS

    /**
	* <p><b>displayChallengeTypes</b></p>
	* <b>Description:</b> Concatenates and returns a string that holds all the descriptions that represent every Challenge literal. 
    * It will loop, put a number and extract the String challenges that holds all the descriptions.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
    *   <li> {@code literals} and {@code descriptions} must have been initialized and the getDescription method must be in place.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A String holding all the numbered descriptions in order will be returned.</li>
	* </ul>
	*
	* @return A String that holds all the numbered descriptions of the Challenge enumeration.
	*/ 
    public String displayChallengeTypes(){
        String message = "Available challenges: \n\t";

        String[] challenges = Community.getChallenges();
    
        for (int i = 0; i < challenges.length; i++) {
            message += (i + 1) + ". " + challenges[i] + "\n\t";
        }
    
        // Return the constructed message
        return message;
    }

    /**
	* <p><b>displayCommunityTypes</b></p>
	* <b>Description:</b> Concatenates and returns a string that holds all the descriptions that represent every CommunityType literal. 
    * It will loop, put a number and extract the String communityTypes that holds all the descriptions.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
    *   <li> {@code literals} and {@code descriptions} must have been initialized and the getDescription method must be in place.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A String holding all the numbered descriptions in order will be returned.</li>
	* </ul>
	*
	* @return A String that holds all the numbered descriptions of the CommunityType enumeration.
	*/     
    public String displayCommunityTypes(){
        String message = "Available community types:\n\t";

        String[] communityTypes = Community.getCommunityTypes();
    
        for (int i = 0; i < communityTypes.length; i++) {
            message += (i + 1) + ". " + communityTypes[i] + "\n\t";
        }
    
        // Return the constructed message
        return message;
    }

    /**
	* <p><b>displayDepartments</b></p>
	* <b>Description:</b> Concatenates and returns a string that holds all the descriptions that represent every Department literal. 
    * It will loop, put a number and extract the String Departments that holds all the descriptions.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
    *   <li> {@code literals} and {@code descriptions} must have been initialized and the getDescription method must be in place.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A String holding all the numbered descriptions in order will be returned.</li>
	* </ul>
	*
	* @return A String that holds all the numbered descriptions of the Deparment enumeration.
	*/     
    public String displayDepartments(){
        String message = "Available departments\n\t";

        String[] departments = Place.getDepartments();
    
        for (int i = 0; i < departments.length; i++) {
            message += (i + 1) + ". " + departments[i] + "\n\t";
        }
    
        // Return the constructed message
        return message;
    }

    /**
	* <p><b>displayPlaceTypes</b></p>
	* <b>Description:</b> Concatenates and returns a string that holds all the descriptions that represent every PlaceType literal. 
    * It will loop, put a number and extract the String PlaceTypes that holds all the descriptions.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
    *   <li> {@code literals} and {@code descriptions} must have been initialized and the getDescription method must be in place.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A String holding all the numbered descriptions in order will be returned.</li>
	* </ul>
	*
	* @return A String that holds all the numbered descriptions of the PlaceType enumeration.
	*/     
    public String displayPlaceTypes(){
        String message = "Available community types:\n\t";

        String[] placeTypes = Place.getPlaceTypes();
    
        for (int i = 0; i < placeTypes.length; i++) {
            message += (i + 1) + ". " + placeTypes[i] + "\n\t";
        }
    
        // Return the constructed message
        return message;
    }

    /**
    * <p><b>displayProductTypes</b></p>
    * <b>Description:</b> Concatenates and returns a string that holds all the descriptions that represent every ProductType literal. 
    * It will loop through the product types, put a number, and extract the String array containing all the descriptions.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code literals} and {@code descriptions} must have been initialized and the {@code getDescription} method must be in place.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A String holding all the numbered descriptions in order will be returned.</li>
    * </ul>
    * 
    * @return A String that holds all the numbered descriptions of the ProductType enumeration.
    */
    public String displayProductTypes(){
        String message = "Types of products:\n\t";

        String[] productTypes = Community.getProductTypes();
    
        for (int i = 0; i < productTypes.length; i++) {
            message += (i + 1) + ". " + productTypes[i] + "\n\t";
        }
    
        // Return the constructed message
        return message;
    }


    //DISPLAYING LIST OF COMMUNITIES
    /**
    * <p><b>displayCommunities</b></p>
    * <b>Description:</b> Concatenates and returns a string that holds all the names of the available communities. 
    * It iterates through the communities array, appending the index and name of each community to the message.
    * It makes sure that no null community is passed on to prevent a Null Exception.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code communities} must have been initialized.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A string containing all the numbered names of the available communities is returned.</li>
    * </ul>
    * 
    * @return A string holding all the numbered names of the available communities.
    */
    public String displayCommunities(){
        String message = "Available communities: ";
        for(int i = 0; i < communities.length; i++){
            if(communities[i]!=null){
                System.out.print("\t"+(i+1) + ". " + communities[i].getName() + "\n");
            }
        }
        return message;
    }

    //DISPLAYING LIST OF PRODUCTS
    /**
    * <p><b>displayProducts</b></p>
    * <b>Description:</b> Concatenates and returns a string that holds all the descriptions of products associated with the specified community.
    * It delegates the task of displaying products to the {@link Community#displayProducts()} method by passing the selected community.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>The {@code community} parameter must be a valid instance of the Community class.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A string containing all the descriptions of products associated with the specified community is returned.</li>
    * </ul>
    * 
    * @param community The community whose products are to be displayed.
    * @return A string holding all the names of products associated with the specified community.
    */
    public String displayProducts(Community community){
        return community.displayProducts();
    }

    //SEARCH IF AT LEAST ONE OF SOMETHING IS REGISTERED
    /**
	* <p><b>oneMinCommunity</b></p>
	* <b>Description:</b> Will check if at least one community was registered already (first position of communities).
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
    *   <li> {@code Array} of communities must already exist. </li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A boolean stating if the first position in the community array was occupied or not.</li>
	* </ul>
	*
	* @return A boolean stating if the first position of communities is filled.
	*/     
    public boolean oneMinCommunity() {
        boolean oneCommunity = false;

        if (communities[0] != null) {
            oneCommunity = true;
        } 
    
        return oneCommunity;
    }

    /**
    * <p><b>oneMinProduct</b></p>
    * <b>Description:</b> Checks if the specified community has at least one product registered.
    * It delegates the task of checking to the {@link Community#oneMinProduct()} method by giving it the selected community.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>The {@code community} parameter must be a valid instance of the Community class.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A boolean value indicating whether the specified community has at least one product registered inse a communities inventory or not is returned.</li>
    * </ul>
    * 
    * @param community The community to check for the existence of at least one product.
    * @return A boolean indicating if the specified community has at least one product registered.
    */   
    public boolean oneMinProduct(Community community) {
        boolean oneProduct = false;

        oneProduct = community.oneMinProduct();
    
        return oneProduct;
    }


    //CHANGE AN INT TO A COMMUNITY
    /**
	* <p><b>intToCommunity</b></p>
	* <b>Description:</b> Takes in the selected option from the list of communities and then extracts the community in the communities array.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code intType} must be an int within the range of communities printed.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li> A community is returned that was associated to the entered option.</li>
	* </ul>
	*
	* @param intCommunity an int that the user entered to choose one of the communities.
    * @return The community that was selected from the community list. 
	*/   
    public Community intToCommunity(int intCommunity){
        Community communityType = communities[intCommunity-1];
    
        return communityType;
    }   

    //CONSTRUCTOR
    /**
	* <p><b>Controller</b></p>
	* <b>Description:</b> Initializes the Controller with the empty arrays for communities and places.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code None} No preconditions.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>The controller is initialized with both of the necessary arrays.</li>
	* </ul>
	*/
    public Controller(){

        this.communities = new Community[50];
        this.places = new Place[200];

    }

    //SETTERS AND GETTERS
    
    /**
    * <p><b>getCommunities</b></p>
    * <b>Description:</b> Retrieves the array of communities saved in controller.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Array} of communities must be in place beforehand.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>An array of communities is returned containing all available communities.</li>
    * </ul>
    * 
    * @return The array of communities (including nulls if there are any).
    */
    public Community[] getCommunities() {
        return communities;
    }

    public Place[] getPlaces() {
        return places;
    }

    

}
