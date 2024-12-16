import sys
input = sys.stdin.readline

k = int(input())
stack = []
for i in range(k):
        num = int(input())
        if ( num != 0 ):
                stack.append(num)
        else :
                if(stack):
                        stack.pop()
                else :
                        continue
                

print(sum(stack))