import java.util.Scanner;

class ParticipantInfo {
    // Protected attributes (as per requirement)
    protected String participantId;
    protected String name;
    protected String email;
    protected long phoneNumber;

    // Public parameterized constructor (4 args)
    public ParticipantInfo(String participantId, String name, String email, long phoneNumber) {
        this.participantId = participantId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Public getters and setters
    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

class Organizer extends ParticipantInfo {

    // Private attribute in child class
    private int ticketsAvailable;

    // Public 5-argument constructor in the specified order
    public Organizer(String participantId, String name, String email, long phoneNumber, int ticketsAvailable) {
        super(participantId, name, email, phoneNumber);
        this.ticketsAvailable = ticketsAvailable;
    }

    // Getter and setter for ticketsAvailable
    public int getTicketsAvailable() {
        return ticketsAvailable;
    }

    public void setTicketsAvailable(int ticketsAvailable) {
        this.ticketsAvailable = ticketsAvailable;
    }

    // Business method: calculate selling revenue
    // Returns -1 if ticketsToSell > ticketsAvailable
    public double calculateSellingRevenue(int ticketsToSell, double pricePerTicket) {
        if (ticketsToSell > this.ticketsAvailable) {
            return -1;
        }
        return ticketsToSell * pricePerTicket;
    }
}

class Attendee extends ParticipantInfo {

    // Private attribute in child class
    private double walletBalance;

    // Public 5-argument constructor in the specified order
    public Attendee(String participantId, String name, String email, long phoneNumber, double walletBalance) {
        super(participantId, name, email, phoneNumber);
        this.walletBalance = walletBalance;
    }

    // Getter and setter for walletBalance
    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    // Business method: calculate buying cost
    // Returns -1 if cost > walletBalance
    public double calculateBuyingCost(int ticketsToBuy, double pricePerTicket) {
        double cost = ticketsToBuy * pricePerTicket;
        if (cost > this.walletBalance) {
            return -1;
        }
        return cost;
    }
}

public class question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the participant details");
        String input = sc.nextLine().trim();

        // Expected formats:
        // Organizer:ORG01:Alice:alice@example.com:9876543210:50:12:800
        // Attendee:ATT01:Bob:bob@example.com:9123456780:5000:3:1200

        String[] parts = input.split(":");

        if (parts.length < 8) {
            // Assuming all inputs are valid per problem statement; no exit.
            sc.close();
            return;
        }

        String type = parts[0].trim();

        if ("Organizer".equalsIgnoreCase(type)) {
            // Parse organizer fields
            String participantId = parts[1].trim();
            String name = parts[2].trim();
            String email = parts[3].trim();
            long phoneNumber = Long.parseLong(parts[4].trim());
            int ticketsAvailable = Integer.parseInt(parts[5].trim());
            int ticketsToSell = Integer.parseInt(parts[6].trim());
            double pricePerTicket = Double.parseDouble(parts[7].trim());

            Organizer organizer = new Organizer(participantId, name, email, phoneNumber, ticketsAvailable);
            double revenue = organizer.calculateSellingRevenue(ticketsToSell, pricePerTicket);

            if (revenue == -1) {
                System.out.println("Not enough tickets to sell!");
            } else {
                System.out.println("Calculated ticket selling revenue is " + revenue);
            }

        } else if ("Attendee".equalsIgnoreCase(type)) {
            // Parse attendee fields
            String participantId = parts[1].trim();
            String name = parts[2].trim();
            String email = parts[3].trim();
            long phoneNumber = Long.parseLong(parts[4].trim());
            double walletBalance = Double.parseDouble(parts[5].trim());
            int ticketsToBuy = Integer.parseInt(parts[6].trim());
            double pricePerTicket = Double.parseDouble(parts[7].trim());

            Attendee attendee = new Attendee(participantId, name, email, phoneNumber, walletBalance);
            double cost = attendee.calculateBuyingCost(ticketsToBuy, pricePerTicket);

            if (cost == -1) {
                System.out.println("Not enough funds to buy tickets!");
            } else {
                System.out.println("Calculated ticket buying cost is " + cost);
            }
        }

        sc.close();
    }
}


