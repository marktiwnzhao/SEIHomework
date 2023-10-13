"""write your code in method solve"""
def solve():
    n = int(input())
    num_of_taxi = 0
    ls = input().split()
    count = [0 for i in range(4)]
    for i in range(n):
        ls[i] = int(ls[i])
    for i in range(n):
        if ls[i] == 4:
            count[3] += 1
        elif ls[i] == 3:
            count[2] += 1
        elif ls[i] == 2:
            count[1] += 1
        else:
            count[0] += 1
    num_of_taxi += count[3]
    num_of_taxi += (count[1] // 2)
    count[1] = (count[1] & 1)
    if count[0] >= count[2]:
        num_of_taxi += count[2]
        count[0] -= count[2]
        count[2] = 0
    else:
        num_of_taxi += count[2]
        count[0] = 0
        count[2] = 0
    if count[1] == 1:
        num_of_taxi += count[1]
        count[0] -= 2
    if count[0] > 0:
        num_of_taxi += count[0] // 4
        if (count[0] % 4) > 0:
            num_of_taxi += 1
    print(num_of_taxi)

    return