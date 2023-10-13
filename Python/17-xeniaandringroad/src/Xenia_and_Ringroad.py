"""write your code in method solve"""
def solve():
    n, m = input().split()
    n = int(n)
    m = int(m)
    array_of_tasks = input().split()
    for i in range(m):
        array_of_tasks[i] = int(array_of_tasks[i])
    times = array_of_tasks[0] - 1
    for i in range(1, m):
        if array_of_tasks[i] >= array_of_tasks[i - 1]:
            times += (array_of_tasks[i] - array_of_tasks[i - 1])
        else:
            times += n - array_of_tasks[i - 1] + array_of_tasks[i]
    print(times)

    return