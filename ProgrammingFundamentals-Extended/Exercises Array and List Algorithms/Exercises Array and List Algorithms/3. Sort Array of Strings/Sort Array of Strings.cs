using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3.Sort_Array_of_Strings
{
    class Program
    {
        static void Main(string[] args)
        {
            var text = Console.ReadLine().Split(' ').ToList();

            text.Sort();

            Console.WriteLine(string.Join(" ",text));
        }
    }
}
