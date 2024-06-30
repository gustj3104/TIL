'''
주어진 세 변의 길이로 삼각형이 직각인지 아닌지 구분하시오
'''
while True:
    nums = list(map(int, input().split()))
    if sum(nums) == 0:
            break #세 수가 모두 0으로 입력되면 종료
    max_num = max(nums) #빗변의 길이
    nums.remove(max_num)
    if nums[0]**2 + nums[1]**2 == max_num**2: #피타고라스의 정리
          print("right")
    else:
          print("wrong")