#이항계수 bc = n!/((n-k)!*k!)
import math
n, k = map(int, input().split())

bc = math.factorial(n)//(math.factorial(n-k)*math.factorial(k))
print(bc)
