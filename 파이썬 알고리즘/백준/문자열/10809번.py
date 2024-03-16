'''입력된 단어의 각각의 알파벳에 대하여 포함되어 있는 경우 위치를, 포함되어 있지 않은 경우에는 -1을 출력하기'''
s=list(input().lower())
cnt=[]
alpha='abcdefghijklmnopqrstuvwxyz'

for i in range(len(alpha)):
    if alpha[i] in s:
        cnt.append(s.index(alpha[i]))
    elif alpha[i] not in s:
        cnt.append(-1)
print(*cnt)