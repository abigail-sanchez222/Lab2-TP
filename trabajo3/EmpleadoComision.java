package trabajo3;

public class EmpleadoComision extends Empleado implements Impuesto {
    private double ventasRealizadas;

    public EmpleadoComision(String nombre, int id, double sueldoBase, double ventasRealizadas){
        super(nombre,id,sueldoBase);
        this.ventasRealizadas=ventasRealizadas;
    }

    public double getVentasRealizadas() {
        return ventasRealizadas;
    }

    @Override
    double calcularSueldo() {
        return super.getSueldoBase()*getVentasRealizadas();
    }


    @Override
    public double calcularImpuesto() {
        return super.sueldoBase*0.30;
    }
}
