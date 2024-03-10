'''M이상 N이하 소수 출력하기'''
# import sys

# m, n=map(int, sys.stdin.readline().split())
# num=list(range(m, n+1)) #소수를 저장할 리스트
# prime_num=[2]

# for p in prime_num:
#     for a in num[:]:
#         if a%p == 0:
#             num.remove(a)
#     if num:
#         prime_num.append(num[0])
#         print(num[0])
#     else:
#         break
# for i in num:
#     print(i)

import sys

def prime_al(n):
    primes = [True] * (n + 1) # primes 리스트 생성 -> n까지의 수를 True로 정의
    primes[0] = primes[1] = False # 0, 1은 소수 아님
    
    for i in range(2, int(n ** 0.5) + 1): # 2부터 n의 제곱근까지 반복
        if primes[i]: # primes의 요소가 True일 때만 실행 == 소수일때만 실행됨
            for j in range(i * i, n + 1, i): # i의 배수들은 모두 소수가 아님
                primes[j] = False

    return [i for i in range(2, n + 1) if primes[i]] # if -> True인 값만 리스트에 포함시킴 == 소수만 리스트에 포함시킴 // 조건을 만족하는 i값만 리스트에 추가
            
m, n = map(int, sys.stdin.readline().strip().split())
primes = prime_al(n)
for prime in primes:
    if prime >= m:
        print(prime)


        