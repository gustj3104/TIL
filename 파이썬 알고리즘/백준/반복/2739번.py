'''N을 입력받은 뒤 구구단 N단까지 출력'''

N=int(input())

for m in range(1, 10):
    print(N, "*", m, "=", int(N*m))