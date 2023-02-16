def solution(cap, n, deliveries, pickups):
    deliveries = deliveries[::-1]
    pickups = pickups[::-1]
    answer = 0

    deli, pick = 0, 0
    for i in range(n):
        deli += deliveries[i]
        pick += pickups[i]

        while deli > 0 or pick > 0:
            deli -= cap
            pick -= cap
            answer += (n - i) * 2

    return answer