#! /usr/bin/env python
# -*- coding: utf-8 -*-

import csv


def getcommand(file):
    n = int(input())
    for i in range(n):
        op = input().split()

        if op[0] == 'INSERT':
            f = open(file, 'a')
            print('\n' + op[1], file = f, end = '')
            f.close()
        else:
            f = open(file, 'r')
            info = []
            while True:
                line = f.readline()
                if len(line) == 0:
                    break
                info.append(line.strip().split(','))
            for i in range(len(info) - 1):
                for j in range(len(info) - i - 1):
                    if int(info[j + 1][2]) < int(info[j][2]):
                        temp = info[j + 1]
                        info[j + 1] = info[j]
                        info[j] = temp
            l1, l2 ,sum= 0, 0, 0.0
            for i in range(len(info)):
                if len(info[i][0]) > l1:
                    l1 = len(info[i][0])
                if len(info[i][1]) > l2:
                    l2 = len(info[i][1])
                sum += float(info[i][2])

            print("Name".ljust(l1), 'Title'.ljust(l2), 'Salary')

            for i in range(len(info)):
                print(info[i][0].ljust(l1), info[i][1].ljust(l2), '%.2f' % float(info[i][2]))
            avg = sum / len(info)
            print('AVG:%.2f' % avg)
            f.close()













