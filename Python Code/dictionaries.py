import random

# for i in range(5):
#     print(i+" ")


myDict = {}
people = ['Rob','Steve','Chris','Ibi']

for key in people:
    myDict[key] = random.randint(1,100)

print('Dictionary: ',myDict,'\n')
shallowDict = myDict
deepDict= myDict.copy()
print('Shallow Copy Dictionary: ',shallowDict,'\n')
print('Deep Copy Dictionary: ',deepDict,'\n')





under_fifty={}

for key in myDict:
    if myDict[key]<50:
        myDict[key] = "less than fifty"
        


print("----------------------------------------------")
print('Dictionary: ',myDict,'\n')
print('Shallow Copy Dictionary: ',shallowDict,'\n')
print('Deep Copy Dictionary: ',deepDict,'\n')


# if 'Rob' in myDict:
#     print('Rob number is >50: ',myDict.pop('Rob'),'\n')
# else:
#     print('Rob number is <50: ',under_fifty.pop('Rob'),'\n')

# print('Dictionary: ',myDict,'\n')
# print('less than 50 dictionary: ',under_fifty,'\n')