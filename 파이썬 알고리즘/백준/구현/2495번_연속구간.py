def inspect_list(s):
    flag = False
    count = []  # 구간 길이

    for i in range(len(s)):
        if i + 1 < len(s):
            if s[i + 1] == s[i]:  # 다음 값과 현재 값이 같으면
                if not flag:  # 새로운 연속 구간 시작
                    count.append(1)  # 구간 길이 초기화
                else:
                    count[-1] += 1  # 현재 구간간 길이 증가
                flag = True
            else:
                flag = False
    
    if not count:  
        print(1)
    else:
        print(max(count) + 1)  

# 메인
for _ in range(3):
    s = list(map(int, str(input())))
    inspect_list(s)
