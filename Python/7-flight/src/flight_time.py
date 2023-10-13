def flight_calculation():
    getstr1 = input()
    getstr2 = input()

    if getstr1.endswith(")"):
        str1, str2, str3 = getstr1.split(" ")
        a1, a2, a3 = str1.split(":")
        b1, b2, b3 = str2.split(":")
        s = int(str3[2])
        a1 = int(a1);b1 = int(b1)
        a2 = int(a2);b2 = int(b2)
        a3 = int(a3);b3 = int(b3)
        t1 = s * 24 * 3600 + b1 * 3600 + b2 * 60 + b3 - a1 * 3600 - a2 * 60 - a3
    else:
        str1, str2 = getstr1.split(" ")
        a1, a2, a3 = str1.split(":")
        b1, b2, b3 = str2.split(":")
        a1 = int(a1);b1 = int(b1)
        a2 = int(a2);b2 = int(b2)
        a3 = int(a3);b3 = int(b3)
        t1 = b1 * 3600 + b2 * 60 + b3 - a1 * 3600 - a2 * 60 - a3

    if getstr2.endswith(")"):
        str1, str2, str3 = getstr2.split(" ")
        a1, a2, a3 = str1.split(":")
        b1, b2, b3 = str2.split(":")
        s = int(str3[2])
        a1 = int(a1);b1 = int(b1)
        a2 = int(a2);b2 = int(b2)
        a3 = int(a3);b3 = int(b3)
        t2 = s * 24 * 3600 + b1 * 3600 + b2 * 60 + b3 - a1 * 3600 - a2 * 60 - a3
    else:
        str1, str2 = getstr2.split(" ")
        a1, a2, a3 = str1.split(":")
        b1, b2, b3 = str2.split(":")
        a1 = int(a1);b1 = int(b1)
        a2 = int(a2);b2 = int(b2)
        a3 = int(a3);b3 = int(b3)
        t2 = b1 * 3600 + b2 * 60 + b3 - a1 * 3600 - a2 * 60 - a3

    t = (t2 + t1) / 2
    h = int(t // 3600)
    m = int(t // 60 - h * 60)
    s = int(t - h * 3600 - m * 60)
    print('%02d:' % h + '%02d:' % m + '%02d' % s)


    # enter your code here


