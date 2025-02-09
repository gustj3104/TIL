l, p = map(int, input().split()) # l: 1m^2당 사람의 수, p: 장소의 넓이
people = l * p

people_list = list(map(int, input().split()))
result = []
for p in people_list:
    result.append((p - people))

print(" ".join(map(str, result)))