#! /usr/bin/env python
# -*- coding: utf-8 -*-


def calculate():
	current_age = int(input("What is your current age?"))
	retire_age = int(input("At what age would you like to retire?"))
	work_year = retire_age - current_age
	if work_year > 0:
		print("You have {0} years left until you can retire.".format(work_year))
		print("It's 2022, so you can retire in {0}.".format(work_year + 2022))
	else:
		print("You have 0 years left until you can retire.")
		print("It's 2022, so you can retire in {0}.".format(work_year + 2022))
	pass
