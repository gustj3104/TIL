'''
시작 시간, 필요한 시간 -> 끝나는 시각 계산하기
'''
#시작 시간
h, m, s = map(int, input().split())

# 필요한 시간
time = int(input())

m += (s+time) // 60
s = (s+time) % 60
h += (m) // 60
m = m % 60
h = h % 24

print(h, m, s)