import java.util.ArrayList;
import java.util.Scanner;
class Question{
    private String qText;
    private String qAnswer;
    private int difficulty;

    public Question(String qText,String qAnswer,int difficulty){
        this.qText=qText;
        this.qAnswer=qAnswer;
        this.difficulty=difficulty;
    }

    public String getqText(){
        return this.qText;
    }

    public void setQuestion(String qText){
        this.qText=qText;
    }

    public String getAnswer(){
        return this.qAnswer;
    }

    public void setAnswer(String qAnswer){
        this.qAnswer=qAnswer;
    }

    public int getDifficulty(){
        return this.difficulty;
    }

    public void setDifficulty(int difficulty){
        this.difficulty=difficulty;
    }

}

class Quiz{
    ArrayList <Question> questions=new ArrayList<>();
    private int score=0;

    public Quiz(){
    }
    public int getScore(){return score;}
    public void add_question(String question,String answer,int difficulty){
        Question newQuestion=new Question(question,answer,difficulty);
        questions.add(newQuestion);
    }

    public void remove_question(int placeToRemove) {
        questions.remove(placeToRemove);
    }

    public void modify_question(int placeToModify, String newQuestion, String newAnswer, int newDifficulty){

        Question xx=questions.get(placeToModify);
        xx.setQuestion(newQuestion);
        xx.setAnswer(newAnswer);
        xx.setDifficulty(newDifficulty);
    }

    public boolean give_quiz(int qPlace,String suppliedAnswer){
        Question questionAtplace=questions.get(qPlace);
        String actualAnswer=questionAtplace.getAnswer();
        boolean isAnswerCorrect=actualAnswer.equals(suppliedAnswer);
        if(isAnswerCorrect){
            score++;
        }else{
        }
        return isAnswerCorrect;

    }

}

public class Lab3 {
    public static void main(String[] args) {
        Quiz quizObj = new Quiz();
        System.out.print("What would you like to do?");
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.println("1. Add a question to the quiz.");
            System.out.println("2. Remove a question from the quiz.");
            System.out.println("3. Modify a question in the quiz.");
            System.out.println("4. Take the quiz.");
            System.out.println("5. Quit.");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("What is the question Text?");
                    String qTextInput = input.nextLine();
                    System.out.println("What is the answer?");
                    String aTextInput = input.nextLine();
                    System.out.println("How Difficult(1-3)?");
                    int difficulty = input.nextInt();
                    quizObj.add_question(qTextInput, aTextInput, difficulty);
                    continue;


                case 2:
                    System.out.println("Which Question do you want to Remove?");
                    int removePlace = input.nextInt();
                    quizObj.remove_question(removePlace);
                    continue;

                case 3:
                    System.out.println("Choose the question to modify?");
                    int size = quizObj.questions.size();
                    for (int qIndex = 0; qIndex < size; qIndex++) {
                        Question qAtIndex = quizObj.questions.get(qIndex);
                    }
                    int placeToModify = input.nextInt();
                    System.out.println("What is the question Text?");
                    String newQuestion = input.nextLine();
                    System.out.println("What is the answer?");
                    String newAnswer = input.nextLine();
                    System.out.println("How Difficult(1-3)?");
                    int newDifficulty = input.nextInt();
                    quizObj.modify_question(placeToModify, newQuestion, newAnswer, newDifficulty);
                    continue;

                case 4:
                    int size1 = quizObj.questions.size();
                    for (int qPlace = 0; qPlace < size1; qPlace++) {
                        Question qAtIndex = quizObj.questions.get(qPlace);
                        System.out.println(qAtIndex.getqText());
                        String userAnswer = input.nextLine();
                        boolean isAnswerCorrect = quizObj.give_quiz(qPlace,suppliedAnswer);
                        if (isAnswerCorrect) {
                            System.out.println("Correct.");
                        } else {
                            System.out.println("Incorrect.");
                        }

                        int score = quizObj.getScore();
                        int qCount = quizObj.questions.size();
                        System.out.println("You get " + score + " out of " + qCount);
                        continue;
                    }

                case 5:
                    break;


            }
        }
    }
}

