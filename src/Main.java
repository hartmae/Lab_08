import java.util.Scanner;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)
    {
        //GetUserName();
        //GetFavoriteNumbers();
        //GetDateAndTimeOfBirth();
        //GetCheckoutAtStore();
        //RegExIsMagic();
        PrettyHeader();
    }

    public static void GetUserName() {
        Scanner in = new Scanner(System.in);
        String firstName = "";
        String lastName = "";
        firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");
        lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");
        System.out.println("\nYour full name is: " + firstName + " " + lastName);
    }

    public static void GetFavoriteNumbers() {
        Scanner in = new Scanner(System.in);
        int favoriteInt = 0;
        double favoriteDbl = 0;
        favoriteInt = SafeInput.getInt(in, "Enter your favorite integer.");
        favoriteDbl = SafeInput.getDouble(in, "Enter your favorite double.");
        System.out.println("\nYour favorite integer is: " + favoriteInt + " and your favorite double is: " + favoriteDbl);
    }

    public static void GetDateAndTimeOfBirth() {
        Scanner in = new Scanner(System.in);
        int birthYear;
        int birthMonth;
        int birthDay;
        int birthHour;
        int birthMinute;



        birthYear = SafeInput.getRangedInt(in, "Enter your birth year.", 1950, 2015);
        birthMonth = SafeInput.getRangedInt(in, "Enter your birth month.", 1, 12);

        int dayMax = 31;

        switch (birthMonth) {
            case 4:
            case 6:
            case 9:
            case 11:
                dayMax = 30;
                break;
            case 2:
                dayMax = 29;
                break;
        }

        birthDay = SafeInput.getRangedInt(in, "Enter your birth day.", 1, dayMax);
        birthHour = SafeInput.getRangedInt(in, "Enter your birth hour.", 1, 24);
        birthMinute = SafeInput.getRangedInt(in, "Enter your birth minute.", 0, 59);

        System.out.println(birthMonth + "/" + birthDay + "/" + birthYear + " " + birthHour + " hours " + birthMinute + " minutes.");
    }

    public static void GetCheckoutAtStore() {
        Scanner in = new Scanner(System.in);
        double price = 0;
        String answer = "";
        boolean done = false;

        do {
            price += SafeInput.getRangedDouble(in,"Enter price", .5, 10);
            answer = SafeInput.getYNConfirm(in, "Are you done?");
            if (answer.equalsIgnoreCase("y")){
                done = true;
            }
        } while (!done);

        System.out.printf("\nYour total is: $%.2f", price);
    }

    public static void RegExIsMagic() {
        Scanner in = new Scanner(System.in);
        String ssn = "";
        String ucid = "";
        String menuChoice = "";

        String ssnRegex = "^\\d{3}-\\d{2}-\\d{4}$";
        String ucidRegex = "^(M|m)\\d{5}$";
        String menuChoiceRegex = "^[OoSsVvQq]$";

        ssn = SafeInput.getRegExString(in, "Enter your ssn: ", ssnRegex);
        ucid = SafeInput.getRegExString(in, "Enter your UCID: ", ucidRegex);
        menuChoice = SafeInput.getRegExString(in, "(o)pen, (s)ave, (v)iew, (q)uit: ", menuChoiceRegex);

        System.out.println("\nYour ssn is: " + ssn);
        System.out.println("\nYour ucid is: " + ucid);
        System.out.println("\nYour menuChoice is: " + menuChoice);
    }

    public static void PrettyHeader() {
        Scanner in = new Scanner(System.in);

        String message = SafeInput.getNonZeroLenString(in, "Enter your message");
        SafeInput.prettyHeader(message);
    }
}