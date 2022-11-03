def solution(s):
    number = {"one": "1", "two": "2", "three": "3", "four": "4", "five": "5",
             "six": "6", "seven": "7", "eight": "8", "nine": "9", "zero": "0"}
    for eng, num in number.items():
        s = s.replace(eng, num)
    answer = int(s)
    return answer