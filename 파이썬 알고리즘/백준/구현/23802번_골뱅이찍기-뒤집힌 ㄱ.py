# ㄱ자 모양은 가로 및 세로로 각각 5개의 셀로 구성
# 상자에는 정사각형 모양의 셀의 크기를 나타내는 숫자 하나

n = int(input())
print_string = "@" * 5

for _ in range(n):
    print(print_string * n)


for _ in range(n*5-n):
    print("@" * n)