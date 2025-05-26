import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int u = 1;
        while (true) {
            int cm = Integer.parseInt(br.readLine().trim());

            if (cm == 0) {
                break;
            }

            int n = Integer.parseInt(br.readLine().trim());

            System.out.println("User " + u);

            for (int i = 0; i < n; i++) {
                int walk = Integer.parseInt(br.readLine().trim());
                double km = (walk * cm) / 100000.0;
                System.out.printf("%.5f\n", km);
            }

            u++;
        }
    }
}
