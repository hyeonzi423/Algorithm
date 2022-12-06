def solution(survey, choices):
    answer = ''
    mbti = {"R": 0, "T": 0, "C": 0, "F": 0, "J": 0, "M": 0, "A": 0, "N": 0, }
    for s, c in zip(survey, choices):
        if c <= 3:
            mbti[s[0]] += 4 - c 
        elif c >= 5:
            mbti[s[1]] += c - 4
    
    answer += "R" if mbti["R"] >= mbti["T"] else "T"
    answer += "C" if mbti["C"] >= mbti["F"] else "F"
    answer += "J" if mbti["J"] >= mbti["M"] else "M"
    answer += "A" if mbti["A"] >= mbti["N"] else "N"
    return answer