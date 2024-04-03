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
	* <p><b>getCommunityTypes</b></p>
	* <b>Description:</b> Extracts the array from CommunityType holding every description associated to a Challenge literal and returns it.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code getCommunityTypes} method in CommunityType must be in place.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>An String array is returned holding the descriptions of every Literal. </li>
	* </ul>
	*
	* @return A string[] holding all the descriptions representing the CommunityType literals.
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
