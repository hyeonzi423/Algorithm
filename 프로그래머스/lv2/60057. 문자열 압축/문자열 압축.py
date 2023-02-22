def solution(s):
    answer = len(s)
    for step in range(1, len(s)// + 1):
        sentence = ""
        prev = s[:step]
        count = 1
        for i in range(step, len(s), step):
            if s[i: i+step] == prev:
                count += 1
            else:
                sentence += str(count) + prev if count > 1 else prev
                prev = s[i: i+step]
                count = 1
        sentence += str(count) + prev if count > 1 else prev
        answer = min(answer, len(sentence))
    return answer