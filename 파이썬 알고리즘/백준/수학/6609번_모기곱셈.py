import sys

for line in sys.stdin:
    m, p, l, e, r, s, n = map(int, line.split())

    for _ in range(n):
        # 이번 주 성충이 낳은 알의 수
        new_eggs = m * e
        # 이번 주 성충 수
        m = p // s
        # 이번 주 번데기 수
        p = l // r
        # 이번 주 유충 수
        l = new_eggs

    print(m)
