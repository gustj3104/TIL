import sys
input = sys.stdin.readline

n = int(input())
word = list(input().strip())
if word[n-1] == 'G':
    print("".join(word[:n-1]))
else:
    word.append("G")
    print("".join(word))