public class Cargo {

    private final double weight;
    private final String address;
    private final String registrationNumber;

    private boolean fragile;
    private boolean flipAllowed;

    private final Dimensions dimensions;


    public Cargo(String registrationNumber,String address, double weight, Dimensions dimensions) {
        this.weight = weight;
        this.address = address;
        this.registrationNumber = registrationNumber;
        this.dimensions = dimensions;

    }

    public double getWeight() {
        return weight;
    }

    public Cargo setWeight(double weight) {
        return new Cargo(registrationNumber,address,weight,dimensions);
    }

    public String getAddress() {
        return address;
    }

    public Cargo setAddress(String address) {
        return new Cargo(registrationNumber,address,weight,dimensions);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Cargo setRegistrationNumber(String registrationNumber) {
        return new Cargo(registrationNumber,address,weight,dimensions);
    }

    public Cargo setDimensions (Dimensions dimensions) {
        return new Cargo(registrationNumber,address,weight,dimensions);
    }
    public void Printer () {
        System.out.println( "Address: " + address + "\n" +
                "Registration number: " + registrationNumber + "\n" +
                "Weight: "+ weight + "kg."+ "\n" +
                "Volume: " + dimensions.getVolume() + "\n" +
                "Is Flip allowed : " + flipAllowed + "\n" +
                "Cargo stability : " + fragile);
    }
}



