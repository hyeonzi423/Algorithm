def check_correct(s):
    stack = []
    for i in s:
        if i in "([{":
            stack.append(i)
        elif i == ")":
            if len(stack) == 0 or stack[-1] != "(":
                return False
            else:
                stack.pop()
        elif i == "]":
            if len(stack) == 0 or stack[-1] != "[":
                return False
            else:
                stack.pop()
        elif i == "}":
            if len(stack) == 0 or stack[-1] != "{":
                return False
            else:
                stack.pop()
    return True if len(stack) == 0 else False
            

def solution(s):
    answer = 0
    init_s = s
    for i in range(len(s)):
        if check_correct(s) == True:
            answer += 1
        s = init_s[i+1:] + init_s[:i+1]
    return answer
