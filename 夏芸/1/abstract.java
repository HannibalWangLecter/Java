abstract class Person
{
        protected double money;
        public abstract void pay();
}

class Teacher extends Person
{
        private double basicSalary;
        private int classes;
        Teacher(JUnitdouble bs, int c)
        {
                money = 0;
                basicSalary = bs;
                classes = c;
        }
        public void pay()
        {
                money = basicSalary + classes * 30;
                System.out.println("The payment is:" + money);
        }
}

class CollegeStudent extends Person
{
        private double scholarship;
        CollegeStudent(double s)
        {
                money = 0;
                scholarship = s;
        }
        public void pay()
        {
                money += scholarship;
                System.out.println("The payment is:" + money);
        }
}

