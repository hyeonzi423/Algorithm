def solution(numbers):
    numbers = list(map(str,numbers))
    numbers.sort()
    new_numbers = sorted(numbers, key = lambda x: x*3, reverse = True)
    answer = ''.join(new_numbers) if int(''.join(new_numbers)) != 0 else str(0)
    return answer