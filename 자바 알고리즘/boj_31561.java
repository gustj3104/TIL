import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_31561 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        float minute = Float.parseFloat(br.readLine());
        float realM = 0;

        if (minute >= 30) { // 15분 이상인 경우
            realM += 15;
            minute -= 30; // 15분 이후의 시간 계산해서 더해줌
            realM = realM + minute * ((float) 3 / 2);
        } else {
            realM = minute / 2;
        }

        System.out.printf("%.1f", realM);

    }
}

/*
매시간 정각 분침 : 12시 방향
매시간 정각 ~ 15분 분침 : 원래의 2배 = 6시방향
 => 매시간 15분 분침 : 6시 방향
 매시간 15분 ~ 다음 시간 정각 분침 : 원래의 2/3배
  => 매시간 45분 분침 : 6시 -> 12시 방향

변환한게 30분을 넘는다 -> real time이 15분 이상
real time * 2 = M
real time = M / 2

real time += 15
M -= 30
real time = M *(3/2)
 */