package be.hevelaska.mobile.data.model.message;

public class DtoMessages {

    private int id;
    private int idRecipient;
    private int idSender;
    private String content;
    private String object;

    public DtoMessages(int id, int idRecipient, int idSender, String content, String object) {
        this.id = id;
        this.idRecipient = idRecipient;
        this.idSender = idSender;
        this.content = content;
        this.object = object;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRecipient() {
        return idRecipient;
    }

    public void setIdRecipient(int idRecipient) {
        this.idRecipient = idRecipient;
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "DtoMessages{" +
                "id=" + id +
                ", idRecipient=" + idRecipient +
                ", idSender=" + idSender +
                ", content='" + content + '\'' +
                ", object='" + object + '\'' +
                '}';
    }
}
