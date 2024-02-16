'''주어진 문자열의 첫 글자와 마지막 글자 출력'''
T=int(input())
for i in range(T):
    a=input()
    b=len(a)-1
    print(a[0]+a[b])