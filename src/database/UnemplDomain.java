package database;

import pojo.Education;
import pojo.Unemployed;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UnemplDomain extends CrudRepository{

    public <T> void add (T unemployed){
        Unemployed tmp = null;
        if(unemployed instanceof Unemployed) tmp = (Unemployed) unemployed;
        String sqlQuery = "INSERT INTO unemployed VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,tmp.getId());
            statement.setString(2, tmp.getSurname());
            statement.setString(3, tmp.getName());
            statement.setString(4, tmp.getPatronymic());
            statement.setInt(5, tmp.getAge());
            statement.setInt(6, tmp.getGender());
            statement.setInt(7, tmp.getEducation());
            statement.setInt(8, tmp.getExperience());
            statement.setString(9, tmp.getContacts());
            statement.setInt(10, tmp.getCountry());
            statement.setInt(11, tmp.getPreviousEmployment());
            statement.setString(12, tmp.getPassport());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void delete (int id){
        String sqlQuery = "DELETE FROM unemployed WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public <T> T get (int id){
        String sqlQuery = "SELECT * FROM unemployed WHERE Id='" + id + "'";
        Unemployed unemployed = null;
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            if(rs.next()){
                unemployed = new Unemployed(Integer.parseInt(rs.getString("Id")),rs.getString("??????????????"),rs.getString("??????"),rs.getString("????????????????"),Integer.parseInt(rs.getString("??????????????")),
                        Integer.parseInt(rs.getString("??????")),Integer.parseInt(rs.getString("??????????????????????")), Integer.parseInt(rs.getString("????????")), rs.getString("????????????????"), Integer.parseInt(rs.getString("????????????")),
                        Integer.parseInt(rs.getString("???????????????????? ?????????? ????????????")),rs.getString("??????????????"));
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return (T) unemployed;
    }

    public int transformation (String str) {
        return 0;
    }



    public <T> List<T> readResultSet () {
        Unemployed unemployed = null;
        List<Unemployed> list = new ArrayList<>();
        String sqlQuery = "SELECT * FROM unemployed";
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                unemployed = new Unemployed(Integer.parseInt(rs.getString("Id")),rs.getString("??????????????"),rs.getString("??????"),rs.getString("????????????????"),Integer.parseInt(rs.getString("??????????????")),
                        Integer.parseInt(rs.getString("??????")),Integer.parseInt(rs.getString("??????????????????????")), Integer.parseInt(rs.getString("????????")), rs.getString("????????????????"), Integer.parseInt(rs.getString("????????????")),
                        Integer.parseInt(rs.getString("???????????????????? ?????????? ????????????")),rs.getString("??????????????"));
                list.add(unemployed);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return (List<T>) list;
    }

    public List<Unemployed> getPeopleForCountry(int id){
        List<Unemployed> list = new ArrayList<Unemployed>();
        Unemployed unemployed = null;
        String sqlQuery = "SELECT unemployed.* , country.Id FROM unemployed INNER JOIN country ON country.Id = unemployed.???????????? WHERE country.Id =" + id;
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()){
                unemployed = new Unemployed(Integer.parseInt(rs.getString("Id")),rs.getString("??????????????"),rs.getString("??????"),rs.getString("????????????????"),Integer.parseInt(rs.getString("??????????????")),
                        Integer.parseInt(rs.getString("??????")),Integer.parseInt(rs.getString("??????????????????????")), Integer.parseInt(rs.getString("????????")), rs.getString("????????????????"), Integer.parseInt(rs.getString("????????????")),
                        Integer.parseInt(rs.getString("???????????????????? ?????????? ????????????")),rs.getString("??????????????"));
                list.add(unemployed);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }

    public List<Unemployed> getPeopleForGender(int id){
        List<Unemployed> list = new ArrayList<Unemployed>();
        Unemployed unemployed = null;
        String sqlQuery = "SELECT unemployed.* , gender.Id FROM unemployed INNER JOIN gender ON gender.Id = unemployed.?????? WHERE gender.Id =" + id;
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()){
                unemployed = new Unemployed(Integer.parseInt(rs.getString("Id")),rs.getString("??????????????"),rs.getString("??????"),rs.getString("????????????????"),Integer.parseInt(rs.getString("??????????????")),
                        Integer.parseInt(rs.getString("??????")),Integer.parseInt(rs.getString("??????????????????????")), Integer.parseInt(rs.getString("????????")), rs.getString("????????????????"), Integer.parseInt(rs.getString("????????????")),
                        Integer.parseInt(rs.getString("???????????????????? ?????????? ????????????")),rs.getString("??????????????"));
                list.add(unemployed);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }

    public List<Unemployed> getPeopleForSpeciality(int id){
        List<Unemployed> list = new ArrayList<Unemployed>();
        Unemployed unemployed = null;
        String sqlQuery1 = "SELECT unemployed.*, speciality.??????????????????????????, speciality.??????????????, skills.Id FROM unemployed INNER JOIN speciality INNER JOIN skills ON unemployed.Id = speciality.?????????????? AND skills.Id = speciality.?????????????????????????? WHERE skills.Id=" + id;
        String sqlQuery = "SELECT unemployed.*, speciality.??????????????????????????, speciality.??????????????, FROM unemployed INNER JOIN speciality ON speciality.?????????????? = unemployed.Id";
        //String sqlQuery = "SELECT unemployed.*, speciality.??????????????, speciality.Id, skills.Id FROM unemployed INNER JOIN speciality ON speciality.?????????????? = unemployed.Id ON speciality INNER JOIN skills ON skills.Id = speciality.?????????????? WHERE skills.Id =" + id;
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery1);
            while (rs.next()){
                unemployed = new Unemployed(Integer.parseInt(rs.getString("Id")),rs.getString("??????????????"),rs.getString("??????"),rs.getString("????????????????"),Integer.parseInt(rs.getString("??????????????")),
                        Integer.parseInt(rs.getString("??????")),Integer.parseInt(rs.getString("??????????????????????")), Integer.parseInt(rs.getString("????????")), rs.getString("????????????????"), Integer.parseInt(rs.getString("????????????")),
                        Integer.parseInt(rs.getString("???????????????????? ?????????? ????????????")),rs.getString("??????????????"));
                list.add(unemployed);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }

    public List<Unemployed> getPeopleForEducation(int id){
        List<Unemployed> list = new ArrayList<Unemployed>();
        Unemployed unemployed = null;
        String sqlQuery = "SELECT unemployed.* , education.Id FROM unemployed INNER JOIN education ON education.Id = unemployed.?????????????????????? WHERE education.Id =" + id;
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()){
                unemployed = new Unemployed(Integer.parseInt(rs.getString("Id")),rs.getString("??????????????"),rs.getString("??????"),rs.getString("????????????????"),Integer.parseInt(rs.getString("??????????????")),
                        Integer.parseInt(rs.getString("??????")),Integer.parseInt(rs.getString("??????????????????????")), Integer.parseInt(rs.getString("????????")), rs.getString("????????????????"), Integer.parseInt(rs.getString("????????????")),
                        Integer.parseInt(rs.getString("???????????????????? ?????????? ????????????")),rs.getString("??????????????"));
                list.add(unemployed);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }

    public List<Unemployed> getPeopleForAge(int age){
        List<Unemployed> list = new ArrayList<Unemployed>();
        Unemployed unemployed = null;
        String sqlQuery = "SELECT * FROM unemployed WHERE unemployed.?????????????? >= " + age;
        //String sqlQuery = "SELECT unemployed.* , education.Id FROM unemployed INNER JOIN education ON education.Id = unemployed.?????????????????????? WHERE education.Id =" + id;
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()){
                unemployed = new Unemployed(Integer.parseInt(rs.getString("Id")),rs.getString("??????????????"),rs.getString("??????"),rs.getString("????????????????"),Integer.parseInt(rs.getString("??????????????")),
                        Integer.parseInt(rs.getString("??????")),Integer.parseInt(rs.getString("??????????????????????")), Integer.parseInt(rs.getString("????????")), rs.getString("????????????????"), Integer.parseInt(rs.getString("????????????")),
                        Integer.parseInt(rs.getString("???????????????????? ?????????? ????????????")),rs.getString("??????????????"));
                list.add(unemployed);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }

}
