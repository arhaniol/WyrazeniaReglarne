import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static public void main(String[] args) {
        description("Zadanie1 - liczba zmiennoprzecinkowa:");
        task1();
        description("Zadanie2 - nr lokalu:");
        task2();
        description("Zadanie3 - nazwa miasta");
        task3();
    }

    private static void task3() {
        Pattern pattern = Pattern.compile("[A-Z][a-z]+([ -][A-Z][a-z]+)?");
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        String text;
        boolean wrong;
        do {
            System.out.print("Podaj miejscowość: ");
            text = scanner.next();
            matcher = pattern.matcher(text);
            wrong = !matcher.matches();
            if (wrong) {
                description("Niepoprawna miejscowość!");
            }
        } while (wrong);
        description("Twoja miejscowość to: " + matcher.group(1)+" "+matcher.group(2));
    }

    private static void task2() {
        Pattern pattern = Pattern.compile("[1-9]+[a-zA-Z]*\\\\*[1-9]*");
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        String text;
        boolean wrong;

        do {
            System.out.print("Podaj adres lokalu: ");
            text = scanner.next();
            matcher = pattern.matcher(text);
            wrong = !matcher.matches();
            if (wrong) {
                description("Zły format adresu!");
            }
        } while (wrong);

        description("Mieszkasz pod: " + matcher.group());
    }

    private static void description(String s) {
        System.out.println(s);
    }

    private static void task1() {
        Pattern pattern = Pattern.compile("-?[0-9]+,[0-9]+");
        Matcher matcher;
        String text;
        Scanner scanner = new Scanner(System.in);
        boolean wrong;
        do {
            System.out.print("Wprowadź liczbę zmiennoprzecinkową: ");
            text = scanner.next();
            matcher = pattern.matcher(text);
            wrong = !matcher.matches();
            if (wrong) {
                System.out.println("Liczaba nie jest zmiennoprzecinkowa!");
            }
        } while (wrong);

        System.out.println("Wprowadzono liczbę: " + matcher.group());
    }
}
