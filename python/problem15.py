#!/usr/bin/python

def step(grid, x, y):
	l = len(grid) - 1
	
	if x > l or y > l:
		return 0

	if x == l and y == l:
		return 1

	if grid[x][y] != 0:
		return grid[x][y]

	grid[x][y] = step(grid, x+1, y) + step(grid, x, y+1)
	return grid[x][y]

grid = [[0]*21 for i in range(21)]

print step(grid, 0, 0)
