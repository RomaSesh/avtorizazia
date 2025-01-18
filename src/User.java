public class User {
    private String login; // Логин пользователя
    private String password; // Пароль пользователя

    // Конструктор
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
