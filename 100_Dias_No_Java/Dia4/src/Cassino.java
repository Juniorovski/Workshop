
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Cassino {

    private String[] rolls;
    private double[] simbolProbality;
    private String[] simbols;
    private int[][] paymentLines;
    private double balance;
    private double bet;
    private double RTP = 0.9681;
    private int multiplier;
    private final Random random = new Random();
    private Map<String, Double> symbolValues;

  public Cassino() {
    symbolValues = new HashMap<>();
    symbolValues.put("Gato", 0.1); // Example values, adjust as needed
    symbolValues.put("Coelho", 0.3);
    symbolValues.put("Moeda", 0.4);
    symbolValues.put("Amuleto", 0.2);
}
   
    //method for generate random numbers
    public double generateRandomNumber() {
        return random.nextDouble() * 1 ;
    }

    //method for generate simbols
    public String generateRandomSymbol() {
        double random_Number = generateRandomNumber();
        double amount = 0;
        for (int i = 0; i <= 3; i++) {
            amount = amount + simbolProbality[i];

            if (random_Number < amount) {
                return simbols[i];
            }
        }

        return null;
    }
    //method for verify payment line

    public boolean verifyLinePayment(int[] row) {
        return row[0] == row[1] && row[1] == row[2];
    }

    public String[] generateRolls() {
        rolls = new String[3]; // Initialize rolls as String[]
        for (int i = 0; i < rolls.length; i++) {
            rolls[i] = generateRandomSymbol(); // Assign symbols directly
        }
        return rolls;
    }

    public void play(double bet) {
        balance -= bet;
        rolls = generateRolls();
        double wins = 0;
        multiplier = 1;

        for (int i=0;i <4; i++) {
            if (verifyLinePayment(paymentLines[i])) {
                wins += bet * symbolValues.get(rolls[paymentLines[i][0]]); // Use symbolValues map
            }
        }

        if (generateRandomNumber() < 0.1) {
            multiplier = (int) (generateRandomNumber() * 10);
            wins *= multiplier;
        }

        balance += wins;
        System.out.println("Rolls: " + Arrays.toString(rolls));
        System.out.println("Wins: R$ " + wins);
        System.out.println("Balance: R$ " + balance);
    }

    public double valueSymbols(String [] symbols) { // Now takes a String
        return symbolValues.get(symbols); // Returns the value from the map
    }
//getters e setters
    public String[] getRolls() {
        return rolls;
    }

    public void setRolls(String[] rolls) {
        this.rolls = rolls;
    }

    public double[] getSimbolProbality() {
        return simbolProbality;
    }

    public void setSimbolProbality(double[] simbolProbality) {
        this.simbolProbality = simbolProbality;
    }

    public String[] getSimbols() {
        return simbols;
    }

    public void setSimbols(String[] simbols) {
        this.simbols = simbols;
    }

    public int[][] getPaymentLines() {
        return paymentLines;
    }

    public void setPaymentLines(int[][] paymentLines) {
        this.paymentLines = paymentLines;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBet() {
        return bet;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public double getRTP() {
        return RTP;
    }

    public void setRTP(double RTP) {
        this.RTP = RTP;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiply(int multiplier) {
        this.multiplier = multiplier;
    }

    public Map<String, Double> getSymbolValues() {
        return symbolValues;
    }

    public void setSymbolValues(Map<String, Double> symbolValues) {
        this.symbolValues = symbolValues;
    }

	

}
