mList = []
N = int(input())

def move(a, b, n):
    if n == 1:
        mList.append(f'{a} {b}')
        return
    else:
        move(a, 6-a-b, n-1)
        mList.append(f'{a} {b}')
        move(6-a-b, b, n-1)

move(1, 3, N)
print(len(mList))

for i in range(len(mList)):
    print(mList[i])
