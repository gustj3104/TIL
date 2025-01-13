import sys
input = sys.stdin.readline

possible_string = input().strip()
need_string = input().strip()

if len(possible_string) >= len(need_string):
    print("go")
else:
    print("no")
    