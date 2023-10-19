package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML
    private ListView<String> noOfYearListView;

    @FXML private Button calculateButton;

    @FXML private TextField loanAmountTextField;

    @FXML private ChoiceBox interestRatesChoiceBox;

    @FXML private CheckBox noMissedPaymentOptionsCheckBox;
    @FXML private CheckBox automaticWithdrawalOptionsCheckBox;


    @FXML private RadioButton inDefermentYes;
    @FXML private RadioButton inDefermentNo;


    @FXML private Label annualPaymentLabel;

    ToggleGroup inDefermentGroup = new ToggleGroup();




    private ObservableList<String> itemList;
    private ObservableList<String> interestList;

    int noOfYear = 0;
    float interestRate = 0.0f;
    float newRate = 0.0f;


    public void pressCalculateButton(ActionEvent event){

        ObservableList selectedIndices = noOfYearListView.getSelectionModel().getSelectedIndices();

        for(Object o : selectedIndices){
            noOfYear = Integer.parseInt(String.valueOf(o)) + 1;
        }

        System.out.println("\n");
        System.out.println("Loan Amount: "+ loanAmountTextField.getText());
        System.out.println("No Of Year: "+ noOfYear);
        System.out.println("Interest Rate: "+ interestRate);
        System.out.println("In Deferment Yes: "+ inDefermentYes.isSelected());
        System.out.println("In Deferment No: "+ inDefermentNo.isSelected());
        System.out.println("Missed payment: "+ noMissedPaymentOptionsCheckBox.isSelected());
        System.out.println("Auto Withdrawal: "+ automaticWithdrawalOptionsCheckBox.isSelected());

        if(noMissedPaymentOptionsCheckBox.isSelected() && automaticWithdrawalOptionsCheckBox.isSelected()) {
            newRate = interestRate - 0.5f;
            System.out.println("New Interest Rate: "+ interestRate);
        } else {
            if(noMissedPaymentOptionsCheckBox.isSelected() || automaticWithdrawalOptionsCheckBox.isSelected()) {
                newRate = interestRate - 0.25f;
                System.out.println("New Interest Rate: "+ interestRate);
            }
        }


        if(inDefermentYes.isSelected()) annualPaymentLabel.setText("0.00");
        else {
            newRate =( newRate/100)/12;

            double loanAmount = Double.parseDouble(loanAmountTextField.getText());

            double annulPayment = (newRate * loanAmount) / (1 - Math.pow(1 + newRate, -(noOfYear*12)));

            annualPaymentLabel.setText(""+ annulPayment);
        }

    }

    private double calculateAnnualPayment(){
        double annualPayment = 0;



        return annualPayment;
    }




    public void initialize(){

        genNoOfYearsList();
        genInterestRatesList();
        noOfYearListView.setItems(itemList);
        interestRatesChoiceBox.setItems(interestList);

        // Observe choice box value change
        interestRatesChoiceBox.setOnAction((event) -> {
            interestRate = Float.parseFloat(interestRatesChoiceBox.getValue().toString());
        });



        inDefermentYes.setToggleGroup(inDefermentGroup);
        inDefermentNo.setToggleGroup(inDefermentGroup);
    }



    private void genNoOfYearsList() {
        itemList = FXCollections.observableArrayList();
        for(int i=1;i<=20;i++){
            itemList.add(""+i);
        }
    }
    private void genInterestRatesList() {
        interestList = FXCollections.observableArrayList();
        interestList.add("3.0");
        interestList.add("3.5");
        interestList.add("4.0");
        interestList.add("4.5");
        interestList.add("5.0");
        interestList.add("5.5");
        interestList.add("6.0");
        interestList.add("6.5");
        interestList.add("7.0");
        interestList.add("7.5");
    }
}
