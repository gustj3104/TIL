import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
count = 0

for _ in range(n):
    group_word = defaultdict(int)
    word = list(input())
    flag = word[0]
    for i in word:
        if group_word[i] >= 1 and i != flag:
            count -= 1
            break
        else:
            group_word[i] += 1
        flag = i 
    count += 1

print(count)