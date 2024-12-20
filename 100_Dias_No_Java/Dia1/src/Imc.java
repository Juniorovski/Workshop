
public class Imc {

    private double peso;
    private double altura;
    private double resultado;

    public Imc() {
    }

    public void calcularImc(double peso, double altura) {
        resultado = peso / (altura * altura);
        System.out.println("Seu imc é " + resultado);

        if (resultado <= 17 && resultado <=18) {
            System.out.println("Você esta muito magro! ");
        } else if (resultado >= 20 && resultado <= 24) {
            System.out.println("Você esta no peso ideal! ");
        } else if (resultado >= 26 && resultado <= 29) {
            System.out.println("Você esta sobrepeso grau I! ");
        } else if (resultado >= 30 && resultado <= 39) {
            System.out.println("Você esta com obesidade grau II! ");
        } else if (resultado > 40) {
            System.out.println("Você esta com obesidade grave grau III! ");
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

}
