'''
한 번 입었던 옷의 조합을 다신 입지 않음 
알몸이 아닌 상태로 다닐 수 있는 일 수

한 번에 같은 종류는 하나만, 

'''
import sys
input = sys.stdin.readline


def count_cloth(cloth):
    count = 1
    for category in cloth:
        count *= (len(cloth[category]) + 1)

    return count - 1

t = int(input()) # 테스트 케이스
for _ in range(t):
    cloth = {}
    n = int(input()) #의상 수
    for _ in range(n):
        name, category = map(str, input().strip().split())
        if category not in cloth:
            cloth[category] = []
        cloth[category].append(name)

    print(count_cloth(cloth))