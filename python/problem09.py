#!/usr/bin/python
import math

def is_square(n):
	if (math.sqrt(n) - int(math.sqrt(n))):
		return False
	return True

def find():
	for a in range(1, 1000):
		for b in range(1, 1000):
			cs = a**2 + b**2

			if is_square(cs):
				c = int(math.sqrt(cs))
				if a + b + c == 1000:
					return [a, b, c]

triple = find()
print triple
print triple[0] * triple[1] * triple[2]
