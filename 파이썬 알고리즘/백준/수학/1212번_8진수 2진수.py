import sys
input = sys.stdin.readline

num = list(input().strip())
eight_digit = ["000", "001", "010", "011", "100", "101", "110", "111"]
result = []
for n in num:
    result.append(eight_digit[int(n)])

# 리스트를 문자열로 변환 => 맨 앞 "0" 제거
binary_str = "".join(result).lstrip("0")

# 만약 모든 숫자가 0이라면, 최소한 "0" 하나 출력
print(binary_str if binary_str else "0")
