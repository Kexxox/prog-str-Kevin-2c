import java.util.Scanner;

public class ActividadIfElseTarifa {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.print("Ingresa tu edad: ");
        int edad = leer.nextInt();

        System.out.print("Eres estudiante? (true/false): ");
        boolean estudiante = leer.nextBoolean();

        int tarifa = 0;

        if (edad < 0 || edad > 120) {
            System.out.println("Edad inválida");
            return;
        }

        if (edad < 12) {
            tarifa = 50;
        } else if (edad >= 12 && edad <= 17) {
            if (estudiante == true) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        } else {
            if (estudiante == true) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }

        System.out.println("La edad ingresada es: " + edad);

        if (estudiante == true) {
            System.out.println("Es estudiante: Si");
        } else {
            System.out.println("Es estudiante: No");
        }

        System.out.println("Tarifa final: " + tarifa);
    }
}
