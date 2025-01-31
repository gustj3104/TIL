import sys
input = sys.stdin.readline

n = int(input())  # 파일 개수
file = []

for _ in range(n):
    f = list(input().strip())
    file.append(f)

standard = file[0]
final = list(standard)

for i in range(1, n):
    for f in range(len(standard)):
        if file[i][f] != standard[f]:
            final[f] = "?"

print("".join(final))