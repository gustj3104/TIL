'''
연계 기술 : 사전 기술 + 본 기술을 순서대로 사용 
- 사전 없이 본 기술 -> 오류
- 사전 이후 다른 기술은 가능

- L(사전) -> R(본), S(사전) -> K(본)
- 1 ~ 9는 연계없이 사용하는 기술

몇 번이나 정상적으로 발동하나

입력을 받아서 리스트로 저장
순회하면서 사전이 나오면 FLAG = TRUE
본 기술이 나왔는데 FLAG가 FALSE이면 종료
    FLAG가 TRUE이면 TOTAL + 2
    FLAG 다시 FALSE로
숫자가 나오면 TOTAL + 1
'''
import sys
input = sys.stdin.readline

n = int(input())
skill = list(input().strip())
used_list = []
num = 0

for s in skill:
    # print("start", s)
    if s == "R" : # 본 기술이 나온 경우
        if 'L' in used_list: #사전 기술이 없는 경우
            used_list.remove('L')
            num += 1
        else: 
            break
    elif s == "K":
        if 'S' in used_list: #사전 기술이 없는 경우
            used_list.remove('S')
            num += 1
        else: 
            break
    elif s == "L" or s == "S" :
        used_list.append(s)
    else:
        num += 1

print(num)