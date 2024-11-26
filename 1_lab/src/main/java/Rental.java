import java.time.LocalDate;
import java.util.Objects;

/**
 * Інформація про оренду автомобіля.
 */
public class Rental {
    private Car vehicle;
    private Renter client;
    private String pickupLocation;
    private String dropoffLocation;
    private LocalDate startDate;
    private LocalDate endDate;
    private double dailyRate;
    private double totalCost;

    public Rental(Car vehicle, Renter client, String pickupLocation, String dropoffLocation, LocalDate startDate, LocalDate endDate, double dailyRate, double totalCost) {
        this.vehicle = vehicle;
        this.client = client;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dailyRate = dailyRate;
        this.totalCost = totalCost;
    }

    // Геттери і сеттери
    public Car getVehicle() {
        return vehicle;
    }

    public void setVehicle(Car vehicle) {
        this.vehicle = vehicle;
    }

    public Renter getClient() {
        return client;
    }

    public void setClient(Renter client) {
        this.client = client;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Double.compare(rental.dailyRate, dailyRate) == 0 && Double.compare(rental.totalCost, totalCost) == 0 && Objects.equals(vehicle, rental.vehicle) && Objects.equals(client, rental.client) && Objects.equals(pickupLocation, rental.pickupLocation) && Objects.equals(dropoffLocation, rental.dropoffLocation) && Objects.equals(startDate, rental.startDate) && Objects.equals(endDate, rental.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicle, client, pickupLocation, dropoffLocation, startDate, endDate, dailyRate, totalCost);
    }
}
