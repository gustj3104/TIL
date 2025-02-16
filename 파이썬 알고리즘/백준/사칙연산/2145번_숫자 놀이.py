while True:
    n = int(input())
    if n == 0:
        break
    num = list(str(n))
    
    while True:
        n = 0
        if len(num) == 1:
            print(num[0])
            break
        for i in num:
            n += int(i)
        num = list(str(n))