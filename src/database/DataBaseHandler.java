package database;

import pojo.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler {
    private Connection dbConnection;


    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:ucanaccess://C:/Javist/BDKurs/LaborExchange.accdb";//Когда скину на флешку нужно будет сменить путь
        //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        dbConnection = DriverManager.getConnection(connectionString);
        return dbConnection;
    }

    public boolean userSignIn(String login, String password){
        ResultSet rset = null;
        String sqlQuery = "SELECT * FROM users WHERE Логин =? AND Пароль =?";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setString(1,login);
            statement.setString(2,password);
            rset = statement.executeQuery();
            if(rset.next()) return true;
            else return false;
        }catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    public boolean userRegistration(String login, String password){
        String sqlQuery = "INSERT INTO users (Логин, Пароль) VALUES(?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setString(1, login);
            statement.setString(2, password);
            statement.execute();
            return true;
        }catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    public List<Unemployed> readUnemplResultSet(){
        String sqlQuery = "SELECT * FROM unemployed";
        List<Unemployed> list = new ArrayList<>();
        try(Statement statement = getDbConnection().createStatement()){
            Unemployed up = null;
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                up = new Unemployed(Integer.parseInt(rs.getString("Id")),rs.getString("Фамилия"),rs.getString("Имя"),rs.getString("Отчество"),Integer.parseInt(rs.getString("Возраст")),
                        Integer.parseInt(rs.getString("Пол")),Integer.parseInt(rs.getString("Образование")), Integer.parseInt(rs.getString("Опыт")), rs.getString("Контакты"), Integer.parseInt(rs.getString("Страна")),
                        Integer.parseInt(rs.getString("Предыдущее место работы")),rs.getString("Паспорт"));
                list.add(up);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }

    public void addUnempl(Unemployed unempl){
        String sqlQuery = "INSERT INTO unemployed VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,unempl.getId());
            statement.setString(2, unempl.getSurname());
            statement.setString(3, unempl.getName());
            statement.setString(4, unempl.getPatronymic());
            statement.setInt(5, unempl.getAge());
            statement.setInt(6, unempl.getGender());
            statement.setInt(7, unempl.getEducation());
            statement.setInt(8, unempl.getExperience());
            statement.setString(9, unempl.getContacts());
            statement.setInt(10, unempl.getCountry());
            statement.setInt(11, unempl.getPreviousEmployment());
            statement.setString(12, unempl.getPassport());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public List<Company> readCompanyResultSet(){
        String sqlQuery = "SELECT * FROM company";
        List<Company> list = new ArrayList<>();
        try(Statement statement = getDbConnection().createStatement()){
            Company company = null;
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                company = new Company(Integer.parseInt(rs.getString("Id")), rs.getString("Компания"));
                list.add(company);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }

    public void addCompany(Company company){
        String sqlQuery = "INSERT INTO company VALUES(?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,company.getId());
            statement.setString(2, company.getCompany());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public List<Country> readCountryResultSet(){
        String sqlQuery = "SELECT * FROM country";
        List<Country> list = new ArrayList<>();
        try(Statement statement = getDbConnection().createStatement()){
            Country country = null;
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                country = new Country(Integer.parseInt(rs.getString("Id")), rs.getString("Страна"));
                list.add(country);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }

    public void addCountry(Country country){
        String sqlQuery = "INSERT INTO country VALUES(?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,country.getId());
            statement.setString(2, country.getCountry());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public List<Education> readEducationResultSet(){
        String sqlQuery = "SELECT * FROM education";
        List<Education> list = new ArrayList<>();
        try(Statement statement = getDbConnection().createStatement()){
            Education education = null;
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                education = new Education(Integer.parseInt(rs.getString("Id")), rs.getString("Образование"));
                list.add(education);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }

    public void addEducation(Education education){
        String sqlQuery = "INSERT INTO education VALUES(?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,education.getId());
            statement.setString(2, education.getEducation());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public List<Office> readOfficeResultSet(){
        String sqlQuery = "SELECT * FROM offices";
        List<Office> list = new ArrayList<>();
        try(Statement statement = getDbConnection().createStatement()){
            Office office = null;
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                office = new Office(Integer.parseInt(rs.getString("Id")), rs.getString("Город"));
                list.add(office);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }

    public void addOffice(Office office){
        String sqlQuery = "INSERT INTO offices VALUES(?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,office.getId());
            statement.setString(2, office.getCity());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public List<Skill> readSkillResultSet(){
        String sqlQuery = "SELECT * FROM skills";
        List<Skill> list = new ArrayList<>();
        try(Statement statement = getDbConnection().createStatement()){
            Skill skill = null;
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                skill = new Skill(Integer.parseInt(rs.getString("Id")), rs.getString("Умение"));
                list.add(skill);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }

    public void addSkill(Skill skill){
        String sqlQuery = "INSERT INTO skills VALUES(?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,skill.getId());
            statement.setString(2, skill.getSkill());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public List<Speciality> readSpecialityResultSet(){
        String sqlQuery = "SELECT * FROM speciality";
        List<Speciality> list = new ArrayList<>();
        try(Statement statement = getDbConnection().createStatement()){
            Speciality speciality = null;
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                speciality = new Speciality(Integer.parseInt(rs.getString("Id")), Integer.parseInt(rs.getString("Специальность")),Integer.parseInt(rs.getString("Зарплата")),Integer.parseInt(rs.getString("Человек")));
                list.add(speciality);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }

    public void addSpeciality(Speciality speciality){
        String sqlQuery = "INSERT INTO speciality VALUES(?,?,?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,speciality.getId());
            statement.setInt(2, speciality.getSpeciality());
            statement.setInt(3,speciality.getSalary());
            statement.setInt(4, speciality.getPerson());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public List<Vacancy> readVacancyResultSet(){
        String sqlQuery = "SELECT * FROM vacancy";
        List<Vacancy> list = new ArrayList<>();
        try(Statement statement = getDbConnection().createStatement()){
            Vacancy vacancy = null;
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                vacancy = new Vacancy(Integer.parseInt(rs.getString("Id")), Integer.parseInt(rs.getString("Вакансия")),Integer.parseInt(rs.getString("Опыт")),Integer.parseInt(rs.getString("Зарплата")),
                        Integer.parseInt(rs.getString("Количество рабочих мест")),Integer.parseInt(rs.getString("Льготы")),Integer.parseInt(rs.getString("Офисы")),Integer.parseInt(rs.getString("Предприятие")));
                list.add(vacancy);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }

    public void addVacancy(Vacancy vacancy){
        String sqlQuery = "INSERT INTO vacancy VALUES(?,?,?,?,?,?,?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,vacancy.getId());
            statement.setInt(2, vacancy.getSkill());
            statement.setInt(3,vacancy.getExperience());
            statement.setInt(4, vacancy.getSalary());
            statement.setInt(5,vacancy.getNumberOfWorkplaces());
            statement.setInt(6, vacancy.getPrivileges());
            statement.setInt(7,vacancy.getOffice());
            statement.setInt(8, vacancy.getCompany());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void deleteCompany(int id){
        String sqlQuery = "DELETE FROM company WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void deleteCountry(int id){
        String sqlQuery = "DELETE FROM country WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void deleteEducation(int id){
        String sqlQuery = "DELETE FROM education WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void deleteOffice(int id){
        String sqlQuery = "DELETE FROM offices WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void deleteSkill(int id){
        String sqlQuery = "DELETE FROM skills WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void deleteSpeciality(int id){
        String sqlQuery = "DELETE FROM speciality WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void deleteUnempl(int id){
        String sqlQuery = "DELETE FROM unemployed WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void deleteVacancy(int id){
        String sqlQuery = "DELETE FROM vacancy WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public int genderTransformation(String gender){
        String sqlQuery = "SELECT Id FROM gender WHERE Пол='" + gender + "'";
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            if(rs.next()){
                return Integer.parseInt(rs.getString("Id"));
            }
            return 0;
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
            return 0;
        }
    }

    public int educationTransformation(String education){
        String sqlQuery = "SELECT Id FROM education WHERE Образование='" + education + "'";
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            if(rs.next()){
                return Integer.parseInt(rs.getString("Id"));
            }
            return 0;
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
            return 0;
        }
    }

    public int countryTransformation(String country){
        String sqlQuery = "SELECT Id FROM country WHERE Страна='" + country + "'";
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            if(rs.next()){
                return Integer.parseInt(rs.getString("Id"));
            }
            return 0;
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
            return 0;
        }
    }

    public int previousPlaceTransformation(String place){
        String sqlQuery = "SELECT Id FROM company WHERE Компания='" + place + "'";
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            if(rs.next()){
                return Integer.parseInt(rs.getString("Id"));
            }
            return 0;
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
            return 0;
        }
    }

    public int specialityTransformation(String skill){
        String sqlQuery = "SELECT Id FROM skills WHERE Умение='" + skill + "'";
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            if(rs.next()){
                return Integer.parseInt(rs.getString("Id"));
            }
            return 0;
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
            return 0;
        }
    }

}
