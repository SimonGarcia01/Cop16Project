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
    * <p><b>intToProductType</b></p>
    * <b>Description:</b> Takes in the selected option from the list of literals (printed as descriptions) and then runs a switch to return the value as a literal from the enumeration.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code intType} must be an int between 1 and 2.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A ProductType literal is returned associated with the list of literals.</li>
    * </ul>
    * 
    * @param intType An int that the user entered to choose one of the ProductType types.
    * @return ProductType literal associated with the list of ProductType descriptions.
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
    /**
    * <p><b>ProductType</b></p>
    * <b>Description:</b> Initializes the ProductType literals with an associated String description.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code description} There should be an associated attribute for the description and the literals must have their descriptions.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The literals inside ProductType are initialized with associated descriptions.</li>
    * </ul>
    * 
    * @param description String that comes from the ProductType literal list.  
    */
    private ProductType(String description){
        this.description = description;
    }

    //GETTER
    /**
    * <p><b>getDescription</b></p>
    * <b>Description:</b> Extracts the description associated with the ProductType's literal in the enumeration.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code literals} must have an associated description.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A string that holds the description to a literal is returned.</li>
    * </ul>
    * 
    * @return A String with the description of a ProductType literal.
    */
    public String getDescription(){
        return description;
    }
}
