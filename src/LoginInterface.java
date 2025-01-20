import java.util.Scanner;

/**
 * Класс для взаимодействия с пользователем через консоль.
 */
public class LoginInterface {
    private Scanner scanner; // Сканер для ввода данных
    private AuthService authService; // Сервис для аутентификации

    private static final String BLUE = "\u001B[34m"; // Синий цвет
    private static final String RESET = "\u001B[0m"; // Сброс цвета

    public LoginInterface() {
        scanner = new Scanner(System.in);
        authService = new AuthService(); // Инициализация сервиса аутентификации
    }

    /**
     * Отображает интерфейс для ввода логина и пароля.
     */
    public void show() {
        while (true) {
            System.out.println(BLUE + "1. Войти" + RESET);
            System.out.println(BLUE + "2. Зарегистрироваться" + RESET);
            System.out.println(BLUE + "3. Выход" + RESET);
            System.out.print(BLUE + "Выберите действие: " + RESET);

            int choice = scanner.nextInt();
            scanner.nextLine(); // Читаем оставшийся символ новой строки

            if (choice == 1) {
                login();
            } else if (choice == 2) {
                register();
            } else if (choice == 3) {
                System.out.println(BLUE + "Выход из программы." + RESET);
                break; // Выход из цикла и завершение программы
            } else {
                System.out.println(BLUE + "Неверный выбор." + RESET);
            }
        }

        scanner.close(); // Закрываем сканер
    }

    private void login() {
        System.out.print(BLUE + "Введите логин: " + RESET);
        String inputLogin = scanner.nextLine();

        System.out.print(BLUE + "Введите пароль: " + RESET);
        String inputPassword = scanner.nextLine();

        // Проверяем аутентификацию
        if (authService.authenticate(inputLogin, inputPassword)) {
            System.out.println(BLUE + "Авторизация успешна!" + RESET);
            // Здесь можно добавить код для работы с меню после успешной авторизации
        } else {
            System.out.println(BLUE + "Неверный логин или пароль." + RESET);
        }
    }

    private void register() {
        System.out.print(BLUE + "Введите новый логин: " + RESET);
        String newLogin = scanner.nextLine();

        System.out.print(BLUE + "Введите новый пароль: " + RESET);
        String newPassword = scanner.nextLine();

        // Регистрируем нового пользователя
        if (authService.register(newLogin, newPassword)) {
            System.out.println(BLUE + "Регистрация успешна!" + RESET);
        } else {
            System.out.println(BLUE + "Регистрация не удалась." + RESET);
        }
    }
}