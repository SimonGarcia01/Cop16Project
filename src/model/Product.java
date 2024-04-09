package model;

public class Product {

    //Attributes
    private String name;
    private double naturePercent;
    private String handcraft;
    private ProductType type;
    //Relations

    //Methods

    /**
    * <p><b>getProductTypes</b></p>
    * <b>Description:</b> Extracts the array from ProductType holding every description associated with a ProductType literal and returns it.
    * The method passes on the descriptios done by {@link ProductType#getProductTypes()}.
    *
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code getProductTypes} method in ProductType must be in place.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A String array is returned holding the descriptions of every Literal.</li>
    * </ul>
    * 
    * @return A string[] holding all the descriptions representing the ProductType literals.
    */ 
    public static String[] getProductTypes(){
        return ProductType.getProductTypes();
    }

    //CONSTRUCTOR
    /**
    * <p><b>Product</b></p>
    * <b>Description:</b> Initializes and creates an instance of a Product with the specified parameters.
    * The constructor sets the attributes of the Product object using the provided parameters.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code name} must be a non-null String.</li>
    *   <li>{@code naturePercent} must be a double.</li>
    *   <li>{@code handcraft} must be a String.</li>
    *   <li>{@code intType} must be an int between 1 and 2.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>An instance of a Product is created with all the specified parameters set.</li>
    * </ul>
    * 
    * @param name The name of the product.
    * @param naturePercent The percentage of natural ingredients in the product.
    * @param handcraft The handcraft information related to the product.
    * @param intType The type of the product.
    */
    public Product(String name, double naturePercent, String handcraft, int intType) {
        this.name = name;
        this.naturePercent = naturePercent;
        this.handcraft = handcraft;
        this.type = ProductType.intToProductType(intType);
    }

    //SETTERS AND GETTERS
    
    /**
    * <p><b>getName</b></p>
    * <b>Description:</b> Allows the extraction of the name from a Product instance as a String.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A String containing the name of a Product instance is returned.</li>
    * </ul>
    * 
    * @return A String with the name of a Product instance.
    */
    public String getName() {
        return name;
    }

    /**
    * <p><b>setName</b></p>
    * <b>Description:</b> Sets the name of the product to the provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code name} must be a non-null String.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The name of the product is updated to the provided value.</li>
    * </ul>
    *
    * @param name The new name for the product.
    */  
    public void setName(String name) {
        this.name = name;
    }

    /**
    * <p><b>getNaturePercent</b></p>
    * <b>Description:</b> Retrieves the nature percentage of the product.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The nature percentage of the product is returned.</li>
    * </ul>
    * 
    * @return The nature percentage of the product.
    */ 
    public double getNaturePercent() {
        return naturePercent;
    }

    /**
    * <p><b>setNaturePercent</b></p>
    * <b>Description:</b> Sets the nature percentage of the product to the provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code naturePercent} must be a double.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The nature percentage of the product is updated to the provided value.</li>
    * </ul>
    *
    * @param naturePercent The new nature percentage for the product.
    */ 
    public void setNaturePercent(double naturePercent) {
        this.naturePercent = naturePercent;
    }

    /**
    * <p><b>getHandcraft</b></p>
    * <b>Description:</b> Retrieves the handcraft condition of the product.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The handcraft condition of the product is returned.</li>
    * </ul>
    * 
    * @return The handcraft condition of the product.
    */ 
    public String getHandcraft() {
        return handcraft;
    }

    /**
    * <p><b>setHandcraft</b></p>
    * <b>Description:</b> Sets the handcraft condition of the product to the provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code handcraft} must be a non-null String (yes or no).</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The handcraft of condition the product is updated to the provided value.</li>
    * </ul>
    *
    * @param handcraft The new handcraft condition for the product.
    */ 
    public void setHandcraft(String handcraft) {
        this.handcraft = handcraft;
    }

    /**
    * <p><b>getType</b></p>
    * <b>Description:</b> Retrieves the type of the product.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The type of the product is returned.</li>
    * </ul>
    * 
    * @return The type of the product.
    */ 
    public ProductType getType() {
        return type;
    }

    /**
    * <p><b>setType</b></p>
    * <b>Description:</b> Sets the type of the product to the provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code type} must be a non-null {@code ProductType} object.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The type of the product is updated to the provided value.</li>
    * </ul>
    *
    * @param type The new type for the product.
    */ 
    public void setType(ProductType type) {
        this.type = type;
    }
}
