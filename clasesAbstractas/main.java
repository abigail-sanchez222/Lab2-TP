package clasesAbstractas;

import java.util.LinkedList;
import java.util.ListIterator;

public class main {
    public static void main(String[] args){
        circulo c=new circulo(4);
        //funciona pero sin clase abstracta
        //figura[5]=new circulo(5);
        //up castin
        cuadrado cu= new cuadrado();
        figura f= cu;
        //down castin
        figura fi=new cuadrado();
        cuadrado cua=(cuadrado) fi;


        //listas
        LinkedList <String> personas=new LinkedList<String>();
        personas.add("Tony");
        personas.add("Abi");
        personas.add("Stiven");

        System.out.println("Tamaño de la lista: "+ personas.size());
        //muestra por pantalla las personas
        for (String persona:personas) {
            System.out.println(persona);
        }
        //ListIterator<String> iterator= personas.ListIterator();
           // iterator.next();
           // iterator.add("ico");

        for (String persona:personas) {
            System.out.println(persona);
        }
    }
}
