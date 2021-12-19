package be.hevelaska.mobile.data.model.dog;

public class DtoDog {
    private int id;
    private String nameDog ;
    private String raceDog;
    //private DateTime  dateOfBirth ;
    private String dateOfBirth;
    private int idUser;

    public DtoDog(int id, String nameDog, String raceDog, String dateOfBirth, int idUser) {
        this.id = id;
        this.nameDog = nameDog;
        this.raceDog = raceDog;
        this.dateOfBirth = dateOfBirth;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDog() {
        return nameDog;
    }

    public void setNameDog(String nameDog) {
        this.nameDog = nameDog;
    }

    public String getRaceDog() {
        return raceDog;
    }

    public void setRaceDog(String raceDog) {
        this.raceDog = raceDog;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "DtoDogs{" +
                "id=" + id +
                ", nameDog='" + nameDog + '\'' +
                ", raceDog='" + raceDog + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", idUser=" + idUser +
                '}';
    }
}
