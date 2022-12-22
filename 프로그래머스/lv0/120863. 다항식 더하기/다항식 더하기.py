def solution(polynomial):
    s = polynomial.split()
    num, x_num = 0, 0 
    
    for i in s:
        if i == "+":
            continue
        if i.isdigit():
            num += int(i)
        else:
            x_num += int(i[:len(i)-1]) if len(i) > 1 else 1
    
    x_num_1 = "x" if x_num == 1 else str(x_num) + "x"
    
    if num == 0:
        return x_num_1
    elif x_num == 0:
        return str(num)
    else:
        return x_num_1 + " + " + str(num) 