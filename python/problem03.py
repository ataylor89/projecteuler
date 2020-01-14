#!/usr/bin/python

def prime_factorization(n):
	prime_fact = {}

	for x in xrange(2, n+1):
		if n == 1:
			return prime_fact

		if n % x == 0:
			prime_fact[x] = 1
			n = n / x
		
		while (n % x == 0):
			prime_fact[x] = prime_fact[x] + 1
			n = n / x

n = 600851475143
prime_fact = prime_factorization(n)

print prime_fact
