package database;

import pojo.Office;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OfficeDomain extends CrudRepository{

    public <T> void add (T office){
        Office tmp = null;
        if(office instanceof Office) tmp = (Office) office;
        String sqlQuery = "INSERT INTO offices VALUES(?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,tmp.getId());
            statement.setString(2, tmp.getCity());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }



    public void delete (int id){
        String sqlQuery = "DELETE FROM offices WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public <T> T get (int id){
        String sqlQuery = "SELECT * FROM offices WHERE Id='" + id + "'";
        Office office = null;
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            if(rs.next()){
                office = new Office(Integer.parseInt(rs.getString("Id")), rs.getString("Город"));
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return (T) office;
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
        Office office = null;
        List<Office> list = new ArrayList<>();
        String sqlQuery = "SELECT * FROM offices";
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                office = new Office(Integer.parseInt(rs.getString("Id")), rs.getString("Город"));
                list.add(office);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return (List<T>) list;
    }
}
