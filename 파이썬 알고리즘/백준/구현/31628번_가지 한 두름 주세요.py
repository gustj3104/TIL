''' 
가로 한 줄이 모두 같은 경우 -> len(set(field[i])) == 1
세로 한 줄이 모두 같은 경우 field[i][0]

field = []
flag = 0

for _ in range(10):
    s = list(input().split())
    if len(set(s)) == 1:
        flag = 1
    field.append(s)

# 가로 세로 뒤집기
field2 = list(map(list, zip(*field)))
for i in field2:
    if len(set(i)) == 1:
        flag = 1
        break

print(flag)
'''

field = [input().split() for _ in range(10)]

# any = 각 줄에서 set()이 1인 것(모든 요소가 같은 경우)가 한 번이라도 있으면 True 반환
row_check = any(len(set(row)) == 1 for row in field)

# zip = field[i](가로)를 세로로 변환
col_check = any(len(set(col)) == 1 for col in zip(*field))

print(1 if row_check or col_check else 0)