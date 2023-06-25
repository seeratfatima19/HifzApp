package data;

public class Student {
        private String id;
        private String name;
        private int age;
        private int _class;

        public Student()
        {
            this.id ="S000";
            this.name = "";
            this.age =0;
            this._class=0;
        }

        public Student( String id,String name, int age, int class_no)
        {
            this.id=id;
            this.name = name;
            this.age = age;
            this._class=class_no;

        }
        // getters and setters

        public void setId(String id)
        {
            this.id=id;
        }

        public String getId()
        {
            return this.id;
        }
        public void setName(String name){
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setAge(int age){
            this.age = age;
        }
        public int getAge() {
            return this.age;
        }

        public void setClass(int _class)
        {
            this._class = _class;
        }

        public int get_Class()   {
            return this._class;
        }


}
