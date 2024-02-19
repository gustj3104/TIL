'''주어진 단어에서 가장 많이 사용된 알파벳 알아내기'''
word=list(input().upper())
unique=list(set(word))
cnt_list=[]
a=[]
cnt=0
for i in unique:
    for x in word:
        if x==i:
            cnt+=1
    cnt_list.append(i)
    cnt_list.append(cnt)
    cnt=0
for i in range(len(cnt_list)):
    if i%2==1:
        a.append(cnt_list[i])
if a.count(max(a))>=2:
    print("?")
else:
    for i in range(len(cnt_list)):
        if cnt_list[i]==max(a):
            print(cnt_list[i-1])

# print(word, unique, cnt_list, a)


