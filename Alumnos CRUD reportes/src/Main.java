import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        Alumno[] alumnos = new Alumno[25];
        int opcion;

        do {

            System.out.println("_____________________________");
            System.out.println("Menu");
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Actualizar promedio");
            System.out.println("4) Baja logica");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");

            System.out.print("OPCION: ");
            opcion = leer.nextInt();
            leer.nextLine();
            System.out.println("_____________________________");

            switch (opcion) {

                case 1:
                    System.out.print("Ingresa tu ID: ");
                    int id = leer.nextInt();
                    leer.nextLine();

                    System.out.print("Ingresa tu Nombre: ");
                    String nombre = leer.nextLine();

                    System.out.print("Ingrese el Promedio: ");
                    double promedio = leer.nextDouble();

                    if (CalculosAlumnos.altaAlumno(alumnos, id, nombre, promedio)) {
                        System.out.println("Alumno agregado correctamente");
                    } else {
                        System.out.println("Error al agregar alumno");
                    }
                    break;

                case 2:
                    System.out.print("Ingresa el ID a buscar: ");
                    int idBuscar = leer.nextInt();

                    Alumno encontrado = CalculosAlumnos.buscarAlumno(alumnos, idBuscar);

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese su ID: ");
                    int idAct = leer.nextInt();

                    System.out.print("Nuevo promedio a ingresar: ");
                    double nuevo = leer.nextDouble();

                    if (CalculosAlumnos.actualizarPromedio(alumnos, idAct, nuevo)) {
                        System.out.println("El promedio se a actualizado");
                    } else {
                        System.out.println("No se logro actualizar");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese ID para dar de baja: ");
                    int idBaja = leer.nextInt();

                    if (CalculosAlumnos.bajaLogica(alumnos, idBaja)) {
                        System.out.println("Alumno dado de baja");
                    } else {
                        System.out.println("No se encontro alumno ");
                    }
                    break;

                case 5:
                    CalculosAlumnos.listarActivos(alumnos);
                    break;

                case 6:
                    System.out.println("Promedio general: " + CalculosAlumnos.promedioGeneral(alumnos));

                    Alumno mayor = CalculosAlumnos.mayorPromedio(alumnos);
                    Alumno menor = CalculosAlumnos.menorPromedio(alumnos);

                    if (mayor != null)
                        System.out.println("Mayor promedio: " + mayor);

                    if (menor != null)
                        System.out.println("Menor promedio: " + menor);

                    System.out.println("Alumnos con promedio mayor o igual a 8: " +
                            CalculosAlumnos.contarMayoresOcho(alumnos));
                    break;
            }

        } while (opcion != 0);

        leer.close();
    }
}
