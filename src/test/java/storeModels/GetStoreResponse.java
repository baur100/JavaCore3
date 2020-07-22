package storeModels;

import models.GetPetResponse;

public class GetStoreResponse {
    private int orderId;
    private long petId;
    private int quantity;
    private String date;
    private String status;
    private boolean complete;

    public int getId() {
        return orderId;
    }

    public long getPetId() {
        return petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public boolean isComplete() {
        return complete;
    }
}
