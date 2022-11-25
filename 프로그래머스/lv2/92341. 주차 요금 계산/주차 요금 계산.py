import math
def solution(fees, records):
    b_t, b_f, p_t, p_f = fees[0], fees[1], fees[2], fees[3]
    record, car_l, answer = [], [], []
    
    for r in records:
        time, car, io = map(str, r.split())
        record.append([car, int(time[:2]) * 60 + int(time[3:])])
        car_l.append(car)
    
    parking_time = {i:[] for i in set(car_l)}
    for i in record:
        parking_time[i[0]].append(i[1])
    
    for key, value in parking_time.items():
        sum = 0
        for i in range(len(value)):
            sum -= value[i] if i % 2 == 0 else -value[i]
        sum = sum if sum > 0 else sum + 23*60 + 59
        money = b_f + (math.ceil((sum - b_t) / p_t)) * p_f
        parking_time[key].append(money if money >= b_f else b_f)
    
    parking_time = sorted(parking_time.items(), key = lambda x: x[0])
    for i in parking_time:
        answer.append(i[-1][-1])
    return answer