package org.wit.quiz.controllers

import mu.KotlinLogging
import org.wit.quiz.models.quizJSONStore
import org.wit.quiz.models.quizMemStore
import org.wit.quiz.models.quizModel
import org.wit.quiz.views.quizView
import java.util.*
import kotlin.random.Random.Default.nextInt

class quizController {

    //val quizzes = quizMemStore()
    val quizzes = quizJSONStore()
    val quizView = quizView()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Quiz Console App" }
        println("Quiz Kotlin App Version 1.0")
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> add()
                2 -> update()
                3 -> play()
                4 -> list()
                5 -> search()
                6 -> delete()
                0 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != 0)
        logger.info { "Shutting Down Quiz Console App" }
    }

    fun menu() :Int { return quizView.menu() }

    fun add(){
        var aQuiz = quizModel()

        if (quizView.addQuizData(aQuiz))
            quizzes.create(aQuiz)
        else
            logger.info("Quiz Not Added")
    }

    fun list() {
        quizView.listQuizzes(quizzes)
    }

    var quizScore: Int = 0

    fun play(){
        val newId = Random().nextInt(quizzes.quizzes.size)
        val aQuiz = search(newId.toLong())

        var tempAnswerOne: String?
        var tempAnswerTwo: String?
        var tempAnswerThree: String?
        var tempAnswerFour: String?
        var tempAnswerFive: String?
        var tempAnswerSix: String?
        var tempAnswerSeven: String?
        var tempAnswerEight: String?
        var tempAnswerNine: String?
        var tempAnswerTen: String?

        if(aQuiz != null){
            println("Question 1 : " + aQuiz.questionOne + " ")
            print("Answer 1 : ")
            tempAnswerOne =""+ readLine()!!

            println("Question 2 : " + aQuiz.questionTwo + " ")
            print("Answer 2 : ")
            tempAnswerTwo =""+ readLine()!!

            println("Question 3 : " + aQuiz.questionThree + " ")
            print("Answer 3 : ")
            tempAnswerThree =""+ readLine()!!

            println("Question 4 : " + aQuiz.questionFour + " ")
            print("Answer 4 : ")
            tempAnswerFour =""+ readLine()!!

            println("Question 5 : " + aQuiz.questionFive + " ")
            print("Answer 5 : ")
            tempAnswerFive =""+ readLine()!!

            println("Question 6 : " + aQuiz.questionSix + " ")
            print("Answer 6 : ")
            tempAnswerSix =""+ readLine()!!

            println("Question 7 : " + aQuiz.questionSeven + " ")
            print("Answer 7 : ")
            tempAnswerSeven =""+ readLine()!!

            println("Question 8 : " + aQuiz.questionEight + " ")
            print("Answer 8 : ")
            tempAnswerEight =""+ readLine()!!

            println("Question 9 : " + aQuiz.questionNine + " ")
            print("Answer 9 : ")
            tempAnswerNine =""+ readLine()!!

            println("Question 10 : " + aQuiz.questionTen + " ")
            print("Answer 10 : ")
            tempAnswerTen = ""+ readLine()!!

            tempAnswerOne = tempAnswerOne.toLowerCase()
            tempAnswerTwo = tempAnswerTwo.toLowerCase()
            tempAnswerThree = tempAnswerThree.toLowerCase()
            tempAnswerFour = tempAnswerFour.toLowerCase()
            tempAnswerFive = tempAnswerFive.toLowerCase()
            tempAnswerSix = tempAnswerSix.toLowerCase()
            tempAnswerSeven = tempAnswerSeven.toLowerCase()
            tempAnswerEight = tempAnswerEight.toLowerCase()
            tempAnswerNine = tempAnswerNine.toLowerCase()
            tempAnswerTen = tempAnswerTen.toLowerCase()


            if(tempAnswerOne != null && tempAnswerTwo != null && tempAnswerThree !=null && tempAnswerFour !=null && tempAnswerFive !=null && tempAnswerSix !=null && tempAnswerSeven !=null && tempAnswerEight !=null && tempAnswerNine !=null && tempAnswerTen !=null ){
                if(tempAnswerOne == aQuiz.answerOne){
                    quizScore++
                }
                if(tempAnswerTwo == aQuiz.answerTwo){
                    quizScore++
                }
                if(tempAnswerThree == aQuiz.answerThree){
                    quizScore++
                }
                if(tempAnswerFour == aQuiz.answerFour){
                    quizScore++
                }
                if(tempAnswerFive == aQuiz.answerFive){
                    quizScore++
                }
                if(tempAnswerSix == aQuiz.answerFive){
                    quizScore++
                }
                if(tempAnswerSeven == aQuiz.answerSeven){
                    quizScore++
                }
                if(tempAnswerEight == aQuiz.answerEight){
                    quizScore++
                }
                if(tempAnswerNine == aQuiz.answerNine){
                    quizScore++
                }
                if(tempAnswerTen == aQuiz.answerTen){
                    quizScore++
                }
            }
            else{
                print("You entered an Invalid Answer Type")
            }

        }
        else{
            println("Could not find a quiz")
        }

        println("Your Score is : $quizScore ")

        quizScore = 0

        print("Question 1 : " + aQuiz?.questionOne + " ")
        print("Answer 1 : " + aQuiz?.answerOne + " ")
        print("Question 2 : " + aQuiz?.questionTwo + " ")
        print("Answer 2 : " + aQuiz?.answerTwo + " ")
        print("Question 3 : " + aQuiz?.questionThree + " ")
        print("Answer 3 : " + aQuiz?.answerThree + " ")
        print("Question 4 : " + aQuiz?.questionFour + " ")
        print("Answer 4 : " + aQuiz?.answerFour + " ")
        print("Question 5 : aQuiz?.questionFive)
        print("Question 5 : aQuiz?.answerFive)
        print("Answer 5 : aQuiz?.questionSix)
        print("Question 6 : aQuiz?.answerSix)
        print("Answer 6 : aQuiz?.questionSeven)
        print("Question 7 : aQuiz?.answerSeven)
        print("Answer 7 : aQuiz?.questionEight)
        print("Question 8 : aQuiz?.answerEight)
        print("Answer 8 : aQuiz?.questionNine)
        print("Question 9 : aQuiz?.answerNine)
        print("AnsweraQuiz?.questionTen)
        print("aQuiz?.answerTen)
    }

    fun update() {

        quizView.listQuizzes(quizzes)
        var searchId = quizView.getId()
        val aQuiz = search(searchId)

        if(aQuiz != null) {
            if(quizView.updateQuizData(aQuiz)) {
                quizzes.update(aQuiz)
                quizView.showQuiz(aQuiz)
                println("Quiz Updated : [ $aQuiz ]")
            }
            else
                logger.info("Quiz Not Updated")
        }
        else
            println("Quiz Not Updated...")
    }

    fun delete() {
        quizView.listQuizzes(quizzes)
        var searchId = quizView.getId()
        val aQuiz = search(searchId)

        if(aQuiz != null) {
            quizzes.delete(aQuiz)
            println("Quiz Deleted...")
            quizView.listQuizzes(quizzes)
        }
        else
            println("Quiz Not Deleted...")
    }

    fun search() {
        val aQuiz = search(quizView.getId())!!
        quizView.showQuiz(aQuiz)
    }


    fun search(id: Long) : quizModel? {
        var foundQuiz = quizzes.findOne(id)
        return foundQuiz
    }

}