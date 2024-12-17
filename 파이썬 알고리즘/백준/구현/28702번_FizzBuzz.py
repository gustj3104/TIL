first = input()
second = input()
third = input()

next = 0

if first.isdigit():
    next = int(first) + 3
elif second.isdigit():
    next = int(second) + 2
elif third.isdigit():
    next = int(third) + 1

if next % 15 == 0:
    print("FizzBuzz")
elif next % 3 == 0:
    print("Fizz")
elif next % 5 == 0:
    print("Buzz")
else:
    print(next)
