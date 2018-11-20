using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2.JSON_stringify
{
    public class JSONstringify
    {
        public class Student
        {
            public string Name { get; set; }
            public  int Age { get; set; }
            public int[] Grades { get; set; }
        }
       
        public static void Main(string[] args)
        {
            var students = new List<Student>();

            var input = Console.ReadLine();

            while (input != "stringify")
            {
                string[] split = input.Split(new[] {' ', ':', '-', '>', ','}, StringSplitOptions.RemoveEmptyEntries);
                var grades = split.Skip(2).Select(int.Parse).ToArray();

                var newStudent = new Student();

                newStudent.Name = split[0];
                newStudent.Age = int.Parse(split[1]);
                newStudent.Grades = (grades);
                
                students.Add(newStudent);

                input = Console.ReadLine();
            }

            var result = new StringBuilder();

            for (int i = 0;i < students.Count;i++)
            {
                result.Append("{name:\"");
                result.Append(students[i].Name);
                result.Append("\",age:");
                result.Append(students[i].Age);
                result.Append(",grades:[");
                result.Append(string.Join(", ", students[i].Grades));
                result.Append("]}");
                if (i < students.Count - 1)
                {
                    result.Append(",");
                }
            }

            Console.WriteLine($"[{result}]");
        }
    }
}
