package dbHelpers;

import models.Artist;
import models.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbAdapter {

   public static List<Artist> getAllArtists(){
       List<Artist> list = new ArrayList<>();
       try{
           ResultSet result = dbHelpers.Connection.makeConnectionAndExecuteQuery("select * from artists a");
           while(result.next())//checks if there's next element, breaks if there's no next element
           {
               int id = result.getInt("id");
               String name = result.getString("name");
               Artist artist = new Artist(id,name);
               list.add(artist);
           }

       } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
       }finally {
           dbHelpers.Connection.checkAndCloseConnection();
       }

       return list;
   }
    public static Playlist getPlaylistById(int playlistId){
        Playlist playlist = null;
        try{
            ResultSet result = dbHelpers.Connection.makeConnectionAndExecuteQuery("select * from playlists p where id = "+playlistId);

            while(result.next())//checks if there's next element, breaks if there's no next element
            {
                int id = result.getInt("id");
                String name = result.getString("name");
                playlist = new Playlist(id,name);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            dbHelpers.Connection.checkAndCloseConnection();
        }

        return playlist;
    }

    public static Artist getArtistById(int artistId){
       Artist artist = null;
       try{
           ResultSet result = Connection.makeConnectionAndExecuteQuery("select*from artists where id = "+artistId);

           while (result.next()) {
               int id = result.getInt("id");
               String name = result.getString("name");
               artist = new Artist(id,name);
           }

       } catch (SQLException throwables) {
           throwables.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }finally {
           Connection.checkAndCloseConnection();
       }

        return artist;
    }
}
