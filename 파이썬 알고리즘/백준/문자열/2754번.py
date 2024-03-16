'''성적이 주어졌을 때 평점 출력하기'''
grade=input()
if grade[0] == "A":
    if grade[1] == "+":
        print(4.3)
    elif grade[1] == "0":
        print(4.0)
    elif grade[1] == "-":
        print(3.7)
elif grade[0] == "B":
    if grade[1] == "+":
        print(3.3)
    elif grade[1] == "0":
        print(3.0)
    elif grade[1] == "-":
        print(2.7)
elif grade[0] == "C":
    if grade[1] == "+":
        print(2.3)
    elif grade[1] == "0":
        print(2.0)
    elif grade[1] == "-":
        print(1.7)
elif grade[0] == "D":
    if grade[1] == "+":
        print(1.3)
    elif grade[1] == "0":
        print(1.0)
    elif grade[1] == "-":
        print(0.7)
elif grade[0] == "F":
    print(0.0)