vowel = ['a', 'e', 'i', 'o', 'u']

while True:
    word = 0
    s = input().lower()
    if s == '#':
        break
    else:
        s = list(s)
        for i in s:
            if i in vowel:
                word += 1

        print(word)
        