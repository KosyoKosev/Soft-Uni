using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Last_3_Consecutive_Equal_Strings
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] text = Console.ReadLine().Split(' ');

            string word = string.Empty;

            for (int i = 0; i < text.Length - 2; i++)
            {
                string firstString = text[i];
                string secondString = text[i + 1];
                string thirdString = text[i + 2];

                if (firstString.Equals(secondString) && firstString.Equals(thirdString))
                {
                    word = firstString;
                }
            }

            Console.WriteLine($"{word} {word} {word}");
        }
    }
}
