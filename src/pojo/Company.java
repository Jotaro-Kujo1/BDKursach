package pojo;

public class Company {
    private int id;
    private String company;

    public Company(int id, String company){
        this.id = id;
        this.company = company;
    }

    public Company(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
