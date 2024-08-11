'''
V미터인 나무를 오르는데 낮엔 A미터 ++, 밤엔 B미터 --, 정상에 오른 후엔 미끄러지지 않음.
'''
import math
a, b, v = map(int,input().split())
day = math.ceil((v-a)/(a-b))+1
print(day)