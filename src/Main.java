/**
 * Главный класс для запуска приложения.
 */
public class Main {
    public static void main(String[] args) {
        LoginInterface loginInterface = new LoginInterface(); // Создаем экземпляр интерфейса входа
        loginInterface.show(); // Отображаем интерфейс для пользователя
    }
}