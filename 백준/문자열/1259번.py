'''팰린드롬 검사 // 종료 조건은 0입력
while True:
a=input()
if a가 0이면 break
if a의 reverse와 a가 같으면 yes 출력
아니면 no출력
'''
while True:
    a=input()
    if a == '0':
        break
    b=a[::-1]
    if a == b:
        print("yes")
    else:
        print("no")

        