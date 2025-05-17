package genreDao;

import java.sql.SQLException;
import java.util.List;

public interface GenreDAO {
    public int create(Genre genre) throws SQLException;
    public Genre read(int idGenre) throws SQLException;
    public void update(Genre genre) throws SQLException;
    public void delete(int idGenre) throws SQLException;
    public List<Genre> getGenres() throws SQLException;
}
