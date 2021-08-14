'''
Create a pass of fail grade student that is to be extended from
the student class
'''

from student import Student
from fullTimeStudent import FTstudent

class PFstudent(FTstudent):
    def calcSemGrade(self):
        average = ((self.midterm + self.finalGrade) / 2)

        if average >= 60:
            return "Pass"
        else:
            return "Fail"
