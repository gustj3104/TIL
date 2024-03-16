'''소수 찾기

소수 판별 함수

for 문으로 소수만 출력
'''

def isPrimeNumber(a):
    if a<2:
        return False
    for m in range(2, int(a**0.5)+1):
        if a%m==0:
            return False
    return True


primes=[]
result=0
n=int(input())
m=list(map(int, input().split()))
b=m[-1]
for i in m:
    if isPrimeNumber(i):
        result+=1
print(result)

