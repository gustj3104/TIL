'''
1일 1처리
일 처리 후 중요도 -M
중요도 <= K -> 완료로 간주

만족감 (첫 날은 0)
전날 만족감 = Y
할 일의 중요도 = P
만족감= [Y/2] + P

할 일 개수, 중요도, 중요도 최대값(K) -> 입력
일마다 중요도 -> Di 입력

걸린 일 수, 일별 만족감 출력
''' 

n, m, k = map(int, input().split())
work=[]
day = 0
result_s = []
s = 0


for _ in range(n):
    c = int(input())
    work.append(c)

while work:
    a = work.pop()
    while True:
        day += 1
        result_s.append(a)
        a = a-m

        if a<=k:
            break
            
    if not work:
        break

print(day)
result_s.sort(reverse=True)
for i in result_s:
    s = (s//2) + i
    print(s)
    

