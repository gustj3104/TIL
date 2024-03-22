# '''스택은 자료를 넣는 입구와 자료를 뽑는 입구가 같아 제일 나중에 들어간 자료가 제일 나중에 나오는 특성을 가지고 있다.
# push하는 순서는 반드시 오름차순을 지키도록 한다.'''
# import sys

# n=int(sys.stdin.readline())
# in_list=[] #입력받은 리스트 --> 정렬
# save_list=[] #입력받은 리스트 복사본 --> 정렬X
# cnt_list=[] #스택용 리스트
# push_list=[]
# pr_list=[] #출력용 리스트
# index=0

# for i in range(n):
#     a=input()
#     in_list.append(a)
# save_list=in_list.copy()
# in_list.sort()

# for i in save_list:
#     for j in in_list:
#         while index < len(save_list):
#             if not cnt_list:
#                 cnt_list.append(j)
#             if cnt_list[-1] == save_list[index]:
#                 pr_list.append("-")
#                 cnt_list.pop()
#                 index+=1
#                 e=len(cnt_list)
#                 if index >= len(save_list):
#                     break
#                 elif e==0:
#                     break
#             if cnt_list[-1] != save_list[index]:
#                 cnt_list.append(j)
#                 if cnt_list[0] == j:
#                     del cnt_list[0]
#                 pr_list.append("+")
#                 break

# if e>0:
#     print("NO")
# else:
#     for i in pr_list:
#         print(i)


import sys

def stack_sort(in_list): # in_list: 입력으로 받은 숫자를 저장하는 리스트
    stack = [] # 주어진 리스트를 정렬하기 위한 리스트
    result=[] # +, -를 저장하기 위한 리스트
    current=1 # 스택에 삽입될 변수 (초기값: 1 --> 1씩 증가함)

    for num in in_list:
        while current <= num: #in_list의 최고값보다 current가 작을 때 수행함.
            stack.append(current) #스택에 리스트값 저장 (1부터 리스트의 최고값까지 정렬)
            result.append("+") #스택에 수를 추가할 때마다 리스트에 + 추가
            current+=1 #스택에 저장할 값 1씩 증가
        if stack[-1] == num: # 스택 리스트의 마지막 값이 입력받은 리스트의 값과 같을 때 (정렬 리스트 요소 == 입력 리스트 요소)
            stack.pop() # 스택의 가장 최근 입력값 삭제
            result.append("-") 
        else:
            return "NO"
    return "\n".join(result) #join은 요소의 문자열을 하나의 문자열로 결합함. 

n=int(sys.stdin.readline()) 
in_list=[int(sys.stdin.readline()) for _ in range(n)]
print(stack_sort(in_list)) #정의한 함수 출력


def stack_sort(in_list):
    current=1
    result=[]
    stack=[]

    for num in in_list:
        while current <= num:
            stack.append(current)
            result.append("+")
            current+=1
        if stack[-1] == num:
            stack.pop()
            result.append("-")
        else:
            return "NO"
    return "\n".join(result)
n=int(sys.stdin.readline())
in_list=[int(sys.stdin.readline()) for _ in range(n)]
print(stack_sort(in_list))