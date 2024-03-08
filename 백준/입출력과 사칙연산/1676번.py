'''N!에서 뒤에서부터 처음이 0이 아닌숫자가 나올 때까지 0의 개수를 구하는 프로그램을 구하시오'''

def fac(a):
    sum=1
    for i in range(1, a+1):
        sum=sum*int(i)
    return sum

b=int(input())
result=list(str(fac(b)))
result=result[::-1]
cnt=0
for i in result:
    cnt+=1
    if i != '0':
        print(cnt-1)
        break