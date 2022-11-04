def solution(brown, yellow):
    prime_y = []
    for i in range(1, yellow + 1):
        if yellow % i == 0:
            prime_y.append(i)
    
    for i in range(int((len(prime_y) + 1)/2)):
        w = prime_y[len(prime_y) - i - 1]
        l = prime_y[0 + i]
        if w + l == int((brown - 4)/2):
            answer = [w + 2, l + 2]
    return answer