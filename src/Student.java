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
    private int grade;

    public Student (String first, String last, String phone, int grade)
    {
        super(first, last, phone);
        this.grade = grade;
    }

    public int getGrade()
    {
        return grade;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Grade: " + grade;
    }
}
