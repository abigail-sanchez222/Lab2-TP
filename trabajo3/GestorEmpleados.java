package trabajo3;

import java.util.ArrayList;

class GestorEmpleados  {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void modificarEmpleado(int indice, Empleado empleado) {
        empleados.set(indice, empleado);
    }

    public void eliminarEmpleado(int indice) {
        empleados.remove(indice);
    }

    public void mostrarEmpleados() {
        for (Empleado empleado : empleados) {
            System.out.println(empleado.nombre + " - Sueldo: " + empleado.calcularSueldo()+" - Impuesto: " + empleado.calcularImpuesto());
        }
    }
}



