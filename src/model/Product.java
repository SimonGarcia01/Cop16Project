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

    public void setName(String name) {
        this.name = name;
    }

    public double getNaturePercent() {
        return naturePercent;
    }

    public void setNaturePercent(double naturePercent) {
        this.naturePercent = naturePercent;
    }

    public String getHandcraft() {
        return handcraft;
    }

    public void setHandcraft(String handcraft) {
        this.handcraft = handcraft;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
    

}
