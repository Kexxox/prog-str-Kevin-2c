import java.util.Scanner;
public class Javadocs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opción;
        do {

            System.out.println("\n Menu");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Area de un rectangulo");
            System.out.println("3. Convertir de grados Celsius a Fahrenheit");
            System.out.println("4. Area de circulo");
            System.out.println("5. Salir del pograma");
            System.out.print("Elige una de las opciones: ");
            opción = scanner.nextInt();

            switch (opción) {
                case 1:
                    System.out.println("Ingresa el peso (KG):");
                    double peso = scanner.nextDouble();
                    System.out.println("Ingresa la altura (m):");
                    double altura = scanner.nextDouble();
                    System.out.println("IMC: " + CalcularIMC(peso,altura));
                    break;
                case 2:
                    System.out.println("Ingresa la base:");
                    double base = scanner.nextDouble();
                    System.out.println("Ingresa la altura:");
                    double altRect = scanner.nextDouble();
                    System.out.println("El Area es: " + AreaRectangulo(base,altRect));
                    break;
                case 3:
                    System.out.println("Ingresa en grados Celsius:");
                    double celsius = scanner.nextDouble();
                    System.out.println("Fahrenheit: " + CelsiusAFahrenheit(celsius));
                    break;
                case 4:
                    System.out.println("Ingresa el radio:");
                    double radio = scanner.nextDouble();
                    System.out.println("Area de un circulo: " + AreaCirculo(radio));
                    break;
                case 5:
                    System.out.println("Haz finalizado");
                    break;
                default:
                    System.out.println("La oppcion no es valida");
            }
        } while (opción != 5);
    }

    /**
     * Calcula el indice de masa corporal
     * @param peso en kilogramos
     * @param altura en metros
     * @return El valor del IMC
     */
    public static double CalcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    /**
     * Calcula Area de rectangulo
     * @param base del rectangulo
     * @param altura del rectangulo
     * @return El area total
     */
    public static double AreaRectangulo(double base, double altura) {
        return base * altura;
    }

    /**
     * Convierte Celsius a Fahrenheit
     * @param celsius Grados Celsius
     * @return Grados Fahrenheit
     */

    public static double CelsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }
    /**
     * Calcula Area de circulo con pi 3.1416
     * @param Radio del circulo
     * @return El area calculada
     */

    public static double AreaCirculo(double Radio) {
        return 3.1416 * (Radio * Radio);
    }
}