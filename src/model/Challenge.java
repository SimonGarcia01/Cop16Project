package model;

public enum Challenge {
    HOSPITALS("Absence of hospitals"),
    SCHOOLS("Lack of schools"),
    WATER("Inadequate access to clean water"),
    FOOD("Insufficient access to food");

    //Attributes
    private final String description;

    //Methods
    //Get the description for all the literals
    public static String[] getChallenges() {
        Challenge[] challenges = Challenge.values();
        String[] descriptions = new String[challenges.length];
        for (int i = 0; i < challenges.length; i++) {
            descriptions[i] = challenges[i].getDescription();
        }
        return descriptions;
    }

    //Converting an int into a Challenge
    public static Challenge intToChallenge(int intChallenge){
        Challenge challenge = null;
        switch(intChallenge){
            case 1:
                challenge = Challenge.HOSPITALS;
                break;
            case 2:
                challenge = Challenge.SCHOOLS;
                break;
            case 3:
                challenge = Challenge.WATER;
                break;
            case 4:
                challenge = Challenge.FOOD;
                break;
        }

        return challenge;
    }

    //Constructor
    private Challenge(String description){
        this.description = description;
    }

    //Get the description for one literal
    public String getDescription(){
        return description;
    }


}
