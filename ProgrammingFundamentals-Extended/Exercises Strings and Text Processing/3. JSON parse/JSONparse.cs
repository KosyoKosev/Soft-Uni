using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3.JSON_parse
{
    public class Student
    {
        public string Name { get; set; }
        public int Age { get; set; }
        public int[] Grades { get; set; }
    }
    class JSONparse
    {
        static void Main(string[] args)
        {
            var students = new List<Student>();

            var input = Console.ReadLine();

            var split = input.Split(new[] {'[', ']', '{', '}'}, StringSplitOptions.RemoveEmptyEntries);
            
            var newStudent = new Student();

            for (int i = 0; i < split.Length; i += 3)
            {
                var splitParams = split[i].Split(new[] {':', '\"', ','}, StringSplitOptions.RemoveEmptyEntries);
                var name = splitParams[1];
                var age = int.Parse(splitParams[3]);

                newStudent.Name = name;
                newStudent.Age = age;
            }

            for (int i = 1; i < split.Length; i += 3)
            {
                var grades = split[i].Split(',').Select(int.Parse).ToArray();

                newStudent.Grades = grades;
            }

            foreach (var student in students)
            {
                Console.WriteLine($"{student.Name} : {student.Age} -> {string.Join(", ",student.Grades)}");
            }

        }
    }
}
