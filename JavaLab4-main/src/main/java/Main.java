import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            // Валідний орендар
            Renter renter = new Renter("John", "Doe", "ID123456", "DL123456");
            System.out.println("Renter created: " + renter);

            // Створення першого валідного об'єкта Rental
            Rental rental1 = new RentalBuilder()
                    .setVehicle(null) // Автомобіль не обов’язковий
                    .setClient(renter)
                    .setPickupLocation("Downtown Office")
                    .setDropoffLocation("Airport Office")
                    .setStartDate(LocalDate.parse("2024-11-01"))
                    .setEndDate(LocalDate.parse("2024-11-07"))
                    .setDailyRate(50.0)
                    .setTotalCost(300.0)
                    .build();

            System.out.println("First valid rental created: " + rental1);

            // Створення другого валідного об'єкта Rental
            Rental rental2 = new RentalBuilder()
                    .setVehicle(new Car("Toyota", "1HGCM82633A123456", "ABC1234", "2020-01-15", 30000))
                    .setClient(new Renter("Jane", "Smith", "ID789012", "DL654321"))
                    .setPickupLocation("Train Station")
                    .setDropoffLocation("City Center")
                    .setStartDate(LocalDate.parse("2024-12-01"))
                    .setEndDate(LocalDate.parse("2024-12-05"))
                    .setDailyRate(60.0)
                    .setTotalCost(240.0)
                    .build();

            System.out.println("Second valid rental created: " + rental2);

        } catch (IllegalArgumentException e) {
            System.err.println("Error creating rental:\n" + e.getMessage());
        }

        try {
            // Створення невалідного об'єкта Rental
            Rental invalidRental = new RentalBuilder()
                    .setVehicle(null) // Немає автомобіля
                    .setClient(null) // Відсутній орендар
                    .setPickupLocation("") // Порожнє місце отримання
                    .setDropoffLocation(null) // Відсутнє місце повернення
                    .setStartDate(LocalDate.parse("2023-01-01")) // Дата в минулому
                    .setEndDate(LocalDate.parse("2023-01-05")) // Дата в минулому
                    .setDailyRate(-10.0) // Негативна ціна за день
                    .setTotalCost(0) // Нульова загальна вартість
                    .build();

            System.out.println("Invalid rental created: " + invalidRental);
        } catch (IllegalArgumentException e) {
            System.err.println("Validation errors for invalid rental:\n" + e.getMessage());
        }
    }
}
