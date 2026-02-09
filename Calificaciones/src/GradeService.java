public class GradeService {

    public double calcularPromedio(double p1, double p2, double p3) {
        return (p1 + p2 + p3) / 3;
    }

    public double calcularFinal(double promedio, int asistencia) {
        return (promedio * 0.7) + (asistencia * 0.3);
    }

    public String determinarEstado(double Calfinal, int asistencia, boolean entregaProyecto) {

        if (asistencia < 80) {
            return "REPROBADO por asistencia";
        }

        if (!entregaProyecto) {
            return "REPROBADO por proyecto";
        }

        if (Calfinal >= 70) {
            return "APROBADO";
        } else {
            return "REPROBADO por calificación";
        }
    }

}
