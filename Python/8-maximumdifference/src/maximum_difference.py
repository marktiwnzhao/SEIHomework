def cal_max_difference():
# enter your code here
    inputstr = input()
    length = len(inputstr.split())
    #print(length)
    maxofdifference = int(inputstr.split()[1]) - int(inputstr.split()[0])
    for i in range(1, length):
        for j in range(0, i):
            difference = int(inputstr.split()[i]) - int(inputstr.split()[j])
            if difference >= maxofdifference:
                maxofdifference = difference
    if maxofdifference < 0:
        maxofdifference = -1
    print(int(maxofdifference), end='')

