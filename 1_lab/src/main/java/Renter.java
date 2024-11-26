import java.util.Objects;

/**
 * Інформація про орендаря.
 */
public class Renter {
    private String lastName;
    private String firstName;
    private String idDocument;
    private String driverLicense;

    public Renter(String lastName, String firstName, String idDocument, String driverLicense) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.idDocument = idDocument;
        this.driverLicense = driverLicense;
    }

    // Геттери і сеттери
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    @Override
    public String toString() {
        return "Renter{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", idDocument='" + idDocument + '\'' +
                ", driverLicense='" + driverLicense + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Renter renter = (Renter) o;
        return Objects.equals(lastName, renter.lastName) && Objects.equals(firstName, renter.firstName) && Objects.equals(idDocument, renter.idDocument) && Objects.equals(driverLicense, renter.driverLicense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, idDocument, driverLicense);
    }
}
