#!/usr/bin/python

palindromes = []
for x in range(100, 999):
	for y in range(100, 999):
		n = x * y
		s = str(n)
		t = s[::-1]
		
		if s == t:
			palindromes.append(int(s))

palindromes.sort()
print palindromes	
print palindromes[-1]
