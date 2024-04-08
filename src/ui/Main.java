package ui;

import model.Controller;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main{
    
    public static Scanner sk = new Scanner(System.in);
    public static void main(String[] args){

        Controller controller = new Controller();

        //Variables for the general menu
        int generalOption = 0;
        boolean generalLoop = true;

        //Variables for administrative menu
        int adminOption = 0;
        boolean adminLoop = true;

        //Variables for query menu
        int queryOption = 0;
        boolean queryLoop = true;

        do{

            generalOption = generalMenu();

            switch(generalOption){
                //Enter administrative menu
                case 1:
                    
                    do{
                        adminOption = adminMenu();

                        switch(adminOption){
                            case 1:
                                //Register a community
                                registerCommunity(controller);
                                break;
                            case 2:
                                //Register a place
                                registerPlace(controller);
                                break;
                            case 3:
                                //Add a product to a commmunity
                                addProduct(controller);
                                break;
                            case 4:
                                //delete a product from a community
                                deleteProduct(controller);
                                break;
                            case 5:
                                //Add a species to a place
                                addSpecies(controller);
                                break;
                            case 6:
                                //Modify a species data in a place
                                modifySpecies(controller);
                                break;

                            case 9:
                                //Exit admin menu
                                adminLoop = false;
                                break;
                            default:
                                System.out.println("Please enter a valid option.");
                        }
                    }while(adminLoop);
                    break;
                //Enter query menu
                case 2:
                    
                    do{
                        queryOption = queryMenu();

                        switch(queryOption){
                            case 1:
                                //Access the information from a place
                                break;
                            case 2:
                                //Access the information of the communities in a department
                                break;
                            case 3:
                                //Access the information of communities based on their biggest problematic
                                break;
                            case 4:
                                //Display the name of the place with the most species diversity
                                break;
                            case 5:
                                //Display the three places with the biggest area
                                break;
                            case 9:
                                //Exit query menu
                                queryLoop = false;
                                break;
                            default:
                                System.out.println("Please enter a valid option.");
                        }
                    }while(queryLoop);
                    break;
                case 9:
                    //Exit the program
                    System.out.println("EXITING PROGRAM...");
                    generalLoop = false;
                    break;
                
                default:
                    System.out.println("Please enter a valid option.");


            }

        }while(generalLoop);

    }

    //MENU METHODS

    /**
	 * <p><b>generalMenu</b></p>
	* <b>Description:</b> prints the general menu and then registers the chosen option.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code NONE}: No preconditions.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>The general menu is printed and the chosen option is returned.</li>
	* </ul>
	*
	* @return The option chosen from the menu.
	*/

    public static int generalMenu(){
        int option = 0;

        System.out.println("-----------------------------------------------------------");
		System.out.println("General Menu: ");
		System.out.println("\t1. Administrative menu\n\t2. Consultation menu\n\t9. Exit");
		System.out.println("-----------------------------------------------------------");
		System.out.print("Enter the option: ");
		option = sk.nextInt();
		sk.nextLine();

        return option;
    }
    
    /**
	 * <p><b>adminMenu</b></p>
	* <b>Description:</b> prints the administrative menu and then registers the chosen option.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code NONE}: No preconditions.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>The administrative menu is printed and the chosen option is returned.</li>
	* </ul>
	*
	* @return The option chosen from the menu.
	*/

    public static int adminMenu(){
        int option = 0;

        System.out.println("-----------------------------------------------------------");
		System.out.println("Menu of Administrative Options: ");
		System.out.println("\t1. Register a community\n\t2. Register a place\n\t3. Add a product to a community\n\t4. Delete a product from a community\n\t5. Add a species in a place\n\t6. Modify a species data in a place\n\t9. Leave menu");
		System.out.println("-----------------------------------------------------------");
		System.out.print("Enter the option: ");
		option = sk.nextInt();
		sk.nextLine();

        return option;
    }

    /**
	* <p><b>gueryMenu</b></p>
	* <b>Description:</b> prints the query menu and then registers the chosen option.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code NONE}: No preconditions.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>The query menu is printed and the chosen option is returned.</li>
	* </ul>
	*
	* @return The option chosen from the menu.
	*/

    public static int queryMenu(){
        int option = 0;

        System.out.println("-----------------------------------------------------------");
		System.out.println("Menu for Queries: ");
		System.out.println("\t1. Access the information from a place\n\t2. Access the information of the communities in a department\n\t3. Access the information of communities based on their biggest problematic\n\t4. Display the name of the place with the most species diversity\n\t5. Display the three places with the biggest area\n\t9. Leave menu");
		System.out.println("-----------------------------------------------------------");
		System.out.print("Enter the option: ");
		option = sk.nextInt();
		sk.nextLine();

        return option;
    }

    //ADMINISTRATIVE MENU METHODS

    /**
    * <p><b>registerCommunity</b></p>
    * <b>Description:</b> The method prints and registers all the necessary information to register a community. 
    * Since a community can face multiple challenges, every challenged will be entered as a yes or no question.
    * It will print only one small menu: 
    * <ul>
    *    <li>To choose the CommunityType</li>
    *</ul>
    * <p><b>Preconditions:</b></p>
    * <ul>
    *     <li>{@code controller}: The controller must have been created.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *     <li>A message stating if the community was successfully registered or not. If the community is not registered, the appropriate messages will be returned.</li>
    * </ul>
    *
    * @param controller The general controller of the application.
    */  
    public static void registerCommunity(Controller controller){
        System.out.println("REGISTERING A COMMUNITY");
        
        System.out.print("Enter the community's name: ");
        String name = sk.nextLine();

        System.out.print("Enter the representant's name: ");
        String representantName = sk.nextLine();

        System.out.print("Enter the representant's phone number: " );
        String representantPhone = sk.nextLine();

        System.out.print("Enter the population: ");
        int population = sk.nextInt();
        sk.nextLine();
        
        System.out.println("Problems of the Community:");
        System.out.print("\n\tDoes the community have an absence of hospitals(yes/no): ");
        String hospitals = sk.nextLine();
        System.out.print("\n\tDoes the community have a lack of schools(yes/no): ");
        String schools = sk.nextLine();
        System.out.print("\n\tDoes the community has an inadequate access to clean water(yes/no): ");
        String water = sk.nextLine();
        System.out.print("\n\tDoes the community have an insufficient access to food(yes/no): ");
        String food = sk.nextLine();

        System.out.println(controller.displayCommunityTypes());
        System.out.print("Enter the type of community: ");
        int intType = sk.nextInt();
        sk.nextLine();

        String message = controller.registerCommunity(name, representantName, representantPhone, 
        population, hospitals, schools, water, food, intType);

        System.out.println(message);
    }

    /**
	* <p><b>registerPlace</b></p>
	* <b>Description:</b>The method starts by checking if there is atleast one registered community (showing an error if there isn't), then it prints and registers all the necessary information to register a place. 
    * It will print 3 menus: 
    * <ul>
    *   <li> To select an existing community.</li>
    *   <li> To select the Department.</li>
    *   <li> To select the place type.</li>
	*</ul>
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code controller}: The controller must have been created.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>If there is not one registered community, an error message will be printed and the method will skip itself.</li>	
    * 	<li> A message stating if the place was successfully registered or not. If the place was not registered, the appropiate messages will be returned.</li>
	* </ul>
	*
	* @param controller The general controller of the application. 
	*/        
    public static void registerPlace(Controller controller){
        System.out.println("REGISTERING A PLACE");
        
        boolean existingCommunity = controller.oneMinCommunity();

        if (existingCommunity){

            System.out.println(controller.displayCommunities());
            System.out.print("Enter the number that correspondes to the caregiving community: ");
            int intCommunity = sk.nextInt();
            sk.nextLine();

            System.out.print("Enter the name of the place: ");
            String placeName = sk.nextLine();

            System.out.print("Enter the area (km^2): ");
            int area = sk.nextInt();
            sk.nextLine();

            System.out.print("Enter the URL for the photo: ");
            String photo = sk.nextLine();

            System.out.print("Enter the amount of resources destined to the place: ");
            double resources = sk.nextDouble();
            sk.nextLine();

            System.out.println(controller.displayDepartments());
            System.out.print("Enter the department the place is located in: ");
            int intDepartment = sk.nextInt();
            sk.nextLine();

            System.out.println(controller.displayPlaceTypes());
            System.out.print("Enter the type of place: ");
            int intType = sk.nextInt();
            sk.nextLine();

            System.out.print("Enter the date of inauguration (dd/mm/aaaa): ");
            //get the date as a string with the format dd/mm/aaaa
            String inaugurationDateString = sk.nextLine();
            //create a calendar instance so i can then save the time in it
            Calendar inaugurationDate = Calendar.getInstance();
            //create a simpledateformat to change the String info to date format
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            //now change the Calendar expiration date using the transformed date format
            try {
                //Had to use parce exception because it said so...
                inaugurationDate.setTime(sdf.parse(inaugurationDateString));
            } catch (ParseException e) {
                System.out.println("The format was incorrect, use: dd/MM/yyyy.");
                return;
            }

            String message = controller.registerPlace(intCommunity, placeName, area, inaugurationDate, 
            photo, resources, intDepartment, intType);

            System.out.println(message);
        } else {
            System.out.println("There are no registered communities to associate to a place. Please enter one.");
        }
    }


    /**
	* <p><b>addProduct</b></p>
	* <b>Description:</b>The method starts by checking if there is atleast one registered community (showing an error if there isn't), 
    * then it prints and registers all the necessary information to add a product to a community. 
    * It will print 2 menus: 
    * <ul>
    *   <li> To select an existing community.</li>
    *   <li> To select the product type.</li>
	*</ul>
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code controller}: The controller must have been created.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>If there is not one registered community, an error message will be printed and the method will skip itself.</li>
	* 	<li>A message stating if the product was successfully registered or not. If the place was not registered, the appropiate messages will be returned.</li>
	* </ul>
	*
	* @param controller The general controller of the application. 
	*/  
    public static void addProduct(Controller controller){
        System.out.println("REGISTERING A PRODUCT TO A COMMUNITY:");

        boolean existingCommunity = controller.oneMinCommunity();

        if (existingCommunity){

            System.out.println(controller.displayCommunities());
            System.out.print("Enter the number that correspondes to the community: ");
            int intCommunity = sk.nextInt();
            sk.nextLine();

            System.out.print("Enter the name of the product: ");
            String productName = sk.nextLine();

            System.out.print("Enter the percentage of natural products used to make the product: ");
            double naturePercent = sk.nextDouble();
            sk.nextLine();

            System.out.print("Was the product handcrafted? (yes/no): ");
            String handcraft = sk.nextLine();

            System.out.println(controller.displayProductTypes());
            System.out.print("Enter one of the numbers that represents the type of product: ");
            int intProductType = sk.nextInt();
            sk.nextLine();

            String message = controller.addProduct(intCommunity, productName, naturePercent, handcraft, intProductType);

            System.out.println(message); 
        } else {
            System.out.println("There are no registered communities to add a product. Please enter one.");
        }

    }

    /**
    * <p><b>deleteProduct</b></p>
    * <b>Description:</b> This method facilitates the deletion of a product from a community. 
    * It begins by verifying if at least one community is registered; if not, an error message is displayed and the method terminates.
    * Then it checks if atleast one product is saved inside the community. If that the case, it throws an error and terminates the process.
    * If communities exist, the user is prompted to select a community and then select the product to delete from two separate menus.
    * It will print 2 menus: 
    * <ul>
    *   <li> To select an existing community.</li>
    *   <li> To select the product from the selected community.</li>
	*</ul>
    *
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>The {@code controller} parameter must represent the general controller of the application.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>If there are no registered communities, an error message is displayed, and the method terminates without further action.</li>
    *   <li>A message indicating whether the product was successfully deleted or not is printed.</li>
    * </ul>
    * 
    * @param controller The general controller of the application. 
    */
    public static void deleteProduct(Controller controller){
    System.out.println("DELETING A PRODUCT FROM A COMMUNITY:");

    boolean existingCommunity = controller.oneMinCommunity();

    if (existingCommunity){

        System.out.println(controller.displayCommunities());
        System.out.print("Enter the number that correspondes to the community: ");
        int intCommunity = sk.nextInt();
        sk.nextLine();

        boolean existingProduct = controller.oneMinProduct(controller.intToCommunity(intCommunity));

        if(existingProduct){
            int intProduct = 0;
            System.out.println(controller.displayProducts(controller.intToCommunity(intCommunity)));
            System.out.print("Enter the name of the product (represented as a number from the list): ");
            intProduct = sk.nextInt();
            sk.nextLine();
    
            String message = controller.deleteProduct(intCommunity, intProduct);
    
            System.out.println(message);
        } else {
            System.out.println("There are no registered products inside this community. Please add one.");
        }
    } else {
        System.out.println("There are no registered communities to delete a product from. Please enter one.");
    }

    }

    /**
    * <p><b>addSpecies</b></p>
    * <b>Description:</b> This method starts by checking if there is at least one registered place. 
    * If there isn't, it displays an error message and the method is terminated. 
    * Otherwise, it prompts the user to select an existing place and enters the species information, including name, photo URL, 
    * local population, and species type, to add a new species to the selected place.
    * It will print 2 menus: 
    * <ul>
    *   <li> To select an existing place.</li>
    *   <li> To select the species type of the entered species.</li>
	*</ul>
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *     <li>{@code controller} must have been instantiated.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *     <li>If there are no registered places, an error message is printed, and the method exits.</li>
    *     <li>A message stating whether the species was successfully added or not is printed. If the species was not successfully added, appropriate error messages are displayed.</li>
    * </ul>
    *
    * @param controller The general controller of the application.
    */
    public static void addSpecies(Controller controller){
        System.out.println("ADDING A SPECIES TO A PLACE:");
        
        boolean existingPlace = controller.oneMinPlace();

        if (existingPlace){
            System.out.println(controller.displayPlaces());
            System.out.print("Enter the place the species is in: ");
            int intPlace = sk.nextInt();
            sk.nextLine();
        
            System.out.print("Enter the species's name: ");
            String name = sk.nextLine();
        
            System.out.print("Enter the URL of a photo: ");
            String photo = sk.nextLine();
            
            System.out.print("Enter the local population: ");
            int localPop = sk.nextInt();
            sk.nextLine();
            
            System.out.println(controller.displaySpeciesTypes());
            System.out.print("Enter the the type of species: ");
            int intSpeciesType = sk.nextInt();
            sk.nextLine();

            String message = controller.addSpecies(intPlace, name, photo, localPop, intSpeciesType);

            System.out.println(message);
        } else {
            System.out.println("There are no registered places to add a species to. Please enter one.");
        }
    }

    public static void modifySpecies(Controller controller){
        System.out.println("MODIFYING SPECIES DATA:");

        boolean existingPlace = controller.oneMinPlace();

        if (existingPlace){

            System.out.println(controller.displayPlaces());
            System.out.print("Enter the place the species is in: ");
            int intPlace = sk.nextInt();
            sk.nextLine();

            boolean existingSpecies = controller.oneMinSpecies(controller.intToPlace(intPlace));

            if(existingSpecies){
                System.out.println(controller.displaySpecies(controller.intToPlace(intPlace)));
                System.out.print("Enter the name of the species (represented as a number from the list): ");
                int intSpecies = sk.nextInt();
                sk.nextLine();

                System.out.println("Enter which piece of information you want to modify:\n\t1. Name\n\t2. Photo\n\t3. Local Population\n\t4. SpeciesType");
                System.out.print("Enter one of the options: ");
                int intModification = sk.nextInt();
                sk.nextLine();

                String newName = "";
                String newPhoto = "";
                int newLocalPop = 0;
                int newSpeciesType = 0;

                switch(intModification) {
                    case 1:
                        System.out.println("CHANGING NAME: ");
                        System.out.print("Enter the new name: ");
                        newName = sk.nextLine();
                        break;
                    case 2:
                        System.out.println("CHANGING PHOTO: ");
                        System.out.print("Enter the new photo's URL: ");
                        newPhoto = sk.nextLine();
                        break;
                    case 3:
                        System.out.println("CHANGING LOCAL POPULATION: ");
                        System.out.print("Enter the new local population number: ");
                        newLocalPop = sk.nextInt();
                        sk.nextLine();
                        break;
                    case 4:
                        System.out.println("CHANGING SPECIES TYPE: ");
                        System.out.println(controller.displaySpeciesTypes());
                        System.out.print("Enter the new Species Type: ");
                        newSpeciesType = sk.nextInt();
                        sk.nextLine();
                        break;
                }
        
                String message = controller.modifySpecies(intPlace, intSpecies, intModification, 
                newName, newPhoto, newLocalPop, newSpeciesType);
        
                System.out.println(message);
            } else {
                System.out.println("There are no registered species within this place. Please add one.");
            }


        } else {
            System.out.println("There are no registered places so there are no registered species to modify its information. Please enter a place and a species");
        }
    }

}