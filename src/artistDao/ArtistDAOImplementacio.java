package artistDao;

import sqlInjection.Connexio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAOImplementacio implements ArtistDAO {

    static Connection con = Connexio.getConnection();

    @Override
    public int create(Artist artist) throws SQLException {
        String query = "INSERT INTO artist(nameArtist) VALUES (?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, artist.getNameArtist());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        return id;
    }

    @Override
    public Artist read(int idArtist) throws SQLException {
        String query = "SELECT * FROM artist WHERE ArtistId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, idArtist);
        Artist artist = new Artist();
        ResultSet rs = ps.executeQuery();
        boolean found = false;
        while (rs.next()) {
            found = true;
            artist.setIdArtist(rs.getInt("ArtistId"));
            artist.setNameArtist(rs.getString("Name"));
        }

        if (found) {
            return artist;
        }
        return null;
    }

    @Override
    public void update(Artist artist) throws SQLException {
        String query = "UPDATE artist SET name = ? WHERE ArtistId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, artist.getNameArtist());
        ps.setInt(2, artist.getIdArtist());
        ps.executeUpdate();
    }

    @Override
    public void delete(int idArtist) throws SQLException {
        String query = "DELETE FROM artist WHERE ArtistId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, idArtist);
        ps.executeUpdate();
    }

    @Override
    public List<Artist> getArtists() throws SQLException {
        String query = "SELECT * FROM artist";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Artist> artists = new ArrayList<Artist>();

        while (rs.next()) {
            Artist artist = new Artist();
            artist.setIdArtist(rs.getInt("ArtistId"));
            artist.setNameArtist(rs.getString("Name"));
            artists.add(artist);
        }
        return artists;
    }
}
