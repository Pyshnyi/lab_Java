import java.time.LocalDate;

/**
 * Builder для створення об'єкта Rental.
 */
public class RentalBuilder {
    private Car vehicle;
    private Renter client;
    private String pickupLocation;
    private String dropoffLocation;
    private LocalDate startDate;
    private LocalDate endDate;
    private double dailyRate;
    private double totalCost;

    public RentalBuilder setVehicle(Car vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public RentalBuilder setClient(Renter client) {
        this.client = client;
        return this;
    }

    public RentalBuilder setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
        return this;
    }

    public RentalBuilder setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
        return this;
    }

    public RentalBuilder setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public RentalBuilder setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public RentalBuilder setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
        return this;
    }

    public RentalBuilder setTotalCost(double totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public Rental build() {
        return new Rental(vehicle, client, pickupLocation, dropoffLocation, startDate, endDate, dailyRate, totalCost);
    }
}
