# 7:00부터 19:00 은 1분에 10원
# 19:00부터 7:00 은 1분에 5원
import sys
input = sys.stdin.readline

n = int(input())

total = 0  # 총 전화 요금
for _ in range(n):
    time, count = input().split()
    count = int(count)
    hour, minute = map(int, time.split(":"))

    while count > 0:
        if 7 <= hour < 19:  # 낮 요금
            if minute + count > 60:  # 현재 시간대에서 남은 분 초과
                remaining_minutes = 60 - minute
                total += remaining_minutes * 10
                count -= remaining_minutes
                hour += 1
                minute = 0
            else:
                total += count * 10
                break
        else:  # 밤 요금
            if minute + count > 60:  # 현재 시간대에서 남은 분 초과
                remaining_minutes = 60 - minute5
                
                total += remaining_minutes * 5
                count -= remaining_minutes
                hour += 1
                minute = 0
            else:
                total += count * 5
                break

        # 시간대 변경 처리
        if hour == 24:
            hour = 0

print(total)
