package modelsz;

public class DeleteResponse {
    int code;
    String type;
    Long message;

    public DeleteResponse(int code, String type, Long message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public Long getMessage() {
        return message;
    }
}
