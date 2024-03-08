'''종말의 수=666이 3개 이상 연속으로 들어가는 수
제일 작은 종말의 수 666, 다음은 1666, 2666 --
N번째 종말의 수는?

N 입력받기
k=int('666')
for 1~1000000
if i가 k를 포함하고 있다면 
리스트에 포함시키기
print(list[N+1])
'''

n=int(input())
num=[]

k=666
for i in range(100000000000):
    if str(k) in str(i):
        num.append(i)
        if len(num) == n:
            print(num[n-1])
            break


