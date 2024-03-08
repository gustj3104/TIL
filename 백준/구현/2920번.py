'''c, d, e, f, g, a, b, C를 1~8까지의 숫자로 바꾸기
1부터 8까지 차례대로 연주 -> ascending
8부터 1까지 차례대로 연주 -> descending
둘 다 아니면 mixed'''
a=list(map(int, input().split()))
b=[1, 2, 3, 4, 5, 6, 7, 8]
if a == b:
    print("ascending")
elif a == sorted(b, reverse=True):
    print("descending")
else:
    print("mixed")

