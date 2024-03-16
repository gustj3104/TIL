'''OX퀴즈 점수 출력하기, O의 경우 점수는 연속된 O의 개수'''
t=int(input())
quiz=[]
score=0
last_score=0
for i in range(t):
    a=list(input())
    for k in a:
        if k == 'O':
            score+=1
        else:
            score=0
        last_score=last_score+score
    print(last_score)
    last_score=0
    score=0
    quiz=[]