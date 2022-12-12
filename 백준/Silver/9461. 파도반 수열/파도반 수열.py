n = int(input())
n_list = []
for i in range(n):
    n_list.append(int(input()))

p = [0 for i in range(max(n_list)+1)]
p[1], p[2], p[3] = 1, 1, 1
for i in range(4, max(n_list)+1):
    p[i] = p[i-3] + p[i-2]

for i in n_list:
    print(p[i])