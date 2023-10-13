#! /usr/bin/env python
# -*- coding: utf-8 -*-
import re

def validate():
    # input
    first_name = input("Enter the first name: ")
    last_name = input("Enter the last name: ")
    zip_code = input("Enter the ZIP code: ")
    employee_ID = input("Enter an employee ID: ")

    # functions
    def JudgeName(name, name_str):
        if len(name) == 0:
            print('The {0} must be filled in.'.format(name_str))
        elif len(name) == 1:
            print('\"{0}\" is not a valid {1}. It is too short.'.format(name, name_str))

    def JudgeZipcode(code_str):
        true = 1
        if len(code_str) == 0:
            print('The ZIP code must be numeric.')
            return
        for i in range(len(code_str)):
            if code_str[i] > '9' or code_str[i] < '0':
                true = 0
                break
        if true == 0:
            print('The ZIP code must be numeric.')

    def JudgeID(ID_str):
        if len(ID_str) != 7 or ID_str[2] != '-':
            return False
        for i in range(2):
            if ID_str[i] < 'A' or ID_str[i] > 'Z':
                return False
        for i in range(3, 7):
            if ID_str[i] < '0' or ID_str[i] > '9':
                return False
        return True

    # main
    JudgeName(first_name, 'first name')
    JudgeName(last_name, 'last name')
    JudgeZipcode(zip_code)
    if not JudgeID(employee_ID):
        print('{0} is not a valid ID.'.format(employee_ID))
