package dbTest;

import dbHelpers.DbAdapter;
import models.Artist;
import models.Playlist;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetArtist {
    @Test
    public void getArtist(){
        List<Artist> artists = DbAdapter.getAllArtists();
        for (Artist artist:artists){
            System.out.println(artist.id+" "+artist.name);
        }
    }

    @Test
    public void getPlaylistById(){
        Playlist pl = DbAdapter.getPlaylistById(6944);

            System.out.println(pl.id+" "+pl.name);
    }

    @Test
    public void  getArtistById(){
        Artist art = DbAdapter.getArtistById(23);
        System.out.println(art.id+" "+art.name);
        Assert.assertTrue(art.name.length()!=0);
    }
}
