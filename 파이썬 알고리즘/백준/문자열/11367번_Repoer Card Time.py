import sys
input = sys.stdin.readline

n = int(input()) #테스트 케이스

for _ in range(n):
    name, grade = map(str, input().split())
    grade = int(grade)
    if 97 <= grade <= 100:
        print(name, "A+")
    elif 90 <= grade < 97:
        print(name, "A")
    elif 87 <= grade < 90:
        print(name, "B+")
    elif 80 <= grade < 87:
        print(name, "B")
    elif 77 <= grade < 80:
        print(name, "C+")
    elif 70 <= grade < 77:
        print(name, "C")
    elif 67 <= grade < 70:
        print(name, "D+")
    elif 60 <= grade < 67:
        print(name, "D")
    else:
        print(name, "F")
