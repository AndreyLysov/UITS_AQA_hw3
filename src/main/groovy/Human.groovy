import groovy.transform.Canonical

@Canonical
class Human {
    String name
    String lastname
    boolean gender
    float height
    float weight

    boolean speak(Human human) {
        print "There are "
        if (this.gender == true && human.gender == true) {
            boolean speakProbability = Randomizer.probabilityOfX(50)
            println "two mans so speak method return: $speakProbability"
            return speakProbability
        } else {

            println "not two mans so speak method return: true"
            return true
        }
    }

    boolean tolerateSociety(Human human) {
        boolean probability;
        if (this.gender == true && human.gender == true) {
            probability = Randomizer.probabilityOfX(5.6)
            println "Tolerate society returns: $probability"
            return probability
        } else if (this.gender == false && human.gender == false) {
            probability = Randomizer.probabilityOfX(5)
            println "Tolerate society returns: $probability"
            return probability
        } else {
            probability = Randomizer.probabilityOfX(70)
            println "Tolerate society returns: $probability"
            return probability
        }
    }

    boolean spendTimeTogether(Human human) {
        print "Difference between them is equal: "
        float difference
        boolean probability
        if (this.height > human.height) {
            difference = (this.height - human.height) / this.height
            print difference + " percentage so spend time together method returns: "
            if (difference >= 0.1) {
                probability = Randomizer.probabilityOfX(75)
                print ("$probability ")
                return probability
            } else {
                probability = Randomizer.probabilityOfX(85)
                print ("$probability ")
                return probability
            }
        } else {
            difference = (human.height - this.height) / human.height
            print difference + "percentage so spend time together method returns: "
            if (difference >= 0.1) {
                probability = Randomizer.probabilityOfX(75)
                print ("$probability ")
                return probability
            } else {
                probability = Randomizer.probabilityOfX(85)
                print ("$probability ")
                return probability
            }
        }
    }

    Human haveRelationships(Human human) {
        if (this.speak(human) &&
                this.tolerateSociety(human) &&
                this.spendTimeTogether(human)) {
            if (this.gender == human.gender)
                return null
            else if (this.gender == false)
                return this.giveBirth(human)
            else
                return human.giveBirth(human)
        }

    }

    Human giveBirth(Human father) {
        boolean gender = Randomizer.probabilityOfX(50)
        println ("The child is " + gender ? "boy" : "girl")

        println "Please enter child's name"
        String name = System.in.newReader().readLine()

        float height = gender ? father.height + 0.1 * (this.height - father.height) : this.height + 0.1 * (father.height - this.height)
        float weight = gender ? father.weight + 0.1 * (this.weight - father.weight) : this.weight + 0.1 * (father.weight - this.weight)

        return new Human(name, father.lastname, gender, height, weight)
    }

    @Override
    String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender=" + gender +
                ", height=" + height +
                ", weight=" + weight +
                '}'
    }

    static class Randomizer {
        static Random random = new Random()

        static boolean probabilityOfX(double probability) {
            int randomValue = random.nextInt(100)
            print "<Random value is " + randomValue + ">"
            if (randomValue < probability)
                return true
            else
                return false
        }
    }
}