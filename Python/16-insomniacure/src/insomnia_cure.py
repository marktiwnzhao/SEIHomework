"""write your code in method sove"""
def solve():
    k = int(input())
    l = int(input())
    m = int(input())
    n = int(input())
    d = int(input())
    ls = [0 for i in range(d)]

    def Harm(a, b):
        division = b // a
        for i in range(1, division + 1):
            ls[i * a - 1] = 1

    Harm(k, d)
    Harm(l, d)
    Harm(m, d)
    Harm(n, d)
    dragon_harmed = 0
    for i in range(d):
        if ls[i] == 1:
            dragon_harmed += 1
    print(dragon_harmed)


    return