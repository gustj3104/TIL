n = int(input())
students = [list(map(int, input().split())) for _ in range(n)]

max_count = 0
leader = 0

for i in range(n):
    count = 0
    for j in range(n):
        if i == j:
            continue
        for grade in range(5):
            if students[i][grade] == students[j][grade]:
                count += 1
                break
    if count > max_count or (count == max_count and i < leader):
        max_count = count
        leader = i

print(leader + 1)