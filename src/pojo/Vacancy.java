package pojo;

public class Vacancy {

    private int id;
    private int skill;
    private int experience;
    private int salary;
    private int numberOfWorkplaces;
    private int privileges;
    private int office;
    private int company;

    public Vacancy(int id,int skill,int experience, int salary, int numberOfWorkplaces, int privileges, int office, int company){
        this.id = id;
        this.skill = skill;
        this.experience = experience;
        this.salary = salary;
        this.numberOfWorkplaces = numberOfWorkplaces;
        this.privileges = privileges;
        this.office = office;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public int getSkill() {
        return skill;
    }

    public int getExperience() {
        return experience;
    }

    public int getSalary() {
        return salary;
    }

    public int getNumberOfWorkplaces() {
        return numberOfWorkplaces;
    }

    public int getPrivileges() {
        return privileges;
    }

    public int getOffice() {
        return office;
    }

    public int getCompany() {
        return company;
    }
}
