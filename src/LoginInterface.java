import java.util.Scanner;
public class LoginInterface {
    private Scanner scanner; // Сканер для ввода данных
    private AuthService authService; // Сервис для аутентификации

    // ANSI escape codes для цвета текста
    private static final String BLUE = "\u001B[34m"; // Синий цвет
    private static final String RESET = "\u001B[0m"; // Сброс цвета

    public LoginInterface() {
        scanner = new Scanner(System.in);
        authService = new AuthService(); // Инициализация сервиса аутентификации
    }

    // Метод для отображения интерфейса входа
    public void show() {
        System.out.print(BLUE + "Введите логин: " + RESET);
        String inputLogin = scanner.nextLine();

        System.out.print(BLUE + "Введите пароль: " + RESET);
        String inputPassword = scanner.nextLine();

        // Проверяем аутентификацию
        if (authService.authenticate(inputLogin, inputPassword)) {
            System.out.println(BLUE + "Авторизация успешна!" + RESET);
            // Здесь можно добавить код для работы с меню
        } else {
            System.out.println(BLUE + "Неверный логин или пароль." + RESET);
        }

        scanner.close(); // Закрываем сканер
    }
}