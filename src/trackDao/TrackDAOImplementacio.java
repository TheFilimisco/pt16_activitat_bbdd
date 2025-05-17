package trackDao;

import albumDao.Album;
import albumDao.AlbumDao;
import albumDao.AlbumDaoImplementacio;
import genreDao.GenreDAO;
import genreDao.GenreDAOImplementacio;
import mediatypeDao.MediaTypeDAO;
import mediatypeDao.MediaTypeDAOImplementacio;
import sqlInjection.Connexio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrackDAOImplementacio implements TrackDAO {

    AlbumDao albumDao = new AlbumDaoImplementacio();
    MediaTypeDAO mediaType = new MediaTypeDAOImplementacio();
    GenreDAO genre = new GenreDAOImplementacio();

    static Connection con = Connexio.getConnection();
    @Override
    public int create(Track track) throws SQLException {
        String query = "insert into track(Name,AlbumId,MediaTypeId,GenreId,Composer,Milliseconds,Bytes,UnitPrice)" +
                " values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, track.getName());
        ps.setInt(2,track.getAlbum().getIdAlbum());
        ps.setInt(3,track.getMediaType().getIdMediaType());
        ps.setInt(4,track.getGenre().getIdGenre());
        ps.setString(5,track.getComposer());
        ps.setInt(6,track.getMilliseconds());
        ps.setInt(7,track.getBytes());
        ps.setDouble(8,track.getUnitPrice());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        return id;
    }

    @Override
    public Track read(int idTrack) throws SQLException {
        Track track = new Track();
        String query = "select * from track where TrackId=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1,idTrack);
        ResultSet rs = ps.executeQuery();
        boolean found = false;
        while (rs.next()) {
            found = true;
            track.setIdTrack(rs.getInt("TrackId"));
            track.setName(rs.getString("Name"));
            Album album = albumDao.read(rs.getInt("AlbumId"));
            track.setAlbum(album);
            track.setMediaType(mediaType.read(rs.getInt("MediaTypeId")));
            track.setGenre(genre.read(rs.getInt("GenreId")));
            track.setComposer(rs.getString("Composer"));
            track.setMilliseconds(rs.getInt("Milliseconds"));
            track.setBytes(rs.getInt("Bytes"));
            track.setUnitPrice(rs.getDouble("UnitPrice"));
        }
        if (found) {
            return track;
        } else {
            return null;
        }
    }

    @Override
    public void update(Track track) throws SQLException {
        String query = "update track set Name=?, AlbumId=?, MediaTypeId=?, GenreId=?, Composer=?, Milliseconds=?, Bytes=?, UnitPrice=? where TrackId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, track.getName());
        ps.setInt(2,track.getAlbum().getIdAlbum());
        ps.setInt(3,track.getMediaType().getIdMediaType());
        ps.setInt(4,track.getGenre().getIdGenre());
        ps.setString(5,track.getComposer());
        ps.setInt(6,track.getMilliseconds());
        ps.setInt(7,track.getBytes());
        ps.setDouble(8,track.getUnitPrice());
        ps.setInt(8,track.getAlbum().getIdAlbum());
        ps.executeUpdate();
    }

    @Override
    public void delete(int idTrack) throws SQLException {
        String query = "delete from track where TrackId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,idTrack);
        ps.executeUpdate();
    }

    @Override
    public List<Track> getTracks() throws SQLException {
        String query = "select * from track";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Track> tracks = new ArrayList<Track>();
        while (rs.next()) {
            Track track = new Track();
            track.setIdTrack(rs.getInt("TrackId"));
            track.setName(rs.getString("Name"));
            track.setAlbum(albumDao.read(rs.getInt("AlbumId")));
            track.setMediaType(mediaType.read(rs.getInt("MediaTypeId")));
            track.setGenre(genre.read(rs.getInt("GenreId")));
            track.setComposer(rs.getString("Composer"));
            track.setMilliseconds(rs.getInt("Milliseconds"));
            track.setBytes(rs.getInt("Bytes"));
            track.setUnitPrice(rs.getDouble("UnitPrice"));
            tracks.add(track);
        }
        return tracks;
    }
}
