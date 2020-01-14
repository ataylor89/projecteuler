#!/usr/bin/python

n = 2**1000
sum = 0

for digit in map(int, list(str(n))):
	sum += digit

print sum	
