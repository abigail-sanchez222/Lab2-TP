import java.util.Scanner;
public class Suma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nro;

        System.out.println("Ingrese el nro");
        nro = scanner.nextInt();

        int s=SumaSus(nro);

        System.out.println("Result: "+s);
    }
    public static int SumaSus(int nro){
        //Caso base, si el nro es menor o igual a 1
        if (nro < 1){
            System.out.println("El nro ingresado es menor a 1");
        }
        if (nro==1){
           return 1;
        }
        //llama a la funcion y en cada llamado resta 1 al nro.Ej: Si el nro ingresado es 4,
        // en el primer llamado es 4+3,en el 2do 7+2, en el 3er llamado es 9+1, en el 4to llamado es 10+0;
        return nro+SumaSus(nro-1);
    }

}
