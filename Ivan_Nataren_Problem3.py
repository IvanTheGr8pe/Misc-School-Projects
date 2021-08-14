#Ivan Nataren Assignment 2 Problem 3

age = eval(input("Enter your age: "))
month= eval(input("Enter number of months of service: "))
first =eval(input("Enter first of the three highest salaries: "))
second =eval(input("Enter second of the three highest salaries: "))
third =eval(input("Enter third of the three highest salaries: "))
salList = [first,second,third] #used a list to make calcuting the sum and average easier
yrs = month//12
ave = (sum(salList))/3
perRate = 0
#the value of perRate changes depending on the value of yrs
if yrs <= 5:
    perRate = 0.015
elif 5<yrs<=10:
    perRate = 0.0175
else :
    perRate = .02

p= 0.8-perRate # I had trouble on this one because I didn't know what "minimum of perRate and 80% meant

annPension = p*ave #Annual Pension

print("Annual Pension : ${0:,.2f} ".format(annPension))

    

