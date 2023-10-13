def isPetyaLanguage():
    suffix = [['lios', 'etr', 'initis'], ['liala', 'etra', 'inites']]
    string = input().split()
    valid = False
    noun = 0
    gen_of_noun = 0  # 0:ma; 1:fe
    index_of_noun = 0
    if len(string) == 1:
        for i in range(3):
            if string[0].endswith(suffix[0][i]) or string[0].endswith(suffix[1][i]):
                valid = True
                print('YES')
        if not valid:
            print('NO')
    else:
        for i in range(len(string)):
            if string[i].endswith(suffix[0][1]):
                noun += 1
                gen_of_noun = 0
                index_of_noun = i
            elif string[i].endswith(suffix[1][1]):
                noun += 1
                gen_of_noun = 1
                index_of_noun = i
        if noun > 1 or noun == 0:
            print('NO')
            return
        else:
            for i in range(0, index_of_noun):
                if not string[i].endswith(suffix[gen_of_noun][0]):
                    print('NO')
                    return
            if index_of_noun == len(string) - 1:
                print('YES')
                return
            else:
                for i in range(index_of_noun + 1, len(string)):
                    if not string[i].endswith(suffix[gen_of_noun][2]):
                        print('NO')
                        return
                print('YES')
    return