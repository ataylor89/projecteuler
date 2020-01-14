#!/usr/bin/python
import math

def num_divisors(n):
	num = 0
	m = int(math.sqrt(n))
	
	for x in range(1, m):
		if n % x == 0:
			num += 2

	return num

t = 0
incr = 1
found = False

while not found:
	t += incr
	incr += 1

	if num_divisors(t) > 500:
		found = True

print t
