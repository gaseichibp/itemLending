package entities;

import java.util.Scanner;

class Item {
    private final String name;
    private boolean loaned;
    private Client client;

    public Item(String name) {
        this.name = name;
        this.loaned = false;
        this.client = null;
    }

    public String getName() {
        return name;
    }

    public boolean isLoaned() {
        return loaned;
    }

    public void loan(Client client) {
        this.loaned = true;
        this.client = client;
    }

    public void returnItem() {
        this.loaned = false;
        this.client = null;
    }

    public Client getClient() {
        return client;
    }
}

