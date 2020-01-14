#!/usr/bin/python

def get_seq(n):
	seq = [n]
	while n != 1:
		if n % 2 == 0:
			n = n / 2
			seq.append(n)
		else:
			n = 3 * n + 1
			seq.append(n)
	return seq
		
max = 0
max_seq = [1]

for x in range(2, 1000000):
	seq = get_seq(x)
	if len(seq) > max:
		max = len(seq)
		max_seq = seq

print max_seq
print max_seq[0]
