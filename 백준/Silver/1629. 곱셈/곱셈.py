def mul(a, b, c):
    if b == 1:
        return a % c
    num = mul(a, b//2, c)
    num = num * num % c
    if b % 2 == 0:
        return num
    return num * a % c


A, B, C = map(int, input().split())
print(mul(A, B, C))