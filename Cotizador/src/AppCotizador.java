import java.util.Scanner;

public class AppCotizador {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ShippingCalculator Calculo = new ShippingCalculator();

        double peso = leerDouble(leer, "Rango de peso aceptado (0.1 - 50):", 0.1, 50);
        int distancia = leerInt(leer, "Rango de distancia aceptado (1 - 2000): ", 1, 2000);
        int servicio = leerInt(leer, "Tipo de servicio (1-Estandar, 2-Express): ", 1, 2);
        boolean zonaRemota = leerBolean(leer, "Zona Remota (true/false): " );

        double subtotal = Calculo.calcularSubtotal(peso, distancia, servicio, zonaRemota);
        double iva = Calculo.calcularIVA(subtotal);
        double total = Calculo.calcularTotal(subtotal, iva);

        ImprimirTicket(servicio, peso, distancia, zonaRemota, subtotal, iva, total);

    }

    static double leerDouble(Scanner leer, String msg, double min, int max){
        double valor;
        do {
            System.out.print(msg);
            valor = leer.nextDouble();
        }while (valor < min || valor > max);
        return valor;
    }
    static int leerInt(Scanner leer, String msg, int min, int max){
        int valor;
        do {
            System.out.print(msg);
            valor = leer.nextInt();
        }while (valor < min || valor > max);
        return valor;
    }
    static boolean leerBolean(Scanner leer, String msg){
        System.out.print(msg);
        return leer.nextBoolean();
    }


    static void ImprimirTicket(int servicio, double peso, int distancia, boolean zonaRemota, double subtotal, double iva, double total){
        String tipoServicio;
        if (servicio == 1){
            tipoServicio = "Estandar";
        } else {
            tipoServicio = "Express";
        }
        System.out.println("El tipo de servicio que usted eligio fue: " + tipoServicio);
        System.out.println("El Peso calculado fue: " + peso);
        System.out.println("La Distancia calculada fue: " + distancia);
        System.out.println("La zonaRemota fue: " + zonaRemota);
        System.out.println("El Subtotal fue: " + subtotal);
        System.out.println("El IVA impuesto fue: " + iva);
        System.out.println("El Total final fue: " + total);
    }
}