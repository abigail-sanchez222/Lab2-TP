package serializacion;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BlockdeNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del block (ingrese 'fin' para finalizar: ");
        String nombreBlock = scanner.nextLine();

        List<Block> blocks = cargarBlocks(); // Cargar la lista de blocks existentes

        // Verificar si ya existe un block con el mismo nombre
        Block b = buscarBlockPorNombre(blocks, nombreBlock);

        if (b == null) {
            // Si no existe, crear un nuevo block
            b = new Block(nombreBlock);
            blocks.add(b); // Agregarlo a la lista de blocks
        }

        System.out.println("\nMenú:");
        System.out.println("1. Agregar nota");
        System.out.println("2. Modificar nota");
        System.out.println("3. Eliminar nota");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el texto de la nota: ");

                while (true) {
                    String textoNota = scanner.nextLine();

                    if (textoNota.equalsIgnoreCase("fin")) {
                        break; // Salir del bucle si el usuario ingresa "fin"
                    }
                    b.agregarNota(new Nota(textoNota));
                }

                break;
            case 2:
                if (!b.notas.isEmpty()) {
                    System.out.print("Ingrese el índice de la nota que desea modificar: ");
                    int indiceModificacion = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    if (indiceModificacion >= 0 && indiceModificacion < b.notas.size()) {
                        System.out.print("Ingrese el nuevo texto de la nota: ");
                        String nuevoTexto = scanner.nextLine();
                        b.modificarNota(indiceModificacion, nuevoTexto);
                        System.out.println("Nota modificada exitosamente.");
                    } else {
                        System.out.println("Índice fuera de rango.");
                    }
                } else {
                    System.out.println("No hay notas para modificar.");
                }
                break;
            case 3:
                if (!b.notas.isEmpty()) {
                    System.out.print("Ingrese el índice de la nota que desea eliminar: ");
                    int indiceEliminacion = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    if (indiceEliminacion >= 0 && indiceEliminacion < b.notas.size()) {
                        b.eliminarNota(indiceEliminacion);
                        System.out.println("Nota eliminada exitosamente.");
                    } else {
                        System.out.println("Índice fuera de rango.");
                    }
                } else {
                    System.out.println("No hay notas para eliminar.");
                }
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        // Serializar la lista de blocks después de las operaciones
        Serializador serializador = new Serializador();
        serializador.serializar(blocks);
        System.out.println("Datos serializados.");

        // Deserializar y mostrar el contenido
        List<Block> blocksDeserializados = serializador.deserializar();
        if (blocksDeserializados != null) {
            System.out.println("Datos deserializados:");
            for (Block blockDeserializado : blocksDeserializados) {
                System.out.println(blockDeserializado.notas);
            }
        } else {
            System.out.println("No se encontraron datos deserializados.");
        }
    }

    // Cargar la lista de blocks desde un archivo (si existe)
    private static List<Block> cargarBlocks() {
        List<Block> blocks = new LinkedList<>();
        try {
            FileInputStream archivoEntrada = new FileInputStream("blocks.txt");
            ObjectInputStream flujoEntrada = new ObjectInputStream(archivoEntrada);
            blocks = (List<Block>) flujoEntrada.readObject();
            flujoEntrada.close();
        } catch (Exception e) {
            // No se pudo cargar la lista de blocks (puede ser la primera ejecución)
        }
        return blocks;
    }

    // Buscar un block por nombre en la lista de blocks existentes
    private static Block buscarBlockPorNombre(List<Block> blocks, String nombre) {
        for (Block block : blocks) {
            if (block.texto.equalsIgnoreCase(nombre)) {
                return block;
            }
        }
        return null; // No se encontró un block con el mismo nombre
    }
}

class Serializador {
    public void serializar(List<Block> blocks) {
        try {
            FileOutputStream archivoSalida = new FileOutputStream("blocks.txt");
            ObjectOutputStream flujoSalida = new ObjectOutputStream(archivoSalida);
            flujoSalida.writeObject(blocks);
            flujoSalida.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Block> deserializar() {
        List<Block> blocks = null;
        try {
            FileInputStream archivoEntrada = new FileInputStream("blocks.txt");
            ObjectInputStream flujoEntrada = new ObjectInputStream(archivoEntrada);
            blocks = (List<Block>) flujoEntrada.readObject();
            flujoEntrada.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blocks;
    }
}

class Block implements Serializable {
    LinkedList<Nota> notas;
    String texto;

    public Block(String texto) {
        this.texto = texto;
        notas = new LinkedList<>();
    }

    public void agregarNota(Nota nuevaNota) {
        notas.add(nuevaNota);
    }

    public void eliminarNota(int indice) {
        if (indice >= 0 && indice < notas.size()) {
            notas.remove(indice);
        }
    }

    public void modificarNota(int indice, String texto) {
        if (indice >= 0 && indice < notas.size()) {
            notas.get(indice).texto = texto;
        }
    }
}

class Nota implements Serializable {
    String texto;

    public Nota(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "texto='" + texto + '\'' +
                '}';
    }
}
