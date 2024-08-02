'''
티셔츠: S ~ XXXL의 6가지 사이즈 - 같은 사이즈로 T장 묶음 구매
펜: 한 종류 - P자루씩 묶음 or 한 자루씩

티셔츠는 남아도 ㄱㅊ 신청한 사이즈대로 나누어줘야됨(부족하면 안됨)
펜은 남거나 부족하면 안됨. 정확히 참가자 수만큼

티셔츠는 T장씩 최소 몇 묶음 주문해야 하는지
펜은 P자루씩 최대 몇 묶음 주문? 펜을 한 자루씩 몇 개 주문하는지

참가자수
사이즈별 신청자 수
정수 치셔츠 / 펜 묶음 수
'''

people = int(input())

size_shirts = list(map(int, input().split()))

shirt_bundle, pen_bundle = map(int, input().split())

shirt_cnt = 0
pen_bundle_cnt = 0
pen_cnt = 0

for i in range(6):
    if size_shirts[i] == 0:
        continue
    elif size_shirts[i] < shirt_bundle:
        shirt_cnt += 1
    elif size_shirts[i] % shirt_bundle == 0:
        shirt_cnt += size_shirts[i] // shirt_bundle
    else: 
        shirt_cnt += size_shirts[i] // shirt_bundle + 1  

pen_bundle_cnt = people // pen_bundle
pen_cnt = people % pen_bundle

print(shirt_cnt)
print(pen_bundle_cnt, pen_cnt)
    
