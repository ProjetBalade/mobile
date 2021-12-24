package be.hevelaska.mobile.data.model.ride;

import android.os.Parcel;
import android.os.Parcelable;

public class DtoRides implements Parcelable {

    private int id;
    private String nameRide;
    private String place;
    private String description;
    private String website;
    private int  difficulty;
    private String schedule;
    private int score ;
    private int idUser;
    private double longitude;
    private double latitude;

    public DtoRides(int id, String nameRide, String place, String description, String website, int difficulty, String schedule, String photo, int score, int idUser, double longitude, double latitude) {
        this.id = id;
        this.nameRide = nameRide;
        this.place = place;
        this.description = description;
        this.website = website;
        this.difficulty = difficulty;
        this.schedule = schedule;
        this.score = score;
        this.idUser = idUser;
        this.longitude = longitude;
        this.latitude = latitude;
    }


    protected DtoRides(Parcel in) {
        id = in.readInt();
        nameRide = in.readString();
        place = in.readString();
        description = in.readString();
        website = in.readString();
        difficulty = in.readInt();
        schedule = in.readString();
        score = in.readInt();
        idUser = in.readInt();
        longitude = in.readDouble();
        latitude = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nameRide);
        dest.writeString(place);
        dest.writeString(description);
        dest.writeString(website);
        dest.writeInt(difficulty);
        dest.writeString(schedule);
        dest.writeInt(score);
        dest.writeInt(idUser);
        dest.writeDouble(longitude);
        dest.writeDouble(latitude);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DtoRides> CREATOR = new Creator<DtoRides>() {
        @Override
        public DtoRides createFromParcel(Parcel in) {
            return new DtoRides(in);
        }

        @Override
        public DtoRides[] newArray(int size) {
            return new DtoRides[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "DtoRides{" +
                "id=" + id +
                ", nameRide='" + nameRide + '\'' +
                ", place='" + place + '\'' +
                ", description='" + description + '\'' +
                ", website='" + website + '\'' +
                ", difficulty=" + difficulty +
                ", schedule='" + schedule + '\'' +
                ", score=" + score +
                ", idUser=" + idUser +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
