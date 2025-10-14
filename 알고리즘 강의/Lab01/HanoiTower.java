package Lab01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HanoiTower {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Hanoi(n, "A", "B", "C");
        }
    }

    public static void Hanoi(int i, String start, String mid, String dest) {
        if (i == 1) {
            System.out.println(start + " " + dest + " " + i);
        } else {
            Hanoi(i - 1, start, dest, mid);
            System.out.println(start + " " + dest + " " + i );
            Hanoi(i - 1, mid, start, dest);
        }
    }
}
