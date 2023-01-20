import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam, Mr. Blick, and Landon Moceri
 * @version: 2022-2023
 */

public class ContactList
{
    // ArrayList that holds the contacts
    // Stores Person objects so that Workers and Students can both have the Person reference type and be stored
    private ArrayList<Person> contacts;

    // Constructs a ContactList
    public ContactList()
    {
        contacts = new ArrayList<Person>();
    }

    // Prints out the menu options
    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Worker/Student with reference type Person
     * to the contact list
     */
    public void addContact()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Select a type of contact to add:\n1. Student\n2. Worker");

        int type;
        // Throws an error message when the user doesn't type an int
        try
        {
            type = s.nextInt();
            s.nextLine();
        }
        catch(Exception e)
        {
            System.out.println("Must be a number");
            return;
        }

        // Throws an error message when the type is outside the valid range
        if (type != 1 && type != 2)
        {
            System.out.println("Invalid Type");
            return;
        }

        System.out.println("First Name: ");
        String first = s.nextLine();

        System.out.println("Last Name: ");
        String last = s.nextLine();

        System.out.println("Phone Number: ");
        String phone = s.nextLine();

        if (type == 1)
        {
            // Creates a Student object and throws an error if the grade is not a number
            try
            {
                System.out.println("Grade: ");
                int grade = s.nextInt();
                Person p = new Student(first, last, phone, grade);
                contacts.add(p);
            }
            catch (Exception e)
            {
                System.out.println("Must be a number");
            }
        }
        else
        {
            // Creates a Worker object
            System.out.println("Job: ");
            String job = s.nextLine();
            Person p = new Worker(first, last, phone, job);
            contacts.add(p);
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts()
    {
        for (Person contact : contacts)
        {
            System.out.println(contact);
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy)
    {
        int size = contacts.size();
        if (sortBy == 0)
        {
            // Passes through contacts n (size) times
            for(int pass = 1; pass < size; pass++)
            {
                // Moves the largest element to the end of the array each time
                // Removes the last element from the next pass as its position is valid
                for(int comp = 0; comp < size - pass; comp++)
                {
                    String nameOne = contacts.get(comp).getFirstName();
                    String nameTwo = contacts.get(comp + 1).getFirstName();
                    if (nameOne.compareTo(nameTwo) > 0)
                    {
                        Person temp = contacts.get(comp);
                        contacts.set(comp, contacts.get(comp + 1));
                        contacts.set(comp + 1, temp);
                    }
                }
            }

        }
        // Same methodology for both other sorting types, only conditions are different
        else if (sortBy == 1)
        {
            for(int pass = 1; pass < size; pass++)
            {
                for(int comp = 0; comp < size - pass; comp++)
                {
                    String nameOne = contacts.get(comp).getLastName();
                    String nameTwo = contacts.get(comp + 1).getLastName();
                    if (nameOne.compareTo(nameTwo) > 0)
                    {
                        Person temp = contacts.get(comp);
                        contacts.set(comp, contacts.get(comp + 1));
                        contacts.set(comp + 1, temp);
                    }
                }
            }
        }
        else
        {
            for(int pass = 1; pass < size; pass++)
            {
                for(int comp = 0; comp < size - pass; comp++)
                {
                    String numOne = contacts.get(comp).getPhoneNumber();
                    String numTwo = contacts.get(comp + 1).getPhoneNumber();
                    if (numOne.compareTo(numTwo) > 0)
                    {
                        Person temp = contacts.get(comp);
                        contacts.set(comp, contacts.get(comp + 1));
                        contacts.set(comp + 1, temp);
                    }
                }
            }

        }
    }

    // Searches contacts for a person with a matching first name
    public Person searchByFirstName(String name)
    {
        for (Person p : contacts)
        {
            if (p.getFirstName().equals(name))
            {
                return p;
            }
        }
        return null;
    }

    // Searches contacts for a person with a matching last name
    public Person searchByLastName(String name)
    {
        for (Person p : contacts)
        {
            if (p.getLastName().equals(name))
            {
                return p;
            }
        }
        return null;
    }

    // Searches contacts for a person with a matching phone number
    public Person searchByPhoneNumber(String num)
    {
        for (Person p : contacts)
        {
            if (p.getPhoneNumber().equals(num))
            {
                return p;
            }
        }
        return null;
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents()
    {
        for (Person p : contacts)
        {
            if (p instanceof Student)
            {
                System.out.println(p);
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        Scanner s = new Scanner(System.in);


        while(true)
        {
            // Prompts user for an option and returns error messages if it's out of the valid range or not an int
            printMenuOptions();

            String input = s.nextLine();
            // Checks if there are any non-ints in input
            if (!input.matches("[0-9]+"))
            {
                input = "-1";
            }
            int choice = Integer.parseInt(input);

            switch(choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    // Sorts contacts by first name and prints
                    sort(0);
                    printContacts();
                    break;
                case 3:
                    // Sorts contacts by last name and prints
                    sort(1);
                    printContacts();
                    break;
                case 4:
                    // Sorts contacts by phone number and prints
                    sort(2);
                    printContacts();
                    break;
                case 5:
                    listStudents();
                    break;
                case 6:
                    // Prompts user for the first name and then prints the contact that matches with it
                    System.out.println("Enter a name: ");
                    String first = s.nextLine();

                    Person p = searchByFirstName(first);
                    if (p == null)
                    {
                        System.out.println(first + " is not in the list");
                    }
                    else
                    {
                        System.out.println(p);
                    }
                    break;

                case 7:
                    // Prompts user for the last name and then prints the contact that matches with it
                    System.out.println("Enter a name: ");
                    String last = s.nextLine();

                    p = searchByLastName(last);
                    if (p == null)
                    {
                        System.out.println(last + " is not in the list");
                    }
                    else
                    {
                        System.out.println(p);
                    }
                    break;
                case 8:
                    // Prompts user for the phone number and then prints the contact that matches with it
                    System.out.println("Enter a phone number: ");
                    String num = s.nextLine();

                    p = searchByPhoneNumber(num);
                    if (p == null)
                    {
                        System.out.println(num + " is not in the list");
                    }
                    else
                    {
                        System.out.println(p);
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
