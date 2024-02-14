'''두 정수 A, B를 입력받고 A+B출력하기'''

while True:
    try:
        A, B=map(int, input().split())
        print(A+B)
    except:
        break