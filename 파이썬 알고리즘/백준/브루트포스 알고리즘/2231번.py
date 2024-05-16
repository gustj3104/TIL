'''
N의 분해합: N+N의 각 자리수의 합
M의 분해합이 N인 경우, M을 N의 생성자라 함.
245의 분해합 = 245 + 2 + 4 + 5 = 256
256의 생성자는 245
'''
def breaksum(num):
    numList=list(map(int, str(num)))
    result = num

    for i in range(len(numList)):
        result += int(numList[i])

    return result

createnum = int(input())
found=False
for i in range(createnum):
    n = breaksum(i)
    if n == createnum:
        print(i)
        found = True
        break

if not found:
    print(0)