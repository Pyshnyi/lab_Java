import java.time.LocalDate;

public class Rental {
    private Car vehicle;
    private Renter client;
    private String pickupLocation;
    private String dropoffLocation;
    private LocalDate startDate;
    private LocalDate endDate;
    private double dailyRate;
    private double totalCost;

    public Rental(Car vehicle, Renter client, String pickupLocation, String dropoffLocation,
                  LocalDate startDate, LocalDate endDate, double dailyRate, double totalCost) {
        this.vehicle = vehicle;
        this.client = client;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dailyRate = dailyRate;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "vehicle=" + vehicle +
                ", client=" + client +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", dropoffLocation='" + dropoffLocation + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", dailyRate=" + dailyRate +
                ", totalCost=" + totalCost +
                '}';
    }
}
