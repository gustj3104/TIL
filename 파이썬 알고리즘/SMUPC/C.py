'''
A-Z=1-26
알파벳 사이 거리 = 번호의 차이

M자리 비밀번호를 만들 때 경우의 수 구하기

규칙
- 2 <= i <= M에 대해 i-1 ~ i 사이의 거리가 N 이상
- 알파벳은 대문자, 중복 사용 가능
'''

def toNum(a):
    return ord(a)-64

def fdistance(a, b):

    if (ord(a)-64) - (ord(b)-64) >= 0:
        return (ord(a)-64) - (ord(b)-64)
    else:  
        return (ord(b)-64) - (ord(a)-64)

alpha=['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
n, m = map(int, input().split())
result = []
word=""

for i in alpha:
    word = i
    while True:
        for j in alpha:
            if fdistance(word[-1], j) >= n:
                word += j

        if len(word) == m :
            if word in result:
                break
            else:
                result.append(word)
                word=word[0]
                print(result)
            
            

