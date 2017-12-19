println('Please enter human parameters in format (<Name> <Last Name> <gender> <height> <weight>)')
def humanParameters1 = System.in.newReader().readLine().split(" ")

def human1 = [humanParameters1[0],
           humanParameters1[1],
           humanParameters1[2].toBoolean(),
           humanParameters1[3].toFloat(),
           humanParameters1[4].toFloat()] as Human
println human1


println('Please enter woman parameters in format (<Name> <Last Name> <gender> <height> <weight>)')
def humanParameters2 = System.in.newReader().readLine().split(" ")
def human2 = [humanParameters2[0],
            humanParameters2[1],
            humanParameters2[2].toBoolean(),
            humanParameters2[3].toFloat(),
            humanParameters2[4].toFloat()] as Human
println human2

def human = human1.haveRelationships(human2)
println human