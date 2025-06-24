import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class boj_7662 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int k = Integer.parseInt(br.readLine());
      TreeMap<Integer, Integer> map = new TreeMap<>();

      for (int j = 0; j < k; j++) {
        String[] s = br.readLine().split(" ");
        int num = Integer.parseInt(s[1]);
        if (s[0].equals("I")) {
          map.put(num, map.getOrDefault(num, 0) + 1);
        } else if (s[0].equals("D") && !map.isEmpty()) {
          int key = (num == 1) ? map.lastKey() : map.firstKey();
          if (map.get(key) == 1) {
            map.remove(key);
          } else {
            map.put(key, map.get(key) - 1);
          }
        }
      }

        if (map.isEmpty()) {
          System.out.println("EMPTY");
        } else {
          System.out.println(map.lastKey() + " " + map.firstKey());
        }
    }
  }
}
