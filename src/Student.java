/**
 * A subclass of Person that represents a Student
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam, Mr. Blick, and Landon Moceri
 * @version: 2022-2023
 */

public class Student extends Person
{
    // Instance variable for grade
    private int grade;

    // Constructs a student object
    public Student (String first, String last, String phone, int grade)
    {
        super(first, last, phone);
        this.grade = grade;
    }

    // Getter for grade
    public int getGrade()
    {
        return grade;
    }

    // Overridden toString that also prints the student's grade
    @Override
    public String toString()
    {
        return super.toString() + " Grade: " + grade;
    }
}
