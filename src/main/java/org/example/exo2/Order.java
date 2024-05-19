package org.example.exo2;

public class Order {
    private long id;
    private String clientName;

    public Order(long id, String clientName) {
        this.id = id;
        this.clientName = clientName;
    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
