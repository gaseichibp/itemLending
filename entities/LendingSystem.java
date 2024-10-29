package entities;

public class LendingSystem {
    private final Client[] clients;
    private final Item[] items;
    private int clientCount;
    private int itemCount;

    public LendingSystem(int capacity) {
        clients = new Client[capacity];
        items = new Item[capacity];
        clientCount = 0;
        itemCount = 0;
    }

    public void registerClient(String name, String cpf) {
        if (clientCount < clients.length) {
            clients[clientCount++] = new Client(name, cpf);
            System.out.println("Client registered successfully!");
        } else {
            System.out.println("Maximum client capacity reached!");
        }
    }

    public void registerItem(String name) {
        if (itemCount < items.length) {
            items[itemCount++] = new Item(name);
            System.out.println("Item registered successfully!");
        } else {
            System.out.println("Maximum item capacity reached!");
        }
    }

    public void performLoan(String itemName, String cpfClient) {
        Item item = findItem(itemName);
        Client client = findClient(cpfClient);

        if (item != null && client != null && !item.isLoaned()) {
            item.loan(client);
            System.out.println("Loan performed successfully!");
        } else {
            System.out.println("Loan cannot be performed.");
        }
    }

    public void performReturn(String itemName) {
        Item item = findItem(itemName);

        if (item != null && item.isLoaned()) {
            item.returnItem();
            System.out.println("Return performed successfully!");
        } else {
            System.out.println("Return cannot be performed.");
        }
    }

    public void listLoanedItems() {
        System.out.println("Loaned items:");
        for (Item item : items) {
            if (item != null && item.isLoaned()) {
                System.out.println("Item: " + item.getName() + ", Client: " + item.getClient().getName());
            }
        }
    }

    public void listAvailableItems() {
        System.out.println("Available items:");
        for (Item item : items) {
            if (item != null && !item.isLoaned()) {
                System.out.println("Item: " + item.getName());
            }
        }
    }

    private Item findItem(String name) {
        for (Item item : items) {
            if (item != null && item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    private Client findClient(String cpf) {
        for (Client client : clients) {
            if (client != null && client.getCpf().equals(cpf)) {
                return client;
            }
        }
        return null;
    }
}
