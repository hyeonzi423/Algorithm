def solution(bridge_length, weight, truck_weights):
    answer = 0
    on_bridge = [0]*bridge_length
    now_weight = 0
    
    while on_bridge:
        answer += 1
        tmp = on_bridge.pop(0)
        now_weight -= tmp
        
        if truck_weights:
            if now_weight + truck_weights[0] <= weight:
                t = truck_weights.pop(0)
                on_bridge.append(t)
                now_weight += t
            else:
                on_bridge.append(0)
    return answer