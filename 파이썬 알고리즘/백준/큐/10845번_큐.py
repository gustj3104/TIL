queue = []

def push(n):
    queue.append(n)

def pop():
    if len(queue) > 0:
        print(queue.pop(0))
    else:
        print(-1)

def size():
    print(len(queue))

def empty():
    if len(queue) == 0:
        print(1)
    else:
        print(0)

def front():
    if len(queue) == 0:
        print(-1)
    else:
        print(queue[0])

def back():
    if len(queue) == 0:
        print(-1)
    else:
        print(queue[-1])


import sys

n = int(sys.stdin.readline().rstrip())
for _ in range(n):
    st = sys.stdin.readline().rstrip()

    if ' ' in st:
        method, n = st.split()
        push(int(n))
    else:
        if st == 'pop':
            pop()
        elif st == 'size':
            size()
        elif st == 'empty':
            empty()
        elif st == 'front':
            front()
        else:
            back()