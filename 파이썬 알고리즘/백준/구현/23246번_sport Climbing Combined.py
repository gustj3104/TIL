'''
 순위는 세 종목의 종합 점수를 곱함
 곱한 점수가 낮으면 순위가 앞섬
 곱한 점수가 같으면 합산 점수가 낮은 선수가 앞섬
 두 점수가 같으면 등번호가 낮은 선수가 앞섬

 금, 은, 동 정하는 프로그램
'''
import sys
input = sys.stdin.readline

score = list()
n = int(input()) # 선수 명수
for i in range(n):
    b, p, q, r = map(int, input().split()) #등번호/ 세 종목 등 수
    player_score = p * q * r
    total_score = p + q + r
    score.append([b, player_score, total_score])

score.sort(key=lambda x : (x[1], x[2], x[0]))
print(score[0][0], score[1][0], score[2][0])