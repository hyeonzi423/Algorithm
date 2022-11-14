def solution(cacheSize, cities):
    cache = []
    time = 0
    if cacheSize == 0:
        time = len(cities) * 5
    else:
        for i in cities:
            if len(cache) < cacheSize:
                if i.lower() in cache:
                    cache.remove(i.lower())
                    cache.append(i.lower())
                    time += 1
                else:
                    cache.append(i.lower())
                    time += 5
            elif i.lower() in cache:
                time += 1
                cache.remove(i.lower())
                cache.append(i.lower())
            else:
                time += 5
                cache.remove(cache[0])
                cache.append(i.lower())
    print(time)
    return time