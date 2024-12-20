public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando o programa...");

        Conversor conversor = new Conversor();

        conversor.setCelsius(35);
        conversor.setFahrenheit(90);
        conversor.convertCelsius(conversor.getFahrenheit());
        conversor.converterFahrenheit(conversor.getCelsius());
    }
}
