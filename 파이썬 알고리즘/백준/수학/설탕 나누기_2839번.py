'''
정확하게 N킬로그램 배달 -> 설탕봉지는 3킬로, 5킬로 봉지가 있음. 정확하게 N 킬로그램을 맞출 수 없다면 -1 출력
'''

k = int(input())

#5kg 봉지만으로 담을 수 있을 때
if k % 5 == 0:
    print(k//5)
else:
    cnt = 0 #담은 봉지 수
    while k > 0:
        k -= 3 #3kg 봉지로 남음
        cnt += 1
        if k % 5 == 0: #3kg, 5kg 봉지를 조합해서 담은 경우
            cnt += k // 5
            print(cnt)
            break
        elif k == 1 or k == 2 or k<0: #정확하게 나뉘지 않는 경우
            print(-1)
            break
        elif k == 0: #3kg으로 나뉘어 떨어지는 경우
            print(cnt)
            break