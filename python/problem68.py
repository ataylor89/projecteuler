#!/usr/bin/python
from itertools import permutations

all_permutations = list(permutations([1,2,3,4,5,6,7,8,9,10],10))

for p in all_permutations:
	if p[0] < p[1] and p[0] < p[2] and p[0] < p[3] and p[0] < p[4]:
		sum1 = p[0] + p[5] + p[6]
		sum2 = p[1] + p[6] + p[7]
		sum3 = p[2] + p[7] + p[8]
		sum4 = p[3] + p[8] + p[9]
		sum5 = p[4] + p[9] + p[5]

		if sum1 == sum2 and sum2 == sum3 and sum3 == sum4 and sum4 == sum5:
			print str(p[0]) + str(p[5]) + str(p[6]) + \
				str(p[1]) + str(p[6]) + str(p[7]) + \
				str(p[2]) + str(p[7]) + str(p[8]) + \
				str(p[3]) + str(p[8]) + str(p[9]) + \
				str(p[4]) + str(p[9]) + str(p[5])
