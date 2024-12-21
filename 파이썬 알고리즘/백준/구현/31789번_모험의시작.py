n = int(input())  # 무기 수
x, s = map(int, input().split())  # x: 돈, s: 후안 공격력

can_defeat = False  # 후안을 이길 수 있는 무기가 있는지 여부
for _ in range(n):
    c, p = map(int, input().split())  # c: 무기 가격, p: 무기 공격력
    if c <= x and p > s:  # 구매 가능하고 공격력이 후안보다 높은 경우
        can_defeat = True
        break  # 무기가 하나라도 있으면 YES이므로 종료

if can_defeat:
    print("YES")
else:
    print("NO")
