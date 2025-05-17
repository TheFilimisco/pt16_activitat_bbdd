package mediatypeDao;

import sqlInjection.Connexio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MediaTypeDAOImplementacio implements MediaTypeDAO {

    static Connection con = Connexio.getConnection();

    @Override
    public int create(MediaType mediaType) throws SQLException {
        String query = "insert into mediatype(Name) values(?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, mediaType.getName());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        return id;
    }

    @Override
    public MediaType read(int idMediaType) throws SQLException {
        String query = "select * from mediatype where MediaTypeId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, idMediaType);
        MediaType mediaType = new MediaType();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            mediaType.setIdMediaType(rs.getInt("MediaTypeId"));
            mediaType.setName(rs.getString("Name"));
        }

        if (check) {
            return mediaType;
        } else {
            return null;
        }
    }

    @Override
    public void update(MediaType mediaType) throws SQLException {
        String query = "update mediatype set Name=? where MediaTypeId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, mediaType.getName());
        ps.setInt(2, mediaType.getIdMediaType());
        ps.executeUpdate();
    }

    @Override
    public void delete(int idMediaType) throws SQLException {
        String query = "delete from mediatype where MediaTypeId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, idMediaType);
        ps.executeUpdate();

    }

    @Override
    public List<MediaType> getMediaTypes() throws SQLException {
        String query = "select * from mediatype";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<MediaType> mediaTypes = new ArrayList<>();
        while (rs.next()) {
            MediaType mediaType = new MediaType();
            mediaType.setIdMediaType(rs.getInt("MediaTypeId"));
            mediaType.setName(rs.getString("Name"));
        }
        return mediaTypes;
    }
}
