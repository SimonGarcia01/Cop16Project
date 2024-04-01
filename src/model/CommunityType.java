package model;

public enum CommunityType {
    //Enumeration literals
    AFRO("Afrocolombian"),
    INDIGENOUS("Indigenous"),
    RAIZAL("Raizal");

    //Attributes
    private final String description;

    //Methods
    //Get the description for all the literals
    public static String[] getCommunityTypes() {
        CommunityType[] types = CommunityType.values();
        String[] descriptions = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            descriptions[i] = types[i].getDescription();
        }
        return descriptions;
    }

    //Converting an int into a CommunityType
    public static CommunityType intToCommunityType(int intType){
        CommunityType communityType = null;
        switch(intType){
            case 1:
                communityType = CommunityType.AFRO;
                break;
            case 2:
                communityType = CommunityType.INDIGENOUS;
                break;
            case 3:
                communityType = CommunityType.RAIZAL;
                break;
        }

        return communityType;
    }

    //Constructor
    private CommunityType(String description){
        this.description = description;
    }

    //Get the description for one literal
    public String getDescription(){
        return description;
    }

}
