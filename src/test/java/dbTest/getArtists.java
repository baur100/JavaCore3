package dbTest;

import helpers.DbAdapter;
import models.Artist;
import models.Playlist;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class getArtists {
    @Test
    public void getArtists(){
        List<Artist> artists = DbAdapter.getAllArtists();

        for (Artist arts : artists){
            System.out.println(arts.id + " " + arts.name);
        }
    }
    @Test
    public void getPlaylistById(){
        Playlist pl = DbAdapter.getPlaylistById(6950);
        Assert.assertEquals(pl.name,"ZZZ");
    }
}
