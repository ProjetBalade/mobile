package be.hevelaska.mobile.data.model.dog;

public class DtoCreateDog {

    private String nameDog ;
    private String raceDog;
    private String dateOfBirth;
    private int idUser;

    public DtoCreateDog(String nameDog, String raceDog, String dateOfBirth) {
        this.nameDog = nameDog;
        this.raceDog = raceDog;
        this.dateOfBirth = dateOfBirth;

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
}
