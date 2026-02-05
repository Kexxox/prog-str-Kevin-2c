import java.util.Scanner;

public class Mainsz {

    public static void main(String[] args) {
        int limite = Entero();
        SumarN(limite);
    }
    public static int Entero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un numero entero: ");

        int nUsuario = scanner.nextInt();
        return nUsuario;
    }
    public static void SumarN(int limite) {
        int suma = 0;

        for (int contador = 1;contador <= limite; contador++) {
            suma = suma + contador;
        }
        System.out.println("El resultado de la suma es: " + suma);
    }
}