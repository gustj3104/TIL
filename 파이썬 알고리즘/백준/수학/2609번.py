'''
최대공약수, 최소공배수
최소공배수 - 두 수에 서로 공통으로 존재하는 배수 중 가장 작은 수
[for문]
def lcm(a,b):
    for i in range(max(a,b), (a*b)+1):
        if i%a == 0 and i%b == 0:
            return i

[gcd 활용]
def lcm(a, b):
    return a*b/gcd(a,b)

[math 라이브러리]
import math
math.lcm(a, b)

최소공배수 - 두 수가 서로 공통으로 가지고 있는 약수 중 가장 큰 수
[기본 for문 사용]
def gcd(a, b):
    for i in range(min(a, b), 0, -1):
        if a%i == 0 and b%i == 0:
            return i

[유클리드 호재법]
def gcd(a, b):
    while b>0:
        a,b = b,a%b
    return a

def gcd(a, b):
    if a%b == 0:
        return b
    elif b == 0:
        return a
    else:
        return gcd(b, a%b)

[math 사용]
import math
a, b = 10, 15
math.gcd(a,b)
'''
import math

a, b = map(int, input().split())

print(math.gcd(a, b))
print(math.lcm(a, b))