public class CustomerContact {

    // properties
    private String firstName;
    private String lastName;
    private String email;

    //default constructor needed to instantiate in another class since I didn't instantiate in this class

    public CustomerContact() {
    }

    //constructor
    public CustomerContact(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
