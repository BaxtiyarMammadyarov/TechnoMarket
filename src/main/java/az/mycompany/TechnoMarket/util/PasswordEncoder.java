package az.mycompany.TechnoMarket.util;

import java.util.Base64;

public class PasswordEncoder {
    private static Base64.Encoder encoder=Base64.getEncoder();
    public String passwordEncoder(String password){
        return encoder.encodeToString(password.getBytes());
    }
}
