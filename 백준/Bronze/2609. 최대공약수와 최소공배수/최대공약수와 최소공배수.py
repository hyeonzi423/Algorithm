import sys
from math import gcd
x, y = map(int, (sys.stdin.readline().split()))
print(gcd(x, y))
print(x * y // gcd(x, y))