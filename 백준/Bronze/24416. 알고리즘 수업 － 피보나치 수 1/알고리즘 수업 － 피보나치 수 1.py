def rec_fib(n):
    if n == 1 or n == 2:
        return 1
    else:
        return rec_fib(n-1) + rec_fib(n-2)

def dynamic_fib(n):
    fib = [0]*(n+1)
    fib[1], fib[2] = 1, 1
    cnt = 0
    for i in range(3, n+1):
        fib[i] = fib[i-1] + fib[i-2]
        cnt += 1
    return cnt

n = int(input())
print(rec_fib(n), dynamic_fib(n))