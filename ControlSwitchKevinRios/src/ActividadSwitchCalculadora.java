import java.util.Scanner;

public class ActividadSwitchCalculadora {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Selecciona una de las siguientes opciones: ");
        System.out.println("Sumar : 1 ");
        System.out.println("Restar : 2 ");
        System.out.println("Multiplicar : 3 ");
        System.out.println("Diviri : 4");

        int opcion = leer.nextInt();
        double resul;

        System.out.println("Ingresa el primer valor a calcular : ");
        double a = leer.nextDouble();
        System.out.println("Ingresa el segundo valor a calcular : ");
        double b = leer.nextDouble();

        switch (opcion) {
            case 1:
                System.out.println("Operación elegida : SUMA");
                resul = a + b;
                System.out.println("El resultado de la sumatoria es: " + resul);
                System.out.println("Los numeros ingresados fueron:");
                System.out.println(a);
                System.out.println(b);
                break;

            case 2:
                System.out.println("Operación elegida : RESTA");
                resul = a - b;
                System.out.println("El resultado de la resta es: " + resul);
                System.out.println("Los numeros ingresados fueron:");
                System.out.println(a);
                System.out.println(b);
                break;

            case 3:
                System.out.println("Operación elegida : MULTIPLICACION");
                resul = a * b;
                System.out.println("El resultado de la multiplicacion es: " + resul);
                System.out.println("Los numeros ingresados fueron:");
                System.out.println(a);
                System.out.println(b);
                break;

            case 4:
                System.out.println("Operación elegida : DIVISION");
                resul = a / b;
                System.out.println("Los numeros ingresados fueron:");
                System.out.println(a);
                System.out.println(b);
                if (b == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    resul = a / b;
                    System.out.println("El resultado de la division es: " + resul);
                }

            default:
                System.out.println("Opción inválida");
        }
    }
}
