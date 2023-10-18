class Circle {
    private double radius;

    public Circle(double radius){
        this.radius=radius;
    }

    public double circumference(){
        double circumference= 2* Math.PI*radius;
        return circumference;
    }

    public double area(){
        double a=radius;
        double area= Math.PI * Math.pow(a,2);
        return area;
    }
}

class Triangle{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1,double side2,double side3){
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }

    public Triangle(){
        side1=3;
        side2=4;
        side3=5;
    }

    public double perimeter(){
        double perimeter= side1+side2+side3;
        return perimeter;
    }

    public double area1(){
        double p=(side1+side2+side3)/2;
        double r=p*(p-side1)*(p-side2)*(p-side3);

        double area1=Math.pow(r,0.5);
        return area1;
    }

    public double height(){
        double smallestSide=0;

        if(side1<side2 && side1<side3){
            smallestSide=side1;
        }else if(side2<side1 && side2<side3){
            smallestSide=side2;
        }else if(side3<side1 && side3<side2){
            smallestSide=side3;
        }

        double height= 2*area1()/smallestSide;
        return height;
    }

    public String toString(){
        double myDouble3=side1;
        int myInt3=(int) myDouble3;
        double myDouble4=side2;
        int myInt4=(int)myDouble4;
        double myDouble5=side3;
        int myInt5=(int)myDouble5;
        double myDouble=height();
        int myInt=(int) myDouble;
        double myDouble1=perimeter();
        int myInt1=(int)myDouble1;
        double myDouble2=area1();
        int myInt2=(int)myDouble2;

        String toString="Area of a triangle "+myInt3+"x"+myInt4+"x"+myInt5+" is " +myInt2+" it's perimeter is "+myInt1+
                " and it's height is "+myInt;
         return toString;

    }


}

class Rectangle{
    private double height1;
    private double width;

    public Rectangle(double height1, double width){
        this.height1=height1;
        this.width=width;
    }

    public double perimeter1(){
        double perimeter1=2*height1+2*width;
        return perimeter1;
    }

    public double area2(){
        double area2=height1*width;
        return area2;
    }
}




public class Assignment1 {

    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            Circle obj=new Circle(i);
        obj.area();
        obj.circumference();
            System.out.println("Area of a circle with radius "+i+" is "+obj.area()+" circumference is "+obj.circumference());
        }
        System.out.println();

        for(int m=1;m<=3;m++){
            for(int n=1;n<=3;n++){
                Rectangle obj1=new Rectangle(m,n);
                obj1.perimeter1();
                obj1.area2();
                double myDouble=obj1.perimeter1();
                int myInt=(int) myDouble;
                double myDouble1=obj1.area2();
                int myInt1=(int)myDouble1;
                System.out.println("Area of a rectangle "+m+" by "+n+" is "+myInt1+ " it's perimeter is "
                        +myInt);
            }
        }
        System.out.println();

        double side1=18;
        double side2=30;
        double side3=24;

        Triangle triangle=new Triangle(side1,side2,side3);
        triangle.height();
        triangle.perimeter();
        triangle.area1();

        double myDouble=triangle.height();
        int myInt=(int) myDouble;
        double myDouble1=triangle.area1();
        int myInt1=(int)myDouble1;
        double myDouble2=triangle.perimeter();
        int myInt2=(int)myDouble2;
        double myDouble3=side1;
        int myInt3=(int) myDouble3;
        double myDouble4=side2;
        int myInt4=(int)myDouble4;
        double myDouble5=side3;
        int myInt5=(int)myDouble5;


        System.out.println("Area of a triangle "+myInt3+"x"+myInt4+"x"+myInt5+" is "+myInt1+
                " it's perimeter is "+myInt2+" and it's height is "+myInt);

        Triangle triangle1=new Triangle();
        triangle1.height();
        triangle1.perimeter();
        triangle1.area1();
        triangle1.toString();

        System.out.println(triangle1.toString());
    }
}
