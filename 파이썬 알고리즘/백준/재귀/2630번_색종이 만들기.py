import sys
input = sys.stdin.readline
field = list()

def count(r, c, size):
    global white_count, blue_count
    initial = field[r][c] #현재 색 저장
    same_color = True 

    for i in range(r, r + size):
        for j in range(c, c + size):
            # 색 검사
            if field[i][j] != initial: # 현재 색과 달라지면 False로 전환
                same_color = False
                break
        if not same_color:
            break
        
    if same_color:
        if initial == '0':
            white_count += 1
        else:
            blue_count += 1
    
    else:
        half = size // 2
        # 네 부분으로 나눠서 재귀 호출
        count(r, c, half) # 1사분면
        count(r, c + half, half) # 2사분면
        count(r + half, c, half) # 3사분면
        count(r + half, c + half, half) # 4사분면


n = int(input())
for _ in range(n):
    field.append(input().split())

white_count = 0
blue_count = 0
count(0, 0, n)

print(white_count)
print(blue_count)