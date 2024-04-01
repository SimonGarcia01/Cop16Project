package model;

public class Controller {
    
    //Attributes

    //Relations
    Community[] communities;
    Place[] places;


    //Methods

    //Main Methods
    public String registerCommunity(String name, String representantName, String representantPhone, 
    int population,  int intChallenge, int intType){
        String message = "";

        boolean duplicate = searchCommunity(name);

        if(duplicate){
            message = "A community with that name already exists.";
        } else {

            int space = availableCommunity();

            if (space == -1){
                message = "There is no more space to register a new community.";
            } else {
                communities[space] = new Community(name, representantName, representantPhone, 
                population, intChallenge, intType);
                message = "The community has been registered successfully.";
            }

        }

        return message;
    }

    //Search Methods
    public boolean searchCommunity(String name){

        boolean duplicate = false;

        for (Community community : communities) {
            if (community != null && community.getName().equals(name)) {
                duplicate = true;
            }
        }

        return duplicate;
    }

    //Available Space Methods
    public int availableCommunity(){
        for (int i = 0; i < communities.length; i++) {
            if (communities[i] == null) {
                return i;
            }
        }
        //If there is no more space, a -1 will be returned
        return -1;
    }

    //Displaying enumerations
    public String displayChallengeTypes(){
        String message = "Available challenges: \n\t";

        String[] challenges = Community.getChallenges();
    
        for (int i = 0; i < challenges.length; i++) {
            message += (i + 1) + ". " + challenges[i] + "\n\t";
        }
    
        // Return the constructed message
        return message;
    }

    public String displayCommunityTypes(){
        String message = "Available community types:\n\t";

        String[] communityTypes = Community.getCommunityTypes();
    
        for (int i = 0; i < communityTypes.length; i++) {
            message += (i + 1) + ". " + communityTypes[i] + "\n\t";
        }
    
        // Return the constructed message
        return message;
    }

    //Constructor
    public Controller(){

        this.communities = new Community[3];
        this.places = new Place[3];

    }

}
