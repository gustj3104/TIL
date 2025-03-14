import sys
input = sys.stdin.readline

n = int(input()) # 조사한 시간 
m = int(input()) # 조사 시작 차량 수
car_record = [m]

for i in range(n):
    # i분 경과할 때까지 입구에 통과한 차, 출구를 통과한 차
    in_car, out_car = map(int, input().split()) 
    m = m + in_car - out_car
    car_record.append(m)
    
if min(car_record) < 0:
    print(0)
else:
    print(max(car_record))