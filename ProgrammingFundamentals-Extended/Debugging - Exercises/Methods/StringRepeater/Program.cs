using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringRepeater
{
    class Program
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();
            int number = int.Parse(Console.ReadLine());

            Console.WriteLine(RepeatString(text,number));
        }

        private static string RepeatString(string text, int number)
        {
            string repeatedString = string.Empty;

            for (int i = 0; i < number; i++)
            {
                repeatedString += text;
            }

            return repeatedString;
        }
    }
}
