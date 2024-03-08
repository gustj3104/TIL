'''점수 중 최대값 = M
모든 점수를 (점수)/M*100으로 고침
평균 출력하기

N입력받기 #과목 수
a를 리스트로 입력받아서 분할 #시험 점수

m = max(a) #최대점수
for i in a
i=i/m*100
b.append(i) #새로운 리스트
print(mean(b))
'''
n=int(input())
a=list(map(int, input().split()))
b=[]
sum=0
m=max(a)
for i in a:
    i=i/m*100
    b.append(i)
for i in b:
    sum+=i
t=sum/len(b)
print(t)