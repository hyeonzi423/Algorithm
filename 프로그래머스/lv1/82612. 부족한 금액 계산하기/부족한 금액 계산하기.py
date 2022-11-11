def solution(price, money, count):
    total, n = 0, price
    for i in range(count):
        total += price
        price += n
    answer = total - money if total - money > 0 else 0 
    return answer