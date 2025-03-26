start_y, start_m, start_d = map(int, input().split())
end_y, end_m, end_d = map(int, input().split())

# 1000년 이상 지속 여부 확인
if (end_y > start_y + 1000) or (end_y == start_y + 1000 and (end_m > start_m or (end_m == start_m and end_d >= start_d))):
    print("gg")
    exit(0)

# 윤년 판별 함수
def is_leap_year(year):
    return (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0)

# 월별 일수 설정
days_in_month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

def days_since_year_start(y, m, d):
    days = sum(days_in_month[:m - 1]) + d
    if m > 2 and is_leap_year(y):
        days += 1  # 윤년 2월 보정
    return days

# 전체 일수 계산
total_days = 0
for year in range(start_y, end_y):
    total_days += 366 if is_leap_year(year) else 365

total_days += days_since_year_start(end_y, end_m, end_d) - days_since_year_start(start_y, start_m, start_d)

print(f"D-{total_days}")
'''
from datetime import date
start_y, start_m, start_d = map(int, input().split())
end_y, end_m, end_d = map(int, input().split())

y = end_y - start_y
if y >= 1000:
    print("gg")
    exit(0)

start_date = date(start_y, start_m, start_d)
end_date = date(end_y, end_m, end_d)
days = (end_date - start_date).days

print(f"D-{days}")'
'''