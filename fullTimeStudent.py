'''
This is a full time Student inherited from the student class ...
'''

from student import Student
class FTstudent(Student):

    #initialize the Full Time student
    def __init__(self, n= "", midG = 0, finalG =0, ft = True): # two underscores each
        super().__init__(n, midG, finalG)
        self.fullTime = ft

    def setFullTime(self, ft):
        self.fullTime = ft

    def getFullTime(self):
        return fullTime

    def __str__(self):

        if self.fullTime == 'Y':
            status = "Full-time student"
        else:
            status ="Part-time student"
            
        return super().__str__()+ "\t" + status
