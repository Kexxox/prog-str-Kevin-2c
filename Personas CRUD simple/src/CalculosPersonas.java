public class CalculosPersonas {
    public static boolean IdRepetido(ProcesoPersonas[] personas, int id){
        for (ProcesoPersonas persona : personas) {
            if (persona != null && persona.getId() == id) {
                    return true;
                }
            }
        return false;
    }

    public static ProcesoPersonas BuscarIDActiva(ProcesoPersonas[] personas, int id) {
        for (ProcesoPersonas persona : personas) {
            if (persona != null && persona.getId() == id && persona.isActive()) {
            }
            return persona;
        }
        return null;
    }

    public static boolean BajaLogica(ProcesoPersonas[] personas, int id){
        ProcesoPersonas persona = BuscarIDActiva(personas, id);
        if (persona != null) {
            persona.setActive(false);
            return true;
        }
        return false;
    }

    public static void ListaActivas(ProcesoPersonas[] personas){
        for (ProcesoPersonas persona : personas) {
            if (persona != null && persona.isActive()) {
                System.out.println(persona);
            }
        }
    }

    public static boolean PersonaAgregada (ProcesoPersonas[] personas, int id, String nombre){

            if (id<=0 || nombre.trim().isEmpty()|| IdRepetido(personas, id)) {
                return false;
            }
            for (int contador = 0; contador < personas.length; contador++) {
                if (personas[contador] == null) {
                    personas[contador] = new ProcesoPersonas(id, nombre);
                    return true;
                }
            }


        return false;
    }

    public static boolean NewName (ProcesoPersonas[] personas, int id, String newnombre){
        ProcesoPersonas persona = BuscarIDActiva(personas, id);
        if (persona != null) {
            persona.setName( newnombre);
            return true;
        }
        return false;
    }

}
