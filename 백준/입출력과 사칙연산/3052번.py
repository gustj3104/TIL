'''10개의 수를 입력받은 뒤, 이를 42로 나눈 나머지를 구하여 그 중 서로 다른 값이 몇 개인지 출력하기'''
num=[]
for i in range(0, 10):
    a=int(input())
    a=a%42
    num.append(a)
    num_uni=list(set(num))
print(len(num_uni))



