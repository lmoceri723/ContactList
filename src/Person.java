/**
 * A class that represents a Person
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class Person
{
    // TODO: Complete the Person class
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Person (String first, String last, String phone)
    {
        firstName = first;
        lastName = last;
        phoneNumber = phone;
    }

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

    @Override
    public String toString()
    {
        return firstName + " " + lastName + " - " + phoneNumber;
    }
}
