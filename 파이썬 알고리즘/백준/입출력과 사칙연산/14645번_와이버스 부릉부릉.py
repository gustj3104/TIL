n, k = map(int, input().split()) #N: 출발, 종착역 제외 정거장 수, k: 출발역에서 탑승한 사람 수
for _ in range(n):
    a, b = map(int, input().split()) #승차, 하차 인원
    k = k + a - b