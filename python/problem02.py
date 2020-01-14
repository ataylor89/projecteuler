#!/usr/bin/python

fib = [1, 2]
n = 0
t = 2
while t < 4000000:
	t = fib[n] + fib[n+1]
	fib.append(t)
	n = n + 1

print fib	

sum = 0
for s in fib:
	if s % 2 == 0:
		sum += s

print sum
