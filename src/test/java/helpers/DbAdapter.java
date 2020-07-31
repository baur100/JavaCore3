package helpers;

import models.Artist;
import models.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbAdapter {
    private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://104.237.9.33/dbkoel";
    private static final String USER = "dbuser03";
    private static final String PASSWORD = "pa$$03";

    static Connection connection = null;
    static Statement statement = null;

    public static List<Artist> getAllArtists(){
        List<Artist> list = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            statement = connection.createStatement();

            String query = "select * FROM artists a";

            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                Artist artist = new Artist(id,name);
                list.add(artist);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
    public static Playlist getPlaylistById(int playlistId){
        Playlist playlist=null;
        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            statement = connection.createStatement();

            String query = "SELECT * FROM playlists p where id = "+playlistId;

            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                playlist=new Playlist(id,name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return playlist;
    }
}
