"""write your code in following methods"""
file_path = './tasks.txt'


def to_do():
    while True:
        dir = input()
        if dir[6] == 'q':
            break
        elif dir[6] == 'a' and dir[7] == ' ':
            f = open(file_path, 'a')
            ls = dir[9:].split(' \"')
            for i in range(len(ls)):
                ls[i] = ls[i].strip('\"')
                print("todo:%s" % ls[i], file = f)
            f.close()
        elif dir[6] == 'd':
            f = open(file_path, 'r')
            ls = dir[9:].split(' \"')
            for i in range(len(ls)):
                ls[i] = ls[i].strip('\"')
            info = []
            while True:
                line = f.readline()
                if len(line) == 0:
                    break
                info.append(line)
            f.close()
            for i in range(len(info)):
                for j in range(len(ls)):
                    if ls[j] in info[i]:
                        info[i] = ' '
                        break
            f = open(file_path, 'w')
            for i in range(len(info)):
                if info[i] != ' ':
                    print('%s' % info[i], end='', file = f)
            f.close()
        elif dir[6] == 'c':
            f = open(file_path, 'r')
            ls = dir[9:].split(' \"')
            for i in range(len(ls)):
                ls[i] = ls[i].strip('\"')
            info = []
            while True:
                line = f.readline()
                if len(line) == 0:
                    break
                info.append(line)
            f.close()
            for i in range(len(info)):
                for j in range(len(ls)):
                    if ls[j] in info[i]:
                        change = info[i].split(':')
                        change[0] = 'completed'
                        info[i] = ':'.join(change)
            f = open(file_path, 'w')
            for i in range(len(info)):
                print('%s' % info[i], end = '', file = f)
            f.close()
        elif dir[6] == 'f':
            f = open(file_path, 'r')
            if dir[8] == 't':
                while True:
                    line = f.readline()
                    if len(line) == 0:
                        break
                    if 'todo:' in line:
                        print(line[:-1])
            else:
                while True:
                    line = f.readline()
                    if len(line) == 0:
                        break
                    if 'completed:' in line:
                        print(line[:-1])
            f.close()
        else:
            f = open(file_path, 'r')
            while True:
                line = f.readline()
                if len(line) == 0:
                    break
                print(line[:-1])
            f.close()
    return












