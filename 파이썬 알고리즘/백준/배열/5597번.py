'''학생 30명 중 과제 제출을 안 한 2명의 출석 번호 구하기'''

a=[]
for i in range(1, 31):
    a.append(i)
for i in range(28):
    s=int(input())
    if s in a:
        a.remove(s)
if a[0]<a[1]:
    print(a[0])
    print(a[1])
else:
    print(a[1])
    print(a[0])



