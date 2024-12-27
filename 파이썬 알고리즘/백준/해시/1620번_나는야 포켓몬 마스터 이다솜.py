import sys
input = sys.stdin.read
output = sys.stdout.write

def solve():
    data = input().splitlines()
    n, m = map(int, data[0].split())
    
    monster_list = []  # 번호 → 이름 매핑
    name_to_index = {}  # 이름 → 번호 매핑
    
    # 포켓몬 도감 데이터 처리
    for i in range(1, n + 1):
        name = data[i]
        monster_list.append(name)
        name_to_index[name] = i  

    # 문제 처리
    results = []
    for i in range(n + 1, n + 1 + m):
        query = data[i]
        if query.isdigit():  # 숫자 입력
            results.append(monster_list[int(query) - 1])  # 번호 → 이름
        else:  # 문자열 입력
            results.append(str(name_to_index[query]))  # 이름 → 번호
    
    # 출력
    output("\n".join(results) + "\n")

solve()
