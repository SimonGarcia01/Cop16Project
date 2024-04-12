package model;

import java.text.SimpleDateFormat;
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
* <p><b>modifySpecies</b></p>
* <b>Description:</b> Helps in the process of modifying species data within the specified place and returns a message indicating success or failure. 
* The method retrieves the species based on the provided index and passes it on to the appropriate species's method to perform the modification).
* Based on the modification int, it will go and set the newName, newPhoto, newLocalPopulation or newSpeciesType.
* In case of changing the name, the method will check if the newName that is being entered already exists.
*
* <p><b>Preconditions:</b></p>
* <ul>
*   <li>{@code intSpecies} must be an integer representing an existing species.</li>
*   <li>{@code intModification} must be an integer representing the type of modification (e.g., name, photo, local population, species type).</li>
*   <li>{@code newName} must be a String.</li>
*   <li>{@code newPhoto} must be a String.</li>
*   <li>{@code newLocalPop} must be an int.</li>
*   <li>{@code newSpeciesType} must be an int between one and two.</li>
* </ul>
* 
* <p><b>Postconditions:</b></p>
* <ul>
*   <li>If the species data is successfully modified, a success message is returned.</li>
*   <li>If the user wants to change the speciesName it will first be checked if that name is already used.</li>
* </ul>
* 
* @param intSpecies The index of the species to be modified.
* @param intModification The type of modification to be performed (e.g., name, photo, local population, species type).
* @param newName The new name for the species.
* @param newPhoto The new photo URL for the species.
* @param newLocalPop The new local population for the species.
* @param newSpeciesType The new species type for the species.
* @return A message indicating if the species data was successfully modified or not.
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
                } else {
                    message = "A species with that name already exists. Please enter other one.";
                }
                break;
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

    //TO STRING METHOD
    /**
    * <p><b>toString</b></p>
    * <b>Description:</b> Generates a string representation of the place, including various attributes such as name, area, inauguration date, photo, resources, place type, department, caregiving community, and species information.
    * This method follows these steps to construct the string representation:
    * <ol>
    *   <li>Formats the inauguration date into a string representation using the specified date format.</li>
    *   <li>Constructs a string representation of the place with placeholders for the attributes.</li>
    *   <li>Returns the formatted string containing all the information about the place, including: the descriptions for the department and type literals, and the species information obtained through the {@link Place#displaySpecies()} method.</li>
    * </ol>
    *
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code intPlace} must be an integer representing an existing place.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A string containing the information about the specified place is returned.</li>
    * </ul>
    * 
    * @return A string containing the information about the specified place.
    */
    public String toString(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(this.inaugurationDate.getTime());

        String placeInfo = String.format("\n\tName: %s\n\tArea: %.2f\n\tInauguration Date: %s\n\tPhoto: %s\n\tResources: %.2f\n\tPlace Type: %s\n\tDepartment: %s\n\tCaregiving Community: %s\n\n\t%s",
        name, area, formattedDate, photo, resources, type.getDescription(), department.getDescription(), caregivingCommunity.getName(), displaySpecies());

        return placeInfo;
    }

    //COUNT AMOUNT OF SPECIES
    public int speciesCount(){
        int counter = 0;

        for(Species species : this.species){
            if(species != null){
                counter ++;
            }
        }

        return counter;
    }

    /**
    * <p><b>intToDepartment</b></p>
    * <b>Description:</b> Converts the integer representation of a department to its corresponding Department literal.
    * It delegates the conversion to the {@link Department#intToDepartment(int)} method.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code intDepartment} must be an int between 1 and 4.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The corresponding Department literal value is returned based on the provided integer.</li>
    * </ul>
    * 
    * @param intDepartment The int representing the department.
    * @return The Department enum value corresponding to the provided int.
    */    
    public static Department intToDepartment(int intDepartment){
        return Department.intToDepartment(intDepartment);
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
    * <p><b>intToSpecies</b></p>
    * <b>Description:</b> Retrieves the species associated with the selected option from the list of species.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code intSpecies} must be an integer within the range of species printed.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The species associated with the entered option is returned.</li>
    * </ul>
    *
    * @param intSpecies An integer representing the selected option from the list of species.
    * @return The species that corresponds to the selected option from the list of species. 
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
    
    /**
    * <p><b>setName</b></p>
    * <b>Description:</b> Sets the name of the place to a new provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code name} must be a non-null String.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The name of the place is updated to the provided value.</li>
    * </ul>
    *
    * @param name The new name for the place.
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * <p><b>getArea</b></p>
    * <b>Description:</b> Retrieves the area of the place.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
        *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The area of the place is returned.</li>
    * </ul>
    * 
    * @return The area of the place.
    */
    public double getArea() {
        return area;
    }

    /**
    * <p><b>setArea</b></p>
    * <b>Description:</b> Sets the area of the place to a new provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code area} must be a valid double value.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The area of the place is updated to the provided value.</li>
    * </ul>
    * 
    * @param area The new area for the place.
    */
    public void setArea(double area) {
        this.area = area;
    }

    /**
    * <p><b>getInaugurationDate</b></p>
    * <b>Description:</b> Retrieves the inauguration date of the place.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The inauguration date of the place is returned.</li>
    * </ul>
    * 
    * @return The inauguration date of the place.
    */
    public Calendar getInaugurationDate() {
        return inaugurationDate;
    }

    /**
    * <p><b>setInaugurationDate</b></p>
    * <b>Description:</b> Sets the inauguration date of the place to a new provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code inaugurationDate} must be a valid Calendar object.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The inauguration date of the place is updated to the provided value.</li>
    * </ul>
    * 
    * @param inaugurationDate The new inauguration date for the place.
    */
    public void setInaugurationDate(Calendar inaugurationDate) {
        this.inaugurationDate = inaugurationDate;
    }

    /**
    * <p><b>getPhoto</b></p>
    * <b>Description:</b> Retrieves the photo URL of the place.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The photo URL of the place is returned.</li>
    * </ul>
    * 
    * @return The photo URL of the place.
    */
    public String getPhoto() {
        return photo;
    }

    /**
    * <p><b>setPhoto</b></p>
    * <b>Description:</b> Sets the photo URL of the place to a new provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code photo} must be a non-null String.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The photo URL of the place is updated to the provided value.</li>
    * </ul>
    * 
    * @param photo The new photo URL for the place.
    */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
    * <p><b>getResources</b></p>
    * <b>Description:</b> Retrieves the resources allocated to maintain the place.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The resources allocated to maintain the place are returned.</li>
    * </ul>
    * 
    * @return The resources allocated to maintain the place.
    */ 
    public double getResources() {
        return resources;
    }

    /**
    * <p><b>setResources</b></p>
    * <b>Description:</b> Sets the resources allocated to maintain the place to a new provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code resources} must be a valid double value.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The resources allocated to maintain the place are updated to the provided value.</li>
    * </ul>
    * 
    * @param resources The new resources allocated to maintain the place.
    */
    public void setResources(double resources) {
        this.resources = resources;
    }

    /**
    * <p><b>getType</b></p>
    * <b>Description:</b> Retrieves the type of the place.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The type of the place is returned.</li>
    * </ul>
    * 
    * @return The type of the place.
    */
    public PlaceType getType() {
        return type;
    }

    /**
    * <p><b>setType</b></p>
    * <b>Description:</b> Sets the type of the place to a new provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code type} must be a valid PlaceType object.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The type of the place is updated to the provided value.</li>
    * </ul>
    * 
    * @param type The new type for the place.
    */
    public void setType(PlaceType type) {
        this.type = type;
    }

    /**
    * <p><b>getDepartment</b></p>
    * <b>Description:</b> Retrieves the department where the place is located.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The department where the place is located is returned.</li>
    * </ul>
    * 
    * @return The department where the place is located.
    */    
    public Department getDepartment() {
        return department;
    }

    /**
    * <p><b>setDepartment</b></p>
    * <b>Description:</b> Sets the department where the place is located to a new provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code department} must be a valid Department object.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The department where the place is located is updated to the provided value.</li>
    * </ul>
    * 
    * @param department The new department for the place.
    */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
    * <p><b>getCaregivingCommunity</b></p>
    * <b>Description:</b> Retrieves the caregiving community associated with the place.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The caregiving community associated with the place is returned.</li>
    * </ul>
    * 
    * @return The caregiving community associated with the place.
    */
    public Community getCaregivingCommunity() {
        return caregivingCommunity;
    }

    /**
    * <p><b>setCaregivingCommunity</b></p>
    * <b>Description:</b> Sets the caregiving community associated with the place to a new provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code caregivingCommunity} must be a valid Community object.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The caregiving community associated with the place is updated to the provided value.</li>
    * </ul>
    * 
    * @param caregivingCommunity The new caregiving community for the place.
    */
    public void setCaregivingCommunity(Community caregivingCommunity) {
        this.caregivingCommunity = caregivingCommunity;
    }

    //No need for a set since the species are added by another method
    /**
    * <p><b>getSpecies</b></p>
    * <b>Description:</b> Retrieves the array of species associated with the place.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Null} search can't be done on a null object. Null Pointer Exception.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The array of species associated with the place is returned.</li>
    * </ul>
    * 
    * @return The array of species associated with the place.
    */    
    public Species[] getSpecies() {
        return species;
    }
}
