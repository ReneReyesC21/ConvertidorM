import java.util.Scanner;

public class ConvertidorM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Bienvenido al Convertidor de Monedas");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Convertir de USD a EUR");
            System.out.println("2. Convertir de USD a MXN");
            System.out.println("3. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convertirMoneda("USD", "EUR");
                    break;
                case 2:
                    convertirMoneda("USD", "MXN");
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 3.");
            }
            System.out.println();
        } while (opcion != 3);

        scanner.close();
    }

    private static void convertirMoneda(String fromCurrency, String toCurrency) {
        double tasaDeCambio = ExchangeRateAPI.getExchangeRate(fromCurrency, toCurrency);
        if (tasaDeCambio != -1) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la cantidad en " + fromCurrency + ": ");
            double cantidad = scanner.nextDouble();
            double cantidadConvertida = cantidad * tasaDeCambio;
            System.out.println(cantidad + " " + fromCurrency + " son " + cantidadConvertida + " " + toCurrency);
        } else {
            System.out.println("Error al obtener la tasa de conversión.");
        }
    }
}
