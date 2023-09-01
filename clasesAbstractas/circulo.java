package clasesAbstractas;

public class circulo implements figura,rotable,dibujable{

    private double radio;

    public circulo(double radio) {
        this.radio = radio;
    }

    /*public circulo(double x, double y, double radio) {
        super(x, y);
        this.radio = radio;
    }*/
    //interface
    @Override
    public void rotar() {
        System.out.println("puedo rotar");
    }
    //interface
    @Override
    public void dibujar() {
        System.out.println("estoy dibujando un circulo");
    }

    public double calcularArea() {
        return Math.PI*Math.pow(radio,2);
    }
}
