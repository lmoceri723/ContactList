public class Worker extends Person
{
    private String job;

    public Worker(String first, String last, String phone, String job)
    {
        super(first, last, phone);
        this.job = job;
    }

    public String getJob()
    {
        return job;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Job: " + job;
    }
}
