import java.util.Scanner;

public class Nros
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el primer nro");
        int nro1=scanner.nextInt();
        System.out.println("Ingrese el segundo nro");
        int nro2=scanner.nextInt();
        System.out.println("Ingrese el tercer nro");
        int nro3=scanner.nextInt();

        if (nro1 > nro2 && nro1>nro3 && nro2>nro3){
            System.out.println(nro1);
            System.out.println(nro2);
            System.out.println(nro3);
        }else {
            if (nro2 > nro1 && nro2 > nro3 && nro1 > nro3) {
                System.out.println(nro2);
                System.out.println(nro1);
                System.out.println(nro3);
            } else {
                if (nro1 > nro2 && nro1 > nro3 && nro3 > nro2) {
                    System.out.println(nro1);
                    System.out.println(nro3);
                    System.out.println(nro2);
                } else {
                    if (nro2 > nro1 && nro2 > nro3 && nro3 > nro1) {
                        System.out.println(nro2);
                        System.out.println(nro3);
                        System.out.println(nro1);
                    } else {
                        if (nro3 > nro1 && nro3 > nro2 && nro2 > nro1) {
                            System.out.println(nro3);
                            System.out.println(nro2);
                            System.out.println(nro1);
                        } else {
                            System.out.println(nro3);
                            System.out.println(nro1);
                            System.out.println(nro2);
                        }
                    }
                }
            }
        }

    }

}
