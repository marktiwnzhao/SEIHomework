#! /usr/bin/env python
# -*- coding: utf-8 -*-


def process(param):
	length = len(param)
	i = 0
	while i < length:
		if len(param[i]) == 1:
			del param[i]
			length -= 1
			continue
		else:
			i += 1

	list = [' ' for i in range(len(param))]
	for i in range(len(param)):
		list[i] = param[i].title()
	outputstr = ','.join(list)
	return outputstr
