# 모든 문장에서 가장 앞 두 단어를 제일 마지막에 말함 -> 문장을 요다 말로 바꾸기

n = int(input()) # 문장 수
sentences = []

for _ in range(n):
    s = input().split()
    sentences.append(s)

for i in sentences:
    n = i.pop(0)
    m = i.pop(0)
    i.append(n)
    i.append(m)
    for k in i:
        print(k, end=" ")
    print()