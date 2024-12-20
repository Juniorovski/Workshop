public class App {
    public static void main(String[] args) throws Exception {
     System.out.println("Iniciando o programa aguarde...");
      
     Imc imc = new Imc();

     imc.setPeso(75);
     imc.setAltura(1.69);

     imc.calcularImc(imc.getPeso(), imc.getAltura());
    
    }
}
