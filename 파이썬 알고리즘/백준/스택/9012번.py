'''
제대로 괄호쌍이 맺어져있는지 판단해서 NO, YES 출력
'''

import sys

n = int(input())
for _ in range(n):
    vps=[]
    sen=[]
    sen = list(sys.stdin.readline())
    for i in range(len(sen)):
        if sen[i] == '(':
            vps.append(sen[i])
        elif sen[i] ==')':
            if len(vps) == 0:
                vps.append(sen[i])
                break
            elif vps[-1] == '(':
                vps.pop()

        
    if len(vps) == 0:
        print("YES")
    else:
        print("NO")
       
        

