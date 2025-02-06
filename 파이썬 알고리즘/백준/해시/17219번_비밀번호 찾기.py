import sys
input = sys.stdin.readline

# N: 저장된 사이트 주소의 수 / M: 비밀번호를 찾으려는 사이트 주소의 수
n, m = map(int, input().split())

site_list = {}
for _ in range(n):
    site, password = input().split()
    site_list[site] = (password)

for _ in range(m):
    site = input().strip()
    print(site_list[site])