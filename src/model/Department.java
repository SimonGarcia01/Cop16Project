package model;

public enum Department {
    //Enumeration ligerals
    CHOCO("Choco"),
    VALLE("Valle del Cauca"),
    CAUCA("Cauca"),
    NARINO("Narino");

    //Attributes
    private final String description;

    //Methods

    //TO EXTRACT THE LIST OF DESCRIPTIONS
    /**
    * <p><b>getDepartments</b></p>
    * <b>Description:</b> Extracts all the descriptions that are associated to the literals of the Department enumeration and returns a String[] holding them. 
    * The method loops through each Department, extracting its description, and concatenates everything.
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
    * @return A string[] holding all the descriptions representing the Department literals.
    */
    public static String[] getDepartments() {
        Department[] departments = Department.values();
        String[] descriptions = new String[departments.length];
        for (int i = 0; i < departments.length; i++) {
            descriptions[i] = departments[i].getDescription();
        }
        return descriptions;
    }

    //CHANGE AN INT TO A COMMUNITYTYPE
    /**
    * <p><b>intToDepartment</b></p>
    * <b>Description:</b> Takes in the selected option from the list of literals (printed as descriptions) and then runs a switch to return the value as a literal from the enumeration.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code intDepartment} must be an int between 1 and 4.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A Department literal is returned associated to the list of literals.</li>
    * </ul>
    * 
    * @param intDepartment An int that the user entered to choose one of the Department types.
    * @return Department literal associated to the list of Department descriptions.
    */
    public static Department intToDepartment(int intDepartment){
        Department department = null;
        switch(intDepartment){
            case 1:
                department = CHOCO;
                break;
            case 2:
                department = VALLE;
                break;
            case 3:
                department = CAUCA;
                break;
            case 4:
                department = NARINO;
        }

        return department;
    }

   //CONSTRUCTOR
    /**
    * <p><b>Department</b></p>
    * <b>Description:</b> Initializes the Department literals with an associated String description.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code description} There should be an associated attribute for the description and the literals must have their descriptions.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The literals inside Department are initialized with associated descriptions.</li>
    * </ul>
    * 
    * @param description String that comes from the Department literal list.  
    */
    private Department(String description){
        this.description = description;
    }

    //GET THE DESCRIPTION FOR ONE LITERAL
    /**
	* <p><b>getDescription</b></p>
	* <b>Description:</b> Extracts the description associated to the Department's literal in the enumeration.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code literals} must have an associated description. </li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A string that holds the description to a literal is returned.</li>
	* </ul>
	*
	* @return A String with the description of a Department literal.
	*/
    public String getDescription(){
        return description;
    }
}
