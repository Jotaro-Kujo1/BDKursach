package database;

import pojo.Country;
import pojo.Education;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EducationDomain extends CrudRepository{

    public <T> void add (T education){
        Education tmp = null;
        if(education instanceof Education) tmp = (Education) education;
        String sqlQuery = "INSERT INTO education VALUES(?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,tmp.getId());
            statement.setString(2, tmp.getEducation());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }



    public void delete (int id){
        String sqlQuery = "DELETE FROM education WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public <T> T get (int id){
        String sqlQuery = "SELECT * FROM education WHERE Id='" + id + "'";
        Education education = null;
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            if(rs.next()){
                education = new Education(Integer.parseInt(rs.getString("Id")), rs.getString("Образование"));
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return (T) education;
    }

    public int transformation (String str) {
        String sqlQuery = "SELECT Id FROM education WHERE Образование='" + str + "'";
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

    public <T> List<T> readResultSet () {
        Education tmp = null;
        List<Education> list = new ArrayList<>();
        String sqlQuery = "SELECT * FROM education";
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                tmp = new Education(Integer.parseInt(rs.getString("Id")), rs.getString("Образование"));
                list.add(tmp);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return (List<T>) list;
    }
}
