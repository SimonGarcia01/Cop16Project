package model;

import java.util.Calendar;

public class Place {

    //Attributes
    private String name;
    private double area;
    private Calendar inaugurationDate;
    private String photo;
    private double resources;
    private PlaceType type;
    private Department department;
    
    //Relations
    private Species[] species;
    private Community caregivingCommunity;


    //Methods

    //TO GET THE INFO FROM ENUMERATIONS

    /**
    * <p><b>getDepartments</b></p>
    * <b>Description:</b> Retrieves the array of departments from the Department class and returns it.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code getDepartments} method in the Department class must be in place.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>An array of department names is returned containing all available departments.</li>
    * </ul>
    * 
    * @return A String[] holding all the descriptions representing the Department literals.
    */
    public static String[] getDepartments(){
        return Department.getDepartments();
    }

    /**
    * <p><b>getPlaceTypes</b></p>
    * <b>Description:</b> Retrieves the array of place types from the PlaceType class and returns it.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code getPlaceTypes} method in the PlaceType class must be in place.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>An array of place type names is returned containing all available place types.</li>
    * </ul>
    * 
    * @return A String[] holding all the descriptions representing the PlaceType literals.
    */  
    public static String[] getPlaceTypes(){
        return PlaceType.getPlaceTypes();
    }

    //CONSTRUCTOR
    /**
    * <p><b>Place</b></p>
    * <b>Description:</b> Initializes and creates an instance of Place with the specified parameters.
    * The constructor sets the attributes of the Place object using the provided parameters.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code name} must be a non-null String.</li>
    *   <li>{@code area} must be a double.</li>
    *   <li>{@code inaugurationDate} must be a non-null Calendar object.</li>   
    *   <li>{@code photo} must be a String.</li>
    *   <li>{@code resources} must be a double.</li>
    *   <li>{@code intType} must be an int between 1 and 3.</li>
    *   <li>{@code intDepartment} must be an int between 1 and 4.</li>
    *   <li>{@code caregivingCommunity} must be a non-null and preexisting Community instance.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>An instance of Place is created with all the specified parameters set.</li>
    * </ul>
    * 
    * @param name The name of the place.
    * @param area The area of the place in km2.
    * @param inaugurationDate The inauguration date of the place.
    * @param photo The URL that holds a photo of the place.
    * @param resources The resources allocated to maintain the place.
    * @param intType The type of the place.
    * @param intDepartment The department of the place is located in.
    * @param caregivingCommunity The caregiving community associated with the place.
    */
    public Place(String name, double area, Calendar inaugurationDate, String photo, 
    double resources, int intType, int intDepartment, Community caregivingCommunity) {
        this.name = name;
        this.area = area;
        this.inaugurationDate = inaugurationDate;
        this.photo = photo;
        this.resources = resources;
        this.type = PlaceType.intToPlaceType(intType);
        this.department = Department.intToDepartment(intDepartment);
        this.species = new Species[50];
        this.caregivingCommunity = caregivingCommunity;
    }

    //SETTERS AND GETTERS
    /**
    * <p><b>getName</b></p>
    * <b>Description:</b> Allows the extraction of the name from a Place instance as a String.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A String containing the name of a Place instance is returned.</li>
    * </ul>
    * 
    * @return A String with the name of a Place instance.
    */    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Calendar getInaugurationDate() {
        return inaugurationDate;
    }

    public void setInaugurationDate(Calendar inaugurationDate) {
        this.inaugurationDate = inaugurationDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getResources() {
        return resources;
    }

    public void setResources(double resources) {
        this.resources = resources;
    }

    public PlaceType getType() {
        return type;
    }

    public void setType(PlaceType type) {
        this.type = type;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Community getCaregivingCommunity() {
        return caregivingCommunity;
    }

    public void setCaregivingCommunity(Community caregivingCommunity) {
        this.caregivingCommunity = caregivingCommunity;
    }

    //No need for a set since the species are added by another method
    public Species[] getSpecies() {
        return species;
    }
}
