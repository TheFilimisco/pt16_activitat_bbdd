package trackDao;

import java.sql.SQLException;
import java.util.List;

public interface TrackDAO {
    public int create(Track track) throws SQLException;
    public Track read(int idTrack) throws SQLException;
    public void update(Track track) throws SQLException;
    public void delete(int idTrack) throws SQLException;
    public List<Track> getTracks() throws SQLException;
}
