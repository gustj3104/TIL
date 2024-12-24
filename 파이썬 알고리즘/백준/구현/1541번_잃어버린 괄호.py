import sys
input = sys.stdin.readline
s = input().strip()  # 입력에서 공백 제거

num = []  # 숫자 리스트
op = []   # 연산자 리스트
n = ""    # 현재 숫자를 저장하는 문자열

for i in range(len(s)):
    if s[i] == '-' or s[i] == '+':  
        num.append(int(n))          
        op.append(s[i])             
        n = ""                      
    else:
        n += s[i]                   

# 마지막 숫자 추가
if n:
    num.append(int(n))

result = num[0]  # 첫 숫자를 초기값으로 설정
subtracting = False  # '-' 이후로 모든 숫자를 뺄지 여부

for i in range(len(op)):
    if op[i] == '-':
        subtracting = True  # '-'를 만나면 이후 숫자 모두 뺌
    if subtracting:
        result -= num[i + 1]
    else:
        result += num[i + 1]

print(result)
