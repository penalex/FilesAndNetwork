public class Cargo {

    private final double weight;
    private final String address;
    private final String registrationNumber;

    private boolean fragile;
    private boolean flipAllowed;


    public Cargo(String registrationNumber,String address, double weight) {
        this.weight = weight;
        this.address = address;
        this.registrationNumber = registrationNumber;

    }

    public double getWeight() {
        return weight;
    }

    public Cargo setWeight(double weight) {
        return new Cargo(registrationNumber,address,weight);
    }

    public String getAddress() {
        return address;
    }

    public Cargo setAddress(String address) {
        return new Cargo(registrationNumber,address,weight);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Cargo setRegistrationNumber(String registrationNumber) {
        return new Cargo(registrationNumber,address,weight);
    }

    public boolean isFlipAllowed( boolean flipAllowed ) {
        this.flipAllowed = flipAllowed;
        return flipAllowed;
    }

    public boolean isFragile(boolean fragile) {
        this.fragile = fragile;
        return fragile;

    }

    public void Printer () {
        System.out.println( "Address: " + address + "\n" +
                "Registration number: " + registrationNumber + "\n" +
                "Weight: "+ weight + "kg." + "\n"+
                "Is flip allowed : " + flipAllowed + "\n" +
                "Cargo stability :" + fragile);
    }
}



