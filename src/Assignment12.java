import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Assignment12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password:");
        String password = scanner.nextLine();
        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
        scanner.close();
    }
    public static boolean isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }
        int categoriesCount = 0;
        Pattern lowerCasePattern = Pattern.compile("[a-z]");
        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Pattern digitPattern = Pattern.compile("\\d");
        Pattern specialCharPattern = Pattern.compile("[~!@#$%^&*()-=+_]");
        Matcher lowerCaseMatcher = lowerCasePattern.matcher(password);
        Matcher upperCaseMatcher = upperCasePattern.matcher(password);
        Matcher digitMatcher = digitPattern.matcher(password);
        Matcher specialCharMatcher = specialCharPattern.matcher(password);
        if (lowerCaseMatcher.find()) {
            categoriesCount++;
        }
        if (upperCaseMatcher.find()) {
            categoriesCount++;
        }
        if (digitMatcher.find()) {
            categoriesCount++;
        }
        if (specialCharMatcher.find()) {
            categoriesCount++;
        }
        return categoriesCount >= 3;
    }
}
