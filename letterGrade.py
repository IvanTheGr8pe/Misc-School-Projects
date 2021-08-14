'''
This class will create a letter grade student that is to be extended
from the student class
'''

from fullTimeStudent import FTstudent

class LGstudent(FTstudent):
    def calcSemGrade(self):
        average = round((self.midterm + self.finalGrade) / 2)

        if average >= 90:
            return 'A'
        elif average >= 80:
            return 'B'
        elif average >= 70:
            return 'C'
        elif average >= 60:
            return 'D'
        else:
            return 'F'




