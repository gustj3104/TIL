'''
해시 함수: 임의의 길이와 입력을 받아 고정된 길이의 출력을 내보내는 함수
입력으로 들어오는 문자열 -> 영문 소문자로 구성 // a - 1, b - 2, ..., z - 26으로 고유한 번호 부여
abba ==  1221
'''
alpha = [chr(c) for c in range(97,123)]
alpha_num = dict()
result = 0

for i in alpha:
    alpha_num[i] = alpha.index(i) + 1


n = int(input())
word = list(input())

for i in range(len(word)):
    result += (alpha_num[word[i]]) * (31 ** i)

print(result%1234567891)