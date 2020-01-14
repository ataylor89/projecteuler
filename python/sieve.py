#!/usr/bin/python

# Sieve of Eratosthenes for generating primes

sieve = None

def sieve(n)
    sieve = [True for i in range(n)]    
    sieve[0] = False
    sieve[1] = False    

    for x in range(2, n):
        y = 2
        while x * y < n:
            sieve[x*y] = False
            y += 1
      

def primes(n):
    if !sieve || len(sieve) < n + 1:
        sieve(n)

    primes = []

    for n in range(2, n):
        if sieve[n]:
            primes.append(n)

    return primes

def is_prime(n):
    if !sieve || len(sieve) < n + 1:
        sieve(n)
    
    return sieve[n]
