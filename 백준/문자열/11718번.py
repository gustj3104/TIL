'''입력받은 대로 출력하기'''
while True:
    try:
        word=input()
        print(word)
    except EOFError:
        break
