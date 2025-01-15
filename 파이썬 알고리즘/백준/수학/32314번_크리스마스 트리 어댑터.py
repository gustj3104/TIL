# 어댑터가 암페어보다 크거나 같으면 작동

a = int(input()) # 암페어
w, v = map(int, input().split()) # w: 와트, v: 볼트

if w/v >= a:
    print(1)
else:
    print(0)