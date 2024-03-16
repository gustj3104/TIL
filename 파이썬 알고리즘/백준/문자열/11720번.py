'''N개의 숫자가 공백없이 쓰여있다. 모두 합해서 출력하기'''
n=int(input())
a=[]
s=0
num=input()
for i in str(num):
    a.append(i)
for i in a:
    s=s+int(i)
print(s)