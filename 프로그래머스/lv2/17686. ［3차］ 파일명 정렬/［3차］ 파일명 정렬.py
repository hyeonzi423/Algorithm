def solution(files):
    answer, file = [], []
    for i in files:
        head, number, tail, check1, check2 = '', '', '', True, True
        for f in i:
            if not f.isdigit() and check1 == True:
                head += f
            elif f.isdigit() and check2 == True:
                number += f
                check1 = False
            elif check1 == False and not f.isdigit():
                tail += f
                check2 = False
            else:
                tail += f
        check1, check2 = True, True
        file.append([head, number, tail])
    file.sort(key=lambda x: (x[0].lower(), int(x[1])))
    answer = [''.join(i) for i in file]
    return answer