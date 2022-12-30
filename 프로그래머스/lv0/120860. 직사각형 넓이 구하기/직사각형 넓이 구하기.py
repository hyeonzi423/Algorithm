def solution(dots):
    x, y = [], []
    for a, b in dots:
        x.append(a)
        y.append(b)
    return (max(x)-min(x))*(max(y)-min(y))