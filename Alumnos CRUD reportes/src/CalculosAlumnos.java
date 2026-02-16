public class CalculosAlumnos {

    public static boolean idRepetido(Alumno[] alumnos, int id) {
        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static boolean altaAlumno(Alumno[] alumnos, int id, String nombre, double promedio) {

        if (id <= 0 || nombre.trim().isEmpty() || promedio < 0 || promedio > 10 || idRepetido(alumnos, id)) {
            return false;
        }

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, nombre, promedio);
                return true;
            }
        }

        return false;
    }

    public static Alumno buscarAlumno(Alumno[] alumnos, int id) {
        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.getId() == id && alumno.isActivo()) {
                return alumno;
            }
        }
        return null;
    }

    public static boolean actualizarPromedio(Alumno[] alumnos, int id, double nuevoPromedio) {

        if (nuevoPromedio < 0 || nuevoPromedio > 10) {
            return false;
        }

        Alumno alumno = buscarAlumno(alumnos, id);

        if (alumno != null) {
            alumno.setPromedio(nuevoPromedio);
            return true;
        }

        return false;
    }

    public static boolean bajaLogica(Alumno[] alumnos, int id) {
        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.getId() == id && alumno.isActivo()) {
                alumno.setActivo(false);
                return true;
            }
        }
        return false;
    }

    public static void listarActivos(Alumno[] alumnos) {
        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.isActivo()) {
                System.out.println(alumno);
            }
        }
    }

    public static double promedioGeneral(Alumno[] alumnos) {
        double suma = 0;
        int contador = 0;

        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.isActivo()) {
                suma += alumno.getPromedio();
                contador++;
            }
        }

        if (contador == 0) {
            return 0;
        }

        return suma / contador;
    }

    public static Alumno mayorPromedio(Alumno[] alumnos) {
        Alumno mayor = null;

        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.isActivo()) {
                if (mayor == null || alumno.getPromedio() > mayor.getPromedio()) {
                    mayor = alumno;
                }
            }
        }

        return mayor;
    }

    public static Alumno menorPromedio(Alumno[] alumnos) {
        Alumno menor = null;

        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.isActivo()) {
                if (menor == null || alumno.getPromedio() < menor.getPromedio()) {
                    menor = alumno;
                }
            }
        }

        return menor;
    }

    public static int contarMayoresOcho(Alumno[] alumnos) {
        int contador = 0;

        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.isActivo() && alumno.getPromedio() >= 8.0) {
                contador++;
            }
        }

        return contador;
    }
}
