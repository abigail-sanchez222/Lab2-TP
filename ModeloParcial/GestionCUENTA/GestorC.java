package ModeloParcial.GestionCUENTA;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CuentaPersona cp=new CuentaPersona(567,"abi","sanchez",789);
        cp.depositar(500);
        cp.mostrarInformacion();
        cp.retirar(400);
        cp.mostrarInformacion();


        GestorCuentas gestor = new GestorCuentas();

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Cuenta de Persona");
            System.out.println("2. Agregar Cuenta de Sociedad");
            System.out.println("3. Eliminar Cuenta de Persona");
            System.out.println("4. Eliminar Cuenta de Sociedad");
            System.out.println("5. Editar Saldo de Cuenta de Persona");
            System.out.println("6. Editar Saldo de Cuenta de Sociedad");
            System.out.println("7. Mostrar Todas las Cuentas");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea en blanco

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número de cuenta de persona: ");
                    int numPersona = scanner.nextInt();
                    scanner.nextLine(); // Consumir la línea en blanco
                    System.out.print("Ingrese el saldo inicial de persona: ");
                    int saldoPersona = scanner.nextInt();
                    scanner.nextLine(); // Consumir la línea en blanco
                    System.out.print("Ingrese el nombre de persona: ");
                    String nombrePersona = scanner.nextLine();
                    System.out.print("Ingrese el apellido de persona: ");
                    String apellidoPersona = scanner.nextLine();
                    gestor.agregarCuentaPersona(new CuentaPersona(numPersona, nombrePersona, apellidoPersona, saldoPersona));
                    System.out.println("Cuenta de persona agregada con éxito.");
                    break;

                case 2:
                    System.out.print("Ingrese el número de cuenta de sociedad: ");
                    int numSociedad = scanner.nextInt();
                    scanner.nextLine(); // Consumir la línea en blanco
                    System.out.print("Ingrese el saldo inicial de sociedad: ");
                    int saldoSociedad = scanner.nextInt();
                    scanner.nextLine(); // Consumir la línea en blanco
                    System.out.print("Ingrese el nombre de la empresa de sociedad: ");
                    String nombreEmpresa = scanner.nextLine();
                    System.out.print("Ingrese el tipo de empresa de sociedad: ");
                    String tipoEmpresa = scanner.nextLine();
                    gestor.agregarCuentaSociedad(new CuentaSociedad(numSociedad, saldoSociedad, nombreEmpresa, tipoEmpresa));
                    System.out.println("Cuenta de sociedad agregada con éxito.");
                    break;

                case 3:
                    System.out.print("Ingrese el número de cuenta de persona a eliminar: ");
                    int numPersonaEliminar = scanner.nextInt();
                    gestor.eliminarCuentaPersona(numPersonaEliminar);
                    break;

                case 4:
                    System.out.print("Ingrese el número de cuenta de sociedad a eliminar: ");
                    int numSociedadEliminar = scanner.nextInt();
                    gestor.eliminarCuentaSociedad(numSociedadEliminar);
                    break;

                case 5:
                    System.out.print("Ingrese el número de cuenta de persona a editar: ");
                    int numPersonaEditar = scanner.nextInt();
                    System.out.print("Ingrese el nuevo saldo de persona: ");
                    int nuevoSaldoPersona = scanner.nextInt();
                    gestor.modificarCuentaPersonal(numPersonaEditar, nuevoSaldoPersona);
                    break;

                case 6:
                    System.out.print("Ingrese el número de cuenta de sociedad a editar: ");
                    int numSociedadEditar = scanner.nextInt();
                    System.out.print("Ingrese el nuevo saldo de sociedad: ");
                    int nuevoSaldoSociedad = scanner.nextInt();
                    gestor.modificarCuentaSociedad(numSociedadEditar, nuevoSaldoSociedad);
                    break;

                case 7:
                    gestor.mostrarTodasLasCuentas();
                    break;

                case 8:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}

class GestorCuentas {
    private ArrayList<CuentaPersona> persona;
    private ArrayList<CuentaSociedad>sociedad;

