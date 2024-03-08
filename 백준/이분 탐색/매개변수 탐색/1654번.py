'''N개의 램프 만들기
자체적으로 K개의 램프를 가지고 있음 --> 랜선 길이가 다름
300cm짜리 랜선에서 140cm짜리 랜선으로 자르면 랜선이 2개 있고, 20cm는 버림 // K <= N
항상 정수 단위로 자름. 만들 수 있는 최대 랜선의 길이 구하기 

#4개의 랜선을 잘라서 11개를 만들 때 만들 수 있는 최대 랜선의 길이

K, N입력받기 #K는 가지고 있는 랜선, N은 필요한 랜선 수

for K #가지고 있는 랜선들의 길이 입력받기 -> 리스트에 추가
for a in 1~100000
if total == N: break #total은 자른 랜선 수
    for b in K
        while b-a > 0 #b는 가지고 있던 랜선 길이, a는 자를 길이
            t=(b-a) #t는 K 중 자르고 남은 랜선 길이
            total+=1
lan.append(a)
print(max(len))
'''
k, n=map(int, input().split())
k_list=[] #가지고 있는 랜선 K의 리스트
total=0 #K를 잘라서 만든 랜선 수
t=0 #자르고 남은 랜선의 길이
a=0 #자르는 랜선 길이

for i in range(k):
    m=int(input())
    k_list.append(m)

start=1
end=int(max(k_list))


while start<=end:
    mid=(start+end)//2
    total=0
    for lan in k_list:
        total+=lan//mid
    if total >=n:
        start=mid+1
    else:
        end=mid-1
print(end)
