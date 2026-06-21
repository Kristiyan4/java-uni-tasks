import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User[] users = new User[5];
        int userCount = 0;

        while (true) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Регистрация");
            System.out.println("2. Вход");
            System.out.println("3. Изход");
            System.out.print("Изберете опция: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                try {
                    System.out.print("Въведете потребителско име: ");
                    String username = sc.nextLine();

                    boolean exists = false;
                    for (int i = 0; i < userCount; i++) {
                        if (users[i].getUsername().equals(username)) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        System.out.println("Потребителското име вече съществува!");
                        continue;
                    }

                    System.out.print("Въведете парола: ");
                    String password1 = sc.nextLine();
                    System.out.print("Повторете паролата: ");
                    String password2 = sc.nextLine();

                    if (!password1.equals(password2)) {
                        System.out.println("Паролите не съвпадат!");
                        continue;
                    }

                    System.out.print("Въведете телефонен номер: ");
                    String phone = sc.nextLine();

                    User newUser = new User(username, password1, phone);
                    users[userCount++] = newUser;
                    System.out.println("Регистрацията е успешна!");

                } catch (WrongUserException | WrongPhoneNumberException | IllegalArgumentException e) {
                    System.out.println(" Грешка: " + e.getMessage());
                }

            } else if (choice.equals("2")) {
                System.out.print("Въведете потребителско име: ");
                String username = sc.nextLine();
                System.out.print("Въведете парола: ");
                String password = sc.nextLine();

                boolean found = false;
                for (int i = 0; i < userCount; i++) {
                    if (users[i].getUsername().equals(username) &&
                            users[i].getPassword().equals(password)) {
                        System.out.println(" Успешен вход. Добре дошли, " + username + "!");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Невалидно потребителско име или парола!");
                }

            } else if (choice.equals("3")) {
                System.out.println("Изход от програмата...");
                break;
            } else {
                System.out.println("Невалидна опция!");
            }
        }

        sc.close();
    }
}

