import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ExchangeRateAPI {

    private static final String API_KEY = "5738beaccfcdcf43de783378"; // Reemplaza con tu clave de API válida
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    public static double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            String urlString = API_URL + fromCurrency + "/" + toCurrency;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();

            JSONObject json = new JSONObject(content.toString());
            return json.getDouble("conversion_rate");
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
