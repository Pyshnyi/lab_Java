import java.time.LocalDate;

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
        this.vehicle = vehicle; // Vehicle може бути null
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
        StringBuilder errors = new StringBuilder();

        // Перевірка на помилки
        if (client == null) {
            errors.append("- Client is missing.\n");
        }
        if (pickupLocation == null || pickupLocation.trim().isEmpty()) {
            errors.append("- Pickup location is missing or empty.\n");
        }
        if (dropoffLocation == null || dropoffLocation.trim().isEmpty()) {
            errors.append("- Dropoff location is missing or empty.\n");
        }
        if (startDate == null || startDate.isBefore(LocalDate.now())) {
            errors.append("- Start date is invalid (null or in the past).\n");
        }
        if (endDate == null || (startDate != null && endDate.isBefore(startDate))) {
            errors.append("- End date is invalid (null or before start date).\n");
        }
        if (dailyRate <= 0) {
            errors.append("- Daily rate must be positive.\n");
        }
        if (totalCost <= 0) {
            errors.append("- Total cost must be positive.\n");
        }

        // Якщо є помилки, кидаємо виняток із переліком
        if (errors.length() > 0) {
            throw new IllegalArgumentException("Validation failed:\n" + errors);
        }

        // Якщо немає помилок, повертаємо новий об'єкт
        return new Rental(vehicle, client, pickupLocation, dropoffLocation, startDate, endDate, dailyRate, totalCost);
    }
}
