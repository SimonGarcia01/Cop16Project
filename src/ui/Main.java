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
                                break;
                            case 4:
                                //delete a product from a community
                                break;
                            case 5:
                                //Add a species to a place
                                break;
                            case 6:
                                //Modify a species data in a place
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
	* <b>Description:</b> The method prints and registers all the necessary information to register a community. It will print 2 separate small menus: 
    *<ul>
    *   <li>To choose the Challenge.</li>
    *   <li>To choose the CommunityType</li>
	*</ul>
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code controller}: The controller must have been created.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li> A message stating if the community was successfully registered or not. If the community is not registered, the appropiate messages will be returned.</li>
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

        System.out.println(controller.displayChallengeTypes());
        System.out.print("Enter the biggest challenge: ");
        int intChallenge = sk.nextInt();
        sk.nextLine();

        System.out.println(controller.displayCommunityTypes());
        System.out.print("Enter the type of community: ");
        int intType = sk.nextInt();
        sk.nextLine();

        String message = controller.registerCommunity(name, representantName, representantPhone, 
        population, intChallenge, intType);

        System.out.println(message);
    }

    /**
	* <p><b>registerPlace</b></p>
	* <b>Description:</b> The method prints and registers all the necessary information to register a place. 
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
	* 	<li> A message stating if the place was successfully registered or not. If the place was not registered, the appropiate messages will be returned.</li>
	* </ul>
	*
	* @param controller The general controller of the application. 
	*/        
    public static void registerPlace(Controller controller){
        System.out.println("REGISTERING A PLACE");
        
        int intCommunity = 0;
        if(controller.getCommunities()[0]!=null){
            System.out.println("Available communities to associate to a place:");
            for(int i = 0; i < controller.getCommunities().length; i++){
                if(controller.getCommunities()[i]!=null){
                    System.out.print("\t"+(i+1) + ". " + controller.getCommunities()[i].getName() + "\n");
                }
            }
            System.out.print("Enter the number that correspondes to the caregiving community: ");
            intCommunity = sk.nextInt();
            sk.nextLine();
        }else{
            System.out.println("There are no registered communities.");

        }

        System.out.print("Enter the name of the place: ");
        String placeName = sk.nextLine();

        System.out.print("Enter the area (km^2): ");
        int area = sk.nextInt();
        sk.nextLine();

        System.out.print("Enter the URL for the photo: ");
        String photo = sk.nextLine();

        System.out.print("Enter the amount of resources destined to the place: ");
        double resources = sk.nextDouble();

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
    }

}