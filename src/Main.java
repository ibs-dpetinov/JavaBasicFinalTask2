import java.util.Scanner;
import java.util.regex.Pattern;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String equation;
        Pattern pattern = Pattern.compile("x[+-][0-9]=[0-9]|[0-9][+-]x=[0-9]|[0-9][+-][0-9]=x");
        do {
            System.out.println("Введите уравнение вида x[+-][0-9]=[0-9] или [0-9][+-]x=[0-9] или [0-9][+-][0-9]=x");
            equation = console.nextLine();
            if (!pattern.matcher(equation).find()) {
                System.out.println("Уравнение не соответствует шаблону");
            }
        } while (!pattern.matcher(equation).find());
        int x = 0;
        String signString = String.valueOf(equation.charAt(1));
        int sign = (signString.equals("+")) ? 1 : -1;
        pattern = Pattern.compile("x[+-][0-9]=[0-9]");
        if (pattern.matcher(equation).find()) x = parseInt(String.valueOf(equation.charAt(4))) - sign * parseInt(String.valueOf(equation.charAt(2)));
        pattern = Pattern.compile("[0-9][+-]x=[0-9]");
        if (pattern.matcher(equation).find()) x = sign * (parseInt(String.valueOf(equation.charAt(4))) - parseInt(String.valueOf(equation.charAt(0))));
        pattern = Pattern.compile("[0-9][+-][0-9]=x");
        if (pattern.matcher(equation).find())  x = parseInt(String.valueOf(equation.charAt(0))) + sign * parseInt(String.valueOf(equation.charAt(2)));
        System.out.println("x равно " + x);

    }
}