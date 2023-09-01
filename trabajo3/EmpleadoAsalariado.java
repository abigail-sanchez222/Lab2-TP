package trabajo3;

public class EmpleadoAsalariado extends Empleado implements Impuesto{

    public EmpleadoAsalariado(String nombre, int id, double sueldoBase){
        super(nombre,id,sueldoBase);
    }
    @Override
    double calcularSueldo() {
        return super.getSueldoBase();
    }

    @Override
    public double calcularImpuesto() {
        return super.sueldoBase*0.22;
    }
}
