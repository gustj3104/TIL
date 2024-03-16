'''호텔 정문으로부터 걷는 거리가 가자아 짧도록 방을 배정하는 프로그램
각 층에 w개의 방이 있는 h층 건물이라고 가정, 엘레베이터는 가장 왼쪽에 있음 --> H * X 형태 호텔
호텔 정문은 일층 엘레베이터 바로 앞//정문부터 엘베 사이의 거리는 무시
인접한 두 방 사이의 거리는 1, 호텔 정면 쪽에 방이 있음
305호는 3층, 엘베로부터 5번째 방
엘베를 타고 이동하는 거리는 신경쓰지 않으나 거리가 같으면 아래층 방 선호(102호보다 2101호 선호)
층수, 각층수의방수, 몇번째 손님인지 입력받기'''

t=int(input())
for i in range(t):
    k=0 #손님 횟수
    a=0 #호 수
    h, w, n=map(int, input().split())
    while True:
        a=a+1
        for m in range(1,h+1):
            if a > w:
                a=0
                m=m+1
                if m > h:
                    break
            m=m*100
            k=k+1
            if k == n:
                print(m+a)
                break
        m=1
        if k == n:
            break
        if m > h:
            break
    