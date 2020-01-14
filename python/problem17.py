#!/usr/bin/python

numbers = {
    1: 'one',
    2: 'two',
    3: 'three',
    4: 'four',
    5: 'five',
    6: 'six',
    7: 'seven',
    8: 'eight',
    9: 'nine',
    10: 'ten',
    11: 'eleven',
    12: 'twelve',
    13: 'thirteen',
    14: 'fourteen',
    15: 'fifteen',
    16: 'sixteen',
    17: 'seventeen',
    18: 'eighteen',
    19: 'nineteen',
    20: 'twenty',
    30: 'thirty',
    40: 'forty',
    50: 'fifty',
    60: 'sixty',
    70: 'seventy',
    80: 'eighty',
    90: 'ninety'
}

count = 0

for i in range(1, 1001):
    if i < 20:
        count += len(numbers[i])
        
        continue

    if i < 100:
        s = str(i)
    
        td = int(s[0])
        od = int(s[1])

        count += len(numbers[td*10])

        if od > 0:
            count += len(numbers[od])

        continue

    if i < 1000:
        s = str(i)

        hd = int(s[0])
        td = int(s[1])
        od = int(s[2])

        count += len(numbers[hd]) + len("hundred")
        
        if td == 0 and od > 0:
            count += len("and") + len(numbers[od])

        elif td == 1:
            count += len("and") + len(numbers[td*10 + od])
        
        elif td > 1:
            count += len("and") + len(numbers[td*10])

            if od > 0:
                count += len(numbers[od])
        
        continue        
                                   
    if i == 1000:
        count += len("onethousand")

print(count)
