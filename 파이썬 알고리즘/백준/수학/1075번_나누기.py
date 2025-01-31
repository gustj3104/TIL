import sys
input = sys.stdin.readline

n = int(input().strip())
f = int(input().strip())

n = (n // 100) * 100 # 뒤 두 자리를 00으로 바꾸기

for i in range(100):
    if (n + i) % f == 0:
        print(f"{i:02d}")
        break

