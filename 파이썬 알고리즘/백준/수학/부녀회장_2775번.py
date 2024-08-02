from functools import lru_cache
#함수 결과를 캐싱하여 동일 인자로 호출될 때마다 계산을 반복하지 않고, 캐시값 사용 -> 함수 중복 호출 감소

@lru_cache(maxsize=None)
def peoplecnt(k, n):
    if k == 0:
        return n
    else:
        total = 0
        for i in range(1, n + 1):
            total += peoplecnt(k - 1, i)
        return total

t = int(input())
for _ in range(t):
    k = int(input())
    n = int(input())
    print(peoplecnt(k, n))
