package pojo;

public class Speciality {
    private int id;
    private int speciality;
    private int salary;
    private int person;

    public Speciality(int id, int speciality, int salary, int person){
        this.id = id;
        this.speciality = speciality;
        this.salary = salary;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpeciality() {
        return speciality;
    }

    public void setSpeciality(int speciality) {
        this.speciality = speciality;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }
}
