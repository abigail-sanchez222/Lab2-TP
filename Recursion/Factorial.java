//El primer codigo es con el metodo Recursivo y el 2do con ciclo iterativo

import java.util.Scanner;
public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nro;

        System.out.println("Ingrese el nro que le gustaria factorizar ");
        nro=scanner.nextInt();
        int n=FactorialRecur(nro);
        System.out.println("Result: "+n);
    }
}
//---------------------
import java.util.Scanner;
public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nro,i,n;

        System.out.println("Ingrese el nro que le gustaria factorizar ");
        nro=scanner.nextInt();
        n=1;
        for (i=nro;i>0;i--){
                n = n* i;
        }
        System.out.println("Result: "+ n);
    }
}
