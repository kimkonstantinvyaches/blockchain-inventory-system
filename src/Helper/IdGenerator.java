package Helper;

import java.util.UUID;

public class IdGenerator {
    public static String generateUUID() {
       return UUID.randomUUID().toString().substring(0, 8);
    }
}
