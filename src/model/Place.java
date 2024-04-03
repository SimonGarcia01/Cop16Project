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
	* <p><b>getChallenges</b></p>
	* <b>Description:</b> Extracts the array from Challenge holding every description associated to a Challenge literal and returns it.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code getChallenges} method in Challenge must be in place.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>An String array is returned holding the descriptions of every Literal. </li>
	* </ul>
    *
	* @return A string[] holding all the descriptions representing the Challenge literals.
	*/   
    public static String[] getDepartments(){
        return Department.getDepartments();
    }

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
    public static String[] getPlaceTypes(){
        return PlaceType.getPlaceTypes();
    }

    //CONSTRUCTOR
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
