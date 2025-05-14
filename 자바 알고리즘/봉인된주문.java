import java.util.TreeSet;

public class 봉인된주문 {
    public String solution(long n, String[] bans) {
        TreeSet<Long> banSet = new TreeSet<>();

        // 1. 길이별 합 배열 생성
        long[] Grade = new long[12];
        long[] GradeSum = new long[12];

        Grade[0] = 1;
        GradeSum[0] = 0;
        for (int i = 1; i < 12; i++) {
            Grade[i] = Grade[i - 1] * 26;
            GradeSum[i] = GradeSum[i - 1] + Grade[i];
        }

        // 2. bans -> index 변환
        for (String s : bans) {
            long b = toIndex(s);
            banSet.add(b);
        }

        // 3. bans를 제외한 유효 단어에서 n 위치 찾기 (이진 탐색)
        long left = 0; long right = (long) 1e18;
        long answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long bannedBefore = banSet.headSet(mid + 1).size();
            long validCount = mid - bannedBefore + 1;

            if (validCount >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            return toString(answer);
        }



    }

    // 4. ban -> index로 변환
    private static long toIndex(String s){
        long index = 0;
        for (int i = 0; i < s.length(); i++) {
            index = 26 * i + (s.charAt(i) - 'a');
        }

        return index + GradeSum[s.length() - 1];
    }

    // 4. n -> String으로 변환
    private static String toString(long index){
        int len = 0;
        while (index >= GradeSum[len]) len++;
        index -= GradeSum[len - 1];

        char[] chars = new char[len];
        for (int i = len - 1; i >= 0; i--) {
            chars[i] = (char) ('a' + (int)(index % 26));
            index /= 26;
        }

        return new String(chars);
    }
}
