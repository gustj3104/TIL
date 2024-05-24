'''
- 중복 X
- 버려진 문자의 총 개수에 + 4
- + 1906
- reverse
- + smupc_

'''
num, name = input().split()
num = str(int(num) + 1906)
name = list(name)
pw=[]
alpha=0

#1, 2. 중복 문자 제거, 중복 문자수 +4해서 붙이기
for i in name:
    if i not in pw:
        pw.append(i)
    else:
        alpha+=1

alpha = alpha+4
pw.append(str(alpha))

#3. 출전번호+1906 붙이기
num = list(num)
num.reverse()
for i in num:        
    pw.insert(0, i)   

#4. 뒤집기
pw.reverse()

#smupc붙이기
pw_2 = ''.join(pw)
result = 'smupc_'+pw_2
print(result)