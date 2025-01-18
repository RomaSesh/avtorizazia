import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {
    public static void main(String[] args) {
        System.out.println(hashPassword("password123")); // Для admin
        System.out.println(hashPassword("qwerty")); // Для user
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString(); // Возвращаем хеш пароля
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
