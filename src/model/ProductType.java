package model;

public enum ProductType {
    FOOD("Food"),
    CRAFT("Craft");

    //Attributes
    private final String description;

    //Methods
    
    //TO EXTRACT THE LIST OF DESCRIPTIONS
    /**
    * <p><b>getPlaceTypes</b></p>
    * <b>Description:</b> Extracts all the descriptions that are associated to the literals of the PlaceType enumeration and returns a String[] holding them. 
    * The method loops through each PlaceType, extracting its description, and concatenates everything.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code literals} must have an associated description.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>An String array is returned holding the descriptions of every Literal.</li>
    * </ul>
    * 
    * @return A string[] holding all the descriptions representing the PlaceType literals.
    */
    public static String[] getProductTypes() {
        ProductType[] productTypes = ProductType.values();
        String[] descriptions = new String[productTypes.length];
        for (int i = 0; i < productTypes.length; i++) {
            descriptions[i] = productTypes[i].getDescription();
        }
        return descriptions;
    }

    //CHANGE AN INT TO A PRODUCTTYPE
    /**
    * <p><b>intToPlaceType</b></p>
    * <b>Description:</b> Takes in the selected option from the list of literals (printed as descriptions) and then runs a switch to return the value as a literal from the enumeration.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code intType} must be an int between 1 and 3.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A PlaceType literal is returned associated to the list of literals.</li>
    * </ul>
    * 
    * @param intType An int that the user entered to choose one of the PlaceType types.
    * @return PlaceType literal associated to the list of PlaceType descriptions.
    */
    public static ProductType intToProductType(int intType){
        ProductType productType = null;
        switch(intType){
            case 1:
                productType = FOOD;
                break;
            case 2:
                productType = CRAFT;
                break;
        }

        return productType;
    }


    //CONSTRUCTOR
    private ProductType(String description){
        this.description = description;
    }

    //GETTER
    public String getDescription(){
        return description;
    }
}
