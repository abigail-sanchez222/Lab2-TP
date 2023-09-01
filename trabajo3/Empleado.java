package trabajo3;

abstract class Empleado implements Impuesto {
    protected String nombre;
    protected int id;
    protected double sueldoBase;

    public Empleado(String nombre, int id, double sueldoBase){
        this.nombre=nombre;
        this.id=id;
        this.sueldoBase=sueldoBase;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    abstract double calcularSueldo();
}
