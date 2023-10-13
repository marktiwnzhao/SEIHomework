def is_anagram(str1, str2):
    # Complete this function. Remember to delete this line before you test your program
    if len(str1) != len(str2):
        return False
    ls1 = list(str1)
    ls2 = list(str2)
    ls1.sort()
    ls2.sort()
    str1 = "".join(ls1)
    str2 = "".join(ls2)
    for i in range(len(str1)):
        if str1[i] != str2[i]:
            return False
    return True

