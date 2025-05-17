package albumDao;

import artistDao.Artist;

public class Album {
    private int idAlbum;
    private String nom;
    private Artist artist;

    public Album(int idAlbum, String nom, Artist artist) {
        this.idAlbum = idAlbum;
        this.nom = nom;
        this.artist = artist;
    }

    public Album() {
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Album{" +
                "idAlbum=" + idAlbum +
                ", nom='" + nom + '\'' +
                ", artist=" + artist +
                '}';
    }
}
