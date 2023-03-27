import net.sf.saxon.serialize.MessageWarner;
import org.apache.logging.log4j.Level;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.Manifest;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");

        if (components.length != 4) {
            Main.logger.info("Error adding customer: wrong format of user input");
            throw new IllegalArgumentException("Error adding customer: wrong format. "+
                    "Correct format:\n"+ Main.ADD_COMMAND);
        }
        String name = components[INDEX_NAME]+" "+components[INDEX_SURNAME];

        String phone = components[INDEX_PHONE];
        if (!((phone.length() == 12 && phone.indexOf("+7") == 0 || (phone.length() == 11 && phone.charAt(0) == '8')))) {
           Main.logger.info("Wrong format of phone number");
            throw new IllegalArgumentException("Phone \""+phone+"\" not correct!");
        }

        String email = components[INDEX_EMAIL];
        if (!(email.matches("^.+@.+"))) {
            Main.logger.info("Wrong format of E-mail");
            throw new IllegalArgumentException("E-mail \""+email+"\" not correct!");
        }

        storage.put(name, new Customer(name, phone, email));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}