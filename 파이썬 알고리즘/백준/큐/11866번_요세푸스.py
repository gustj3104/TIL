'''
1번~N번까지 원을 이루며 앉고 K번째 사람 제거 -> 모두 제거될 때까지
'''
from collections import deque

n, k = map(int, input().split())
people = deque(range(1, n+1))
result=[]
while people:
    people.rotate(-(k-1))
    result.append(people.popleft())

formatted_result = '<' + ', '.join(map(str, result)) + '>'
print(formatted_result)



