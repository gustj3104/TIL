import sys
input = sys.stdin.readline

word = input().strip()
word_list = []

for i in range(1, len(word) - 1): # 1글자 보장, 첫 단어 구간
    for j in range(i + 1, len(word)): # 1글자 보장, 두번째 단어 구간
        first = word[:i][::-1]
        second = word[i:j][::-1]
        third = word[j:][::-1]

        result = first + second + third
        word_list.append(result)

print(min(word_list))