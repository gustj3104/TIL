'''
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

'''
import sys

class Stack:
    def __init__(self):
        self.lst = list()

    def pushX(self, n):
        self.lst.append(n)

    def pop(self):
        if self.lst:
            print(self.lst.pop())
        else:
            print(-1)

    def size(self):
        print(len(self.lst))

    def empty(self):
        if self.lst:
            print(0)
        else:
            print(1)

    def top(self):
        if self.lst:
            print(self.lst[-1])
        else:
            print(-1)


n = int(sys.stdin.readline().rstrip())
s = Stack()
for _ in range(n):
    st = sys.stdin.readline().rstrip()

    if ' ' in st:
        method, n = st.split()
        s.pushX(int(n))
    else:
        if st == 'pop':
            s.pop()
        elif st == 'size':
            s.size()
        elif st == 'empty':
            s.empty()
        else:
            s.top()