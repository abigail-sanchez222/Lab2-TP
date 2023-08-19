//El primer codigo es con el metodo Repetitivo y el 2do con el metodo Recursivo
import java.util.Scanner;
public class divisionResta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dividendo,r;
        int divisor,cont;

        System.out.println("Ingrese el dividendo");
        dividendo=scanner.nextInt();
        System.out.println("Ingrese el divisor");
        divisor=scanner.nextInt();

        //Sin recursion
        r= dividendo-divisor;
        cont=1;
       while (r > 0 ){
           r= r-divisor;
           cont=cont+1;
        }
        System.out.println("Resultado es "+cont);
    }
}
//--------------------------------------------------
import java.util.Scanner;
public class divisioRestasRecur {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividendo,divisor,r;

        //pide al usuario que ingrese los nros que desee dividir
        System.out.println("Ingrese el dividendo");
        dividendo=scanner.nextInt();
        System.out.println("Ingrese el divisor");
        divisor=scanner.nextInt();

        //llama a la funcion recursiva
        r= divisionRecursiva(dividendo, divisor);
        System.out.println("El resultado de la división " + dividendo + " / " + divisor + " es: " + r);

    }



    public static int divisionRecursiva(int dividendo, int divisor) {
        // Caso base: Si el divisor es igual a cero, mostramos por pantalla que no es posible realizar esa division
        if (divisor == 0) {
            System.out.println("No se puede dividir por cero");
        }
        // Caso base: Si el dividendo es menor que el divisor, retornamos cero
        if (dividendo < divisor) {
            return 0;
        }
        // Caso base: Si el dividendo es igual al divisor, retornamos uno
        if (dividendo == divisor) {
            return 1;
        }
        // Hacemos la llamada recursiva con restas sucesivas.
        return 1 + divisionRecursiva(dividendo - divisor, divisor);
    }