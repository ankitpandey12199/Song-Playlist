import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class Album {
   private String title;
   private String artist;
   public List<Song>songList;

    public String getTitle() {
        return title;
    }

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        songList=new ArrayList<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    boolean findSong(String title)
    {
        for(Song song:songList)
        {
            if(song.getTitle().equals(title))return  true;
        }
        return false;
    }
    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
    public String addSongToAlbum(String title,double duration)
    {
        if(!findSong(title))
        {
            songList.add(new Song(title,duration));
            return "song added successfully";
        }
        return "song already exits!";
    }

    public String addSongToPlayListFromAlbum(String title , List<Song> playList)
    {

            for (Song s:songList)
            {
                if(s.getTitle().equals(title)) {
                    playList.add(s);
                    return "song sucessfully added to your playlist";
                }
            }

        return "song not found!";

    }
    public String addSongToPlayListFromAlbum(int  trackNo ,List<Song> playList)
    {

        int index=trackNo-1;
        if(index>=0 && index<=songList.size()-1)
        {
            playList.add(songList.get(index));
            return "song added succesfully";
        }
        return "Invalid postion!";
    }

}

