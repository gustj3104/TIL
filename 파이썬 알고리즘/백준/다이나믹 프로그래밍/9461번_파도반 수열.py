'''
첫 삼각형의 변 = 1 -> 나선에서 가장 긴 변 = k이면 변의 길이가 k인 정삼각형 추가
P(1)~P(10) = 1 1 1 2 2 3 4 5 7 9 ...
N일 때 P(N) 구하기
'''
import sys
input = sys.stdin.readline

def dynamic(n):
    if n == 1:
        return 1
    elif n == 2:
        return 1
    elif n == 3:
        return 1
    
    dp = [0] * (n+1)
    dp[1], dp[2], dp[3] = 1, 1, 1

    for i in range(4, n + 1):
        dp[i] = dp[i-2] + dp[i-3]

    return dp[n]

#메인
t = int(input()) #테스트 케이스 
for _ in range(t):
    n = int(input())
    print(dynamic(n))