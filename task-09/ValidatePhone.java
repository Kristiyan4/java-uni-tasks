public interface ValidatePhone {
    static boolean validatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10,15}")) {
            throw new WrongPhoneNumberException("Телефонният номер трябва да съдържа само цифри (10-15).");
        }
        return true;
    }
}
