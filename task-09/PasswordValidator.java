public class PasswordValidator {
    public static boolean validatePassword(String password) {
        if (password == null) return false;
        return password.matches("[a-zA-Z]{11,}");
    }
}

