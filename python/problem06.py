#!/usr/bin/python

z = range(1, 101)

s = 0
t = 0

for x in z:
	s += x**2
	t += x

t = t**2
diff = t - s

print "Sum of squares: " + str(s)
print "Square of sum: " + str(t)
print "Difference: " + str(diff)
