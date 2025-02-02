'''
끝말잇기 기록 중 하나의 기록이 ? 로 주어짐 
?에 들어갈 문자열 후보가 주어질 때 ?에 들어갈 문자열 출력하기

단어 모음 리스트 생성
단어를 입력받으면서 단어를 리스트로 저장 -> 단어 모음에 저장
? 가 나오면 바로 전 단어 리스트를 pop해서 꺼내서 key_word에 저장
첫 단어, 마지막 단어를 key_word에서 꺼내서 저장
후보 중에서 검사해서 출력
'''
import sys
input = sys.stdin.readline

n = int(input()) #끝말잇기 기록

words = list()
used_words = set()

for _ in range(n): 
    word = input().strip()
    words.append(word)
    used_words.add(word)

if "?" in words:
    i = words.index("?")
    if i == 0:
        first = ""
    else:
        first = words[i-1][-1]
    
    if i == len(words) - 1:
        last = ""
    else:
        last = words[i+1][0]


m = int(input()) #후보 단어 개수
for _ in range(m):
    word = input().strip()
    if word not in used_words:
        if (not first or word[0] == first) and (not last or word[-1] == last):
            print(word)