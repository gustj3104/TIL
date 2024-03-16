'''M*N크기의 보드를 8*8크기의 체스판으로 만들려고 한다. 
보드가 체스판처럼 칠해져있지 않아 다시 칠해야 함. 다시 칠해야 하는 정사각형의 최소 개수를 구하시오.'''
n,m=map(int,input().split())

mtr=[]
cnt=[]
for i in range(n):
    mtr.append(input())
    
for a in range(n-7):
    for b in range(m-7):#8*8로 자르기 위해, -7해준다
        w_index=0 #흰색으로 시작
        b_index=0 #검은색으로 시작

        # 8*8 체스판으로 자른 후 이제 칠해야 하는 정사각형 수 세는 거 -> 반복해서 시행 후 최소값을 찾는 거임
        for i in range(a,a+8):#시작지점
            for j in range(b,b+8):#시작지점
                if (i+j)%2==0:#짝수인 경우
                    if mtr[i][j]!='W':#W가 아니면, 즉 B이면
                        w_index+=1#W로 칠하는 갯수
                    else:#W일 때
                        b_index+=1#B로 칠하는 갯수
                else:#홀수인 경우
                    if mtr[i][j]!='W':#W가 아니면, 즉 B이면
                        b_index+=1#B로 칠하는 갯수
                    else:
                        w_index+=1#W로 칠하는 갯수
                        
        cnt.append(w_index) #W로 시작할 때 경우의 수
        cnt.append(b_index) #B로 시작할 때 경우의 수
print(min(cnt))
