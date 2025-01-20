import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private Map<String, String> users; // Словарь для хранения пользователей (логин, пароль)

    public AuthService() {
        users = new HashMap<>();
        // Добавим несколько тестовых пользователей для проверки
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean authenticate(String login, String password) {
        // Проверяем, существует ли логин и соответствует ли пароль
        return users.containsKey(login) && users.get(login).equals(password);
    }

    public boolean register(String login, String password) {
        // Проверяем, существует ли уже такой логин
        if (users.containsKey(login)) {
            return false; // Логин уже занят
        }
        // Добавляем нового пользователя
        users.put(login, password);
        return true; // Регистрация успешна
    }
}
