#!/usr/bin/python
from fractions import gcd
from math import sqrt

limit = 1500000
mlimit = int(sqrt(limit/2))

lengths = {}

for m in range(2, mlimit):
	for n in range(1, m):
		if gcd(m,n) == 1 and (m % 2 == 0 or n % 2 == 0):
			a = m**2 - n**2
			b = 2 * m * n
			c = m**2 + n**2 
		
			k = 1
			length = a + b + c 
			while length <= limit:
				if length in lengths:
					lengths[length] += 1
				else:
					lengths[length] = 1

				k += 1
				length = k * (a + b + c)
				
num_solutions = 0

for length in lengths:
	if lengths[length] == 1:
		num_solutions += 1

print num_solutions
