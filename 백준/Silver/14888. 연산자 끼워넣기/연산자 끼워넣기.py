n = int(input())
num = list(map(int, input().split()))
ord = list(map(int, input().split()))
answer = []

def cal(x, y, id):
    if id == 0:
        return x + y
    elif id == 1:
        return x - y
    elif id == 2:
        return x * y
    else:
        if x < 0:
            return -(abs(x)//y)
        else:
            return x//y

def dfs(value, idx, op):
    if idx == n:
        answer.append(value)
        return
    for i, o in enumerate(ord):
        if o:
            ord[i] -= 1
            new_value = cal(value, num[idx],i)
            dfs(new_value, idx + 1, ord)
            ord[i] += 1
dfs(num[0], 1, ord)
print(max(answer))
print(min(answer))