import java.util.Scanner;

public class Conversion {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        int C_a_F = 0;
        int F_a_C = 0;
        int Km_a_M = 0;
        int M_a_Km = 0;

        do {
            System.out.println("1 °C a °F");
            System.out.println("2 °F a °C");
            System.out.println("3 Km a Millas");
            System.out.println("4 Millas a Km");
            System.out.println("5 Salir");

            System.out.print("Eliga una opcion: ");
            while (!leer.hasNextInt()) {
                System.out.println("El valor que ingreso no es un numero entero.");
                leer.next();
                System.out.print("Eliga una opcion: ");
            }
            opcion = leer.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                double valor = solicitarValor(leer);
                double resultado = 0;

                switch (opcion) {
                    case 1:
                        resultado = (valor * 1.8) + 32;
                        System.out.printf(valor + " °C = "+ resultado+ " °F");
                        C_a_F++;
                        System.out.print("\n==================\n");
                        break;
                    case 2:
                        resultado = (valor - 32) / 1.8;
                        System.out.printf(valor + " °F = " + resultado + " °C");
                        F_a_C++;
                        System.out.print("\n==================\n");
                        break;
                    case 3:
                        resultado = valor * 0.621371;
                        System.out.printf(valor + " Km" + resultado + " Millas");
                        Km_a_M++;
                        System.out.print("\n==================\n");
                        break;
                    case 4:
                        resultado = valor * 1.60934;
                        System.out.printf(valor + " Millas = " + resultado + " Km");
                        M_a_Km++;
                        System.out.print("\n==================\n");
                        break;
                }
            } else if (opcion == 5) {
                System.out.println("Usted a terminado");
            } else {
                System.out.println("Opcion fuera del rango mostrado");
            }

        } while (opcion != 5);

        int total = C_a_F + F_a_C + Km_a_M + M_a_Km;
        System.out.println("Cuántas conversiones de cada tipo se hicieron:");
        System.out.println("Total conversiones: " + total);
        System.out.println("°C a °F: " + C_a_F);
        System.out.println("°F a °C: " + F_a_C);
        System.out.println("Km a Millas: " + Km_a_M);
        System.out.println("Millas a Km: " + M_a_Km);

        leer.close();
    }

    public static double solicitarValor(Scanner scanner) {
        System.out.print("Ingresa una cantidad ");
        while (!scanner.hasNextDouble()) {
            System.out.println("El valor ingresado no es numerico");
            scanner.next();
            System.out.print("Ingresa una cantidad ");
        }
        return scanner.nextDouble();
    }
}