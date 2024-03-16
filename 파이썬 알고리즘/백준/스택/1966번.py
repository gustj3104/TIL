'''FIFO 구조의 프린터(큐) 만들기
1. 현재 큐의 가장 앞에 있는 문서의 중요도 확인하기
2. 나머지 문서 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 큐의 가장 뒤에 재배치한다. 아니면 인쇄
어떤 한 문서가 몇 번째로 인쇄되는지 알아내기


def queue(a, b): #a: 문서의 개수, b: 현재 큐에서 몇 번째에 있는가
    count=0 # 탐색 문서 전 문서 개수
    goalIndex=b
    q_list=list(map(int, input().split())) #문서의 중요도를 입력받아 리스트에 저장
    c=q_list[b] #c: 탐색하려는 문서의 중요도 저장 
    copy_q_list=q_list[:]


    if q_list.count(c) < 2:
        copy_q_list.sort(reverse=True)
        print((copy_q_list.index(c))+1)
    else:
        start_index=q_list.index(max(q_list))
        index=start_index
        count=+1
        while q_list:
            if q_list[index+1]==max(q_list) and q_list.index(q_list[index+1])>start_index:
                count+=1
                index+=1
                if q_list[index] == c:
                    print(c)
                    return c
                if index >=len(q_list):
                    index=0
            else:
                index+=1


t=int(input())
for i in range(t):
    a, b=map(int, input().split())
    queue(a, b)
    
'''

#모르겠어서 답지 봄 ;;
t = int(input()) #t:테스트 횟수

for _ in range(t):
    n, m = map(int, input().split()) #문서 개수, 탐색 문서의 인덱스
    data = list(map(int, input().split())) #문서 입력받기 --> data리스트에 저장
    
    result = 1 #출력 순서
    while data:
        if data[0] < max(data): 
            data.append(data.pop(0))
            print(data, m)

        else:
            if m == 0: break

            data.pop(0)
            result += 1
            print(data, m)
        m = m - 1 if m > 0 else len(data) - 1 #m이 0보다 크면 1감소, 아니면 길이 - 1

    print(result)
