/**
 * Класс, представляющий пользователя с логином и паролем.
 */
public class User {
    private String login; // Логин пользователя
    private String password; // Пароль пользователя

    /**
     * Конструктор для создания объекта пользователя.
     *
     * @param login    Логин пользователя.
     * @param password Пароль пользователя.
     */
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // Геттеры
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}