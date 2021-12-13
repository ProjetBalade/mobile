package be.hevelaska.mobile.dto.ride;

public class DtoCreateRide {
    private String nameRide;
    private String place;
    private String description;
    private String website;
    private int  difficulty;
    private String schedule;
    private String photo;
    private int score ;
    private int idUser;

    public DtoCreateRide(String nameRide, String place, String description, String website, int difficulty, String schedule, String photo, int score, int idUser) {
        this.nameRide = nameRide;
        this.place = place;
        this.description = description;
        this.website = website;
        this.difficulty = difficulty;
        this.schedule = schedule;
        this.photo = photo;
        this.score = score;
        this.idUser = idUser;
    }

    public String getNameRide() {
        return nameRide;
    }

    public void setNameRide(String nameRide) {
        this.nameRide = nameRide;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Byte difficulty) {
        this.difficulty = difficulty;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(Byte score) {
        this.score = score;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
