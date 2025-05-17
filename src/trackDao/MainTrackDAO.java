package trackDao;

import albumDao.Album;
import genreDao.Genre;
import mediatypeDao.MediaType;
import sqlInjection.Connexio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainTrackDAO {

    public void menu(){
        System.out.println("Diguis quina opció vols executar:\n"
                + "1) Llista els Tracks\n"
                + "2) Selecciona un sol Track\n"
                + "3) Introdueix un Track\n"
                + "4) Modifica un Track\n"
                + "5) Elimina un Track\n"
                + "0) Sortir\n"
        );
    }

    public static void main(String[] args) throws SQLException {
        Connection con = Connexio.getConnection();
        TrackDAO trackDAO = new TrackDAOImplementacio();
        MainTrackDAO main = new MainTrackDAO();

        main.menu();
        Scanner sc = new Scanner(System.in);
        int opcio = sc.nextInt(); sc.nextLine();
        while(opcio != 0){
            switch(opcio){
                case 1:{
                    trackDAO.getTracks().forEach(System.out::println);
                    break;
                }
                case 2:{
                    System.out.println("Introdueix quin Track vols veure");
                    int idTrack = sc.nextInt();sc.nextLine();
                    System.out.println(trackDAO.read(idTrack));
                    break;
                }
                case 3: {
                    System.out.println("Introdueix el Name nou");
                    String nameTrack = sc.nextLine();
                    System.out.println("Introdueix el AlbumId nou");
                    int idAlbum = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix el MediaTypeId nou");
                    int idMediaType = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix el GenreId nou");
                    int idGenre = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix el Composer nou");
                    String composer = sc.nextLine();
                    System.out.println("Introdueix els Milliseconds nou");
                    int millis = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix els Bytes nou");
                    int bytes = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix el UnitPrice nou");
                    int unitPrice = sc.nextInt();
                    sc.nextLine();
                    Album album = new Album();
                    album.setIdAlbum(idAlbum);
                    MediaType mediaType = new MediaType();
                    mediaType.setIdMediaType(idMediaType);
                    Genre genre = new Genre();
                    genre.setIdGenre(idGenre);
                    System.out.println("Create a new track: " +
                            trackDAO.create(new Track(0, nameTrack, album, mediaType, genre, composer, millis, bytes, unitPrice)));
                    break;
                }
                case 4: {
                    System.out.println("Introdueix quin Track vols modificar");
                    int idTrack = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix el Name nou");
                    String nameTrack = sc.nextLine();
                    System.out.println("Introdueix el AlbumId nou");
                    int idAlbum = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix el MediaTypeId nou");
                    int idMediaType = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix el GenreId nou");
                    int idGenre = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix el Composer nou");
                    String composer = sc.nextLine();
                    System.out.println("Introdueix els Milliseconds nou");
                    int millis = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix els Bytes nou");
                    int bytes = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix el UnitPrice nou");
                    int unitPrice = sc.nextInt();
                    Album album = new Album();
                    album.setIdAlbum(idAlbum);
                    MediaType mediaType = new MediaType();
                    mediaType.setIdMediaType(idMediaType);
                    Genre genre = new Genre();
                    genre.setIdGenre(idGenre);
                    trackDAO.update(new Track(idTrack, nameTrack, album, mediaType, genre, composer, millis, bytes, unitPrice));
                    break;
                }
                case 5: {
                    System.out.println("Introdueix quin Track vols eliminar");
                    int idTrack = sc.nextInt();sc.nextLine();
                    trackDAO.delete(idTrack);
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.println("Introdueix un nombre vàlid del 0 al 6");
                    break;
            }
            main.menu();
            opcio = sc.nextInt(); sc.nextLine();
        }
        con.close();
    }
}
