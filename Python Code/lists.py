data = ["B",78,69,"E","S",73,"P",80,83,66,"I","N"]

def get_letters(data):
    newlist = []
    for item in data:
        if type(item) == str:
           
            newlist.append(item)
    return newlist

def get_digits(data):
    newlist = []
    for item in data:
        if type(item) == int:
            
            newlist.append(item)
    return newlist



def print_list(letters,numbers):
    for i in range(len(letters)):
        print(letters[i],numbers[i])
    
characters_list = get_letters(data)
print(characters_list)
characters_list.sort()
print(characters_list)
characters_list.sort(reverse=True)
print(characters_list)

numbers_list = get_digits(data)
print(numbers_list)
numbers_list.sort()
print(numbers_list)
numbers_list.sort(reverse=True)
print(numbers_list)

print_list(characters_list,numbers_list)

