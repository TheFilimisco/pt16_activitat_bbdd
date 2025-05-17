package mediatypeDao;

public class MediaType {
    private int idMediaType;
    private String name;

    public MediaType() {
    }

    public MediaType(int idMediaType, String name) {
        this.idMediaType = idMediaType;
        this.name = name;
    }

    public int getIdMediaType() {
        return idMediaType;
    }

    public void setIdMediaType(int idMediaType) {
        this.idMediaType = idMediaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MediaType{" +
                "idMediaType=" + idMediaType +
                ", name='" + name + '\'' +
                '}';
    }
}
