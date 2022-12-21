def solution(babbling):
    answer = 0
    can = ['aya', 'ye', 'woo', 'ma']
    for b in babbling:
        for i in can:
            if i in b:
                b = b.replace(i, ' ')
        if b == ' '*len(b):
            answer += 1
    return answer