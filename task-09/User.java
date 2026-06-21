public class User implements ValidatePhone {
    private String username;
    private String password;
    private String phoneNumber;

    public User(String username, String password, String phoneNumber)
            throws WrongUserException, WrongPhoneNumberException
    {
        if (!UsernameValidator.validateUsername(username)) {
            throw new WrongUserException("Невалидно потребителско име!");
        }
        if (!PasswordValidator.validatePassword(password)) {
            throw new IllegalArgumentException("Невалидна парола!");
        }
        if (!ValidatePhone.validatePhoneNumber(phoneNumber)) {
            throw new WrongPhoneNumberException("Невалиден телефонен номер!");
        }

        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws WrongUserException {
        if (!UsernameValidator.validateUsername(username)) {
            throw new WrongUserException("Невалидно потребителско име!");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!PasswordValidator.validatePassword(password)) {
            throw new IllegalArgumentException("Невалидна парола!");
        }
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        if (!ValidatePhone.validatePhoneNumber(phoneNumber)) {
            throw new WrongPhoneNumberException("Невалиден телефонен номер!");
        }
        this.phoneNumber = phoneNumber;
    }
}

