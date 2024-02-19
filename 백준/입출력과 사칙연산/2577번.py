'''a*b*c의 계산 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지 구하기'''
a=int(input())
b=int(input())
c=int(input())

d=a*b*c
d_list=list(str(d))
print(d_list)