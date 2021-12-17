package be.hevelaska.mobile.data.model.comment;

public class DtoCreateComment {

    private String content;
    private int score ;
    private int difficulty ;
    private int idUser;
    private int idRide ;

    public DtoCreateComment(String content, int score, int difficulty, int idUser, int idRide) {
        this.content = content;
        this.score = score;
        this.difficulty = difficulty;
        this.idUser = idUser;
        this.idRide = idRide;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRide() {
        return idRide;
    }

    public void setIdRide(int idRide) {
        this.idRide = idRide;
    }
}
