import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album album = new Album("nhi pata", "unjaan");
        album.addSongToAlbum("song1", 2.32);
        album.addSongToAlbum("song2", 4.33);
        album.addSongToAlbum("song3", 3.4);

        Album album1 = new Album("moosa", "sidhu moosewala");
        album1.addSongToAlbum("levels", 3.45);
        album1.addSongToAlbum("legend", 4.3);
        album1.addSongToAlbum("295", 4);

        List<Song> list = new LinkedList<>();
        album1.addSongToPlayListFromAlbum("295", list);
        album1.addSongToPlayListFromAlbum("legend", list);
        album.addSongToPlayListFromAlbum(2, list);
        album.addSongToPlayListFromAlbum(1, list);

        play(list);
    }

    public static void play(List<Song> playList) {
        if (playList.size() == 0) {
            System.out.println("list is Empty");
            return;
        }
        ListIterator<Song> ptr = playList.listIterator();
        Scanner sc = new Scanner(System.in);
        System.out.println(ptr.next());
        printMenu();
        boolean isNext = true;
        while (true) {
            System.out.println("enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (!isNext) {
                        ptr.next();
                    }
                    if (ptr.hasNext()) {
                        System.out.println("Now playing");
                        System.out.println(ptr.next());
                        isNext = true;
                    } else {
                        System.out.println("No enough songs");
                    }
                    break;
                case 2:
                    if (isNext) {
                        ptr.previous();
                    }
                    if (ptr.hasPrevious()) {
                        System.out.println("Now playing");
                        System.out.println(ptr.previous());
                        isNext = false;
                    } else {
                        System.out.println("No enough songs");
                    }
                    break;

                case 3:
                    if (ptr.hasPrevious()) {
                        ptr.previous();
                        System.out.println(ptr.next());
                    }
                    else if(ptr.hasNext())
                    {
                        ptr.next();
                        System.out.println(ptr.previous());
                    }
                    break;
                case 4:
                    ptr.remove();
                    break;
                case 5:
                    printAllSong(playList);
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                    System.out.println("Exited successfully");
                    return;

            }
        }
    }

    static void printMenu() {
        System.out.println("1.play next song");
        System.out.println("2.play previous song");
        System.out.println("3.repeat current song");
        System.out.println("4.delete this song");
        System.out.println("5.show all songs");
        System.out.println("6.print menu");
        System.out.println("7.exit");
    }

    static void printAllSong(List<Song> list) {
        for (Song a : list)
            System.out.println(a);
    }
}
