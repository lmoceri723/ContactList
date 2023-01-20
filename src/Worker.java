/**
 * A class that represents a Person
 *
 * Created for Menlo School CS2
 *
 * @author: Landon Moceri
 * @version: 2022-2023
 */
public class Worker extends Person
{
    // Instance variable for the worker's job
    private String job;

    // Constructs a worker object
    public Worker(String first, String last, String phone, String job)
    {
        super(first, last, phone);
        this.job = job;
    }

    // Getter for job
    public String getJob()
    {
        return job;
    }

    // Overridden toString that prints the workers job in addition to their other info
    @Override
    public String toString()
    {
        return super.toString() + " Job: " + job;
    }
}
