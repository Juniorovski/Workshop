public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando Cassino...");
       
        Cassino cassino  = new Cassino();
        cassino.setBalance(1000.0);
        cassino.setBet(10.0);
        cassino.setSimbolProbality(new double []{ 0.1,0.3,0.4,0.2});
        cassino.setSimbols(new String []{"Gato","Coelho","Moeda","Amuleto"});
        cassino.setPaymentLines(new int [][] {{0, 0, 0}, {1, 1, 1}, {2, 2, 2}, {0, 1, 2}, {2, 1, 0}});
       
       int i=0;
       while (i<10) {
          cassino.play(cassino.getBet());
          i++;
       }

    }
}
