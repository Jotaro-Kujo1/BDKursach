package database;

import pojo.Speciality;
import pojo.Vacancy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VacancyDomain extends CrudRepository{

    public <T> void add (T vacancy){
        Vacancy tmp = null;
        if(vacancy instanceof Vacancy) tmp = (Vacancy) vacancy;
        String sqlQuery = "INSERT INTO vacancy VALUES(?,?,?,?,?,?,?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,tmp.getId());
            statement.setInt(2, tmp.getSkill());
            statement.setInt(3,tmp.getExperience());
            statement.setInt(4, tmp.getSalary());
            statement.setInt(5,tmp.getNumberOfWorkplaces());
            statement.setInt(6, tmp.getPrivileges());
            statement.setInt(7,tmp.getOffice());
            statement.setInt(8, tmp.getCompany());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void delete (int id){
        String sqlQuery = "DELETE FROM vacancy WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public <T> T get (int id){
        String sqlQuery = "SELECT * FROM vacancy WHERE Id='" + id + "'";
        Vacancy vacancy = null;
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            if(rs.next()){
                vacancy = new Vacancy(Integer.parseInt(rs.getString("Id")), Integer.parseInt(rs.getString("Вакансия")),Integer.parseInt(rs.getString("Опыт")),Integer.parseInt(rs.getString("Зарплата")),
                        Integer.parseInt(rs.getString("Количество рабочих мест")),Integer.parseInt(rs.getString("Льготы")),Integer.parseInt(rs.getString("Офисы")),Integer.parseInt(rs.getString("Предприятие")));
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return (T) vacancy;
    }

    public int transformation (String str) {
        return 0;
    }



    public <T> List<T> readResultSet () {
        Vacancy vacancy = null;
        List<Vacancy> list = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vacancy";
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                vacancy = new Vacancy(Integer.parseInt(rs.getString("Id")), Integer.parseInt(rs.getString("Вакансия")),Integer.parseInt(rs.getString("Опыт")),Integer.parseInt(rs.getString("Зарплата")),
                        Integer.parseInt(rs.getString("Количество рабочих мест")),Integer.parseInt(rs.getString("Льготы")),Integer.parseInt(rs.getString("Офисы")),Integer.parseInt(rs.getString("Предприятие")));
                list.add(vacancy);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return (List<T>) list;
    }
}
