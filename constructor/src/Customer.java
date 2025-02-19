public class Customer {
    private String name;
    private double creaditLimit;
    private String emailAdress;

    public Customer() {
        this("Nobody ", "nobody@gmail.com");
    }

    public Customer(String name, String emailAdress) {
        this(name, 1000, emailAdress);
    }

    public Customer(String name, double creaditLimit, String emailAdress) {
        this.name = name;
        this.creaditLimit = creaditLimit;
        this.emailAdress = emailAdress;
    }

    public double getCreaditLimit() {
        return creaditLimit;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public String getName() {
        return name;
    }
}

