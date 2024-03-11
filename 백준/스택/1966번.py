'''FIFO 구조의 프린터(큐) 만들기
1. 현재 큐의 가장 앞에 있는 문서의 중요도 확인하기
2. 나머지 문서 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 큐의 가장 뒤에 재배치한다. 아니면 인쇄
어떤 한 문서가 몇 번째로 인쇄되는지 알아내기
'''

def queue(a, b): #a: 문서의 개수, b: 현재 큐에서 몇 번째에 있는가
    count=0 # 탐색 문서 전 문서 개수
    q_list=list(map(int, input().split())) #문서의 중요도를 입력받아 리스트에 저장
    c=q_list[b] #c: 탐색하려는 문서의 중요도 저장 
    q_list.sort(reverse=True)
    i=q_list.index(c)+1
    if q_list.count(c)>=2:
        while q_list[0] != c:
            count+=1
            q_list.remove(q_list[0])
    if q_list.count(c)>=2:
        i=q_list.count(c)+count
    print(i)

t=int(input())
for i in range(t):
    a, b=map(int, input().split())
    queue(a, b)
