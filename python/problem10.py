#!/usr/bin/python

def sieve_of_eratosthenes(n):
	sieve = {}

	for x in range(2, n):
		sieve[x] = True

	for y in range(2, n):
		if sieve[y]:
			z = y 
			while z + y < n:
				z = z + y
				sieve[z] = False

	return sieve

sum = 0
n = 2000000
sieve = sieve_of_eratosthenes(n)
print sieve

for x in range(2, n):
	if sieve[x]:
		sum += x

print sum
