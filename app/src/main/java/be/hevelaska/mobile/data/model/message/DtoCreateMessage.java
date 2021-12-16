package be.hevelaska.mobile.data.model.message;

public class DtoCreateMessage {
    private int idRecipient;
    private int idSender;
    private String content;
    private String object;

    public DtoCreateMessage(int idRecipient, int idSender, String content, String object) {
        this.idRecipient = idRecipient;
        this.idSender = idSender;
        this.content = content;
        this.object = object;
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
}
