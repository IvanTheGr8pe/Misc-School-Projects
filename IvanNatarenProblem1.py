presentPop = 7 *(10**9)#present population
futurePop = presentPop #future population
rate = .011 #how much population grows per year
year = 2011 #year 0 from where it starts

def displayPop():
    print("the population will be {0:,d} by the year {1:d}".format(int(futurePop),int(year)))


while(futurePop <=(9*(10**9))):
    while(futurePop <=(8*(10**9))):
        year+=1
        futurePop = futurePop *(1+rate)
        if futurePop >=(8*(10**9)):
            displayPop()
    year+=1
    futurePop = futurePop *(1+rate)

displayPop()



    
