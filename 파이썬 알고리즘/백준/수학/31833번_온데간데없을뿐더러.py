n = int(input())  # 정수의 개수
X = input().split()
Y = input().split()

X_total = ""
Y_total = ""

for x in X:
    X_total += x

for y in Y:
    Y_total += y

if int(X_total) <= int(Y_total):
    print(int(X_total))
else:
    print(int(Y_total))
