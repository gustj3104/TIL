'''9개의 서로 다른 자연수가 주어질 때, 최댓값을 찾고, 몇 번째 수인지 구하기'''
a=[]
for i in range(9):
    b=int(input())
    a.append(b)
c=max(a)
for i in range(len(a)):
    if a[i]==c:
        print(c)
        print(i+1)