#!/usr/bin/python

primes = [2, 3]
n = primes[-1]
while len(primes) < 10001:
	n = n + 1
	isPrime = True

	for p in primes:
		if n % p == 0:
			isPrime = False
			break

	if isPrime:
		primes.append(n)

print primes
print primes[-1]
