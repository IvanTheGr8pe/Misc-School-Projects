import unittest
from student import Student

class TestStudentClass(unittest.TestCase):

    def setUp(self):
        print("\nsetUp")

        self.st1 = Student("Jack", 75,60)
        self.st2 = Student("Emma", 85,65)

    def tearDown(self):
        print("tearDown\n")
        

    def test_getStName(self):
        print("test_getStName")
        
        self.assertEqual(self.st1.getStName(), "Jack")
        self.assertEqual(self.st2.getStName(), "Emily")

    def test_getAvgGrade(self):
        print("test_getAvgGrade")
        
        self.assertEqual(self.st1.getAvgGrade(), 67.5)
if __name__ == '__main__':
    unittest.main()
