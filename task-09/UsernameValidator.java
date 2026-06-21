public class UsernameValidator {
    public static boolean validateUsername(String username) {
        if (username == null) return false;
        return username.matches("[a-z0-9_-]{3,15}");
    }
}

