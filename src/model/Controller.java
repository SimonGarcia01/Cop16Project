package model;

import model.Community.Challenge;
import model.Community.CommunityType;

public class Controller {
    
    //Attributes

    //Relations
    Community[] communities;
    Place[] places;


    //Methods
    //Main Methods
    public String registerCommunity(String name, String representantName, String representantPhone, 
    int population, Challenge challenge, CommunityType type){
        String message = "";

        boolean duplicate = searchCommunity(name);

        if(duplicate){
            message = "Ya existe una comunidad con ese nombre.";
        } else {

            int space = availableCommunity();

            if (space == -1){
                message = "There is no more space to register a new community";
            } else {
                communities[space] = new Community(name, representantName, representantPhone, 
                population, challenge, type);
                message = "The community has been registered successfully";
            }

        }

        return message;
    }

    //Search Methods
    public boolean searchCommunity(String name){

        boolean duplicate = false;

        for (Community community : communities) {
            if (community.getName().equals(name)) {
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
        String message = "Available challenge: \n";

        String[] challenges = Community.getChallenges();
    
        for (int i = 0; i < challenges.length; i++) {
            message += (i + 1) + ". " + challenges[i] + "\n";
        }
    
        // Return the constructed message
        return message;
    }

    public String displayCommunityTypes(){
        String message = "Available comunity types:\n";

        String[] communityTypes = Community.getCommunityTypes();
    
        for (int i = 0; i < communityTypes.length; i++) {
            message += (i + 1) + ". " + communityTypes[i] + "\n";
        }
    
        // Return the constructed message
        return message;
    }

    //Constructor
    public Controller(){

    }

}
