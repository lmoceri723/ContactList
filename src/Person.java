/**
 * A class that represents a Person
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam, Mr. Blick, and Landon Moceri
 * @version: 2022-2023
 */

public class Person
{
    // Instance variables for the first name, last name, and number
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructs a person object
    public Person (String first, String last, String phone)
    {
        firstName = first;
        lastName = last;
        phoneNumber = phone;
    }

    // Getters for the instance variables
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    // Overridden toString that prints information about the person
    @Override
    public String toString()
    {
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}
