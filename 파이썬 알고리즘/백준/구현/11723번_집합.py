import sys
input = sys.stdin.readline
x = set()

def add(n):
    x.add(n)

def remove(n):
    if n in x:
        x.remove(n)
    else:
        return 0

def check(n):
    if n in x:
        print(1)
    else:
        print(0)

def toggle(n):
    if n in x:
        x.remove(n)
    else:
        x.add(n)

def all():
    global x
    x = {i for i in range(1, 21)}

def empty():
    global x
    x = set()

# 메인
n = int(input())
for _ in range(n):
    command, *args = input().split()
    if args:
        n = int(args[0])
    if command == "add":
        add(n)
    elif command == "remove":
        remove(n)
    elif command == "check":
        check(n)
    elif command == "toggle":
        toggle(n)
    elif command == "all":
        all()
    elif command == "empty":
        empty()