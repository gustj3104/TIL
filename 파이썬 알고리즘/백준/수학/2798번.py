'''
카드 합이 21이 넘지 않는 한도 내에서 카드의 합을 최대한 크게 만드는 게임
N장의 카드 / N장 중 3장 선택 
고른 카드의 합이 M을 넘지 않게 M과 가까운 수를 만들어야 됨.

combination 라이브러리
combinations(반복 가능한 객체, n) //n = 몇 개를 뽑을지
'''
from itertools import combinations

card_num, target = map(int, input().split())
card_set = list(map(int,input().split()))
max_num = 0

for cards in combinations(card_set, 3):
    temp_sum = sum(cards)
    if max_num < temp_sum <= target:
        max_num = temp_sum

print(max_num)