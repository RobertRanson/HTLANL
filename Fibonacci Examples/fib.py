def fib(num1):
    if num1==0:
        return 0
    elif num1==1:
        return 1
    else:
        return fib(num1-1) + fib(num1-2)

for i in range(10):
    print(fib(i))

values =[]
for i in range(10):
    values.append(i)
print (values)