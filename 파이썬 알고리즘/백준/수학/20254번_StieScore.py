# Ur: 지역 대회의 대학 수
# Tr: 지역 대회의 팀 수
# Uo: TOPC의 대학 수
# To TOPC의 팀 수

# 사이트 점수 = 56Ur + 24Tr + 14Uo + 6To
import sys
input = sys.stdin.readline

ur, tr, uo, to = map(int, input().split())
print(56*ur + 24*tr + 14*uo + 6*to)