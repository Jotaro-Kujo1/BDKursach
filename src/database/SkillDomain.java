package database;

import pojo.Office;
import pojo.Skill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDomain extends CrudRepository{

    public <T> void add (T skill){
        Skill tmp = null;
        if(skill instanceof Skill) tmp = (Skill) skill;
        String sqlQuery = "INSERT INTO skills VALUES(?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,tmp.getId());
            statement.setString(2, tmp.getSkill());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void delete (int id){
        String sqlQuery = "DELETE FROM skills WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public <T> T get (int id){
        String sqlQuery = "SELECT * FROM skills WHERE Id='" + id + "'";
        Skill skill = null;
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            if(rs.next()){
                skill = new Skill(Integer.parseInt(rs.getString("Id")), rs.getString("Умение"));
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return (T)skill;
    }

    public int transformation (String str) {
        String sqlQuery = "SELECT Id FROM offices WHERE Город='" + str + "'";
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
        Skill skill = null;
        List<Skill> list = new ArrayList<>();
        String sqlQuery = "SELECT * FROM skills";
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                skill = new Skill(Integer.parseInt(rs.getString("Id")), rs.getString("Умение"));
                list.add(skill);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return (List<T>)list;

    }
}









