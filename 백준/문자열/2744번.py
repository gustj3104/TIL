'''영단어를 입력받고, 대문자와 소문자를 서로 바꾸어 출력하기'''

word=list(input().split())
for i in range(len(word)):
    word[i]=word[i].swapcase()
    print(word[i])


