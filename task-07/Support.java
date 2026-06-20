public class Support extends User {
    private final String username;

    public Support(String id, String name, String username) {
        super(id, name, UserRole.SUPPORT);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}


