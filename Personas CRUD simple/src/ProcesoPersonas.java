public class ProcesoPersonas {
    private int id;
    private String name;
    private boolean isActive;


    public ProcesoPersonas(int id, String name) {
        this.id = id;
        this.name = name;
        this.isActive = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "ProcesoPersonas " +
                " ID = " + id +
                ", Nombre ='" + name + '\'' +
                ", ¿Esta Activo? =" + isActive;
    }
}
