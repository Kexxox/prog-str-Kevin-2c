import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        GradeService servicio = new GradeService();

        String nombre = leerTextoNoVacio(leer, "Ingrese el nombre de alumno: ");

        double p1 = leerDoubleEnRango(leer, "Calificacion de °1 parcial (0-100): ", 0, 100);
        double p2 = leerDoubleEnRango(leer, "Calificacion de °2 parcial(0-100): ", 0, 100);
        double p3 = leerDoubleEnRango(leer, "Calificacion de °3 parcial (0-100): ", 0, 100);

        int asistencia = leerIntEnRango(leer, "Calificacion de asistencia (0-100): ", 0, 100);
        boolean entregaProyecto = leerBoolean(leer, "¿Se entrego un proyecto? (true/false): ");

        double promedio = servicio.calcularPromedio(p1, p2, p3);
        double Calfinal = servicio.calcularFinal(promedio, asistencia);
        String estado = servicio.determinarEstado(Calfinal, asistencia, entregaProyecto);

        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregaProyecto, Calfinal, estado);
    }

    static String leerTextoNoVacio(Scanner leer, String msg) {
        String mensaje = "";

        while (mensaje.equals("")) {
            System.out.print(msg);
            mensaje = leer.nextLine();
        }
        return mensaje;
    }

    static double leerDoubleEnRango(Scanner leer, String msg, double min, double max) {
        double valor;
        do {
            System.out.print(msg);
            valor = leer.nextDouble();
        } while (valor < min || valor > max);
        leer.nextLine();
        return valor;
    }

    static int leerIntEnRango(Scanner leer, String msg, int min, int max) {
        int valor;
        do {
            System.out.print(msg);
            valor = leer.nextInt();
        } while (valor < min || valor > max);
        leer.nextLine();
        return valor;
    }

    static boolean leerBoolean(Scanner leer, String msg) {
        System.out.print(msg);
        boolean valor = leer.nextBoolean();
        leer.nextLine();
        return valor;
    }

    static void imprimirReporte(String nombre, double p1, double p2, double p3, double promedio, int asistencia, boolean entregaProyecto, double Calfinal, String estado) {

        System.out.println("Alumno ingresado " + nombre);
        System.out.println("Calificacion de °1 parcial:"+ p1);
        System.out.println("Calificacion de °2 parical:"+ p2);
        System.out.println("Calificacion de °3 parcial:"+ p3);
        System.out.println("El promedio fue de : " + promedio);
        System.out.println("La calificacion de la asistencia fue: " + asistencia);
        System.out.println("Entregó proyecto: "+ entregaProyecto);
        System.out.println("La calificación final fue : " + Calfinal);
        System.out.println("Su estado es: " + estado);
    }
}
