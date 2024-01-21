import sys
input = sys.stdin.readline

sentence = input()
other = set()

for i in range(1, len(sentence)):
    for j in range(len(sentence)-i):
        tmp = sentence[j:j+i]
        other.add(tmp)

print(len(other))