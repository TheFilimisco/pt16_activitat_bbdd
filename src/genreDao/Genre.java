package genreDao;

public class Genre {
    private int idGenre;
    private String name;

    public Genre(int idGenre, String name) {
        this.idGenre = idGenre;
        this.name = name;
    }

    public Genre() {
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "idGenre=" + idGenre +
                ", name='" + name + '\'' +
                '}';
    }
}
