t = int(input())
a_player = 100
b_player = 100
for _ in range(t):
    a, b = map(int, input().split())
    if a > b :
        b_player -= a
    elif a < b:
        a_player -= b
    else:
        continue

print(a_player)
print(b_player)