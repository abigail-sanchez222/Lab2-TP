package trabajo3;

public class EmpleadoxHoras extends Empleado implements Impuesto{
    private int horasTrabajadas;

    public EmpleadoxHoras(String nombre, int id, double sueldoBase, int horasTrabajadas){
        super(nombre,id,sueldoBase);
        this.horasTrabajadas=horasTrabajadas;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    double calcularSueldo() {
        return super.getSueldoBase()*getHorasTrabajadas();
    }


    @Override
    public double calcularImpuesto() {
        return super.sueldoBase*0.50;
    }
}
