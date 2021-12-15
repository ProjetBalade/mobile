package be.hevelaska.mobile.dto.comment;

public class DtoComment {
    private int id;
    private String content;
    private int score ;
    private String image;
    private int difficulty ;
    private int idUser;
    private int idRide ;

    public DtoComment(int id, String content, int score, String image, int difficulty, int idUser, int idRide) {
        this.id = id;
        this.content = content;
        this.score = score;
        this.image = image;
        this.difficulty = difficulty;
        this.idUser = idUser;
        this.idRide = idRide;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    @Override
    public String toString() {
        return "DtoComments{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", score=" + score +
                ", image='" + image + '\'' +
                ", difficulty=" + difficulty +
                ", idUser=" + idUser +
                ", idRide=" + idRide +
                '}';
    }
}
