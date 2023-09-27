package ModeloParcial.ConcesionariaVehiculo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;


public class ConsesonariaV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Concesionaria vehiculo = new Concesionaria();
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar vehiculo");
            System.out.println("2. Eliminar vehiculo");
            System.out.println("3. Editar vehiculo");
            System.out.println("4. Mostrar Todos lo vehiculos");
            System.out.println("5. Guardar");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese el precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Es moto o Auto: ");
                    String tipo = scanner.nextLine();

                    if (tipo.equals("Moto")) {
                        vehiculo.agregarMoto(new Moto(marca, modelo, precio));
                    } else {
                        vehiculo.agregarAuto(new Auto(marca, modelo, precio));
                    }
                    System.out.println("Vehiculo agregado con éxito.");

                    break;
                case 2:
                    System.out.print("Ingrese la marca y el modelo que desea eliminar y si es moto o auto: ");
                    marca = scanner.nextLine();
                    modelo = scanner.nextLine();
                    tipo = scanner.nextLine();
                    if (tipo.equals("Moto")) {
                        vehiculo.eliminarMoto(marca, modelo);
                    } else {
                        vehiculo.eliminarAuto(marca, modelo);
                    }
                    System.out.println("Vehiculo aliminado con éxito.");

                    break;
                case 3:
                    System.out.print("Ingrese la marca, el modelo que desea editar y si es moto o auto: ");
                    marca = scanner.nextLine();
                    modelo = scanner.nextLine();
                    tipo = scanner.nextLine();
                    if (tipo.equals("Moto")) {
                        System.out.print("Ingrese el nuevo precio: ");
                        int NuevoPrecio = scanner.nextInt();
                        vehiculo.editarPrecioMoto(marca, modelo, NuevoPrecio);
                    } else {
                        System.out.print("Ingrese el nuevo precio: ");
                        int NuevoPrecio = scanner.nextInt();
                        vehiculo.editarPrecioAuto(marca, modelo, NuevoPrecio);
                    }
                    break;
                case 4:
                    vehiculo.mostrarInventario();
                    break;
                case 5:

                        // Serializar el objeto 'vehiculo'
                        Serializador serializador = new Serializador();
                        serializador.serializar(vehiculo);
                        System.out.println("Vehículo guardado con éxito.");

                        Concesionaria concesionariaDeserializado = serializador.deserializar();
                        System.out.println(concesionariaDeserializado.a);
                        System.out.println(concesionariaDeserializado.m);
                        System.out.println("Vehículo deserializado con éxito.");

                    break;
                case 6:
                    System.exit(0);
            }
        }

            }
        }

        class Serializador {
            public void serializar(Concesionaria c) {
                try {
                    // Crear un flujo de salida para escribir en un archivo llamado "curso.txt"
                    FileOutputStream archivoSalida = new FileOutputStream("consecionaria.txt");
                    // Crear un flujo de objeto para escribir objetos en el flujo de salida
                    ObjectOutputStream flujoSalida = new ObjectOutputStream(archivoSalida);
                    // Escribir el objeto "curso" en el flujo de salida
                    flujoSalida.writeObject(c);
                    // Importante: cerrar el flujo de salida para liberar recursos
                    flujoSalida.close();
                } catch (Exception e) {
                    e.printStackTrace(); // En caso de error, imprimir información de la excepción
                }
            }


            public Concesionaria deserializar() {
                Concesionaria c = null;
                try {
                    // Abrir un flujo de entrada para leer desde el archivo "curso.txt"
                    FileInputStream archivoEntrada = new FileInputStream("consecionaria.txt");
                    // Crear un flujo de objeto para leer objetos desde el flujo de entrada
                    ObjectInputStream flujoEntrada = new ObjectInputStream(archivoEntrada);
                    // Leer el objeto serializado desde el flujo de entrada y convertirlo a un objeto Curso
                    c = (Concesionaria) flujoEntrada.readObject();
                    // Importante: cerrar el flujo de entrada para liberar recursos
                    flujoEntrada.close();
                } catch (Exception e) {
                    e.printStackTrace(); // En caso de error, imprimir información de la excepción
                }
                return c; // Devolver el objeto Curso deserializado
            }
        }


        class Concesionaria implements Serializable {
            transient ArrayList<Auto> a;
            transient ArrayList<Moto> m;

            public Concesionaria() {
                a = new ArrayList<>();
                m = new ArrayList<>();
            }

            public void agregarAuto(Auto auto) {
                a.add(auto);
            }

            public void agregarMoto(Moto moto) {
                m.add(moto);
            }

            public void eliminarMoto(String marca, String modelo) {
                for (int i = 0; i < m.size(); i++) {
                    // Recorre la lista de estudiantes y verifica si el número de legajo coincide con nroLegajo
                    if (m.get(i).getMarca().equals(marca) && m.get(i).getModelo().equals(modelo)) {
                        m.remove(i); // Si hay coincidencia, elimina al estudiante en esa posición
                    }
                }
            }

            public void eliminarAuto(String marca, String modelo) {
                for (int i = 0; i < a.size(); i++) {
                    // Recorre la lista de estudiantes y verifica si el número de legajo coincide con nroLegajo
                    if (a.get(i).getMarca().equals(marca) && a.get(i).getModelo().equals(modelo)) {
                        a.remove(i); // Si hay coincidencia, elimina al estudiante en esa posición
                    }
                }
            }

            public void editarPrecioAuto(String marca, String modelo, double nuevoPrecio) {
                for (int i = 0; i < a.size(); i++) {
                    // Recorre la lista de estudiantes y verifica si el número de legajo coincide con nroLegajo
                    if (a.get(i).getMarca().equals(marca) && a.get(i).getModelo().equals(modelo)) {
                        a.get(i).precio = nuevoPrecio; // Si hay coincidencia, modifica el nombre del estudiante en esa posición
                    }
                }
            }
            public void editarPrecioMoto(String marca, String modelo, double nuevoPrecio) {
                for (int i = 0; i < m.size(); i++) {
                    // Recorre la lista de estudiantes y verifica si el número de legajo coincide con nroLegajo
                    if (m.get(i).getMarca().equals(marca) && m.get(i).getModelo().equals(modelo)) {
                        m.get(i).precio = nuevoPrecio; // Si hay coincidencia, modifica el nombre del estudiante en esa posición
                    }
                }
            }

            public void mostrarInventario() {
                System.out.println("Autos:");
                for (Auto auto : a) {
                    auto.mostrarInformacion();
                    System.out.println();
                }
                System.out.println("Moto:");
                for (Moto moto : m) {
                    moto.mostrarInformacion();
                    System.out.println();
                }
            }

            private void writeObject(ObjectOutputStream out) throws IOException {
                /**Se utiliza `throws IOException` para manejar posibles errores
                 * con la entrada/salida de datos durante la serialización de la clase `Curso`.
                 */
                out.defaultWriteObject(); // Llama al método predeterminado de serialización de la superclase
                out.writeObject(a);
                out.writeObject(m); // Escribe la lista de estudiantes en el flujo de salida
            }

            private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
                in.defaultReadObject(); // Llama al método predeterminado de deserialización de la superclase
                a = (ArrayList<Auto>) in.readObject();
                m = (ArrayList<Moto>) in.readObject();
            }
        }

        class Moto extends Vehiculo implements Serializable{

            public Moto(String marca, String modelo, double precio) {
                super(marca, modelo, precio);
            }

            @Override
            public void calcularImpuesto() {

            }

            @Override
            public void mostrarInformacion() {
                System.out.println("Moto - " + super.toString());
            }

        }

        class Auto extends Vehiculo implements Serializable{

            public Auto(String marca, String modelo, double precio) {
                super(marca, modelo, precio);
            }

            @Override
            public void calcularImpuesto() {

            }

            @Override
            public void mostrarInformacion() {
                System.out.println("Auto: " + super.toString());
            }

        }

        abstract class Vehiculo implements Serializable{
            protected String marca;
            protected String modelo;
            protected double precio;

            public Vehiculo(String marca, String modelo, double precio) {
                this.marca = marca;
                this.modelo = modelo;
                this.precio = precio;
            }

            public abstract void mostrarInformacion();

            public abstract void calcularImpuesto();

            public String getMarca() {
                return marca;
            }

            public void setMarca(String marca) {
                this.marca = marca;
            }

            public String getModelo() {
                return modelo;
            }

            public double getPrecio() {
                return precio;
            }

            public void setPrecio(double precio) {
                this.precio = precio;
            }

            public void setModelo(String modelo) {
                this.modelo = modelo;
            }

            @Override
            public String toString() {
                return "Vehiculo{" +
                        "marca='" + marca + '\'' +
                        ", modelo='" + modelo + '\'' +
                        ", precio=" + precio +
                        '}';
            }
        }



