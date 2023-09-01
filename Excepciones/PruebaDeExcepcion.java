package Excepciones;
import java.io.IOException;
import java.util.Scanner;
public class PruebaDeExcepcion {

public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Ingrese un numero: ");
        try {
        evaluarRango(s.nextInt());
        } catch (rangoNumeros e) {
        // TODO Auto-generated catch block
                System.out.println("Nro fuera de rango");
        }
        }


static void evaluarRango(int n) throws rangoNumeros {

        if (n < 1 || n > 100) {

        rangoNumeros error = new rangoNumeros("Numero fuera de rango");
        throw error;
        }
        }
}
class rangoNumeros extends IOException {

        public rangoNumeros() {
        }

        public rangoNumeros(String mError) { super(mError); }

}