import java.util.Scanner;

public class CrudSimple {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        ProcesoPersonas[] personas = new ProcesoPersonas[20];
        int opcion;

        do{
            System.out.println("_____________________________");
            System.out.println("Menu");
            System.out.println("Alta (1)");
            System.out.println("Buscar por ID (Solo Activas) (2)");
            System.out.println("Baja logica por ID (3)");
            System.out.println("Listar activas (4)");
            System.out.println("Actualizar nombre por ID (5)");
            System.out.println("Salir (0)");

            System.out.print("OPCION: ");
            opcion = leer.nextInt();
            leer.nextLine();
            System.out.println("______________________________");

            switch(opcion){
                case 1:
                    System.out.print("Ingresa tu ID: ");
                    int id = leer.nextInt();
                    leer.nextLine();

                    System.out.print("Ingresa tu nombre: ");
                    String Nombre = leer.nextLine();

                    if (CalculosPersonas.PersonaAgregada(personas, id, Nombre)){
                        System.out.println("Persona a sido agregada");
                    } else {
                        System.out.println("Error al agregar persona");
                    }
                    break;
                case 2:
                    System.out.print("Ingresa tu ID: ");
                    int buscar = leer.nextInt();
                    ProcesoPersonas encontrada = CalculosPersonas.BuscarIDActiva(personas, buscar);
                    if (encontrada != null){
                        System.out.println("ID encontrada");
                    } else {
                        System.out.println("Error al buscar ID");
                    }
                    break;
                case 3:
                    System.out.print("Ingresa ID que se dara de baja: ");
                    int DadaBaja = leer.nextInt();

                    if (CalculosPersonas.BajaLogica(personas,DadaBaja)){
                        System.out.println("ID dada de baja");
                    } else {
                        System.out.println("Error al dar de baja");
                    }
                    break;
                case 4:
                    CalculosPersonas.ListaActivas(personas);
                    break;
                case 5:
                    System.out.println("ID a actualizar");
                    int actualiNombre = leer.nextInt();
                    leer.nextLine();
                    System.out.print("Ingrese nuevo nombre: ");
                    String NewNombre = leer.nextLine();

                    if (CalculosPersonas.NewName(personas,actualiNombre,NewNombre)){
                    }else {
                        System.out.println("Error al actualizar nombre");
                    }
                    break;
                case 0:
                    System.out.println("Usted a finalizado");
                    break;

                default:
                    System.out.println("Opcion Invalida");
            }
        } while (opcion != 0);
    }
}