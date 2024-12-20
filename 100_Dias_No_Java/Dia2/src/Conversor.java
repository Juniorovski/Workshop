
public class Conversor {

    private double temp;
    private double celsius;
    private double fahrenheit;

    public Conversor() {
    }

    public void converterFahrenheit(double celsius) {
        temp = celsius * 1.8 + 32;
        System.out.println(temp);
        System.out.println("Temperatura convertida para Fahrenheit " + temp);
    }

    public void convertCelsius(double fahrenheit) {
        temp = (fahrenheit - 32) / 1.8;
        System.out.println(temp);
        System.out.println("Temperatura convertida para Celsius " + temp);
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

}
