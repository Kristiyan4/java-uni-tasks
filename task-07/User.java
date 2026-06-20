public abstract class User {
    private final String id;
    private final String name;
    private final UserRole role;

    public User(String id, String name, UserRole role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserRole getRole() {
        return role;
    }
}


