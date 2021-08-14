'''
This class will define a student with three attributes:
- Name
- Midterm grade
- Final grade
'''

class Student:
    # the initialization method
    def __init__(self, n="", midG=0, finalG=0):
        self.name = n
        self.midterm = midG
        self.finalGrade = finalG

    # set the attribute name
    def setName(self, n):
        self.name = n

    # set the midterm grade
    def setMidTerm(self, midG):
        self.midterm = midG

    # set the final grade
    def setFinalGrade(self, finalG):
        self.finalGrade = finalG

    def getName(self):
        return self.name

    def __str__ (self):
        return self.name + "\t" + self.calcSemGrade()

