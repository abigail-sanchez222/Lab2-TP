package clasesAbstractas;


//en las clases abstractas es "extends"
//en las interfaces es "implements"
//se elimina "public" y se pone final para indicar que nadie mas va a heredar esa clase
final class cuadrado implements figura,dibujable {
        private double lado;

    public cuadrado() {
    }


    /* clase abstracta
    public cuadrado(double x, double y, double lado) {
        super(x, y);
        this.lado=lado;
    }*/
    //interfas
    @Override
    public void dibujar() {
        System.out.println("estoy dibujando");
    }

    @Override
        public double calcularArea() {
            return lado*lado;

    }
}
