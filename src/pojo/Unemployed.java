package pojo;

public class Unemployed {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private int age;
    private int gender;
    private int education;
    private int experience;
    private String contacts;
    private int country;
    private int previousEmployment;
    private String passport;

    public Unemployed(int id, String surname, String name, String patronymic, int age, int gender, int education, int experience, String contacts, int country, int previousEmployment, String  passport){
       this.id = id;
       this.surname = surname;
       this.name = name;
       this.patronymic = patronymic;
       this.age = age;
       this.gender = gender;
       this.education = education;
       this.experience = experience;
       this.contacts = contacts;
       this.country = country;
       this.previousEmployment = previousEmployment;
       this.passport = passport;
    }

    public Unemployed(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getPreviousEmployment() {
        return previousEmployment;
    }

    public void setPreviousEmployment(int previousEmployment) {
        this.previousEmployment = previousEmployment;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
