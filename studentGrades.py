
from letterGrade import LGstudent
from passFailStudent import PFstudent

def main():
    listOfStudents = obtainListOfStudents()
    displayResults(listOfStudents)

def obtainListOfStudents():
    listOfStudents = []

    carryOn ='Y'
    while carryOn == 'Y':
        stName = input("Enter a student's name: ")
        stMidtem = float(input("Enter a midterm grade: "))
        stFinal = float(input("Enter a final grade: "))

        category = input("Enter category (LG or PF): ")
        category = category.upper()

        ft = input("Is this a full-time student (Y/N): ")
        ft = ft.upper()


        if category == "LG":
            st = LGstudent(stName, stMidtem, stFinal, ft)
        else:
            st = PFstudent(stName, stMidtem, stFinal, ft)

        listOfStudents.append(st)

        print("-------------------------\n\n")

        carryOn = input("Do you have more studetns (Y/N): ")
        carryOn = carryOn.upper()
    return listOfStudents

def displayResults(listOfStudents):
    print("\nName\tGrade")
    listOfStudents.sort(key=lambda x: x.getName())

    for pupil in listOfStudents:
        print(pupil)

main()
