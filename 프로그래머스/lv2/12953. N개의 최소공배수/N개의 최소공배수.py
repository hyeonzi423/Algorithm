from math import gcd
def solution(arr):
    while len(arr) >= 2:
        a = arr.pop(0)
        b = arr.pop(0)
        arr.append(a * b // gcd(a,b))
    return arr[0]