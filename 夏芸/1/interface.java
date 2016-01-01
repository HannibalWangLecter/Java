
public interface Person {
        void pay();
}

class Teacher implements Person
{
        private double basicSalary;
        private int classes;
        private double money;
        Teacher(double bs, int c)
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

class CollegeStudent implements Person
{
        private double scholarship;
        private double money;
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
