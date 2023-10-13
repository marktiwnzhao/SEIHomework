def special_typing():
    def Judge():
        s = str(input())
        t = str(input())
        if len(s) < len(t):
            print('NO')
            return
        flag = False
        for i in range(len(s) - len(t) + 1):
            tt = list(t)
            if s[i] == t[0]:
                index_s = i
                tt[0] = ''
                for k in range(1, len(t)):
                    for j in range(index_s + 1, len(s), 2):
                        if t[k] == s[j]:
                            tt[k] = ''
                            index_s = j
                            break
                if tt[len(t) - 1] == '' and (len(s) - index_s) & 1 != 0:
                    print('YES')
                    flag = True
                    break
        if not flag:
            print('NO')
            return
    n = int(input())
    for i in range(n):
        Judge()
    # your code here ^_^

