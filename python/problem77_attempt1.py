#!/usr/bin/python

import sieve
import itertools

primes = sieve.primes(7500)

lst = []

for p in primes:
    n = 7500 / p

    for i in range(n):
        lst.append(p)

print "Generated primes using sieve"

N = []

for i in range(2, 7500/2 + 1):
    
    stop = 0

    for j in range(len(lst)):
        if 2 * (i-1) + lst[j] > 7500:
            stop = j
    
    print("Stopping point for i=" + str(i) + ": " + str(stop))

    combinations = list(itertools.combinations(lst[0:stop], i))
    
    for combination in combinations:
        if sum(combination) == 7500:
            N.append(combination)   

    del combinations

print(N)
print("There are exactly " + len(N) + " ways to make 7500 as a sum of primes")
