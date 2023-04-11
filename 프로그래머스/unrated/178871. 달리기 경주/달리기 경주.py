def solution(players, callings):
    play = {players[i]: i for i in range(len(players))}
    idx = {i: players[i] for i in range(len(players))}
        
    for c in callings:
        now_idx = play[c] #idx
        pre_idx = now_idx - 1
        
        now_name = idx[now_idx]
        pre_name = idx[pre_idx]
        
        play[now_name], play[pre_name] = pre_idx, now_idx
        idx[now_idx], idx[pre_idx] = pre_name, now_name

    return list(idx.values())