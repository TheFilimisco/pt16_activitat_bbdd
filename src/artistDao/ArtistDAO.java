package artistDao;

import java.sql.SQLException;
import java.util.List;


public interface ArtistDAO {
    public int create(Artist artist) throws SQLException;
    public Artist read(int idArtist) throws SQLException;
    public void update(Artist artist) throws SQLException;
    public void delete(int idArtist) throws SQLException;
    public List<Artist> getArtists() throws SQLException;
}