    public GestorCuentas(){
        persona=new ArrayList<>();
        sociedad=new ArrayList<>();
    }
    public void agregarCuentaPersona(CuentaPersona NuevaPersona){
        persona.add(NuevaPersona);
    }
    public void agregarCuentaSociedad(CuentaSociedad NuevaSociedad){
        sociedad.add(NuevaSociedad);
    }
    public void eliminarCuentaPersona(int nroDeCuenta) {
        for (int i = 0; i < persona.size(); i++) {
            // Recorre la lista de estudiantes y verifica si el número de legajo coincide con nroLegajo
            if (persona.get(i).nroCuenta == nroDeCuenta) {
                persona.remove(i); // Si hay coincidencia, elimina al estudiante en esa posición
            }
        }
    }
    public void eliminarCuentaSociedad(int nroDeCuenta) {
        for (int i = 0; i < sociedad.size(); i++) {
            // Recorre la lista de estudiantes y verifica si el número de legajo coincide con nroLegajo
            if (sociedad.get(i).nroCuenta == nroDeCuenta) {
                sociedad.remove(i); // Si hay coincidencia, elimina al estudiante en esa posición
            }
        }
    }
    public void modificarCuentaPersonal (int NuevoSaldo, int nroDeCuenta) {
        for (int i = 0; i < persona.size(); i++) {
            // Recorre la lista de estudiantes y verifica si el número de legajo coincide con nroLegajo
            if (persona.get(i).nroCuenta == nroDeCuenta) {
                persona.get(i).saldo = NuevoSaldo; // Si hay coincidencia, modifica el nombre del estudiante en esa posición
            }
        }
    }
    public void modificarCuentaSociedad (int NuevoSaldo, int nroDeCuenta) {
        for (int i = 0; i < sociedad.size(); i++) {
            // Recorre la lista de estudiantes y verifica si el número de legajo coincide con nroLegajo
            if (sociedad.get(i).nroCuenta == nroDeCuenta) {
                sociedad.get(i).saldo = NuevoSaldo; // Si hay coincidencia, modifica el nombre del estudiante en esa posición
            }
        }
    }

    public void mostrarTodasLasCuentas(){
        System.out.println("Cuentas de Personas:");
        for (CuentaPersona p : persona) {
            p.mostrarInformacion();
            System.out.println();
        }
        System.out.println("Cuentas de Sociedades:");
        for (CuentaSociedad s : sociedad) {
            s.mostrarInformacion();
            System.out.println();
        }

    }
}

class CuentaSociedad extends Cuenta{
    private String nombreEmpresa;
    private String tipoEmpresa;

    public CuentaSociedad(int nroCuenta, int saldo, String nombreEmpresa, String tipoEmpresa) {
        super(nroCuenta, saldo);
        this.nombreEmpresa=nombreEmpresa;
        this.tipoEmpresa=tipoEmpresa;
    }

    @Override
    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    // Implementación del método para retirar una cantidad
    @Override
    public void retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            System.out.println("Saldo insuficiente para realizar la operación.");
        }
    }

    // Implementación del método para mostrar información de la cuenta
    @Override
    public void mostrarInformacion() {
        System.out.println("Número de Cuenta: " + nroCuenta+ "Nombre: " + nombreEmpresa+ "Tipo: " + tipoEmpresa+ "Saldo: " + saldo);
    }
}


class CuentaPersona extends Cuenta {
    private String nombre;
    private String apellido;

    public CuentaPersona(int nroCuenta, String nombre, String apellido, int saldo) {
        super(nroCuenta, saldo);
        this.nombre=nombre;
        this.apellido=apellido;
    }


    @Override
    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    // Implementación del método para retirar una cantidad
    @Override
    public void retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            System.out.println("Saldo insuficiente para realizar la operación.");
        }
    }

    // Implementación del método para mostrar información de la cuenta
    @Override
    public void mostrarInformacion() {
        System.out.println("Número de Cuenta: " + nroCuenta+" Nombre: " + nombre+" Apellido: " + apellido+" Saldo: " + saldo);
    }
}


abstract class Cuenta {
    protected int nroCuenta;
    protected int saldo;

    public Cuenta(int nroCuenta,int saldo){
        this.nroCuenta=nroCuenta;
        this.saldo=saldo;
    }
    public abstract void depositar(double cantidad);

    // Método abstracto para retirar una cantidad
    public abstract void retirar(double cantidad);

    // Método abstracto para mostrar información de la cuenta
    public abstract void mostrarInformacion();
}
