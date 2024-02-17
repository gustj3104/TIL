'''(A+B)%C는 ((A%C) + (B%C))%C 와 같을까? // (A×B)%C는 ((A%C) × (B%C))%C 와 같을까'''
A, B, C=map(int, input().split())
i=(A+B)%C
k=((A%C) + (B%C))%C
m=(A*B)%C
n=((A%C) * (B%C))%C
print(i)
print(k)
print(m)
print(n)