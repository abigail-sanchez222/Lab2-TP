package trabajo3;

import java.io.IOException;
public class main {
    public static void main(String[] args){

        GestorEmpleados gestor = new GestorEmpleados();

        EmpleadoxHoras empleado1 = new EmpleadoxHoras("Juan", 1, 15000.0, 8);
        EmpleadoAsalariado empleado2 = new EmpleadoAsalariado("María", 2, 25000.0);
        EmpleadoComision empleado3 = new EmpleadoComision("Carlos", 3, 10000.0, 0);
        try{
            evaluarHoras(empleado1.getHorasTrabajadas());
            gestor.agregarEmpleado(empleado1);

        }catch (EvaluarNro e){
            System.out.println("El nro de horas trabajadas que ingresaste es invalido: \n");
        }
        try{
            evaluar(empleado2.getSueldoBase());
            gestor.agregarEmpleado(empleado2);
            evaluar(empleado3.getVentasRealizadas());

        }catch (EvaluarNro e){
            System.out.println("El sueldo basico que ingresaste es invalido: \n");
        }
        try{
            evaluar(empleado3.getVentasRealizadas());
            gestor.agregarEmpleado(empleado3);

        }catch (EvaluarNro e){
            System.out.println("Las ventas realizadas que ingresaste son invalidas: \n");
        }





        System.out.println("Lista de empleados: \n");
        gestor.mostrarEmpleados();
        gestor.eliminarEmpleado(1);
        System.out.println("\n Lista de empleados sin el elemento borrado:");
        gestor.mostrarEmpleados();

    }
    public static void evaluarHoras(int nro) throws EvaluarNro{
        if (nro==0){
            EvaluarNro error=new EvaluarNro("Nro fuera de rango");
            throw error;
        }
    }
    public static void evaluar(double nro) throws EvaluarNro{
        if (nro==0){
            EvaluarNro error=new EvaluarNro("Nro fuera de rango");
            throw error;
        }
    }
}
class EvaluarNro extends IOException{

    public EvaluarNro(){}

    public EvaluarNro(String mError){
        super(mError);
    }
}



