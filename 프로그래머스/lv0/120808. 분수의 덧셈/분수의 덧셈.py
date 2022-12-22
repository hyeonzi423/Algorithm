from math import gcd
def solution(denum1, num1, denum2, num2):
    denum = denum1 * num2 + denum2 * num1 
    num = num1 * num2
    gcd_n = gcd(denum, num)
    return [denum/gcd_n, num/gcd_n]