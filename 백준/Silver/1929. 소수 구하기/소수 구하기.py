import math

start, end = map(int, input().split())

def is_prime(num):
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

if start == 1:
    start = 2
    
for i in range(start, end+1):
    if is_prime(i):
        print(i)
