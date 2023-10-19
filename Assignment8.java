import java.util.*;
public class Assignment8{
    public static String decimaltoBinary(int number){
        if(number==0){
            return " ";
        }else{
            int remainder=(number%2);
            return decimaltoBinary(number/2)+Integer.toString(remainder);
        }
    }

    public static String decimaltoHexadecimal(int number){
        int remainder=number%16;
        if(number!=0){
            switch(remainder){
                case 10:
                    return decimaltoHexadecimal(number/16)+"A";
                case 11:
                    return decimaltoHexadecimal(number/16)+"B";
                case 12:
                    return decimaltoHexadecimal(number/16)+"C";
                case 13:
                    return decimaltoHexadecimal(number/16)+"D";
                case 14:
                    return decimaltoHexadecimal(number/16)+"E";
                case 15:
                    return decimaltoHexadecimal(number/16)+"F";
                default:
                    return decimaltoHexadecimal(number/16)+remainder;
            }
        }else{
            return " ";
        }
    }

    public static String convertIpAddress(String[] str,int i) {
        if (i == str.length - 1)
            return decimaltoBinary(Integer.parseInt(str[i]));
            return decimaltoBinary(Integer.parseInt(str[i])) + "." + convertIpAddress(str, ++i);

    }

        public static String convertMacAddress(String[] str,int i){
            if (i == str.length - 1)
                return decimaltoHexadecimal(Integer.parseInt(str[i]));
                return decimaltoHexadecimal(Integer.parseInt(str[i])) + ":" + convertMacAddress(str, ++i);

        }

            public static void main(String[] args){
                Scanner input=new Scanner(System.in);
                while(true){
                    System.out.println("1-Convert Decimal Number to Binary Number");
                    System.out.println("2-Convert Decimal Number to HexaDecimal Number");
                    System.out.println("3-Convert Decimal IP Address to Binary IP Address");
                    System.out.println("4-Convert Decimal MAC Address to Hexadeciaml MAC Address");
                    System.out.println("5-Exit");
                    System.out.println();
                    System.out.print("Enter choice:");
                    int choice=input.nextInt();

                    if(choice==1){
                        System.out.println();
                        System.out.print("Enter Decimal Integer: ");
                        int integer=input.nextInt();
                        String binary=decimaltoBinary(integer);
                        System.out.println("Decimal number: "+integer);
                        System.out.println("Binary number: "+binary);
                        System.out.println();
                    }

                    else if(choice==2){
                        System.out.println();
                        System.out.print("Enter Decimal Integer: ");
                        int integer=input.nextInt();
                        String hexa=decimaltoHexadecimal(integer);
                        System.out.println("Decimal number: "+integer);
                        System.out.println("HexaDecimal number: "+hexa);
                        System.out.println();
                    }

                    else if(choice==3){
                        System.out.println();
                        System.out.print("Enter Decimal Address(i.e 192.168.35.10: ");input.nextLine();
                        String s=input.nextLine();
                        String[] decimal=s.split("\\.");
                        String binaryIP=convertIpAddress(decimal,0);
                        System.out.println("Decimal IP Address: "+s);
                        System.out.println("Binary IP Address: "+binaryIP);
                        System.out.println();
                    }

                    else if(choice==4){
                        System.out.println();
                        System.out.print("Enter MAC Address(i.e 203:65:157:93:13:7: ");input.nextLine();
                        String s=input.nextLine();
                        String[] decimal=s.split(":");
                        String hexaMAC=convertMacAddress(decimal,0);
                        System.out.println("Decimal MAC Address: "+s);
                        System.out.println("HexaDecimal MAC Address: "+hexaMAC);
                        System.out.println();
                    }

                    else if(choice==5){
                        break;
                    }

                    else{
                        System.out.println();
                        System.out.println("Error: Please Enter Valid Input");
                        System.out.println();
                    }
                }
    }
}



