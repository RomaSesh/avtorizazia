import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthService {
    private static final String FILE_PATH = "credentials.txt"; // Путь к файлу с учетными данными

    // Метод для аутентификации пользователя
    public boolean authenticate(String login, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(":");
                // Проверяем логин и хеш пароля
                if (credentials.length == 2 && credentials[0].equals(login) && credentials[1].equals(hashPassword(password))) {
                    return true; // Успешная аутентификация
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
        return false; // Не удалось аутентифицировать
    }

    // Метод для хеширования пароля
    private String hashPassword(String password) {
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
