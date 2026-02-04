import java.util.Scanner;

public class Mainss {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
       Imputvalidator imputvalidator = new Imputvalidator();
       Scanner sc = new Scanner(System.in);
        // I-P-O
        //Imput
        int cantidad = imputvalidator.GetValidInt("Ingesa la cantidad de articulos", sc);

        //Process
        ticket.process(cantidad);

        //Debut
        ticket.imprimirTicket(cantidad);
    }
}
