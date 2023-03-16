def solution(wallpaper):
    min_Xvalue, min_Yvalue = 50, 50
    max_Xvalue, max_Yvalue = 0, 0
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == "#":
                print(i, j)
                if min_Xvalue > i:
                    min_Xvalue = i
                if min_Yvalue > j:
                    min_Yvalue = j
                if max_Xvalue < i:
                    max_Xvalue = i
                if max_Yvalue < j:
                    max_Yvalue = j
    answer = [min_Xvalue, min_Yvalue, max_Xvalue + 1, max_Yvalue + 1]
    return answer