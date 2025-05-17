package genreDao;

import sqlInjection.Connexio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAOImplementacio implements GenreDAO {

    static Connection con = Connexio.getConnection();

    @Override
    public int create(Genre genre) throws SQLException {
        String query = "INSERT INTO genre(Name) VALUES (?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, genre.getName());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        return id;
    }

    @Override
    public Genre read(int idGenre) throws SQLException {
        String query = "SELECT * FROM genre WHERE GenreId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, idGenre);
        Genre genre = new Genre();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            genre.setIdGenre(rs.getInt("GenreId"));
            genre.setName(rs.getString("Name"));
        }

        if (check) {
            return genre;
        } else {
            return null;
        }

    }

    @Override
    public void update(Genre genre) throws SQLException {
        String query = "UPDATE genre SET Name = ? WHERE GenreId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, genre.getName());
        ps.setInt(2, genre.getIdGenre());
        ps.executeUpdate();
    }

    @Override
    public void delete(int idGenre) throws SQLException {
        String query = "DELETE FROM genre WHERE GenreId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, idGenre);
        ps.executeUpdate();
    }

    @Override
    public List<Genre> getGenres() throws SQLException {
        String query = "SELECT * FROM genre";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Genre> genres = new ArrayList<>();
        while (rs.next()) {
            Genre genre = new Genre();
            genre.setIdGenre(rs.getInt("GenreId"));
            genre.setName(rs.getString("Name"));
            genres.add(genre);
        }

        return genres;
    }
}
