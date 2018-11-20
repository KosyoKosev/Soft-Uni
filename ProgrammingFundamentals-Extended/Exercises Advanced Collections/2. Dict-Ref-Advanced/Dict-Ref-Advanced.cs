using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2.Dict_Ref_Advanced
{
    class Program
    {
        static void Main(string[] args)
        {
            var studentGrades = new Dictionary<string, List<int>>();

            var input = Console.ReadLine();

            while (input != "end")
            {
                string[] split = input.Split(new[] {' ', '-', '>', ','},StringSplitOptions.RemoveEmptyEntries);

                for (int i = 1; i < split.Length; i++)
                {
                    var key = split[0];
                    var value = 0;
                    var afterKey = "";

                    bool isParseInt = Int32.TryParse(split[i], out value);

                    if (isParseInt)
                    {
                        if (!studentGrades.ContainsKey(key))
                        {
                            studentGrades[key] = new List<int>();
                        }
                        studentGrades[key].Add(value);
                    }
                    else
                    {
                        afterKey = split[i];

                        if (studentGrades.ContainsKey(afterKey))
                        {
                            studentGrades[key] = new List<int>(studentGrades[afterKey]);
                        }
                    }
                }

                input = Console.ReadLine();
            }

            foreach (var student in studentGrades.Keys)
            {
                Console.WriteLine($"{student} === {string.Join(", ", studentGrades[student])}");
            }
        }
    }
}
