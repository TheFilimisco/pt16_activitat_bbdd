package mediatypeDao;

import java.sql.SQLException;
import java.util.List;

public interface MediaTypeDAO {
    public int create(MediaType mediaType) throws SQLException;
    public MediaType read(int idMediaType) throws SQLException;
    public void update(MediaType mediaType) throws SQLException;
    public void delete(int idMediaType) throws SQLException;
    public List<MediaType> getMediaTypes() throws SQLException;
}
