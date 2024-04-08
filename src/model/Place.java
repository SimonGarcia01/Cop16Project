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

    //ADD A PRODUCT TO A COMMUNITY
    /**
    * <p><b>addSpecies</b></p>
    * <b>Description:</b> Associates a new species with the specified place and returns a success message. 
    * First, it checks if there is a duplicate species with the same name already existing within the place. If so, a duplicate message is returned.
    * Second, it checks if there is space to register a new species within the place. If not, a no space message will be returned.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code name} must be a String.</li>
    *   <li>{@code photo} must be a String.</li>
    *   <li>{@code intSpeciesType} must be an int between 1 and 2.</li>
    *   <li>{@code localPop} must be an int.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>If a species with the same name already exists within the place, a duplicate message is returned.</li>
    *   <li>If there is no more space to register a new species within the place, a no space message is returned.</li>
    *   <li>Otherwise, the new species is added to the species array of the place, and a success message is returned.</li>
    * </ul>
    * 
    * @param name The name of the species.
    * @param photo The URL of a photo that contains the species.
    * @param localPop The local population of the species.
    * @param intSpeciesType The type of the species.
    * @return A message stating if the species was added successfully or not (showing the reason if it wasn't successful).
    */
    public String addSpecies(String name, String photo, int localPop, int intSpeciesType){
        String message = "";

        boolean duplicate = searchSpecies(name);

        if(duplicate){
            message = "A species with that name already exist within the place.";
        } else {

            int space = availableSpecies();

            if (space == -1){
                message = "There is no more space to register a new species within the place.";
            } else {
                species[space] = new Species(name, photo, localPop, intSpeciesType);
                message = "The species has been added successfully to the place's list.";
            }

        }

        return message;
    }

    //MODIFY A SPECIES WITHIN A PLACE
    /**
    * <p><b>deleteProduct</b></p>
    * <b>Description:</b> Deletes a product from the community based on the specified product index.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code intProduct} must be an int representing a valid index of a product within the community.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The product at the specified index is removed from the community, and a success message is returned.</li>
    * </ul>
    * 
    * @param intProduct The index of the product to be deleted from the community.
    * @return A message indicating that the product was successfully deleted.
    */   
    public String modifySpecies(int intSpecies, int intModification, 
    String newName, String newPhoto, int newLocalPop, 
    int newSpeciesType){
        String message = "";

        Species species = intToSpecies(intSpecies);

        switch(intModification) {
            case 1:
                if(!searchSpecies(newName))
                {
                    species.setName(newName);
                    message = "The new name has been set successfully.";
                    break;
                } else {
                    message = "A species with that name already exists. Please enter other one.";
                }
            case 2:
                species.setPhoto(newPhoto);
                message = "The new photo has been set successfully.";
                break;
            case 3:
                species.setLocalPop(newLocalPop);
                message = "The new local population has been set successfully.";
                break;
            case 4:
                species.setType(Species.intToSpeciesType(newSpeciesType));
                message = "The new species type been set successfully.";
                break;

        }

        return message;
    }


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

    /**
    * <p><b>getSpeciesTypes</b></p>
    * <b>Description:</b> Retrieves an array containing descriptions of all species types available.
    * The actual organization of the String[] is done by {@link Species#getSpeciesTypes()}.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code getSpeciesTypes} method in the {@link Species} class must be in place.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>An array of species type names is returned containing all available species types.</li>
    * </ul>
    * 
    * @return A String[] holding all the descriptions representing the species type literals.
    */  
    public static String[] getSpeciesTypes(){
        return Species.getSpeciesTypes();
    }


    //SEARCH METHODS
    /**
    * <p><b>searchSpecies</b></p>
    * <b>Description:</b> Verifies if the entered species name already exists in the array of species. 
    * It iterates through all the existing species and checks if the name matches the entered species name.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code species array} holding the species must already be initialized.</li>
    *   <li>{@code speciesName} must be a String.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A boolean indicating if a duplicate species name was found or not.</li>
    * </ul>
    * 
    * @param speciesName The name of the species to be searched for in the species array.
    * @return A boolean indicating if there is a duplicate species name or not.
    */
    
    public boolean searchSpecies(String speciesName){

        boolean duplicate = false;

        for (Species species : this.species) {
            if (species != null && species.getName().equals(speciesName)) {
                duplicate = true;
            }
        }

        return duplicate;
    }

    //AVAILABLE SPACE METHODS 
    /**
    * <p><b>availableSpecies</b></p>
    * <b>Description:</b> Checks for the availability of space in the array of species to accommodate another species.
    * It iterates through the species array and verifies if each element is null. If an element is null, it returns the index of that element.
    * If no null elements are found, it returns -1 indicating no available space.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>The array holding the species must already be initialized.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>Returns the index of the last null element in the species array if space is available. If there is no more space, returns -1.</li>
    * </ul>
    * 
    * @return An integer representing the index of the last null element in the species array (returns -1 if there is no available space).
    */
    public int availableSpecies(){
        for (int i = 0; i < species.length; i++) {
            if (species[i] == null) {
                return i;
            }
        }
        //If there is no more space, a -1 will be returned
        return -1;
    }   

    //CHECK IF THERE IS ATLEAST ON SPECIES REGISTERED
    /**
    * <p><b>oneMinProduct</b></p>
    * <b>Description:</b> Checks if at least one product was registered already.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Array} of products must already exist.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A boolean value indicating if the first position in the products array is occupied or not is returned.</li>
    * </ul>
    * 
    * @return {@code true} if the first position of the products array is filled, {@code false} otherwise.
    */      
    public boolean oneMinSpecies() {
        boolean oneSpecies = false;

        if(species[0] != null){
            oneSpecies = true;
        }

        return oneSpecies;
    }


    //DISPLAY ALL CURRENTLY SAVED SPECIES
    /**
    * <p><b>displayProducts</b></p>
    * <b>Description:</b> Concatenates and returns a string that holds all the descriptions of the products within the community.
    * It iterates through the products array, assigns a number to each product, and extracts the product names.
    * It makes sure that no null product is passed on to prevent a Null Exception.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li> {@code products} must be in place and initialized.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A String holding all the numbered product names in order will be returned.</li>
    * </ul>
    * 
    * @return A String containing all the numbered product names within the community.
    */
    public String displaySpecies(){
        String message = "Species within this place:\n\t";

        for(int i = 0; i < species.length; i++){

            if(species[i]!=null){
                message += (i + 1) + ". " + species[i].getName() + "\n\t";
            }
        }

        return message;
    }

    //CHANGE AN INT TO A SPECIES
    /**
    * <p><b>intToPlace</b></p>
    * <b>Description:</b> Retrieves the place associated with the selected option from the list of places.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code intPlace} must be an int within the range of places printed.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The place associated with the entered option is returned.</li>
    * </ul>
    *
    * @param intPlace An int representing the selected option from the list of places.
    * @return The place that corresponds to the selected option from the list of places. 
    */   
    public Species intToSpecies(int intSpecies){
        Species species = this.species[intSpecies-1];
    
        return species;
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
