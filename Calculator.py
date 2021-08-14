from tkinter import *
from tkinter import font

'''
This method will do some calculation based on the entry fields
'''
def calculate(button_id):
    L = []
    L.append(eval(text1.get()))
    L.append(eval(text2.get()))
    L.append(eval(text3.get()))
    L.append(eval(text4.get()))

    if button_id==1:
        text5.set("The total is: " + str(sum(L)))
    elif button_id==2:
        text5.set("The average is: " + str(sum(L)/len(L)))
    elif button_id==3:
        text5.set("The maximum is: " + str(max(L)))
    elif button_id==4:
        text5.set("The minimum is: " + str(min(L)))


window = Tk()
window.title("Calculator")

# Specify the font style to be used
fontStyle = font.Font(family='Arial', size=13, weight='bold')

# Initialize the text fields
text1 = StringVar()
text2 = StringVar()
text3 = StringVar()
text4 = StringVar()
text5 = StringVar()

# Create a set of labels to be placed in the window
Label(window, text="First number: ").grid(row=0, column=0, padx = 5, pady=5, sticky=W)
Label(window, text="Second number: ").grid(row=1, column=0, padx = 5, pady=5, sticky=W)
Label(window, text="Third number: ").grid(row=2, column=0, padx = 5, pady=5, sticky=W)
Label(window, text="Fourth number: ").grid(row=3, column=0, padx = 5, pady=5, sticky=W)

# Initialize the text field with a default entry
text1.set(0)
text2.set(0)
text3.set(0)
text4.set(0)

'''
Create a set of entry fields
Each field will be placed in a specific location in the frame
using the row and column parameters
'''
ent1 = Entry(window, width=10, textvariable=text1)
ent1.grid(row=0, column=1, columnspan=2, pady=2, sticky=W)

ent2 = Entry(window, width=10, textvariable=text2)
ent2.grid(row=1, column=1, columnspan=2, pady=5, sticky=W)

ent3 = Entry(window, width=10, textvariable=text3)
ent3.grid(row=2, column=1, columnspan=2, pady=5, sticky=W)

ent4 = Entry(window, width=10, textvariable=text4)
ent4.grid(row=3, column=1, columnspan=2, pady=5, sticky=W)

ent5 = Entry(window, width=30, font=fontStyle, state="readonly", textvariable=text5)
ent5.grid(row=4, column=1, columnspan=4, pady=10, sticky=W)

'''
Create a set of buttons
Each button will call the calculate method with a 
specific value specifying the button being clicked
'''

btn1 = Button(window, text="Total", command=lambda:calculate(1))
btn1.grid(row=0, column=4, padx=10, pady=5, sticky=EW)

btn2 = Button(window, text="Average", command=lambda:calculate(2))
btn2.grid(row=1, column=4, padx=10, pady=5, sticky=EW)

btn3 = Button(window, text="Maximum", command=lambda:calculate(3))
btn3.grid(row=2, column=4, padx=10, pady=5, sticky=EW)

btn4 = Button(window, text="Minimum", command=lambda:calculate(4))
btn4.grid(row=3, column=4, padx=10, pady=5, sticky=EW)

window.mainloop()
