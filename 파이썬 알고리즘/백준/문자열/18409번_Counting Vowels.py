vowel = ['a', 'i', 'e', 'o', 'u']
n = int(input()) #단어 길이
word = list(input())

count = 0
for w in word:
    if w in vowel:
        count += 1
    
print(count)