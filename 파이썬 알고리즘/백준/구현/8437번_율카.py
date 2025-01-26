# 총 사과 수 / 한 사람의 사과 수를 입력으로 받아 각각 몇 개의 사과를 가지고 있는지 출력하기
apple = int(input())
one = int(input())
two = (apple - one) // 2
print(apple - two)
print(two)