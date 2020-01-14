#!/usr/bin/python

D = range(1, 21)
n = 19
found = False

while not found:
	found = True
	n = n + 1	

	for d in D:
		if n % d != 0:
			found = False
			break
print n	
