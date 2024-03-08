'''알파벳 소문자로 이루어진 N개의 단어를 길이가 짧은 것부터(사전순으로)나열하기 // 중복된 단어는 한 개만 남기고 제거'''
'''
단어 수 N 입력받기
for N
단어를 입력받기
리스트에 넣기

set으로 리스트 중복 제거

리스트 정렬(key=len)
//sort의 key값으로 기준 주는거
//출력 형식 좀 제발 잘 확인하자^^ 1트할 거 2트한다..

'''

N=int(input())
a=[]

for i in range(N):
    word=input()
    a.append(word)

a=list(set(a))
a.sort()
a.sort(key=len)

for i in a:
    print(i)