package artistDao;

public class Artist {
    private int idArtist;
    private String nameArtist;

    public Artist() {
    }
    public Artist(int idArtist, String nameArtist) {
        this.idArtist = idArtist;
        this.nameArtist = nameArtist;
    }

    public int getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(int idArtist) {
        this.idArtist = idArtist;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "idArtist=" + idArtist +
                ", nameArtist=" + nameArtist +
                '}';
    }
}
