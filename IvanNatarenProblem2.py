#Ivan Nataren Assignment 2 problem 2

salary1 =20000 
raise1 =1000
year1 = 1 # how many times a year the person gets a raise
salary2 = 10000
raise2 = 250
year2 =2
choice = 0 #user input variable
tenTotal =0 #ten year total

def calc(salary,r,year): #parameters are uniform to make calculation simpler
    tenTotal = 10*((salary + r)*year)
    print("After ten years, you will have received ${0:,.2f}".format(tenTotal))

choice = eval(input ("Please enter the number 1 or the number 2 to calculate your "+
                     "salary options: \n" ))
if choice == 1:
    calc(salary1,raise1,year1)
elif choice == 2:
    calc(salary2,raise2,year2)
else:
    print("I'm sorry, that is not a choice.")

    
