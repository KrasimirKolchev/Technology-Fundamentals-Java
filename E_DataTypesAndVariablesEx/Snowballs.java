package E_DataTypesAndVariablesEx;

        import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long snowballValueOut = 0;
        int snowballSnowOut = 0;
        int snowballTimeOut = 0;
        int snowballQualityOut = 0;

        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            double snowballValue = (Math.pow((snowballSnow / (double)snowballTime), snowballQuality));

            if (snowballValue >= snowballValueOut) {
                snowballValueOut = (long)snowballValue;
                snowballSnowOut = snowballSnow;
                snowballQualityOut = snowballQuality;
                snowballTimeOut = snowballTime;
            }
        }
        System.out.printf("%d : %d = %d (%d)",
                snowballSnowOut, snowballTimeOut, snowballValueOut, snowballQualityOut);
    }
}
