import java.io.*;
public class CurrencyCalculation {

	public static void main(String[] args) {
		String temp = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("How many euros are you exchanging?");
			temp = br.readLine();
			double euros = Double.parseDouble(temp);
			System.out.println("What is the exchange rate?");
			temp = br.readLine();
			double rate = Double.parseDouble(temp);
			double dollars = euros * rate / 100;
			System.out.println(String.format("%.2f euros at an exchange rate of %.2f is %.2f U.S. dollars.", euros, rate, dollars));
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
